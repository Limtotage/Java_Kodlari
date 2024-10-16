class Solution_10 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() != 0) {
            char[] tc = t.toCharArray(), sc = s.toCharArray();
            int k = 0, syc = 0;
            for (char sim : tc) {
                if (sc[k] == sim) {
                    syc++;
                    k++;
                    if(k>=sc.length) break;
                }

            }
            return k == sc.length;
        }
        else return true;
    }
}
