class Solution {
    private record Element(int value, int freq) {} ; 

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>() ; 
        PriorityQueue<Element> minHeap = new PriorityQueue<>(
            (a,b)->{ 
                if(a.freq() != b.freq()){ 
                    return a.freq() - b.freq() ; 
                }
                return a.value() - b.value() ; 
            }
        ) ; 

        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            Element elm = new Element(num,freq) ; 
            minHeap.add(elm) ; 

            if(minHeap.size() > k){ 
                minHeap.poll() ; 
            }
            
        } 

        int[] result = new int[k];

        for ( int i = 0 ; i < k ; i++ ){ 
            result[i] = minHeap.poll().value() ;
        }

        return result ; 
    }
}
