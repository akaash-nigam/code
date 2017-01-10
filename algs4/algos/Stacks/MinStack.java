import java.util.*;

// A user defined stack that supports getMin() in
// addition to push() and pop()
class MyStack
{
    Stack<Integer> s;
    Integer minEle;
    MyStack() { s = new Stack<Integer>(); }

    void getMin()
    {
        if (s.isEmpty())
            System.out.println("Stack is empty");

        else
            System.out.println("Minimum Element in the " +
                               " stack is: " + minEle);
    }


    void peek()
    {
        if (s.isEmpty())
        {
            System.out.println("Stack is empty ");
            return;
        }

        Integer t = s.peek(); // Top element.

        System.out.print("Top Most Element is: ");

        if (t < minEle)
            System.out.println(minEle);
        else
            System.out.println(t);
    }


    void pop()
    {
        if (s.isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Top Most Element Removed: ");
        Integer t = s.pop();
        if (t < minEle)
        {
            System.out.println(minEle);
            minEle = 2*minEle - t;
        }
        else
            System.out.println(t);
    }

    void push(Integer x)
    {
        if (s.isEmpty())
        {
            minEle = x;
            s.push(x);
            System.out.println("Number Inserted: " + x);
            return;
        }
        if (x < minEle)
        {
            s.push(2*x - minEle);
            minEle = x;
        }
        else
            s.push(x);
        System.out.println("Number Inserted: " + x);
    }
};


public class Main
{
    public static void main(String[] args)
    {
        MyStack s = new MyStack();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
    }
}