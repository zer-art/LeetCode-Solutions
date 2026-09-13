class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if ( k <= 1 ){ 
            return 0 ; 
        }
        int count = 0 ; 
        int i = 0  ;
        int p = 1 ; 
        for ( int j = 0 ; j < nums.length ; j ++ ){ 
            p = p * nums[j] ;
            while ( p >= k ){ 
                p = p / nums[i] ; 
                i ++ ; 
            }
            count = count + (j - i + 1);
        }
        return count ; 
    }
}
