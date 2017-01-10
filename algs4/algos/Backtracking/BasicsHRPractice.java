public class Solution {

    public static void main(String[] args) {
         System.out.println("Hello, World.");
         System.out.println("Hello, Java.");
    }
}

///////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line_num = 0;
        while(sc.hasNext())
            System.out.println(++line_num + " " + sc.nextLine());
        sc.close();
    }
}


///////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.security.*;
public class Solution {
 public static void main(String[] args) {

  DoNotTerminate.forbidExit();

  try {
    Scanner in = new Scanner(System.in);
    int n = in .nextInt();
    in.close();
    String s = Integer.toString(n);
 
    if (n == Integer.parseInt(s)) {
        System.out.println("Good job");
    } else {
        System.out.println("Wrong answer.");
    }
    } catch (DoNotTerminate.ExitTrappedException e) {
    System.out.println("Unsuccessful Termination!!");
  }
 }
}

//The following class will prevent you from terminating the code using exit(0)!
class DoNotTerminate {

 public static class ExitTrappedException extends SecurityException {

  private static final long serialVersionUID = 1;
 }

 public static void forbidExit() {
  final SecurityManager securityManager = new SecurityManager() {
   @Override
   public void checkPermission(Permission permission) {
    if (permission.getName().contains("exitVM")) {
     throw new ExitTrappedException();
    }
   }
  };
  System.setSecurityManager(securityManager);
 }
}

///////////////////////////////////////////////////////////////////////////////////////////////
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}
class MyRegex
{
         String pattern = 
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

}
///////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
    
public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        sc.close();
        
        System.out.println( A.length() + B.length() );
        System.out.println( (A.compareTo(B) > 0) ? "Yes" : "No");
        System.out.println(
            A.substring(0, 1).toUpperCase() + A.substring(1) + " " +
            B.substring(0, 1).toUpperCase() + B.substring(1)
        );
    }
}


///////////////////////////////////////////////////////////////////////////////////////////
public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(A.length()+B.length());
        System.out.println(A.compareTo(B)>0?"Yes":"No");
        System.out.println(capitalizeFirstLetter(A) + " " + capitalizeFirstLetter(B));
    }
    
    public static String capitalizeFirstLetter(String original) {
    if (original == null || original.length() == 0) {
        return original;
    }
    return original.substring(0, 1).toUpperCase() + original.substring(1);
}
///////////////////////////////////////////////////////////////////////////////////////////

public class Solution{
static int B, H;
static boolean flag = true;
    static {

        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();
        sc.close();
            try {
                if (B <= 0 || H <= 0)
                    throw new Exception("Breadth and height must be positive");
                } catch (Exception e) {
                System.out.println(e);
                System.exit(0);
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US); 
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN")); 
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE); 
        
        String us = usFormat.format(payment);
        String india = indiaFormat.format(payment);
        String china = chinaFormat.format(payment);
        String france = franceFormat.format(payment);
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}

///////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        String input_date = day + "/" + month + "/" + year;
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            DateFormat format2 = new SimpleDateFormat("EEEE"); 
            String final_day = format2.format(format1.parse(input_date));
            System.out.println(final_day.toUpperCase());
        }
        catch(Exception e){}
    }
}
///////////////////////////////////////////////////////////////////////////////////////////


import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String s1=sc.next();
                int x=sc.nextInt();
                System.out.printf( "%-15s%03d %n", s1, x);
            }
            System.out.println("================================");

    }
}


/*Exception Handling*/
///////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        try {
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(x / y);
        } 
        catch(InputMismatchException e) {
            // ensure that "java.util.InputMismatchException" is printed only.
            System.out.println(e.getClass().toString().replaceFirst("class ", ""));
        }
        catch(ArithmeticException e) {
            // Print exception
            System.out.println(e);
        }
        scan.close();
    }
}

///////////////////////////////////////////////////////////////////////////////////////////

class MyCalculator {
 public int power(final int n, final int p) throws Exception {
  if (n < 0 || p < 0) {
   throw new Exception("n and p should be non-negative");
  }
  int res = 1;
  for (int i = 0; i < p; i++) {
   res *= n;
  }
  return res;
 }
}
///////////////////////////////////////////////////////////////////////////////////////////


/*Arrays*/

