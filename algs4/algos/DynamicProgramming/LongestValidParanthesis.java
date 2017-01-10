       private static int longestValidParentheses(String s) {
        int len_s = s.length();
        if (len_s == 0) return 0;
        int[] f = new int[len_s];
        //f[n] means the longestValidParentheses substring ending at n 
        f[0] = 0;
        int max = 0;
        for (int i=0;i<len_s-1;i++) {
            if (s.charAt(i+1)=='(') {
                // if the end of substring is '(', it cant be a valid string
                f[i+1] = 0;
                continue;
            }
            // s.charAt(i+1) == ')'
            // you get ')' at i+1 so check for the '(' on the left.
            if (i-f[i]>=0 && s.charAt(i-f[i])=='(') {
                f[i+1] = 2 + f[i]; 
                //2 means the '(' at i-f[i] and ')' at i+1,
                if (i-f[i]-1>=0)
                    f[i+1] += f[i-f[i]-1];
            }
            if (f[i+1]>max) max = f[i+1];
        }
        return max;
    }