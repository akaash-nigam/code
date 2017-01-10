Code 2. Stack

package com.java2novice.ds.stack;
 
public class MyGenericsStack<T extends Object> {
 
    private int stackSize;
    private T[] stackArr;
    private int top;
     
    /**
     * constructor to create stack with size
     * @param size
     */
    @SuppressWarnings("unchecked")
    public MyGenericsStack(int size) {
        this.stackSize = size;
        this.stackArr = (T[]) new Object[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top 
     * of the stack
     * @param entry
     * @throws Exception 
     */
    public void push(T entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the 
     * top of the stack.
     * @return
     * @throws Exception 
     */
    public T pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        T entry = this.stackArr[top--];
        System.out.println("Removed entry: "+entry);
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public T peek() {
        return stackArr[top];
    }
 
    private void increaseStackCapacity(){
         
        @SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
     
    /**
     * This method returns true if the stack is 
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
     
    public static void main(String a[]){
        MyGenericsStack<String> stringStack = new MyGenericsStack<String>(2);
        stringStack.push("java2novice");
        MyGenericsStack<Integer> integerStack = new MyGenericsStack<Integer>(2);
        integerStack.push(23);
    }
}
—— —— —— —— —— —— —— —— —— —— —— —— —— —— —— 

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
 
    /**
     * constructor to create stack with size
     * @param size
     */
    public StackImpl(int size) {
        this.stackSize = size;
        this.stackArr = new char[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top 
     * of the stack
     * @param entry
     * @throws Exception 
     */
    public void push(char entry) {
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the 
     * top of the stack.
     * @return
     * @throws Exception 
     */
    public char pop() {
        char entry = this.stackArr[top--];
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public char peek() {
        return stackArr[top];
    }
 
    /**
     * This method returns true if the stack is 
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
}


—— 

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
 
    /**
     * constructor to create stack with size
     * @param size
     */
    public StackImpl(int size) {
        this.stackSize = size;
        this.stackArr = new char[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top 
     * of the stack
     * @param entry
     * @throws Exception 
     */
    public void push(char entry) {
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the 
     * top of the stack.
     * @return
     * @throws Exception 
     */
    public char pop() {
        char entry = this.stackArr[top--];
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public char peek() {
        return stackArr[top];
    }
 
    /**
     * This method returns true if the stack is 
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
}


———— 

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
 
    /**
     * constructor to create stack with size
     * @param size
     */
    public MyDynamicStack(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top 
     * of the stack
     * @param entry
     * @throws Exception 
     */
    public void push(int entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the 
     * top of the stack.
     * @return
     * @throws Exception 
     */
    public int pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this.stackArr[top--];
        //System.out.println("Removed entry: "+entry);
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
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
     
    /**
     * This method returns true if the stack is 
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
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
}
—— 
package com.java2novice.ds.stack;
 
public class TowersOfHanoiImpl {
     
    private static MyDynamicStack[] tower; 
     
    public static void towersOfHanoi(int n) {
 
        // create three stacks, tower[0] is scratch
        tower = new MyDynamicStack[4];
        for (int i = 0; i <= 3; i++){
            tower[i] = new MyDynamicStack(4);
        }
        for (int d = n; d > 0; d--){
            // initialize
            // add disk d to tower 1
            tower[1].push(new Integer(d)); 
        }
        // move n disks from tower 1 to 2 using 3 as
        // intermediate tower
        showTowerStates(n, 1, 2, 3);
    }
 
    public static void showTowerStates(int n, int x, int y, int z) {
         
        if (n > 0) {
            try{
                showTowerStates(n - 1, x, z, y);
                // move d from top of tower x
                Integer d = (Integer) tower[x].pop(); 
                // to top of tower y
                tower[y].push(d); 
                System.out.println("Move disk " + d 
                        + " from tower "+ x + " to top of tower " + y);
                showTowerStates(n - 1, z, y, x);
            } catch(Exception ex){}
        }
    }
 
    public static void main(String[] args) {
        System.out.println("Running 3 disk problem:");
        towersOfHanoi(3);
    }
}
 
public class MyDynamicStack {
 
    private int stackSize;
    private int[] stackArr;
    private int top;
 
    /**
     * constructor to create stack with size
     * @param size
     */
    public MyDynamicStack(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top 
     * of the stack
     * @param entry
     * @throws Exception 
     */
    public void push(int entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the 
     * top of the stack.
     * @return
     * @throws Exception 
     */
    public int pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this.stackArr[top--];
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
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
     
    /**
     * This method returns true if the stack is 
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
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
}
—— 


package com.java2novice.ds.stack;
 
import java.util.StringTokenizer;
 
public class InfixFullParantEx {
 
    public static String evaluateInfix(String exps){
         
        /**remove if any spaces from the expression**/
        exps = exps.replaceAll("\\s+", "");
        /**we assume that the expression is in valid format**/
        MyGenericsStack<String> stack = new MyGenericsStack<String>(exps.length());
        /**break the expression into tokens**/
        StringTokenizer tokens = new StringTokenizer(exps, "{}()*/+-", true);
        while(tokens.hasMoreTokens()){
            String tkn = tokens.nextToken();
            /**read each token and take action**/
            if(tkn.equals("(") 
                    || tkn.equals("{")
                    || tkn.matches("[0-9]+") 
                    || tkn.equals("*")
                    || tkn.equals("/")
                    || tkn.equals("+")
                    || tkn.equals("-")){
                /**push token to the stack**/
                stack.push(tkn);
            } else if(tkn.equals("}") || tkn.equals(")")){
                try {
                    int op2 = Integer.parseInt(stack.pop()); 
                    String oprnd = stack.pop();
                    int op1 = Integer.parseInt(stack.pop());
                    /**Below pop removes either } or ) from stack**/
                    if(!stack.isStackEmpty()){
                        stack.pop();
                    }
                    int result = 0;
                    if(oprnd.equals("*")){
                        result = op1*op2;
                    } else if(oprnd.equals("/")){
                        result = op1/op2;
                    } else if(oprnd.equals("+")){
                        result = op1+op2;
                    } else if(oprnd.equals("-")){
                        result = op1-op2;
                    }
                    /**push the result to the stack**/
                    stack.push(result+"");
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
        String finalResult = "";
        try {
            finalResult = stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalResult;
    }
     
    public static void main(String a[]){
        String expr = "((2*5)+(6/2))";
        System.out.println("Expression: "+expr);
        System.out.println("Final Result: "+evaluateInfix(expr));
        expr = "(((2 * 5) - (1 * 2)) / (11 - 9))";
        System.out.println("Expression: "+expr);
        System.out.println("Final Result: "+evaluateInfix(expr));
         
    }
}
 
/**
 * Stack implementation
 */
public class MyGenericsStack<T extends Object> {
 
    private int stackSize;
    private T[] stackArr;
    private int top;
     
    /**
     * constructor to create stack with size
     * @param size
     */
    @SuppressWarnings("unchecked")
    public MyGenericsStack(int size) {
        this.stackSize = size;
        this.stackArr = (T[]) new Object[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top 
     * of the stack
     * @param entry
     * @throws Exception 
     */
    public void push(T entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the 
     * top of the stack.
     * @return
     * @throws Exception 
     */
    public T pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        T entry = this.stackArr[top--];
        System.out.println("Removed entry: "+entry);
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public T peek() {
        return stackArr[top];
    }
 
    private void increaseStackCapacity(){
         
        @SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
     
    /**
     * This method returns true if the stack is 
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
}


* Array implementation of Stack
* LinkedList implementation of Stack
* Dequeue Interface of Java that we will be using instead of Stack. 
* Applications. 
    * Infix to postfix. 
    * infix to prefix. 
    * postfix to infix. 
    * prefix to infix. 
    * Expression Evolution. 
    * Infix to PostFix
    * Infix to Prefix
    * PostFix to Infix
    * Prefix to Infix. 
    * Parenthesis check using Stack. 
    * Prefix: Reverse Polish Notation
    * Postfix.: Polish Notation. 
http://www.cs.man.ac.uk/~pjj/cs212/fix.html
Infix: Infix. 
￼
— — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — 
Conversation one: Intfix to Postfix. 

Infix String: 
Stack
char ch = input.charAt(j);
switch (ch);
    case ‘+’
    case’-‘:
    case’*’:
    case’/‘:





Book1:Stack, Queue Implementation. 

All the basic code:

————————————————————————————————————————————————————————————————————
public class Int2BaseString {
    public static void main(String args[]) {
        int n = 200;
        int base = 3;
        String s = "";
        System.out.print(n);
        do {
            s = n % base + s;
            n = n / base;
        } while (n > 0);
        System.out.print(" = ");
        System.out.print(s);
        System.out.print(" in base ");
        System.out.println(base);
    }
}
————————————————————————————————————————————————————————————————————
public class intSqRoot {
    public static void main(String args[]) {
        int x = 25;
        for (x = 0; x < 32; x++) {
            System.out.print("X = " + x);
            int low = 0;
            int high = x;
            while (low < high) {
                int mid = (low + high)/2;
                if (mid * mid < x) low = mid + 1;
                else high = mid;
            }
            if (high * high != x) high = high - 1;
            System.out.println("  IntSqRoot = " + high);
        }
    }
}

1. http://www.iitk.ac.in/esc101/08Jan/sample/Average.java

————————————————————————————————————————————————————————————————————

import java.util.Scanner;

class Numbers {
    final public static int MAX = 20;
    int []numbers;

    int readInNumbers() {
        // Read as many numbers as given on stdin
        // and return the count of numbers.
        // Maximum numbers that can be taken is MAX
        int i=0;
        Scanner in = new Scanner(System.in);
        numbers = new int[MAX];
        while ((i<MAX) && (in.hasNextInt()))
            numbers[i++] = in.nextInt();
        return i;
    }
    int sumOfNumbers(int sz) {
        int i, s = 0;
        for (i = 0, s = 0; i<sz; i++)
            s = s + numbers[i];
        return s;
    }
}

————————————————————————————————————————————————————————————————————
public class Average {
    public static void main(String args[]) {
        Numbers nums = new Numbers();
        int sz;
        System.out.println("Type in up to " + Numbers.MAX + " integers");
        sz = nums.readInNumbers();
        if (sz == 0) {
            System.err.println("Not Enough Numbers");
            return;
        }
        System.out.println("Average: " + (double)(nums.sumOfNumbers(sz))/
                (double)sz);
    }
}


———————————————————————————————————————————————————————————————————— 
1. http://www.iitk.ac.in/esc101/08Jan/sample/Cal.java

import java.util.Scanner;
class Year {
    int year;
    Year() {
        this.year = 2000;
    }
    Year(int y) {
        year = (y > 1900) ? y: 1900;
    }
    Year(Year y) {
        year = y.year;
    }
    public static boolean isLeap(int year) {
        if ((year % 400) == 0) return true;
        if ((year % 100) == 0) return false;
        if ((year % 4) == 0) return true;
        return false;
    }
    boolean isLeap() {
        return isLeap(year);
    }
    int weekDay() {
        int date = Date.MON; // Day on 1.1.1900
        int i;
        for (i = 1900; i < year; i++)
            date = (date + 365 + (isLeap(i)?1:0)) % 7;
        return date;
    }
    public String toString() {
        return "" + year;
    }
}
——

Code: 3: Queue

Code1: 

package com.java2novice.ds.queue;


public Class QueueImpl{
    private int capacity;
    int queueArr[];
    int front=0;
    int rear=-1;
    int currentSize=0
    public QueueIml(int queueSize){

    }

}


public class QueueImpl{
    private int capacity;
    int queueArr[];
    int front=0;
    int rear =-1;
    int currentSize =0;

    public QueueImp(int queueSize){
}

    public QueueImpl(int queueSize){
        this.capacity=queueSizel;
        queueArr= new int[this.capacity];
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: "+item);
        } else {
            rear++;
            if(rear == capacity-1){
                rear = 0;
            }
            queueArr[rear] = item;
            currentSize++;
            System.out.println("Element " + item+ " is pushed to Queue !");
        }
}

public class QueueImpl {
    private int capacity;
    int queueArr[];
    int front = 0;
    int rear = -1;
    int currentSize = 0;
    
    public QueueImpl(int queueSize){
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    /**
     * this method adds element at the end of the queue.
     * @param item
     */
    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: "+item);
        } else {
            rear++;
            if(rear == capacity-1){
                rear = 0;
            }
            queueArr[rear] = item;
            currentSize++;
            System.out.println("Element " + item+ " is pushed to Queue !");
        }
    }

    /**
     * this method removes an element from the top of the queue
     */
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            front++;
            if(front == capacity-1){
                System.out.println("Pop operation done ! removed: "+queueArr[front-1]);
                front = 0;
            } else {
                System.out.println("Pop operation done ! removed: "+queueArr[front-1]);
            }
            currentSize--;
        }
    }

    /**
     * This method checks whether the queue is full or not
     * @return boolean
     */
    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == capacity){
            status = true;
        }
        return status;
    }
    
    /**
     * This method checks whether the queue is empty or not
     * @return
     */
    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){
            status = true;
        }
        return status;
    }
    
    public static void main(String a[]){
        
        QueueImpl queue = new QueueImpl(4);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(24);
        queue.dequeue();
        queue.enqueue(98);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(435);
    }
}


Array implementation of Queue has four methods. 
1. empty
2. full
3. queue
4. deque. 
——————————————————————————————————————————————————————
package com.java2novice.ds.queue;
 
public class DynamicQueueImpl {
 
    private int capacity = 2;
    int queueArr[];
    int front = 0;
    int rear = -1;
    int currentSize = 0;
     
    public DynamicQueueImpl(){
        queueArr = new int[this.capacity];
    }
 
    /**
     * this method adds element at the end of the queue.
     * @param item
     */
    public void enqueue(int item) {
         
        if (isQueueFull()) {
            System.out.println("Queue is full, increase capacity...");
            increaseCapacity();
        }
        rear++;
        if(rear >= queueArr.length && currentSize != queueArr.length){
            rear = 0;
        }
        queueArr[rear] = item;
        currentSize++;
        System.out.println("Adding: " + item);
    }
 
    /**
     * this method removes an element from the top of the queue
     */
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            front++;
            if(front > queueArr.length-1){
                System.out.println("removed: "+queueArr[front-1]);
                front = 0;
            } else {
                System.out.println("removed: "+queueArr[front-1]);
            }
            currentSize--;
        }
    }
 
    /**
     * This method checks whether the queue is full or not
     * @return boolean
     */
    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == queueArr.length){
            status = true;
        }
        return status;
    }
     
    /**
     * This method checks whether the queue is empty or not
     * @return
     */
    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){
            status = true;
        }
        return status;
    }
     
    private void increaseCapacity(){
         
        //create new array with double size as the current one.
        int newCapacity = this.queueArr.length*2;
        int[] newArr = new int[newCapacity];
        //copy elements to new array, copy from rear to front
        int tmpFront = front;
        int index = -1;
        while(true){
            newArr[++index] = this.queueArr[tmpFront];
            tmpFront++;
            if(tmpFront == this.queueArr.length){
                tmpFront = 0;
            }
            if(currentSize == index+1){
                break;
            }
        }
        //make new array as queue
        this.queueArr = newArr;
        System.out.println("New array capacity: "+this.queueArr.length);
        //reset front & rear values
        this.front = 0;
        this.rear = index;
    }
     
    public static void main(String a[]){
         
        DynamicQueueImpl queue = new DynamicQueueImpl();
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.dequeue();
        queue.enqueue(24);
        queue.enqueue(98);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(435);
        queue.dequeue();
        queue.dequeue();
    }
}
—— ——————————————
package com.java2novice.ds.queue;
 
import java.util.ArrayList;
import java.util.List;
 
public class DoubleEndedQueueImpl {
 
    private List<Integer> deque = new ArrayList<Integer>();
     
    public void insertFront(int item){
        //add element at the beginning of the queue
        System.out.println("adding at front: "+item);
        deque.add(0,item);
        System.out.println(deque);
    }
     
    public void insertRear(int item){
        //add element at the end of the queue
        System.out.println("adding at rear: "+item);
        deque.add(item);
        System.out.println(deque);
    }
     
    public void removeFront(){
        if(deque.isEmpty()){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        //remove an item from the beginning of the queue
        int rem = deque.remove(0);
        System.out.println("removed from front: "+rem);
        System.out.println(deque);
    }
     
    public void removeRear(){
        if(deque.isEmpty()){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        //remove an item from the beginning of the queue
        int rem = deque.remove(deque.size()-1);
        System.out.println("removed from front: "+rem);
        System.out.println(deque);
    }
     
    public int peakFront(){
        //gets the element from the front without removing it
        int item = deque.get(0);
        System.out.println("Element at first: "+item);
        return item;
    }
     
    public int peakRear(){
        //gets the element from the rear without removing it
        int item = deque.get(deque.size()-1);
        System.out.println("Element at rear: "+item);
        return item;
    }
     
    public static void main(String a[]){
        DoubleEndedQueueImpl deq = new DoubleEndedQueueImpl();
        deq.insertFront(34);
        deq.insertRear(45);
        deq.removeFront();
        deq.removeFront();
        deq.removeFront();
        deq.insertFront(21);
        deq.insertFront(98);
        deq.insertRear(5);
        deq.insertFront(43);
        deq.removeRear();
    }
}
——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— ——— 

package com.java2novice.ds.queue;
 
public class DequeDblLinkedListImpl<T> {
 
    private Node<T> front;
    private Node<T> rear;
     
    public void insertFront(T item){
        //add element at the beginning of the queue
        System.out.println("adding at front: "+item);
        Node<T> nd = new Node<T>();
        nd.setValue(item);
        nd.setNext(front);
        if(front != null) front.setPrev(nd);
        if(front == null) rear = nd;
        front = nd;
    }
     
    public void insertRear(T item){
        //add element at the end of the queue
        System.out.println("adding at rear: "+item);
        Node<T> nd = new Node<T>();
        nd.setValue(item);
        nd.setPrev(rear);
        if(rear != null) rear.setNext(nd);
        if(rear == null) front = nd;
         
        rear = nd;
    }
     
    public void removeFront(){
        if(front == null){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        //remove an item from the beginning of the queue
        Node<T> tmpFront = front.getNext();
        if(tmpFront != null) tmpFront.setPrev(null);
        if(tmpFront == null) rear = null;
        System.out.println("removed from front: "+front.getValue());
        front = tmpFront;
    }
     
    public void removeRear(){
        if(rear == null){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        //remove an item from the beginning of the queue
        Node<T> tmpRear = rear.getPrev();
        if(tmpRear != null) tmpRear.setNext(null);
        if(tmpRear == null) front = null;
        System.out.println("removed from rear: "+rear.getValue());
        rear = tmpRear;
    }
     
    public static void main(String a[]){
        DequeDblLinkedListImpl<Integer> deque = new DequeDblLinkedListImpl<Integer>();
        deque.insertFront(34);
        deque.insertFront(67);
        deque.insertFront(29);
        deque.insertFront(765);
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
        deque.insertRear(43);
        deque.insertRear(83);
        deque.insertRear(84);
        deque.insertRear(546);
        deque.insertRear(356);
        deque.removeRear();
        deque.removeRear();
        deque.removeRear();
        deque.removeRear();
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
    }
}
 
class Node<T>{
     
    private Node<T> prev;
    private Node<T> next;
    private T value;
     
    public Node<T> getPrev() {
        return prev;
    }
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}
—————————————————— 

package com.java2novice.ds.queue;
 
public class PriorityQueueImpl {
    @SuppressWarnings("rawtypes")
    private Comparable[] pQueue;
    private int index;

         public PriorityQueueImpl(int capacity){
        pQueue = new Comparable[capacity];
    }
     
    public void insert(Comparable item ){
        if(index == pQueue.length){
            System.out.println("The priority queue is full!! can not insert.");
            return;
        }
        pQueue[index] = item;
        index++;
        System.out.println("Adding element: "+item);
    }
     
    @SuppressWarnings("unchecked")
    public Comparable remove(){
        if(index == 0){
            System.out.println("The priority queue is empty!! can not remove.");
            return null;
        }
        int maxIndex = 0;
        // find the index of the item with the highest priority 
        for (int i=1; i<index; i++) { 
            if (pQueue[i].compareTo (pQueue[maxIndex]) > 0) { 
                maxIndex = i; 
            } 
        } 
        Comparable result = pQueue[maxIndex]; 
        System.out.println("removing: "+result);
        // move the last item into the empty slot 
        index--; 
        pQueue[maxIndex] = pQueue[index]; 
        return result;
    }
     
    public static void main(String a[]){
        PriorityQueueImpl pqi = new PriorityQueueImpl(5);
        pqi.insert(34);
        pqi.insert(23);
        pqi.insert(5);
        pqi.insert(87);
        pqi.insert(32);
        pqi.remove();
        pqi.remove();
        pqi.remove();
        pqi.remove();
        pqi.remove();
    }
}


stack implementation practice
package com.java2novice.ds.stack;

public class MyGenericStack<T extends Object>{
    private int stack size;
    private T[] stacker;
    private int top;

    public MyGenericStack(int size){
        this.stackSize= size;
        this.stackArr=(T[] new Object[StackSize];
        this.top = -1;
    }
    public void Push (T entry){
        if (this.isStackFull(){
            System.out.rpintln(“Stack is full_;
        }
        this.increaseStackCapacity();
        }
        this.stackArr[++top]=entry;

    }
    public T pop() throws Exception {
    if (this.isStackEmpty(){
    
        throw new Exception
    }
    public T peek() {
        return StackArr[top];
    }

    private void increaseStackCapacity(){
        T[] newStack = (T[]) new Object[this.stackSize*2];
        for (int i=0;i<stackSize;i++) {
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.StackSize*2;
    }

    public boolean isStackEmpty(){
        return(top ==-1);
    }
    public boolean isStackFull(){
        return (top==stackSize-1);
    }
    public static void main(String a[]) {
    MyGenericStack<String> stringStack = new MyGenericStack<String>(2);
        stringStack.push(“java2novice”);
    MyGenericStack<Integer>(2);
        integerStack.push(23);
    }
}


public class MyReverse {
    public String reverseWord(String word) {
    StringBuilder sb = new StringBuilder();
    int size = word.length();
    StackImpl stack =new StackImpl(size);
    for (int i=0;i<size;i++) {
        stack.push(word.charAt(i);
    }
    while(!stack.isStackEmpty(){
        sb.append(stack.pop());
    }
    return sb.toString()
}
}


class StackImpl{
    private int stackSize;
    private char[] stacker;
    private int top;
    public StackImpl(int size) {
        this.stackSize=size;
        this.stackArr = new char[stacksize];
        this.top=-1;
    }
    public void push(char entry) {
        this.stackArr[++top]=entry;
    }
    public char pop() {
        char entry = this.stackArr[top—];
        return entry;
    }
    public char peek(){
        return StackArr[top];
    }
    public boolean isStackEmpty(){
        return (top==-1);
    }
    public boolean isStackFull(){
        return(top==stackSize-1);
    }
—— —— —— —— —— —— —— —— 
}