public class Solution {

    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
            int val = sc.nextInt();
            a[i] = val;
        }
        scan.close();
        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}


///////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
         int[][] arr = new int[10][10];
         Scanner sc = new Scanner(System.in);
         for(int i=0;i<6;i++){
             for(int j=0;j<6;j++){
                 arr[i][j]=sc.nextInt();

             }
         }
         int maxi=-100000;
         for(int i=0;i<6;i++){
             for(int j=0;j<6;j++){
                 if(i<=3 && j<=3){
                     int sum=arr[i][j]+arr[i][j+1]+arr[i][j+2]+(arr[i+1][j+1])+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                     if(sum>maxi) maxi=sum;
                 }
             }
         }
         System.out.println(maxi);
    }
}

///////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        
        for(int i = 0;i < n;i++){
            a[i] = scan.nextInt();
        }
        scan.close();
        
        int numNegativeSubarrays = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                
                int sum = 0;
                
                for(int k = i; k <= j; k++) {
                    sum = sum + a[k];
                }
                
                if(sum < 0) {
                    numNegativeSubarrays++;
                }
            }
        }
        
        System.out.println(numNegativeSubarrays);
    }
}

///////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.util.*;



public class Solution {

    public static void main(String[] args) 
    {

      Scanner scan = new Scanner(System.in);
      ArrayList[] list= new ArrayList[20002];
      int n;
      n=scan.nextInt();
      for(int i=1;i<=n;i++)
      {

          list[i]=new ArrayList();
          int x=scan.nextInt();

          for(int j=1;j<=x;j++)
          {
              int val=scan.nextInt();
              list[i].add(val);

          }
      }
      int q=scan.nextInt();

      for(int i=1;i<=q;i++)
      {
              int x,y;
              x=scan.nextInt();
              y=scan.nextInt();
              try
              {
                System.out.println(list[x].get(y-1));
              }catch(Exception e)
              {
                  System.out.println("ERROR!");
              }
      }
    }
}

////////////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
 public static void main(String[] args) {
  Scanner st = new Scanner(System.in);
  LinkedList < Integer > LL = new LinkedList < Integer > ();
  int n = st.nextInt();
  for (int i = 0; i < n; i++) {
   int p = st.nextInt();
   LL.add(p);
  }
  int q = st.nextInt();
  while (q--> 0) {
   st.nextLine();
   String s = st.nextLine();
   if (s.equals("Insert")) {
    int index = st.nextInt();
    int num = st.nextInt();
    LL.add(index, num);
   } else {
    int num = st.nextInt();
    LL.remove(num);
   }
  }

  Iterator itr = LL.iterator();
  while (itr.hasNext()) {
   System.out.print(itr.next() + " ");
  }
  System.out.println("\n");
 }
}


///////////////////////////////////////////////////////////////

import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh)
    {
        HashMap<String, Integer> hash = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();
            hash.put(name,phone);
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            try
            {
                int out=hash.get(s);
                System.out.println(s+"="+out);
            }
            catch(Exception e)
            {
                System.out.println("Not found");
            }
        }
    }
}

///////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Parser
{
    private static final Map<Character, Character> brackets = new HashMap<Character, Character>();
    static {
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('(', ')');
    }  


    boolean checkParenthesesBalance(String str)
    {
        if (str.length() == 0) {
                    throw new IllegalArgumentException("String length should be greater than 0");
                }
                // odd number would always result in false
                if ((str.length() % 2) != 0) {
                    return false;
                }

                final Stack<Character> stack = new Stack<Character>();
                for (int i = 0; i < str.length(); i++) {
                    if (brackets.containsKey(str.charAt(i))) {
                        stack.push(str.charAt(i));
                    } else if (stack.empty() || (str.charAt(i) != brackets.get(stack.pop()))) {
                        return false;
                    } 
                }
                return true;
        }
}
class Solution{

    public static void main(String []argh)
    {
        Parser X=new Parser();
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(X.checkParenthesesBalance(in.next()));
        }

    }
}

////////////////////////////////////////////////////////////////////////

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        HashSet<String> myhash = new HashSet<String>();
        for (int i = 0; i < t; i++) {
            myhash.add(pair_left[i]+"#"+pair_right[i]);
            System.out.println(myhash.size());
        }

    }
}

