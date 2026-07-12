

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Step 1: Create a copy of the array and sort it
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        // Step 2: Use a HashMap to store the rank of each unique element
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        
        for (int num : sortedArr) {
            // Only assign a rank if we haven't seen this number before
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++; // Increment rank for the next unique element
            }
        }
        
        // Step 3: Create the result array by looking up the ranks
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        
        return result;
    }
}