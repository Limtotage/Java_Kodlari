class Daily_Solution_2 {
    public String inverever(String s){
        char[] chars = s.toCharArray();
        int i=0;
        for(char ch:chars){
            if(ch=='0') chars[i]='1';
            else chars[i]='0';
            i++;
        }
        String b = new String(chars);
        StringBuffer rever = new StringBuffer(b);
        rever.reverse();
        return rever.toString();
    }
    public char findKthBit(int n, int k) {
        String sip="0";
        for(int i =1; i<n ; i++){
            sip=sip+"1"+inverever(sip);
        }
        return sip.charAt(k-1);
    }
}
