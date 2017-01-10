public List<List<Integer>> fourSum(int[] num, int target) {
    Arrays.sort(num);
    List<List<Integer>> list = new ArrayList<>();
    for(int i = 0; i < num.length-3; i++){
        if(i > 0 && num[i] == num[i-1]) continue; /** avoid duplicates */
        for(int j = i+1; j < num.length-2; j++){
            if(j > i+1 && num[j] == num[j-1]) continue; /** avoid duplicates */
            int left = j+1, right = num.length-1;
            while(left < right){
                int sum = num[i] + num[j] + num[left] + num[right];
                if(sum == target){
                    list.add(Arrays.asList(num[i], num[j], num[left], num[right]));
                    left++;
                    right--;
                    while(left < right && num[left] == num[left - 1]) left++;
                    while(left < right && num[right] == num[right + 1]) right--;
                }
                else if(sum > target) right--;
                else left++;
            }
        }
    }
    return list;
}