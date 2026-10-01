class Solution {
    public int maxProduct(int[] nums) {
        int bestEnding = nums[0] ; 
        int worstEnding = nums[0] ; 
        int ans = nums [0] ; 

        for(int i = 1 ; i< nums.length ; i ++ ){ 
            int c1 = bestEnding * nums[i] ; 
            int c2 = worstEnding * nums[i] ;
            int c3 = nums[i] ; 

            if ( c1 < c2 ){ 
                bestEnding = Math.max(c2,c3 ) ; 
                worstEnding = Math.min(c1,c3) ; 
            }else { 
                bestEnding = Math.max(c1,c3 ) ; 
                worstEnding = Math.min(c2,c3) ; 
            }

            ans = Math.max(bestEnding , ans ) ; 
        }

        return ans ; 
    }
}
