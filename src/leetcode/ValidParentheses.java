package leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        char [] c=s.toCharArray();
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<c.length;++i){
            if(c[i]==')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()=='('){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else if(c[i]==']'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()=='['){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else if(c[i]=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()=='{'){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else {
                stack.add(c[i]);
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

}
