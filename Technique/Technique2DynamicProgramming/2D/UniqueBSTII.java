public class Solution {
public List<List<String>> partition(String s) {
        char[] souceArray = s.toCharArray();
        List<List<String>>[] dp = new List[souceArray.length + 1];
        dp[0] = new ArrayList<>();dp[0].add(new ArrayList<>());
        for (int i = 1; i <= souceArray.length; i++) {
            dp[i] = new ArrayList<>();
            for (int reverseIndex = i-1,end=i-1; reverseIndex >= 0; reverseIndex--) {
                if (!isPalindrome(souceArray, reverseIndex, end)) {
                    continue;
                }
                String palindrome = s.substring(reverseIndex, i);
                for (List<String> state : dp[reverseIndex]) {
                    List<String> tmp = new ArrayList<>(state);
                    tmp.add(palindrome);
                    dp[i].add(tmp);
                }
            }
        }
        return dp[souceArray.length];
    }

    private boolean isPalindrome(char[] charArrayToJudge, int begin, int end) {
        int count = end-begin;
        for (int i = 0; i < count; i++) {
            if (charArrayToJudge[i+begin] != charArrayToJudge[end-i]) {
                return false;
            }
        }
        return true;
    }
}