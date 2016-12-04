public static int getGap(int N) {
    int max = 0;
    int count = -1;
    int r = 0;
 
    while (N > 0) {
        // get right most bit & shift right
        r = N & 1;
        N = N >> 1;
 
        if (0 == r && count >= 0) {
            count++;
        }
 
        if (1 == r) {
            max = count > max ? count : max;
            count = 0;
        }
    }
 
    return max;
}

public static int getGap(int N) {
    int pre = -1;
    int len = 0;
 
    while (N > 0) {
        int k = N & -N;
 
        int curr = (int) Math.log(k);
 
        N = N & (N - 1);
 
        if (pre != -1 && Math.abs(curr - pre) > len) {
            len = Math.abs(curr - pre) + 1;
        }
        pre = curr;
    }
 
    return len;
}