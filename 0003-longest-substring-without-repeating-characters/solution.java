class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>  set = new HashSet<>();
        int res = 0 ;
        int low = 0 ; 
        for ( int high = 0 ; high < s.length() ; high ++){ 

            while ( set.contains(s.charAt(high))){ 
                set.remove(s.charAt(low)) ; 
                low++ ; 
            }

            set.add(s.charAt(high)) ; 
            res =  Math.max(set.size() , res ) ; 
        }

        return res ; 
    }
}
