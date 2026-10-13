class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0 ; 
        int sumCurr  = 0 ; 
        HashMap <Integer, Integer > map = new HashMap() ; 
        map.put( 0 , 1 ) ;

        for ( int i = 0; i < nums.length ; i++){ 
            sumCurr += nums[i] ; 
            if (map.containsKey(sumCurr - k )){ 
                res += map.get(sumCurr - k) ;
            }
            if ( map.containsKey (sumCurr)){ 
                map.put( sumCurr , map.get(sumCurr) + 1 ) ;
            }else { 
                map.put( sumCurr , 1 ) ;
            }
            
        }
        return res ; 
    }
}
