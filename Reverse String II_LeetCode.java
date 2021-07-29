/*
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104
*/

class Solution {
    public String reverseStr(String s, int k) {
        char ch[] = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i += (2*k)) {
            int start = i;
            int end = Math.min((i + k - 1) , (ch.length - 1));
            while(start < end) {
                char temp = ch[start];
                ch[start++] = ch[end];
                ch[end--] = temp;
            }
        }
        return String.valueOf(ch);
    }
}
