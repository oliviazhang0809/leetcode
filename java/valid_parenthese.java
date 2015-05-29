public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack == null || stack.isEmpty() || helper(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    public Character helper(Character c) {
        if (c == '(') return ')';
        else if (c == '{') return '}';
        else return ']';
    }
}