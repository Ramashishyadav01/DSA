import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Set to store the unique characters in the current window
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        
        // Expand the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If we find a duplicate, shrink the window from the left 
            // until the duplicate is removed
            while (window.contains(currentChar)) {
                window.remove(s.charAt(left));
                left++;
            }
            
            // Add the new character to the window
            window.add(currentChar);
            
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}