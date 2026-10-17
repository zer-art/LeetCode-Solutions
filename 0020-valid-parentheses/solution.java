/* class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Deque <Character> stack =  new ArrayDeque<>() ; 
        HashMap<Character,Character> brackets = new HashMap<>() ; 
        brackets.put(')' , '(') ; 
        brackets.put('}' , '{') ; 
        brackets.put(']' , '[') ; 

        for( int i = 0 ; i < s.length() ; i++){ 
            if ( stack.isEmpty() || brackets.get(s.charAt(i)) != stack.peek()){ 
                stack.push(s.charAt(i)) ;
            }else { 
                stack.pop() ; 
            }
        }
        return stack.isEmpty() ; 
    }
}

*/ 

class Solution {

    public boolean isValid(String s) {
        // A valid string must have an even number of characters
        if (s.length() % 2 != 0) return false; 
        
        Deque<Character> stack = new ArrayDeque<>();
        
        // Using toCharArray() is often faster than charAt(i) in a loop
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, it must match the top of the stack
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
