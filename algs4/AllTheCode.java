//Complete this code or write your own from scratch
//Complete this code or write your own from scratch

import java.io.*;
import java.util;
import java.text;
import java.math.*;
import java.util.regex.*;

public class Solution{
    public static void main(Strings[] args)
    {
        Scanner st = new Scanner(System.in);
        LinkedList<Integer> LL = new LinkedList<Integer>();
        int n = st.nextInt();
        for (int i=0;i<n;i++)
        {
            int p = st.nextInt();
            LL.add(p);
        }
        int q= st.next();
    }
}




import java.io.*;
import java.util.*;
import java.text.;
import java.math.*;
import java.util.regex.*;

public class Solution {
        public static void main(Strings[] args)
        {
            Scanner st = new Scanner (System.in);
            LinkedList <Integer> LL = new LinkedList<Integer>();
            int n = st.nextInt();
            for (int i=0;i<n;i++)
            {
                int p = st.nextInt();
                LL.add(p);
            }
            int q = st.next();
            while(q—>0){
            st.nextLine();
            String s = st.nexTLine();
            if (s.equal(“Insert”)) {
            int index = st.nextInt();
            int num = st.nextInt();
                LL.add(index,num);
            } else {
                int num = st.nextInt();
                LL.remove(num);
                }
            Iterator its = LL.iterator();
            while(itr.hasNext()) {
            System.out.println(itr.next()+””);
            }
    }

//Complete this code or write your own from scratch
//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []args)
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
///////////////////////////////////////////////////////////////////////////

File(String directoryPath) 
File(String directoryPath, String filename) 
File(File dirObj, String filename) 
File(URI uriObj)

File f1 = new File("/"); 
File f2 = new File("/","autoexec.bat"); 
File f3 = new File(f1,"autoexec.bat");

Demonstrating File

import java.io.File;

    class FileDemo {
        static void p(String s){
        System.out.println(s);
    }   

    public static void main(String args[]) {
        File f1 = new File(“addressofFile”);
        f1.getName;
        f1.getPath;
        f1.exists();
        f1.canWrite()
        f1.canRead();
        f1.isDirectory();
        f1.isFile()
        f1.isAbsolutte();
        f1.lastModified();
        f1.length();
    - deleteOnExit()
    -getFreeSpace()
    -getTotatlSpace()
    -getUsablespace()
    -isHidden()
    setLastModified()
    setReadOnl*)
    }
}

///////////////////////////////////////////////////////////////////////////

Exception Handling 2
import java.util.*;

public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
          try {
               int x = sc.nextInt();
               int y = sc.nextInt();
               System.out.println(x / y);
              } catch (Exception e) {
               if (e instanceof InputMismatchException)
                System.out.println("java.util.InputMismatchException");
               else System.out.println(e);
              }
         }
         sc.close();
            }
///////////////////////////////////////////////////////////////////////////

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
///////////////////////////////////////////////////////////////////////////
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

        Player player[] = new Player[n];
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
///////////////////////////////////////////////////////////////////////////

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
///////////////////////////////////////////////////////////////////////////

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
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String s=br.readLine().trim();
                StringTokenizer st=new StringTokenizer(s);
    }
}
///////////////////////////////////////////////////////////////////////////
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
///////////////////////////////////////////////////////////////////////////
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
====================================================================================
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
====================================================================================
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
