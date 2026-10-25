class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int high = arr.length -1 ; 
        int low = 0 ; 
        int mid = low + (high - low ) / 2 ; 

        int res = Integer.MIN_VALUE ; 

        while(low <= high ){ 
            mid = low + (high - low ) / 2 ; 
            if(mid < arr.length - 2  && arr[mid] < arr[mid + 1] ){ 
                low = mid + 1 ; 
            }else if(mid > 1   && arr[mid] < arr[mid - 1]){ 
                high = mid - 1 ; 
            }
            else { 
                res = mid ; 
                break ; 
            }
        }
        return res ; 
    }
}
