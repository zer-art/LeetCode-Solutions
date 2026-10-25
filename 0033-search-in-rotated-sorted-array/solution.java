class Solution {
    public int search(int[] nums, int target) {
        if ( nums.length == 1 && target == nums[0]){ 
            return 0 ; 
        }
        int n = nums.length - 1 ; 
        int low = 0 ; 
        int high = n ; 
        int start = -1 ; 

        // first find the parts 
        while ( low <= high){ 
            int mid = low + (high - low)/2 ; 
            if(nums[mid] > nums[n]){ 
                low = mid + 1 ; 
            }else { 
                start = mid ; 
                high = mid - 1 ; 
            }
        }

        if(target < nums[n]){ 
            high = n ; 
            low = start ; 
        }else if (target > nums[n]) { 
            low = 0 ; 
            high = start - 1 ; 
        }else { 
            return n ; 
        }

        while ( low <= high ){ 
            int mid = low + ( high - low ) /2 ; 

            if (nums[mid] > target){ 
                high = mid - 1 ; 
            }else if (nums[mid] < target){ 
                low = mid + 1 ; 
            }else { 
                return mid ; 
            }
        }
        return  -1 ; 
    }
}
