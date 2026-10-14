class Solution {
    public int[][] merge(int[][] intervals) {  
        List<int[]> mergeList = new ArrayList<>(); 
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0] , b[0])) ; 
        int s1 = intervals[0][0];
        int e1 = intervals[0][1];
    
        for ( int i = 1 ; i < intervals.length ; i++){ 
            int s2 = intervals[i][0] ; 
            int e2 = intervals[i][1] ; 
            
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
