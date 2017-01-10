package com.java2novice.ds.stack;
 
public class MyWordReverse {
 
    public String reverseWord(String word){
         
        StringBuilder sb = new StringBuilder();
        int size = word.length();
        StackImpl stack = new StackImpl(size);
        for(int i=0;i<size;i++){
            stack.push(word.charAt(i));
        }
        while(!stack.isStackEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
     
    public static void main(String a[]){
        MyWordReverse mwr = new MyWordReverse();
        System.out.println("Java2Novice == "+mwr.reverseWord("Java2Novice"));
        System.out.println("Java == "+mwr.reverseWord("Java"));
        System.out.println("program == "+mwr.reverseWord("program"));
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