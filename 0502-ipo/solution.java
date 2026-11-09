class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int maxCapital = w ; 

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
        int[][] projects = new int[profits.length][2] ;  
        for( int pos = 0 ; pos < profits.length ; pos ++ ){ 
            projects[pos][0] = capital[pos] ; 
            projects[pos][1] = profits[pos] ; 
        }

        Arrays.sort(projects , (a,b) -> { return Integer.compare(a[0], b[0]) ;}) ; 

        int i = 0 ; 
        int j = 0 ; 
        while( i < k ){ 
            while (j < projects.length && maxCapital >= projects[j][0]){ 
                maxHeap.add(projects[j][1]) ; 
                j++ ; 
            }
            if (maxHeap.isEmpty()) {
                break;
            }
    
            maxCapital += maxHeap.poll(); 
            i++;

        }

        return maxCapital; 
    }
}
