public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int start=gas.length, end=0, sum=0;
      do sum+= sum>0? gas[end]-cost[end++]: gas[--start]-cost[start]; while (start!=end);
      return sum>=0? start: -1;
    }
}