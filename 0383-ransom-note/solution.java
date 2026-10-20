import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // 1. Map the ransom note (record exactly what we need)
        // Using .charAt(i) avoids the memory overhead of .toCharArray()
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 2. Search through the magazine
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            
            // If we need this character, decrement its requirement
            if (map.containsKey(c)) {
                int count = map.get(c);
                
                if (count == 1) {
                    // We found all needed instances of this specific character
                    map.remove(c); 
                    
                    // SUCCEED FAST: If the map is completely empty, we're done!
                    // We don't have to read the rest of the magazine.
                    if (map.isEmpty()) {
                        return true; 
                    }
                } else {
                    map.put(c, count - 1);
                }
            }
        }

        // If we finish the entire magazine and the map isn't empty, we failed
        return map.isEmpty(); 
    }
}
