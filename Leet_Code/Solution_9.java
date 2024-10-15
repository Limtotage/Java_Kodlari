class Solution_9 {
    public String gcdOfStrings(String str1, String str2) {
        String search ="";
        String biggest="";
        
        if(str1.length()>str2.length()){
            for(int i=0;i<str2.length();i++){
                search+=str2.charAt(i);
                if(str1.length()%search.length()==0&&str2.length()%search.length()==0){
                    String[] myArray = str1.split(search);
                    String[] my2Array = str2.split(search);
                    System.out.println(search);
                    if (myArray.length==0&&my2Array.length==0) biggest=search;
                } 
            }
        }
        else if(str2.length()>str1.length()){
            for(int i=0;i<str1.length();i++){
                search+=str1.charAt(i);
                if(str2.length()%search.length()==0&&str1.length()%search.length()==0){
                    String[] myArray = str2.split(search);
                    System.out.println(search);
                    if (myArray.length==0) biggest=search;
                } 
            }
        }
        else if(str2.contains(str1)) biggest=str1;
        return biggest;
    }
}
