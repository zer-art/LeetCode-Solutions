class Solution {
    private char forward = '(' ; 
    private char backward = ')' ; 

    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>() ;  
        StringBuilder sb = new StringBuilder() ; 
        int forwardCount = 0 ; 
        int backwardCount = 0 ; 

        helper ( out , n , sb , forwardCount , backwardCount ) ; 

        return out ; 
    }

    private void  helper( List<String> out , int n , StringBuilder sb , int forwardCount , int backwardCount ){ 
        if(forwardCount == n && backwardCount == n ){ 
            String s = sb.toString() ; 
            out.add(s) ; 
            return ; 
        }

        if( forwardCount < n ){ 
            sb.append(forward) ; 
            helper(out, n, sb , forwardCount+1 , backwardCount) ; 
            // reverseing the condition so we can backtrack 
            sb.deleteCharAt(sb.length() - 1) ; 
        }

        if(backwardCount < forwardCount ){ 
            sb.append(backward) ; 
            helper(out, n, sb , forwardCount , backwardCount + 1) ; 
            // reverseing the condition so we can backtrack 
            sb.deleteCharAt(sb.length() - 1) ; 
            
        }
       
    } 
}
