class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length -1 ; 
        int low = 0 ; 
        int random = (high + low )/2 ; 

        while (true) { 
            if (high < low ) { 
                break ; 
            }
            random = (high + low )/2 ; 
            if (nums[random] == target){ 
                return random ; 
            }else if (nums[random] < target ){ 
                low = random + 1  ; 
            }else { 
                high = random  - 1 ; 
            }
        }
        return -1 ; 
    }
}
