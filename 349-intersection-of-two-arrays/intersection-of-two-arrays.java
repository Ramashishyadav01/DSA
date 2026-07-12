import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums2.length; i++){
            set.add(nums2[i]);
        }

        int arr[] = new int[nums1.length];

        int j = 0;

        for(int i = 0; i < nums1.length; i++){
            if(set.contains(nums1[i])) {
                arr[j++] = nums1[i];
                set.remove(nums1[i]);
            }
        }

        // create final array of exact size
        int result[] = new int[j];

        for(int i = 0; i < j; i++){
            result[i] = arr[i];
        }

        return result;
    }
}