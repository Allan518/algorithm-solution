package com.allan;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for( char c : s.toCharArray()){
            if ( c == '('){
                stack.push(')');
            }
            else if ( c == '['){
                stack.push(']');
            }
            else if ( c == '{'){
                stack.push('}');
            }
            else if ( stack.isEmpty() || stack.pop() != c ){
                return false;
            }

        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();

        String checkStr = "{}()[](([{}]))";
        System.out.println(" The input string " + checkStr + " is " + (validParentheses.isValid(checkStr) ? "" : " not" )+ " valid");
    }
}
