/*You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Return a list of integers representing the size of these parts.

 

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*/

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> part = new ArrayList<>();
        
        int li[] = new int[26];
        for(int i = 0 ; i < s.length() ; i++) {
            li[s.charAt(i) - 'a'] = i;
        }
        
        int i = 0;
        while(i < s.length()) {
            int end = li[s.charAt(i) - 'a'];
            int j = i;
            
            while(j != end) {
                end = Math.max(end , li[s.charAt(j++) - 'a']);
            }
            
            part.add(j - i + 1);
            i = (j + 1);
        }
        return part;
    }
}
