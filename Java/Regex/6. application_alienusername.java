import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); 
        Pattern p = Pattern.compile("^[_\\.]\\d+\\p{Alpha}*_?$"); // alt: ^[_\\.][0-9]+[a-zA-Z]*_?$
        
        while(n-- > 0) {
            Matcher m = p.matcher(scan.next());
            System.out.println(m.matches() ? "VALID" : "INVALID");
        }
        
        scan.close();
    }
}
