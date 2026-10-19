class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Step 1: Count frequencies of all characters in the text
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Get counts for each required letter in "balloon"
        // 'l' and 'o' need to be divided by 2 because each word requires two of them
        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0) / 2;
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);
        
        // Step 3: Find the bottleneck (the minimum count among all required letters)
        int minBalloons = Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
        
        return minBalloons;
    }
}
