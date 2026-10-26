class Solution {
    private long getHours(int k , int[] piles ){ 
        long hours = 0 ; 
        for ( int i : piles){ 
            if ( i%k != 0){ 
                hours += i/k + 1 ; 
            }else { 
                hours += i/k ; 
            }
        }
        return hours ; 
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 ; 
        int high = Integer.MIN_VALUE ; 
        for ( int i : piles){ 
            high = Math.max ( high , i) ; 
        }
        int res = Integer.MAX_VALUE ; 

        while (low <= high ){ 
            int mid = low + (high - low ) / 2 ; 
            if (getHours( mid, piles) > h ){ 
                low = mid + 1 ;  
            }else { 
                res = mid  ; 
                high = mid - 1 ; 
            }
        }

        return res ;
    }
}   
