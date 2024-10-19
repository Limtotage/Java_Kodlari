class Solution_24 {
    public String rowbuild(String s){
        String str ="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') str+="01";
            else str+="10";
        }
        return str;
    }
    public int kthGrammar(int n, int k) {
        String res ="0";
        for(int i =1;i<n;i++){
            res = rowbuild(res);
        }
        return (res.charAt(k-1)-'0');
    }
}
