class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length < 2){ 
            return stones[0] ; 
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder() ) ; 
        
        for (int i : stones ) maxHeap.add(i) ; 
        
        while ( !maxHeap.isEmpty() ){ 
            if (maxHeap.size() < 2 ){ 
                return maxHeap.poll() ; 
            }

            int first = maxHeap.poll() ; 
            int second = maxHeap.poll() ; 

           if (first != second) {
                maxHeap.add(first - second); 
            }
        }

        return 0 ; 
    }
}
