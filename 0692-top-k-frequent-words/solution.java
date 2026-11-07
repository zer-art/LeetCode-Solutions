class Solution {
    private record Element(String word , int freq ){} ;

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>() ; 

        for (String s : words ) map.put(s,map.getOrDefault(s,0)+1) ; 
        PriorityQueue<Element> minHeap = new PriorityQueue<>(
            (a,b) -> { 
                if(a.freq() != b.freq()) return b.freq() - a.freq() ; 
                return a.word().compareTo(b.word()) ; 
            }
        ) ; 

        map.forEach((word,freq)->{ 
            Element elm = new Element(word,freq) ; 
            minHeap.add(elm) ; 

        }) ; 

        List<String> result = new ArrayList<>() ; 

        for (int i = 0 ; i < k ; i++){ 
            result.add(minHeap.poll().word()) ; 
        }
    
        return result ; 
    }
}
