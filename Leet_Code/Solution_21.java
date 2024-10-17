import java.util.Collection;
class Solution_21 {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> wmap1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> wmap2 = new HashMap<Character, Integer>();
        if(word1.length()==word2.length()){
            for(char ch : word1.toCharArray()){
                if(wmap1.containsKey(ch)){
                    wmap1.replace(ch, wmap1.get(ch)+1);
                }
                else{
                    wmap1.put(ch,1);
                }
            }
            for(char ch : word2.toCharArray()){
                if(wmap2.containsKey(ch)){
                    wmap2.replace(ch, wmap2.get(ch)+1);
                }
                else{
                    wmap2.put(ch,1);
                }
            }
            Collection<Integer> values1 = wmap1.values();
            Collection<Integer> values2 = wmap2.values();
            Integer[] imap1 = values1.toArray(new Integer[0]);
            Integer[] imap2 = values2.toArray(new Integer[0]);
            Arrays.sort(imap1);
            Arrays.sort(imap2);
            boolean result = Arrays.equals(imap1, imap2);
            if(wmap1.keySet().equals(wmap2.keySet())){
                if(result) return true;
                else return false;
            }
            else return false;
        }
        else return false;
    }
}
