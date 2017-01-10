package com.java2novice.ds.stack;
 
public class MyDelimiterMatching {
 
    public static void main(String a[]){
        MyDelimiterMatching mdm = new MyDelimiterMatching();
        String expression = "{(a+b)*(c+d)}";
        boolean result = mdm.isDelimiterMatching(expression);
        System.out.println(expression +" == "+result);
         
        expression = "{(a+b)+[x*(c+d)]}";
        result = mdm.isDelimiterMatching(expression);
        System.out.println(expression +" == "+result);
         
        expression = "{(a+b)+[x*(c+d)}}";
        result = mdm.isDelimiterMatching(expression);
        System.out.println(expression +" == "+result);
    }
 
    public boolean isDelimiterMatching(String inputExpr) {
         
        int stackSize = inputExpr.length();
        StackImpl theStack = new StackImpl(stackSize);
        for (int j = 0; j < inputExpr.length(); j++) {
            char ch = inputExpr.charAt(j);
            switch (ch) {
            case '{':
            case '[':
            case '(':
                    theStack.push(ch);
                    break;
            case '}':
            case ']':
            case ')':
                    if (!theStack.isStackEmpty()) {
                        char stackContent = theStack.pop();
                        if ((ch == '}' && stackContent != '{') 
                                || (ch == ']' && stackContent != '[')
                                || (ch == ')' && stackContent != '(')){
                            System.out.println("Mismatch found: " + ch + " at " + j);
                            return false;
                        }
                    } else {
                        System.out.println("Mismatch found: " + ch + " at " + j);
                        return false;
                    }
                    break;
            default: break;
            }
        }
        if (!theStack.isStackEmpty()){
            System.out.println("Error: missing right delimiter");
            return false;
        }
        return true;
    }
}
 
 
class StackImpl {
 
    private int stackSize;
    private char[] stackArr;
    private int top;
 

    public StackImpl(int size) {
        this.stackSize = size;
        this.stackArr = new char[stackSize];
        this.top = -1;
    }
 

    public void push(char entry) {
        this.stackArr[++top] = entry;
    }
 

    public char pop() {
        char entry = this.stackArr[top--];
        return entry;
    }
     

    public char peek() {
        return stackArr[top];
    }
 

    public boolean isStackEmpty() {
        return (top == -1);
    }
 

    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
}