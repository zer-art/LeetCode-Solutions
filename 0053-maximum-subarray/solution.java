class Solution {
    public int maxSubArray(int[] nums) {
        int bestEnding = nums[0] ; 
        int ans = nums[0] ; 

        for ( int i = 1 ; i < nums.length ; i++){ 
            int c1 = bestEnding + nums[i] ; 
            int c2 = nums[i]; 

            bestEnding = Math.max(c1 , c2 ); 
            ans = Math.max( ans , bestEnding ) ; 
        }

        return ans ; 
    }
}
