package com.dsAlgo.StackAndQueue;

public class TrapRainWater {
    public static void main(String[] args) {
        System.out.println(trapOptimalSolution(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }


    //Approach: Take 2 pointer l(left pointer) and r(right pointer) pointing to 0th and (n-1)th index respectively.
    // Take two variables leftMax and rightMax and initialise it to 0.If heigh[l] is less than or equal to height[r] then if leftMax is less then height[l] update leftMax to height[l]
    // else add leftMax-height[l] to your final answer and move the l pointer to the right i.e l++.If height[r] is less then height[l],then now we are dealing with the right block.
    // If height[r] is greater then rightMax,then update rightMax to height[r] else add rightMax-height[r] to the final answer.Now move r to the left.
    // Repeat theses steps till l and r crosses each other.
    //
    //Intuition: We need a minimum of leftMax and rightMax.So if we take the case when height[l]<=height[r] we increase l++,
    // so we can surely say that there is a block with a height more than height[l] to the right of l. \
    // And for the same reason when height[r]<=height[l] we can surely say that there is a block to the left of r which is at least of height[r].
    // So by traversing these cases and using two pointers approach the time complexity can be decreased without using extra space.
    private static int trapOptimalSolution(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int res= 0;
        int left = 0;
        int right = n-1;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=leftMax){
                    leftMax = height[left];
                }else{
                    res += leftMax-height[left];
                }
                left++;
            }else{
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
