//   If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
//   If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
//   If p.charAt(j) == '*': 
//   here are two sub conditions:
//               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
//               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
//                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
//                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
//                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty

public boolean isMatch(String s, String p) {

    if (s == null || p == null) {
        return false;
    }
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i-1]) {
            dp[0][i+1] = true;
        }
    }
    for (int i = 0 ; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '.') {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == s.charAt(i)) {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                    dp[i+1][j+1] = dp[i+1][j-1];
                } else {
                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
    }
    return dp[s.length()][p.length()];
}














public boolean isMatch(String s, String p) {
    // base case
    if (p.length() == 0) {
        return s.length() == 0;
    }
 
    // special case
    if (p.length() == 1) {
 
        // if the length of s is 0, return false
        if (s.length() < 1) {
            return false;
        }
 
        //if the first does not match, return false
        else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
            return false;
        }
 
        // otherwise, compare the rest of the string of s and p.
        else {
            return isMatch(s.substring(1), p.substring(1));
        }
    }
 
    // case 1: when the second char of p is not '*'
    if (p.charAt(1) != '*') {
        if (s.length() < 1) {
            return false;
        }
        if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
            return false;
        } else {
            return isMatch(s.substring(1), p.substring(1));
        }
    }
 
    // case 2: when the second char of p is '*', complex case.
    else {
        //case 2.1: a char & '*' can stand for 0 element
        if (isMatch(s, p.substring(2))) {
            return true;
        }
 
        //case 2.2: a char & '*' can stand for 1 or more preceding element, 
        //so try every sub string
        int i = 0;
        while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
            if (isMatch(s.substring(i + 1), p.substring(2))) {
                return true;
            }
            i++;
        }
        return false;
    }
}