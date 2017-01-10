import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int getScore(String s) {
        boolean starts = Pattern.matches("^hackerrank.*", s);
        boolean ends = Pattern.matches(".*hackerrank$", s);
        return (starts && ends) 
                ? 0
                : (starts)
                    ? 1
                    : (ends)
                        ? 2
                        : -1;
    } 

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().trim());
        while(n-- > 0) {
            System.out.println(getScore(scan.nextLine().trim()));
        }
        scan.close();
    }
}