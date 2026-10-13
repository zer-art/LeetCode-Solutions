class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0; 
        int currSum = 0; 
        HashMap<Integer, Integer> map = new HashMap<>(); 

        map.put(0, 1); 
        for (int i = 0; i < nums.length; i++) { 
            // 1. Update the running sum with the current element
            currSum += nums[i]; 
            
            int rem = ((currSum % k) + k) % k; 
            
            if (map.containsKey(rem)) { 
                // 2. Add the frequency of how many times we've seen this remainder
                res += map.get(rem); 
            }
            
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return res; 
    }
}
