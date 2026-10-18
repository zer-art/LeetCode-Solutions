class Solution {
    class Elem{
        char c ; 
        int count ;

        Elem(char c , int count){ 
            this.c = c ; 
            this.count = count  ; 
        } 

    }
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder() ; 
        Deque<Elem> st = new ArrayDeque<>() ;

        if(s.length() == 0){ 
            return "" ;
        }
        st.push(new Elem (s.charAt(0) , 1)) ; 

        for ( int i = 1 ; i < s.length() ; i++){ 
            if (!st.isEmpty() && s.charAt(i) == st.peek().c){ 
                st.peek().count++ ; 
            }else { 
                st.push(new Elem (s.charAt(i) , 1)) ; 
            }
            if(st.peek().count == k){ 
                st.pop() ; 
            }
            
        }

        while (!st.isEmpty()){ 
            Elem curr = st.pop();
            for(int i = 0 ; i < curr.count ;i++){ 
                sb.append(curr.c) ; 
            }
        }
        sb.reverse(); 
        String result = sb.toString() ; 
        return result ; 
         
    }
}
