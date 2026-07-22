

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // A quadruplet requires at least 4 numbers
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        // Sort the array to easily handle duplicates and use two pointers
        Arrays.sort(nums);
        int n = nums.length;
        
        // Fix the first number
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Fix the second number
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // Use two pointers for the third and fourth numbers
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    // Use long to prevent integer overflow since array values can be up to 10^9
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for the third number
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Skip duplicates for the fourth number
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        // Move both pointers inward after finding a valid quadruplet
                        left++;
                        right--;
                    } else if (sum < target) {
                        // We need a larger sum, move the left pointer to the right
                        left++;
                    } else {
                        // We need a smaller sum, move the right pointer to the left
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}