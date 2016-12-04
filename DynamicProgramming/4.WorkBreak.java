public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
             return wordBreakHelper(s, dict, 0);
    }
 
    public boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length()) 
            return true;
 
        for(String a: dict){
            int len = a.length();
            int end = start+len;
 
            //end index should be <= string length
            if(end > s.length()) 
                continue;
 
            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }
 
        return false;
    }
}


public class Solution {
    
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()];
    }
}
