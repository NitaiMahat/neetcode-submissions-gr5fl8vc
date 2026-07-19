class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,Set<Character>> map = new HashMap<>();
      for(String word : words){
        for(char c : word.toCharArray()){
            map.put(c,new HashSet<>());
        }
      }
      int[] inDegree = new int[26];
      for(int i=0;i<words.length-1;i++){
        String word1 = words[i];
        String word2 = words[i+1];
        if(!populateGraph(word1,word2,map,inDegree)){
            return "";
        }
      }
      Queue<Character> queue  = new LinkedList<>();
      for(char key : map.keySet()){
        if(inDegree[key-'a']==0){
            queue.add(key);
        }
      }
      StringBuilder ans = new StringBuilder();
      while(!queue.isEmpty()){
        char curr = queue.poll();
        ans.append(curr);
        for(char next : map.get(curr)){
            inDegree[next-'a']--;
            if(inDegree[next-'a']==0){
                queue.add(next);
            }
        }
      }
      if(ans.length() != map.size()){
        return "";
      }
      return ans.toString();
    }
    private boolean populateGraph(String word1 , String word2, Map<Character,Set<Character>> map, int[] inDegree){
        int minLen = Math.min(word1.length(), word2.length());
        for(int i=0;i<minLen;i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                if(!map.get(word1.charAt(i)).contains(word2.charAt(i))){
                    map.get(word1.charAt(i)).add(word2.charAt(i));
                    inDegree[word2.charAt(i)-'a']++;
                }
                return true;
            }
        }
        if(word1.length() > word2.length()){
            return false;
        }
        return true;
    }
}

