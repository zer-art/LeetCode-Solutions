import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    private record Element(char ch, int count) {}
    
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        
      
        HashMap<Character, Integer> map = new HashMap<>(); 
        for (char i : tasks) { 
            map.put(i, map.getOrDefault(i, 0) + 1); 
        }

        PriorityQueue<Element> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.count(), a.count())
        ); 

        for (Map.Entry<Character, Integer> entry : map.entrySet()) { 
            maxHeap.add(new Element(entry.getKey(), entry.getValue()));
        }

        int maxFreq = maxHeap.poll().count(); 
        
        int numMaxTasks = 1; 
        while (!maxHeap.isEmpty() && maxHeap.peek().count() == maxFreq) { 
            maxHeap.poll(); 
            numMaxTasks++; 
        }

        int res = (maxFreq - 1) * (n + 1) + numMaxTasks; 
        
        return Math.max(res, tasks.length); 
    }
}
