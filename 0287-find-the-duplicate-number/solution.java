class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0 ; 
        int slow = 0 ; 

        int dup = -1 ; 
        while (true){ 
            fast = nums[nums[fast]] ; 
            slow = nums[slow] ; 
            
            if(fast == slow ){ 
                slow = 0 ; 
                while (fast!=slow){ 
                    slow = nums[slow];
                    fast = nums[fast];
                    if ( fast == slow ){ 
                        dup = fast ; 
                        break ; 
                    }
                }
                break ; 
            }
        }
        return dup ; 
    }
}
