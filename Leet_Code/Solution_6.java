class Solution_6 {
    public String reverseVowels(String s) {
        char[] kat = new char[s.length()];
        String search = "iaeouAEOUI";
        String p="",r="";
        char temp;
        int i,j,k=s.length();
        for(i=0;i<k;i++){
            kat[i]=s.charAt(i);
            if(search.contains(Character.toString(kat[i]))) p+=kat[i];
        }
        char[] sat = new char[p.length()];
        for(i=0;i<p.length();i++){
            sat[i]=p.charAt(i);
        }
        i=sat.length-1;
        j=0;
        for(char ch: kat){
            if(search.contains(Character.toString(ch))) {
                kat[j]=sat[i];
                i--;
            }
            j++;
        }
        i=0;
        for(char ch: kat){
            r+=kat[i];
            i++;
        }
        return r;
    }
}