////////////////////////////////////////////////////////////////////////

//method needs to be public 
//because separate solution class will attempt to access it
public <T> void printArray(T[] array){
    for(T item: array){
        System.out.println(item);
    }
}
////////////////////////////////////////////////////////////////////////

import java.util.*;

class Checker implements Comparator<Player>{

    public int compare(Player a, Player b) {
        // If 2 Players have the same score
        if(a.score == b.score){
            // Order alphabetically by name
            if(a.name.compareTo(b.name) < 0){
                return -1;
            }
            else if(a.name.compareTo(b.name) > 0){
                return 1;
            }
            return 0;
        }    
        
        // Otherwise, order higher score first   
        else if(a.score > b.score){
            return -1;
        }
        else if(a.score < b.score){
            return 1;
        }
        
        return 0;
    }
}

/** Alternative Approach:

    class Checker implements Comparator<Player>{

        public int compare(Player a, Player b) {
            // If 2 Players have the same score
            if(a.score == b.score){
                // Order alphabetically by name
                return a.name.compareTo(b.name);
            }    

            // Otherwise, order higher score first  
            return ((Integer) b.score).compareTo(a.score);
        }
    }

**/

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

/////////////////////////////////////////////////////////////////////////////////

import java.util.*;

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {

        double cgpa1 = s1.getCgpa();
        double cgpa2 = s2.getCgpa();

        if(Math.abs(cgpa1 - cgpa2)<.00000001){
            int fnameCom = s1.getFname().compareTo(s2.getFname());
            if(fnameCom==0){
                return s1.getId()-s2.getId(); 
            }
            return fnameCom;
        }

        return (cgpa1<cgpa2)?1:(cgpa1>cgpa2?-1:0);
    }

}

public class Solution
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Collections.sort(studentList, new StudentComparator());
        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}

////////////////////////////////////////////////////////////////////////

Deque deque = new LinkedList<>();
Deque deque = new ArrayDeque<>();


import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        int n = in.nextInt();
        int m = in.nextInt();
        int ans = 0, distinct = 0;
        
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            if (hashmap.get(num) == null) hashmap.put(num,0);
            
            hashmap.put(num, hashmap.get(num)+1);
            
            if (hashmap.get(num)==1) distinct++;
            
            if (deque.size() == m+1){
                int ele = deque.removeFirst();
                hashmap.put(ele, hashmap.get(ele)-1);
                if (hashmap.get(ele) == 0) distinct--;
            }
            if (deque.size() == m){
                if (distinct > ans) ans = distinct;
            }
           
        }
        System.out.println(ans);
        in.close();
    }
}

////////////////////////////////////////////////////////////////////////


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine().trim();
        StringTokenizer st=new StringTokenizer(s);
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        BitSet bit1=new BitSet(N);
        BitSet bit2=new BitSet(N);
        while(M-->0)
        {
           s=br.readLine().trim();
           st=new StringTokenizer(s);
           String ins=st.nextToken();
           int a=Integer.parseInt(st.nextToken());
           int b=Integer.parseInt(st.nextToken());
           switch(ins)
           {
               case "AND":
                    if(a==1)
                         bit1.and(bit2);
                    else
                        bit2.and(bit1);
                    break;
               case "OR":
                    if(a==1)
                        bit1.or(bit2);
                    else
                        bit2.or(bit1);
                    break;
               case "XOR":
                    if(a==1)
                        bit1.xor(bit2);
                    else
                        bit2.xor(bit1);
                    break;
               case "FLIP":
                    if(a==1)
                        bit1.flip(b);
                    else
                        bit2.flip(b);
                    break;
               case "SET":
                    if(a==1)
                        bit1.set(b);
                    else
                        bit2.set(b);
                    break;

           }
           System.out.println(bit1.cardinality()+" "+bit2.cardinality());

        }

    }
}

////////////////////////////////////////////////////////////////////////////


import java.util.*;

