public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxArea = 0;

    while (left < right) {
        maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                * (right - left));
        if (height[left] < height[right])
            left++;
        else
            right--;
    }

    return maxArea;
}

   public int maxArea(int[] height) {
        int maxWater=0, left=0, right=height.length-1;
        while(left<right) {
            maxWater = Math.max(maxWater,(right-left)*Math.min(height[left], height[right]));
            if(height[left]<height[right]) left++;
            else right--;
        }
        return maxWater;
    }


public int maxArea(int[] height) {
    int max=0, left=0, right=height.length-1;
    while (left < right) {
        int h = Math.min(height[left], height[right]);
        max = Math.max(max, (right-left) * h);

        while (height[left] <= h && left < right) left++;
        while (height[right] <= h && left < right) right--;
    }
    return max;
}
