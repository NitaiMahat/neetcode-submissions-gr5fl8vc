class Solution {
    public String foreignDictionary(String[] words) {
      /**
    "hrn","hrf","er","enn","rfnn"

    hrn          
    hrf   n->f
    er  r- > n
    enn
    enn
    rfnn
      **/
      Map<Character,Set<Character>> graph = new HashMap<>();
    for(String word: words){
      for(char c : word.toCharArray()){
        if(!graph.containsKey(c)){
          graph.put(c,new HashSet<>());
        }
      }
    }
    int[] inDegree = new int[26];

    for(int i=0;i<words.length-1;i++){
      String wordA = words[i];
      String wordB = words[i+1];

      if(!populateGraph(wordA,wordB,graph,inDegree)){
        return "";
      }
    }

    Queue<Character> queue = new LinkedList<>();
    for(char key : graph.keySet()){
      if(inDegree[key-'a']==0){
        queue.add(key);
      }
    }
    StringBuilder res = new StringBuilder();
    while(!queue.isEmpty()){
      char currChar = queue.poll();
      res.append(currChar);
      for(char next : graph.get(currChar)){
        inDegree[next-'a']--;
        if(inDegree[next-'a']==0){
            queue.add(next);
        }
      }
    }
    if(res.length()!=graph.size()){
      return "";
    }
    return res.toString();

    }
    private boolean populateGraph(String wordA,String wordB, Map<Character,Set<Character>> graph,int[] inDegree){

      int minLen = Math.min(wordA.length(),wordB.length());

      for(int i=0;i<minLen;i++){
        if(wordA.charAt(i)!=wordB.charAt(i)){
          if(!graph.get(wordA.charAt(i)).contains(wordB.charAt(i))){
              graph.get(wordA.charAt(i)).add(wordB.charAt(i));
              inDegree[wordB.charAt(i)-'a']++;
          }
          return true;
        }
      }
      if(wordA.length() > wordB.length()){
        return false;
      }
      return true;
    }
    
}
