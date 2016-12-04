public static List<String> wordBreak(String s, Set<String> dict) {
    //create an array of ArrayList<String>
    List<String> dp[] = new ArrayList[s.length()+1];
    dp[0] = new ArrayList<String>();
 
    for(int i=0; i<s.length(); i++){
        if( dp[i] == null ) 
            continue; 
 
        for(String word:dict){
            int len = word.length();
            int end = i+len;
            if(end > s.length()) 
                continue;
 
            if(s.substring(i,end).equals(word)){
                if(dp[end] == null){
                    dp[end] = new ArrayList<String>();
                }
                dp[end].add(word);
            }
        }
    }
 
    List<String> result = new LinkedList<String>();
    if(dp[s.length()] == null) 
        return result; 
 
    ArrayList<String> temp = new ArrayList<String>();
    dfs(dp, s.length(), result, temp);
 
    return result;
}
 
public static void dfs(List<String> dp[],int end,List<String> result, ArrayList<String> tmp){
    if(end <= 0){
        String path = tmp.get(tmp.size()-1);
        for(int i=tmp.size()-2; i>=0; i--){
            path += " " + tmp.get(i) ;
        }
 
        result.add(path);
        return;
    }
 
    for(String str : dp[end]){
        tmp.add(str);
        dfs(dp, end-str.length(), result, tmp);
        tmp.remove(tmp.size()-1);
    }
}


public List<String> wordBreak(String s, Set<String> wordDict) {
    ArrayList<String> [] pos = new ArrayList[s.length()+1];
    pos[0]=new ArrayList<String>();
 
    for(int i=0; i<s.length(); i++){
        if(pos[i]!=null){
            for(int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i,j);
                if(wordDict.contains(sub)){
                    if(pos[j]==null){
                        ArrayList<String> list = new ArrayList<String>();
                        list.add(sub);
                        pos[j]=list;
                    }else{
                        pos[j].add(sub);
                    }
 
                }
            }
        }
    }
 
    if(pos[s.length()]==null){
        return new ArrayList<String>();
    }else{
        ArrayList<String> result = new ArrayList<String>();
        dfs(pos, result, "", s.length());
        return result;
    }
}
 
public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
    if(i==0){
        result.add(curr.trim());
        return;
    }
 
    for(String s: pos[i]){
        String combined = s + " "+ curr;
        dfs(pos, result, combined, i-s.length());
    }
}