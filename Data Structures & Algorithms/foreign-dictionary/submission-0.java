class Solution {
    public String foreignDictionary(String[] words) {
        if(words==null || words.length == 0){
            return "";
        }
      Map<Character,Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
      for(String word : words){
        for(char c : word.toCharArray()){
            graph.put(c,new HashSet<>());
        }
      }

      for(int i=0;i<words.length-1;i++){
        String word1 = words[i];
        String word2 = words[i+1];
        if(!populateGraph(word1,word2,graph,inDegree)){
            return "";
        }
      }
      Queue<Character> queue = new LinkedList<>();
      for(char c : graph.keySet()){
        if(inDegree[c-'a']==0){
            queue.add(c);
        }
      }
      StringBuilder finalString = new StringBuilder();

      while(!queue.isEmpty()){
        char curr = queue.poll();
        finalString.append(curr);
        for(char neigh : graph.get(curr)){
            inDegree[neigh-'a']--;

            if(inDegree[neigh-'a']==0){
                queue.add(neigh);
            }
        }
      }
      if(finalString.length()!=graph.size()){
        return "";
      }
      return finalString.toString();

    }
    private boolean populateGraph(String word1,String word2, Map<Character,Set<Character>> graph,int[] inDegree){
        int minLen = Math.min(word1.length(),word2.length());
        for(int i=0;i<minLen;i++){
            if(word1.charAt(i)!= word2.charAt(i)){
                if(!graph.get(word1.charAt(i)).contains(word2.charAt(i))){
                      graph.get(word1.charAt(i)).add(word2.charAt(i));
                inDegree[word2.charAt(i)-'a']++;
                }
                return true;
              
            }
        }
        
        if(word1.length()>word2.length()){
            return false;
        }
        return true;
    }
}
