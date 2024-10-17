class Solution_14 {
    public int maxVowels(String s, int k) {
        StringBuilder sum = new StringBuilder();
        StringBuilder sb = new StringBuilder(s);
        char[] sc = s.toCharArray();
        char ch;
        int maks = 0, temp = 0;
        String vow = "aeiouAEIOU";
        sum.append(sb.substring(0, k));
        for (int i = 0; i < sc.length; i++) {
            if (i < k) {
                ch = sum.charAt(i);
                if (vow.indexOf(ch) != -1) {
                    temp++;
                }
            } 
            else {
                ch = sum.charAt(0);
                if (vow.indexOf(ch) != -1) {
                    temp--;
                }
                sum.deleteCharAt(0);
                sum.append(sc[i]);
                if (vow.indexOf(sc[i]) != -1) {
                    temp++;
                }
            }
            maks = Math.max(maks, temp);
        }
        return maks;
    }
}
