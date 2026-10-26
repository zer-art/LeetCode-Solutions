class Solution {
    private boolean candidate(int mid , int[] days , int m , int k ){ 
        int mC = m ; 
        int kC = k ; 
        for ( int i : days){ 
            if ( i <= mid ){ 
                kC -- ;   
            }else { 
                kC = k ;
            }

            if ( kC == 0 ){ 
                mC -- ; 
                kC = k ; 
            }

            if ( mC == 0){ 
                return true ;
                
            }
        }

        return false  ; 
        
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int res = -1 ; 
        if (m*k > bloomDay.length){ 
            return -1 ; 
        }
        int low = bloomDay[0] ; 
        int high = -1 ; 
        for(int i : bloomDay){ 
            if ( i > high) high = i ;
            if ( i < low) low = i ; 
        }
        
        while(low <= high){ 
            int mid = low + ( high - low )/2 ; 
            if(candidate(mid , bloomDay, m,  k)){ 
                res = mid ;
                high = mid -1 ; 
            }else { 
                low = mid + 1 ; 
            }
        }
        return res ; 
    }
}
