class Solution_2 {
    public String reverseWords(String s) {
        String Output="";
        s=s.trim();
        String[] K=s.split("\\s+");
        for(int i=K.length-1;i>=0;i--){
            Output+=K[i];
            if(i!=0){
                Output+=" ";
            }
        }
        return Output;
    }
}