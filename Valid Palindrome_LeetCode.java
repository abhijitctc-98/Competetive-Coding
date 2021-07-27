/*
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/

class Solution {
    public boolean isPalindrome(String s) {
        if((s == null) && (s.length() == 0)) {
            return true;
        }   
        
        String res = "";
        for(char ch : s.toCharArray()) {
           if((Character.isDigit(ch)) || (Character.isLetter(ch))) {
               res += ch;
           } 
        }
        
        res = res.toLowerCase();
        
        int l = 0;
        int e = res.length() - 1;
        
        while(l <= e) {
            if(res.charAt(l) != res.charAt(e)) {
                return false;
            }
            
            l++;
            e--;
        }
        return true;
    }
}
