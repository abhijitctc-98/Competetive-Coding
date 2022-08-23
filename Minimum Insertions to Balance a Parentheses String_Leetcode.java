/*
Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.

Example 1:

Input: s = "(()))"
Output: 1
Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.
Example 2:

Input: s = "())"
Output: 0
Explanation: The string is already balanced.
Example 3:

Input: s = "))())("
Output: 3
Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
*/  

class Solution {
    public int minInsertions(String s) {
        int need_left = 0; // ( need_left is for '(' )
        int need_right = 0; // ( need_right is for ')' )
        
        char[] arr = s.toCharArray();
        
        for(char ch: arr) {
            if(ch == '(') {
                need_right++;
                need_right++;
                
                if(need_right % 2 == 1) {
                    need_left++;
                    need_right--;
                }
            }
            
            if(ch == ')') {
                need_right--;
                if(need_right == -1) {
                    need_left++;
                    need_right = 1;
                }
            }
        }
        return (need_left + need_right);
    }
}
