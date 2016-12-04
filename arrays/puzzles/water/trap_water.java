Trapping Rain Water. 
public class Solution {
    public int trap(int[] A) {
        int i = 0, j = A.length - 1, result = 0, plank = 0;
        while(i <= j){
            plank = plank < Math.min(A[i], A[j]) ? Math.min(A[i], A[j]) : plank;
            result = A[i] >= A[j] ? result + (plank - A[j--]) : result + (plank - A[i++]);
        }
        return result;
    }
}

============================================================

public class Solution {
public int trap(int[] height) {
    if (height.length <= 2) return 0;
    int max = Integer.MIN_VALUE;
    int maxIndex = -1;
    for (int i = 0; i < height.length; i++) {
        if (height[i] > max) {
            max = height[i];
            maxIndex = i;
        }
    }
    
    int leftMax = height[0];
    int water = 0;
    for (int i = 1; i < maxIndex; i++) {
        if (height[i] > leftMax) {
            leftMax = height[i];
        } else {
            water += leftMax - height[i];
        }
    }
    
    int rightMax = height[height.length - 1];
    for (int i = height.length - 2; i > maxIndex; i--) {
        if (height[i] > rightMax) {
            rightMax = height[i];
        } else {
            water += rightMax - height[i];
        }
    }
    
    return water;
}
