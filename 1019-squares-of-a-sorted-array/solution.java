class Solution {
    public int[] sortedSquares(int[] nums) {
        int  len =  nums.length ; 
        int[] out = new int[len] ; 
        int i = 0 ; 
        int j = len - 1 ; 
        int k = 1 ; 
        while (i <= j ){ 
            if (Math.abs(nums[i]) >=  nums[j]) { 
                out[len - k ] =  nums[i] * nums[i] ;
                k++ ; 
                i++ ; 
            }else { 
                out[len - k ] =  nums[j] * nums[j] ;
                j-- ; 
                k++ ; 
            }
        } 
        return out ; 
    }
}
