class Solution {
    public int maximumSum(int[] arr) {
        int bestEnding = arr[0] ; 
        int bestEndingWithDel = arr[0] ; 
        int ans = arr[0] ; 
        
        for ( int i = 1 ; i < arr.length ; i ++){             
            bestEndingWithDel = Math.max(bestEnding , bestEndingWithDel + arr[i]  ) ; 
            bestEnding = Math.max(arr[i] , bestEnding + arr[i]  ); 
            
            int currAns = Math.max( bestEnding , bestEndingWithDel );
            ans = Math.max(currAns , ans ) ; 
        }
        return ans ; 
    }
}
