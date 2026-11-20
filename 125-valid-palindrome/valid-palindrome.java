class Solution {
    public boolean isPalindrome(String s) {
      StringBuilder cleaned =new StringBuilder();
      for(char ch:s.toCharArray()){
        if(Character.isLetterOrDigit(ch)){
            cleaned.append(Character.toLowerCase(ch));
        }
      }
      String og =cleaned.toString();
      String rev=cleaned.reverse().toString();
      return og.equals(rev);
    }
}