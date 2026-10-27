class Solution {
    public boolean candidate(int mid , int[] candies, long k){ 
        long kC = k ; 
        for(int i : candies){ 
            kC = kC- i/mid ; 
            if (kC <= 0 ){ 
                return true ; 
            }
        }
        return false ; 
    }
    public int maximumCandies(int[] candies, long k) {
        int res = 0 ; 
        int high = candies[0] ; 
        int low = 1 ;
        long sum = 0 ; 
        for ( int i : candies){ 
            if(i>high) high = i ;
            sum += i ; 
        }

        if ( sum < k ) return 0 ; 


        while( high >= low ){ 
            int mid = low + (high - low) /2 ; 
            if(candidate(mid , candies, k)){
                res = mid ; 
                low = mid + 1 ; 
            }else { 
                high = mid - 1 ;
            }
        }
        return res ; 
    }
}
