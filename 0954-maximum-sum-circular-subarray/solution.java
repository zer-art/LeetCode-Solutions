class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxEnd = nums[0] ; 
        int minEnd = nums[0] ; 
        int totalSum = nums[0] ; 
        int max = nums[0] ; 
        int min = nums[0] ; 
        int res = 0 ; 
        

        for(int i = 1 ; i < nums.length ; i++){ 

            maxEnd = Math.max(maxEnd + nums[i],nums[i]) ; 
            minEnd = Math.min(minEnd + nums[i] ,nums[i]) ;
            
            max = Math.max(maxEnd , max ) ; 
            min = Math.min(min , minEnd) ; 
            totalSum += nums[i] ; 
        }
        if ( totalSum == min){ 
            return max ; 
        }
        int wrapAroundSum  = totalSum - min ; 
        res = Math.max(wrapAroundSum , max ); 
        return res ; 
    }
}
