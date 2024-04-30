package dsa;

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;

        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] < nums[high]){
                high = mid;
            }else {
               low = mid+1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        MinInRotatedSortedArray array = new MinInRotatedSortedArray();
        int[] arr = {3,4,5,1,2};
        System.out.println(array.findMin(arr));
    }
}
