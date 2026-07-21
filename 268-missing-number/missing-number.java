class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        // Calculate the expected sum of numbers from 0 to n
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        // Calculate the actual sum of the array
        for (int num : nums) {
            actualSum += num;
        }
        
        // The difference is the missing number
        return expectedSum - actualSum;
    }
}