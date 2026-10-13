class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0 ; 
        int currSum  = 0 ;
        HashMap < Integer , Integer > map = new HashMap() ; 

        map.put ( 0 , -1 ) ; 
        for ( int i = 0 ; i  < nums.length ; i++){ 
            if ( nums[i] == 0){ 
                currSum -= 1 ;
            }else { 
                currSum += 1 ;  
            }
            if ( map.containsKey(currSum)){ 
                int len =  i - map.get(currSum)  ; 
                res = Math.max(len , res ) ;  
            }else { 
                map.put( currSum , i  ) ;
            }
        }
        return res ; 
    }
}
