class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int i = 0 ; 
        int close = nums[i] + nums [1] + nums[2]; 
        Arrays.sort(nums) ; 
        while (i < nums.length- 2 ){ 
            int j = i + 1 ; 
            int k = nums.length -1 ; 
            while ( j < k){ 
                int currClose = Math.abs((nums[i] + nums[j] + nums[k]) - target) ; 
                int prevClose = Math.abs(close - target ); 
                if (  currClose < prevClose) { 
                    close = nums[i] + nums[j] + nums[k] ; 
                }
                if ( nums [j] + nums [k] == ( target - nums[i])){ 
                    return (nums [i] + nums[j] + nums[k]) ;      
                }else if (nums[j] + nums[k] > ( target - nums[i])){ 
                    k -- ; 
                }else { 
                    j++ ;
                }
            }
            i++ ; 
            while (i < nums.length && nums[i] == nums[i-1 ]){ 
                i++ ;
            }   
        }
        return close  ;   
    }
}
