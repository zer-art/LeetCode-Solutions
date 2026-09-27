class Solution {
    private int algo(int n) {
        int val = 0;
        while (n > 0) {
            int digit = n % 10;
            val += digit * digit;
            n /= 10;
        }
        return val;
    }
    
    public boolean isHappy(int n) {
        if ( algo(n) == 1 ) return true ; 
        
        int fast = n ; 
        int slow = n ; 

        while ( fast != 1 ){ 
            slow = algo(slow) ;
            fast = algo(algo(fast)) ; 
            if ( fast == slow ){ 
                return false ; 
            }
        }
        return true ; 
    }
}