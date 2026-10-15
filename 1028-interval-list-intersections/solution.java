class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> inter = new ArrayList<>() ;

        if(firstList.length == 0 || secondList.length==0){ 
            return new int[][]{} ; 
        }
        
        int i = 0 ; 
        int j = 0 ; 
        while(true){ 
            if ( i == firstList.length || j == secondList.length){ 
                break ; 
            }
            int sf = firstList[i][0] ; 
            int ef = firstList[i][1] ; 

            int ss = secondList[j][0] ;
            int es = secondList[j][1] ; 
            
            int s =  Math.max(sf,ss) ;
            int f = Math.min(ef,es) ; 

            if(s<=f){ 
                inter.add(new int[] {s,f}); 
            }

            if ( es > ef){ 
                i++ ; 
            }else { 
                j++ ; 
            }

        }

        int [][] result = inter.toArray(new int [inter.size()][2]) ;
        return result ; 
    }
}
