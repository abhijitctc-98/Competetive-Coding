/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105
*/

/*
Given below is my first approach for solving this question using 2 Arrays.
These 2 arrays are created just to keep track of the Maximum height to the left and right of the current height.
This approach will take O(n) Time Complexity and O(1) additional space complexity.
*/
class Solution {
  public int trap(int[] height) {
    int n = height.length;
    int leftMax[] = new int[n];
    int rightMax[] = new int[n];
    int water = 0;
    
    for(int i = 0 ; i < n ; i++) {
      if(i == 0) {
          leftMax[0] = height[0];
          rightMax[n-1] = height[n - 1]; 
       } else {
          leftMax[i] = Math.max(height[i] , leftMax[i - 1]);
          rightMax[n - 1 - i] = Math.max(height[n - i - 1] , rightMax[n - i]);
      }
    }
    
    for(int i = 0 ; i < n ; i++) {
      water += (Math.min(leftMax[i] , rightMax[i]) - height[i]);
    }
    
    return water;
  }
}

/*
The next approach which I'm gonna use for solving this particular question is using Stack memory.
*/

class Solution {
  public int trap(int[] height) {
      Stack<Integer> stack = new Stack<>();
      int curr = 0;
      int water = 0;
      
      while(curr < height.length) {
          while(((!stack.isEmpty()) && (height[curr])) > height[stack.peek()]) {
              int top = stack.pop();
              if(stack.isEmpty()) {
                break;
              }
              int d = curr - stack.peek() - 1;
              int fill = d * (Math.min(height[curr] , height[st.peek]) - height[top]);
              water += fill;
          }
          stack.push(curr++);
      }
    return water;
  }
}
