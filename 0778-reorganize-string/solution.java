class Solution {
    private record Element(char ch, int count) {}

    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        
        // Count frequencies
        for (char c : ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Max heap ordered by frequency (descending) and then character (alphabetical)
        PriorityQueue<Element> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a.count() != b.count()) {
                    return b.count() - a.count();
                }
                return a.ch() - b.ch();
            }
        );

        // Add elements to the heap
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(new Element(entry.getKey(), entry.getValue()));
        }

        // If the most frequent character is too frequent to separate, return ""
        if (maxHeap.peek().count() > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int pos = 0;

        // Place characters in the array
        while (!maxHeap.isEmpty()) {
            Element current = maxHeap.poll();
            char c = current.ch();
            int count = current.count();

            // Fill the array skipping one spot each time
            while (count > 0) {
                // Once we go past the end of the array, wrap around to index 1 (odd indices)
                if (pos >= s.length()) {
                    pos = 1;
                }
                
                res[pos] = c;
                pos += 2;
                count--;
            }
        }

        // Return the final string
        return new String(res);
    }
}
