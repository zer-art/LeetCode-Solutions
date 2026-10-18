class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length ; 
        int[] ans  = new int[n] ; 
        Deque<Integer> st = new ArrayDeque<>() ; 

        for ( int i = 0 ; i < n ; i++){ 
            ans[i] = 0 ; 
        } 

        for (int i = 0 ; i < n ; i++ ){ 
            while ( !st.isEmpty() && temperatures[st.peek()] < temperatures[i] ){ 
                int prevIdx = st.pop() ; 
                ans[prevIdx] = i-prevIdx;   
            }
            st.push(i) ; 
        }


        return ans ; 
    }
}
