public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
        switch (s.charAt(i)) {
            case '(':
                stack.push('(');
                break;
            case '{':
                stack.push('{');
                break;
            case '[':
                stack.push('[');
                break;
            case ')':
                if (stack.size() == 0 || stack.pop() != '(')
                    return false;
                break;
            case '}':
                if (stack.size() == 0 || stack.pop() != '{')
                    return false;
                break;
            case ']':
                if (stack.size() == 0 || stack.pop() != '[')
                    return false;
                break;
        }
    }
    return stack.isEmpty();
}


public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        return stack.empty();
    }
}
