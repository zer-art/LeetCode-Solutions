class Solution {
    public int[] searchRange(int[] nums, int target) { 
        int high  = nums.length -1 ; 
        int low = 0 ; 
        int mid = (high+low) /2 ; 
        int [] ans = {-1 , -1} ; 

        while ( high >= low ){ 
            mid = low + (high-low) /2 ; 
            if ( nums[mid] <= target){ 
                if ( nums[mid] == target ){ 
                    ans[1] = mid ; 
                }
                low = mid + 1 ; 
            }else { 
                high = mid -1 ; 
            }
        } 
        low = 0 ; 
        while (high >= low){ 
            mid = low + (high-low) /2 ; 
            if(nums[mid]>=target){ 
                if ( nums[mid] == target ){ 
                    ans[0] = mid ; 
                }
                high = mid - 1 ; 
            }else { 
                low = mid + 1 ; 
            }
        }
        return ans ; 
    }
}
