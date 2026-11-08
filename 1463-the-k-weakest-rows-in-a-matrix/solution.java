class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> {
                if(a[1] !=  b[1]){ 
                    return b[1] - a[1] ; 
                }
                return b[0] - a[0] ; 
            }
        ) ; 

        for ( int i = 0 ; i < mat.length ; i++){ 
            int low = 0 ; 
            int high = mat[0].length -1  ; 
            while ( low <= high){ 
                int mid = low + (high - low ) / 2 ; 
                if (mat[i][mid] == 0 ){ 
                    high = mid - 1 ; 
                }else { 
                    low = mid + 1 ; 
                }
            }
            
            minHeap.add(new int[] {i,low}) ; 

            if ( minHeap.size() > k ){ 
                minHeap.poll() ; 
            }
            
        }

        int[] res = new int[k] ;
        
        for (int i = k - 1; i >= 0; i--) { 
            res[i] = minHeap.poll()[0]; 
        }

        return res ; 
    }
}