class Student{
    private int token;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getToken() {
        return token;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {

        double cgpa1 = s1.getCgpa();
        double cgpa2 = s2.getCgpa();

        if(cgpa1 == cgpa2){
            int fnameCom = s1.getFname().compareTo(s2.getFname());
            if(fnameCom==0){
                return s1.getToken()-s2.getToken(); 
            }
            return fnameCom;
        }

        return (cgpa1<cgpa2)?1:(cgpa1>cgpa2?-1:0);
    }

}

public class Solution
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());

        Queue<Student> studentPQ = new PriorityQueue<Student>(10, new StudentComparator());
        while(totalEvents>0){
            String event = in.next();
            if(event.equals("ENTER")){
                String fname = in.next();
                double cgpa = in.nextDouble();
                int token = in.nextInt();

                Student st = new Student(token, fname, cgpa);
                studentPQ.add(st);
            }
            else if(event.equals("SERVED")){
                studentPQ.poll();
            }
            totalEvents--;
        }
        boolean flag=true;
        while(!studentPQ.isEmpty()){
            Student st = studentPQ.poll();
            System.out.println(st.getFname());
            flag=false;
        }
        if(flag){
            System.out.println("EMPTY");
        }
    }
}
////////////////////////////////////////////////////////////////////////////
/*inheritence*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Animal{
   void walk(){
      System.out.println("I am walking");
   }
}

class Bird extends Animal{
   void fly(){
      System.out.println("I am flying");
   }
   void sing(){
       System.out.println("I am singing");
   }
}
public class Solution{

   public static void main(String args[]){

     Bird bird = new Bird();
     bird.walk();
     bird.fly();
     bird.sing();
   
   }
}

////////////////////////////////////////////////////////////////////////////
class Arithmetic {
    Arithmetic() {}
    
    int add(int a, int b) {
        return a + b;
    }
}

class Adder extends Arithmetic {
    Adder() {}
}



import java.util.*;
abstract class Book{
    String title;
    abstract void setTitle(String s);
    String getTitle(){
        return title;
    }
}

class MyBook extends Book{
    void setTitle(String s){
        title=s;
    }
}

public class Main{

    public static void main(String []args){
        //Book new_novel=new Book();  Abstract cass cannot be instantiated like this
        Scanner sc=new Scanner(System.in);
        String title=sc.nextLine();
        MyBook new_novel=new MyBook();
        new_novel.setTitle(title);
        System.out.println("The title is: "+new_novel.getTitle());

    }
}

////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
interface AdvancedArithmetic {
 public abstract int divisorSum(int n);
}

//Solution starts
class MyCalculator implements AdvancedArithmetic {
 public int divisor_sum(int n) {
  int ans = 0;
  for (int i = 1; i <= n; i++) {
   if (n % i == 0) ans += i;
  }
  return ans;
 }
}
//Solution ends


class Solution {

 public static void main(String[] argh) {
   MyCalculator my_calculator = new MyCalculator();
   System.out.print("I implemented: ");
   ImplementedInterfaceNames(my_calculator);
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   System.out.print(my_calculator.divisorSum(n) + "\n");

  }
  /*
   *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
   */
 static void ImplementedInterfaceNames(Object o) {

  Class[] theInterfaces = o.getClass().getInterfaces();
  for (int i = 0; i < theInterfaces.length; i++) {
   String interfaceName = theInterfaces[i].getName();
   System.out.println(interfaceName);
  }
 }
}


////////////////////////////////////////////
class Sports{

    String getName(){
        return "Generic Sports";
    }
  
    void getNumberOfTeamMembers(){
        System.out.println( "Each team has n players in " + getName() );
    }
}

class Soccer extends Sports{
    @Override
    String getName(){
        return "Soccer Class";
    }
    
    @Override
    void getNumberOfTeamMembers(){
        System.out.println( "Each team has 11 players in " + getName() );
    }
}

public class Solution{
    
    public static void main(String []args){
        Sports c1 = new Sports();
        Soccer c2 = new Soccer();
        System.out.println(c1.getName());
        c1.getNumberOfTeamMembers();
        System.out.println(c2.getName());
        c2.getNumberOfTeamMembers();
    }
}

//////////////////////////////////////////////////

import java.util.*;
import java.io.*;

class BiCycle{
    String define_me(){
        return "a vehicle with pedals.";
    }
}

class MotorCycle extends BiCycle{
    String define_me(){
        return "a cycle with an engine.";
    }
    
