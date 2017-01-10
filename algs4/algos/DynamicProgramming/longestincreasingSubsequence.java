public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}


public int lengthOfLIS(int[] nums) {
    ArrayList<Integer> dp = new ArrayList<>(nums.length);
    for (int num : nums) {
        if (dp.size() == 0 || dp.get(dp.size()-1) < num) dp.add(num);
        else {
            int i = Collections.binarySearch(dp, num);
            dp.set((i<0) ? -i-1 : i, num);
        }
    }
    return dp.size();
}



public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (list.isEmpty()) {
                list.add(nums[i]);
                continue;
            }
            int last = list.get(list.size() - 1);
            if (nums[i] > last) {
                list.add(nums[i]);
            } else {
                int pos = find(list, nums[i]);
                list.set(pos, nums[i]);
            }
        }
        return list.size();
    }
    public int find(ArrayList<Integer> list, int val) {
        int start = 0, end = list.size() - 1;
        if (val < list.get(0))
            return 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == val)
                return mid;
            if (list.get(mid) < val)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
}
