class Solution {
    public String longestCommonPrefix(String[] strs) {
        // If the array is empty, there is no common prefix
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Start by assuming the first string is the common prefix
        String prefix = strs[0];
        
        // Loop through the remaining strings in the array
        for (int i = 1; i < strs.length; i++) {
            // While the current string does NOT start with the prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by 1 character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}