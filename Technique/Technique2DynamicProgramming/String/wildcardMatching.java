public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                match[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                        match[i][j]=match[i+1][j+1];
                else if(p.charAt(j)=='*')
                        match[i][j]=match[i+1][j]||match[i][j+1];
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }
}

/////////////////////////////////////////////////////////////////////////////////////
public boolean isMatch(String s, String p) {
    int i = 0;
    int j = 0;
    int starIndex = -1;
    int iIndex = -1;
 
    while (i < s.length()) {
        if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
            ++i;
            ++j;
        } else if (j < p.length() && p.charAt(j) == '*') {
            starIndex = j;      
            iIndex = i;
            j++;
        } else if (starIndex != -1) {
            j = starIndex + 1;
            i = iIndex+1;
            iIndex++;
        } else {
            return false;
        }
    }
 
    while (j < p.length() && p.charAt(j) == '*') {
        ++j;
    }
 
    return j == p.length();
}
/////////////////////////////////////////////////////////////////////////////////