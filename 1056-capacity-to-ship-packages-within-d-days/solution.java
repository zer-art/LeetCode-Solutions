class Solution {
    private boolean candidate(int mid ,int[] weights , int days){ 
        int dayCount = 1 ;
        int weight = 0 ; 
        for (int i : weights){ 
            if(weight + i <= mid){ 
                weight += i ; 
            }else { 
                dayCount += 1 ; 
                weight = i  ; 
            }
        }

        return dayCount <= days ; 
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0] ; 
        int high = 0 ; 
        for ( int i : weights ){ 
            high += i ; 
            if (i > low ) low = i ; 
        }
        int res = high ; 

        while ( low <= high ){ 
            int mid =  low + (high - low )/ 2 ; 
            if (candidate(mid,weights ,days) ){ 
                res = mid ; 
                high = mid - 1 ; 
            }else { 
                low = mid + 1 ; 
            }
        }
        return res ; 
    }
}
