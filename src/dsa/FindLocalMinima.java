package dsa;

public class FindLocalMinima {
    public static int findLocalMinima(int[] nums){
        int l = 0, r = nums.length-1;

        while(l <= r){
            int mid = l + (r-l)/2;
            if ((mid == 0 || nums[mid] < nums[mid-1]) && (mid==nums.length-1 || nums[mid] < nums[mid+1])){
                return mid;
            }
            // If the middle element is greater than its left neighbor, then there is always a local minima in left half
            //If the middle element is greater than its right neighbor, then there is always a local minima in right half
            // 1, 2, 3, middle element is 2 so left is 1 which is always a local minima
            // 3, 2, 1 middle is 2, less is 1 which is always local minima
            if(mid > 0 && nums[mid] > nums[mid-1]){ //move towards side with lower neighbour
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 1, 2, 1, 3};
        System.out.println("Index of valley element in nums1: " + findLocalMinima(nums1)); // Output: 2

        int nums2[] = {4, 3, 1, 14, 16, 40};
        System.out.println("Index of valley element in nums2: " + findLocalMinima(nums2)); // Output: 5

        int nums3[] = {4};
        System.out.println("Index of valley element in nums2: " + findLocalMinima(nums3)); // Output: 5
    }
}
