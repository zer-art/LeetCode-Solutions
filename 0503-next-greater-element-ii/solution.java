class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int result [] = new int [nums.length] ; 
        Deque<Integer> st = new ArrayDeque<>() ; 

        for ( int i = 0 ; i < nums.length ; i++ ){ 
            result[i] = -1 ; 
        }
        for ( int i = 0 ; i < nums.length*2 ; i++ ){ 
            int currIdx = i % nums.length ; 

            while ( !st.isEmpty() && nums[currIdx] >  nums[st.peek()]){ 
                int prevIdx = st.pop() ; 
                result[prevIdx] = nums[currIdx] ; 
            }

            if(i < nums.length){ 
                st.push(currIdx) ; 
            }
        }
        return result ;  
    }
}
