public int candy(int[] ratings) {

    int len = ratings.length;
    int[] candy = new int[len];
    
    candy[0] =1;
    for (int i = 1; i < len; ++i) {
        if (ratings[i] > ratings[i-1]) {
            candy[i] = candy[i-1] + 1;
        } else {
            candy[i] = 1;
        }
    }

    int total = candy[len-1];
    for (int i = len - 2; i >= 0; --i) {
        if (ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) {
            candy[i] = candy[i+1] + 1;
        }
        total += candy[i];    
    }
    return total;
}