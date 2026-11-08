class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()) ; 
        int maxReach = startFuel;
        int stops = 0;
        
        for( int[] station : stations){ 
            int pos = station[0] ; 
            int fuel = station[1] ; 

            while ( maxReach < pos){ 
                if(maxHeap.isEmpty()){
                    return -1 ; 
                }
                maxReach += maxHeap.poll();
                stops++;
            }

            maxHeap.add(fuel);
        }

        while (maxReach < target){ 
            if(maxHeap.isEmpty()){ 
                return -1 ; 
            }
            maxReach += maxHeap.poll() ; 
            stops++ ; 
        }

        return stops ; 
    }
}
