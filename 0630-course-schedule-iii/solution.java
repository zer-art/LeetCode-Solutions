class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses , (a,b) -> {return a[1] - b[1] ; }) ; 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()) ; 

        int totalTime = 0 ; 
        int totalSelected = 0 ; 
        
        for ( int[] i : courses){ 

            if (totalTime + i[0] <= i[1]){ 
                totalTime += i[0] ; 
                totalSelected++ ; 
                maxHeap.add(i[0]);
            }else { 
                if((!maxHeap.isEmpty()) && maxHeap.peek() > i[0]){ 
                    totalTime -= maxHeap.poll() ; 
                    totalTime += i[0] ; 
                    maxHeap.add(i[0]) ; 
                }
            }
        }

        return totalSelected ; 
    }
}
