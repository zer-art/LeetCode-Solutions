class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergeList = new ArrayList<>() ;
        boolean insert = false ; 

        int i = 0 ;
        int j = 0 ; 

        int [][] intervals1 = new int [intervals.length+1][2] ;
        
        // 1. Copy all intervals that come strictly before newInterval
        while (i < intervals.length && intervals[i][0] < newInterval[0]) {
            intervals1[j] = intervals[i];
            i++;
            j++;
        }

        // 2. Insert newInterval
        intervals1[j] = newInterval;
        j++;

        // 3. Copy the remaining intervals
        while (i < intervals.length) {
            intervals1[j] = intervals[i];
            i++;
            j++;
        }
        
        // merging 
        int s1 = intervals1[0][0];
        int e1 = intervals1[0][1];
    
        for ( i = 1 ; i < intervals1.length ; i++){ 
            int s2 = intervals1[i][0] ; 
            int e2 = intervals1[i][1] ; 
            
            if(e1 >= s2){ 
                e1 = Math.max(e2,e1) ; 
            }else { 
                mergeList.add(new int [] {s1 ,e1}) ; 
                s1 = s2 ;  
                e1 = e2 ; 
                
            }
        
        }
        mergeList.add(new int [] {s1 ,e1}) ;
        
        int[][] result = mergeList.toArray(new int[mergeList.size()][]);
        return result;
    }
}
