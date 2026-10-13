class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0 ; 
        for (int i = 0; i < nums.length ; i ++){ 
            sum += nums[i] ; 
        }
        int prefix = 0 ; 
        int suffix = sum - nums[0] - prefix ;
        if (prefix == suffix ){ 
                return 0 ; 
            }
        for (int i = 1 ; i< nums.length ; i++ ){ 
            prefix += nums[i-1] ; 
            suffix = sum - nums[i] - prefix ; 
            if (prefix == suffix ){ 
                return i ; 
            }
        }
        return -1 ; 
    }
}
