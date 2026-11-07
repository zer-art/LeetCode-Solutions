class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0 ; 
        int high = arr.length -1 ; 
        int n = 0 ; 
        while(high >= low ){ 
            if(arr.length - n == k ){ 
                break ; 
            }

            int disLow = x - arr[low] ; 
            int disHigh = arr[high] - x ;

            if ( disLow > disHigh){
                low ++ ; 
                n++ ; 
            }else { 
                high -- ; 
                n++ ; 
            }   

        }

        List<Integer> res = new ArrayList<>() ; 
        for ( int i = low ; i <= high ; i++){ 
            res.add(arr[i]); 
        }

        return res ; 
    }
}
