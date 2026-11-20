class Solution {
    public int lengthOfLastWord(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i =s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(Character.isLetter(ch)){
                sb.append(ch);
            }
            else if(sb.length()>0){ break;}
        }
        
        return sb.length();
    }
}