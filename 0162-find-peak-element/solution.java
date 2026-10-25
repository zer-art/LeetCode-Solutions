class Solution {
    public int findPeakElement(int[] nums) {
        int res = Integer.MIN_VALUE ; 

        int low = 0 ; 
        int high = nums.length -1 ; 

        int mid = low + (high - low )/2 ; 

        while ( low <= high ){ 
            if(mid < nums.length - 1 &&  nums[mid] < nums[mid + 1 ] ){ 
                low = mid + 1 ; 
            }else if (mid > 0  && nums[mid] < nums[mid - 1 ]){ 
                high = mid - 1 ; 
            }else  { 
                return mid ; 
            }
            mid = low + (high - low )/2 ; 
        }
        return res ; 
    }
}
