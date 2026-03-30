class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        hashMap <string, list<String>>
        string will be sorted and lsi String will contians sorted string anagram
        can sotre the mpas vlaue in the Lsit<LSit<Stirng> and return

        n(n log n * m)
        **/
        List<List<String>> finalList = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] charSorted = strs[i].toCharArray();
            Arrays.sort(charSorted);
            String sortedString = new String(charSorted);
            if(anagramMap.containsKey(sortedString)){
                List<String> temp = anagramMap.get(sortedString);
                temp.add(strs[i]);
            }else{
                anagramMap.put(sortedString,new ArrayList<>());
                List<String> temp = anagramMap.get(sortedString);
                temp.add(strs[i]);
            }

            
        }
        for(List<String> vals : anagramMap.values()){
            finalList.add(vals);
        }
        return finalList;
    }
}
