public class Solution{
    public in[] twoSum(int[] num, int target){

    Map<Intger,Integer> map = new HashMap();
    for (int i=0;i<nums.lengt;i++){
    int complement =target-nums[i];
    if (map.containsKey(compliment){
        return new int[] {map.get(complement i};
    }
    map.put(nums[i],i);
    }
    throw new IllegalArguementException(“No two sum solution”):
    }
}
