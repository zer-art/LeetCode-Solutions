class Solution {
    private boolean isMatch(int[] sFreq , int[] pFreq){ 
        for ( int i = 0 ; i < 26 ; i++){ 
            if(sFreq[i] != pFreq[i]) return false ; 
        }
        return true ; 
    }
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()){ 
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>() ; 

        int[] sFreq = new int [26] ; 
        int[] pFreq = new int [26] ; 

        for(int i = 0 ; i < p.length() ; i ++ ){ 
            int idx = p.charAt(i)-'a' ; 
            pFreq[idx]++ ; 
        }

        int high =  p.length() -1 ; 

        for(int i = 0 ; i < p.length() ; i ++ ){ 
            int idx = s.charAt(i)-'a' ; 
            sFreq[idx]++ ; 
        }

        int low = 0 ; 
        
        while(high < s.length()){ 
            if(isMatch(sFreq , pFreq )){ 
                res.add(low) ; 
            }
            if ( high <  s.length() - 1 ){ 
                high ++ ;
                int idx = s.charAt(high)-'a' ; 
                sFreq[idx]++ ; 
            }else { 
                break ; 
            }
            int idx = s.charAt(low)-'a' ; 
                sFreq[idx]--; 
            low++ ; 
        }

        return res ; 
    }
}