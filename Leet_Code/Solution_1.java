class Solution_1 {
    public String mergeAlternately(String word1, String word2) {
        String Input=""+word1+word2;
        String Output="";
        int j=0,k=0;
        for(int i=0;i<Input.length();i++){
            if(i%2==0){
                if(j<word1.length()){
                    Output+=word1.charAt(j);
                    j++;
                }
                else{
                    Output+=word2.charAt(k);
                    k++;
                }
            }
            else{
                if(k<word2.length()){
                    Output+=word2.charAt(k);
                    k++;
                }
                else{
                    Output+=word1.charAt(j);
                    j++;
                }

            }
        }
        return Output;
    }
}