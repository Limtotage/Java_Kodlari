class Solution_25 {
    public String decodeString(String s) {
        String num = "0123456789";
        Stack<String> str= new Stack();
        for (char ch : s.toCharArray()){
            String chs = ""+ch;
            if(!chs.equals("]")) {
                str.push(chs);
            }
            else {
                StringBuilder temp = new StringBuilder();
                while (!str.isEmpty() && !str.peek().equals("[")) {
                    temp.insert(0, str.pop()); 
                }
                if(str.peek().equals("[")) str.pop(); 
                StringBuilder numStr = new StringBuilder();
                while (!str.isEmpty() && num.contains(str.peek())) {
                    numStr.insert(0, str.pop());  
                }
                int rep = Integer.parseInt(numStr.toString());
                String repeated = temp.toString().repeat(rep);
                str.push(repeated);
            }
        }
        String my="";
        while(!str.isEmpty()){
            my=str.pop()+my;
        }
        return my;
    }
}
