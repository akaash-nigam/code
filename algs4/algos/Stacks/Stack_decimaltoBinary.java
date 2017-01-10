package com.java2novice.ds.stack;
 
public class MyDecimalToBinary {
 
    public static String convertDecialToBinary(int number){
         
        StringBuilder binary = new StringBuilder();
        MyDynamicStack stack = new MyDynamicStack(10);
        if(number == 0){
            binary.append("0");
        } else {
            while(number != 0){
                stack.push(number%2);
                number = number/2;
            }
        }
        while(!stack.isStackEmpty()){
            try {
                binary.append(stack.pop());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return binary.toString();
    }
     
    public static void main(String a[]){
        System.out.println("Binary value of 2 is: "+convertDecialToBinary(2));
        System.out.println("Binary value of 15 is: "+convertDecialToBinary(15));
        System.out.println("Binary value of 23 is: "+convertDecialToBinary(23));
    }
}
 
 
class MyDynamicStack {
 
    private int stackSize;
    private int[] stackArr;
    private int top;
 

    public MyDynamicStack(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }
 
    public void push(int entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
 
    public int pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this.stackArr[top--];
        //System.out.println("Removed entry: "+entry);
        return entry;
    }
     
    public long peek() {
        return stackArr[top];
    }
 
    private void increaseStackCapacity(){
         
        int[] newStack = new int[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
     

    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
 
    public static void main(String[] args) {
        MyDynamicStack stack = new MyDynamicStack(2);
        for(int i=1;i<10;i++){
            stack.push(i);
        }
        for(int i=1;i<4;i++){
            try {
                stack.pop();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
 }