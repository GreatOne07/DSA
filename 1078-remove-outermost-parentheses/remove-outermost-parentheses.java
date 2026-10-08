class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder ans = new StringBuilder();

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // If balance is 0, this is outermost '('
                if (balance > 0) {
                    ans.append(ch);
                }

                balance++;

            } else {

                balance--;

                // If balance is 0, this is outermost ')'
                if (balance > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}