class Solution {
    private boolean isMatch( int[] freqInS1 , int[] freqInS2 ){ 
        for (int i = 0 ; i < 26 ; i++ ){ 
            if ( freqInS1 [i] !=  freqInS2 [i]) return false ;
        }
        return true ; 
    }
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()){ 
            return false ; 
        }
        
        int[] freqInS1 = new int [26] ; 
        int[] freqInS2 = new int [26] ; 

        int low = 0 ; 
        int high = s1.length() -1 ; 

        for (int i = 0 ; i < s1.length(); i ++){ 
            freqInS1[s1.charAt(i) -'a']++ ; 
        }

        for (int i = 0 ; i < s1.length(); i ++){ 
            freqInS2[s2.charAt(i) -'a']++ ; 
        }

        while ( high < s2.length()){ 
            if (isMatch(freqInS1 ,freqInS2)){ 
                return true ; 
            }
            if (high < s2.length() - 1 ){ 
                high ++ ; 
                freqInS2[s2.charAt(high) -'a']++ ; 
            }else { 
                break ; 
            }
            freqInS2[s2.charAt(low) -'a'] -- ; 
            low ++ ;
            
        }
        return false ;  
    }
}
