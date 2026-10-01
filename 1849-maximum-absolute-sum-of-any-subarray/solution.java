class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEnd = nums[0];
        int minEnd = nums[0] ;
        int ans = Math.abs(nums[0]) ; 

        for ( int i = 1 ; i < nums.length ; i++ ){ 
            maxEnd = Math.max(maxEnd + nums[i] ,nums[i] ); 
            minEnd = Math.min(minEnd + nums[i] ,nums[i]);

            int currMax =  Math.max( Math.abs(minEnd) , maxEnd) ; 
            ans = Math.max( ans ,currMax) ; 
        }  

        return ans ;  
    }
}
