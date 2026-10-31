class Solution {
    private int countSmallerK(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int low = 1 ; 
        int high = m*n ; 
        int res = 0 ; 

        while ( low <= high ){ 
            int mid = low + ( high -low )/2 ; 
            int count = countSmallerK(mid , m , n ) ; 
            if (count<k){ 
                low = mid + 1 ; 
            }else { 
                res = mid ; 
                high = mid -1 ; 
            }
        }

        return res ; 
    }
}
