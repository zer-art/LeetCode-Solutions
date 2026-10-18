class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder(); 
        String[] filePath = path.split("/");
        Deque<String> st = new ArrayDeque<>() ; 

        for (String f : filePath){ 
            if (!st.isEmpty() && f.equals("..")){ 
                st.pop();
            }else if ( st.isEmpty() && f.equals("..")){ 
                continue ; 
            }else if (f.equals(".") || f.equals(" ") || f.isEmpty()) { 
                continue ; 
            }else { 
                st.push(f) ;
            }    
        }

        if(st.isEmpty()){ 
            return "/" ; 
        }else { 
            Iterator<String> it = st.descendingIterator();
            while (it.hasNext()) {
                sb.append("/").append(it.next());
            }
        }
        
        String result = sb.toString() ; 
        return result ; 
    }
}