    MotorCycle(){
        System.out.println("Hello I am a motorcycle, I am "+ define_me());

System.out.println("My ancestor is a cycle who is "+ temp );
    }
    
}
class Solution{
    public static void main(String []args){
        MotorCycle M=new MotorCycle();
    }

java String temp=super.define_me();


///////////////////////////////////////////////////////////////

import java.util.*;
public class Main
{
    static Iterator func(ArrayList mylist)
    {
        Iterator it=mylist.iterator();
        while(it.hasNext())
        {
            Object element = it.next();
            if(element instanceof String)
                break;
        }
        return it;

    }
    @SuppressWarnings({ "unchecked" })
    public static void main(String []argh)
    {
        ArrayList mylist = new ArrayList();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            mylist.add(sc.nextInt());
        }
        mylist.add("###");
        for(int i=0;i<m;i++)
        {
            mylist.add(sc.next());
        }


        Iterator it=func(mylist);
        while(it.hasNext())
        {
            Object element = it.next();
            System.out.println((String)element);
        }

    }
}
///////////////////////////////////////////////////////


class Calculate {
 VolumeCalculator output;
 BufferedReader br;
 Calculate() {
  br = new BufferedReader(new InputStreamReader(System.in));

  output = new VolumeCalculator();
 }
 static VolumeCalculator do_calc() {
  return new VolumeCalculator();

 }
 public int get_int_val() throws NumberFormatException, IOException {
  return Integer.parseInt(br.readLine().trim());
 }
 public double get_double_val() throws NumberFormatException, IOException {
  return Double.parseDouble(br.readLine());
 }


}
class VolumeCalculator {

 public double get_volume(int a) {
  if (a < -100 || a > 100)
   throw new NumberFormatException("Out of range");
  if (a <= 0) {
   //System.exit(0);
   throw new NumberFormatException("All the values must be positive");
  }

  return a * a * a;

 }

 public double get_volume(double r, double h) {
  if (r < -100 || r > 100 || h < -100 || h > 100)
   throw new NumberFormatException("Out of range");
  if (r <= 0 || h <= 0)
   throw new NumberFormatException("All the values must be positive");

  return Math.PI * r * r * h;
 }

 public double get_volume(double r) {
  if (r < -100 || r > 100)
   throw new NumberFormatException("Out of range");
  if (r <= 0)
   throw new NumberFormatException("All the values must be positive");
  return ((double) 2 / 3) * Math.PI * r * r * r;
 }

 public double get_volume(int l, int b, int h) {
  if (l < -100 || l > 100 || b < -100 || b > 100 || h < -100 || h > 100)
   throw new NumberFormatException("Out of range");
  if (l <= 0 || b <= 0 || h <= 0)
   throw new NumberFormatException("All the values must be positive");
  return l * b * h;
 }
 public void display(double volume) {
  System.out.printf("%.3f\n", volume);

 }

}


////////////////////////////////////////////////////////////
import java.math.*;
import java.util.Scanner;
public class Solution {
   public static void main(String []args){
       Scanner input = new Scanner(System.in);
       BigInteger a,b,c;
       String s1,s2;
       s1=input.nextLine();
       s2=input.nextLine();
       input.close();
       System.out.println(new BigInteger(s1).add(new BigInteger(s2)));
       System.out.println(new BigInteger(s1).multiply(new BigInteger(s2)));
   }
}


/////////////////////////////////////////////////////////////////////////////
import java.math.BigDecimal;
import java.util.*;
class Solution {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String []s = new String[n+2];
        for(int i = 0;i < n;i++){
            s[i] = sc.next();
        }

        for(int i = 0;i<n;i++){
            BigDecimal max = new BigDecimal(s[i]);
            int idx = i;
            for(int j = i+1;j<n;j++)
            {
                BigDecimal curr = new BigDecimal(s[j]);
                if(curr.compareTo(max) == 1){
                    max=curr;
                    idx=j;
                }
            }
            String temp = s[i];
            s[i] = s[idx];
            s[idx] = temp;
        }

        for(int i = 0;i<n;i++){
            System.out.println(s[i]);
        }

    }
}

////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

     public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     BigInteger n = in.nextBigInteger();
     in.close();
      if(n.isProbablePrime(1)){
         System.out.println("prime");
      }
      else{
         System.out.println("not prime");
      }

    }
}