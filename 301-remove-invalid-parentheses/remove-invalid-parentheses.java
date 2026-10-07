import java.util.*;

class Solution {

    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int removeLeft = 0;
        int removeRight = 0;

        // Find minimum number of '(' and ')' to remove
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                removeLeft++;

            } else if (ch == ')') {

                if (removeLeft > 0) {
                    removeLeft--;
                } else {
                    removeRight++;
                }
            }
        }

        // Backtracking
        dfs(s, 0, 0, removeLeft, removeRight, new StringBuilder());

        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, int balance,
                     int removeLeft, int removeRight,
                     StringBuilder current) {

        // Invalid path
        if (balance < 0) {
            return;
        }

        // End of string
        if (index == s.length()) {

            if (balance == 0 && removeLeft == 0 && removeRight == 0) {
                result.add(current.toString());
            }

            return;
        }

        char ch = s.charAt(index);

        // Case 1: '('
        if (ch == '(') {

            // Remove '('
            if (removeLeft > 0) {
                dfs(s, index + 1, balance,
                    removeLeft - 1, removeRight, current);
            }

            // Keep '('
            current.append('(');

            dfs(s, index + 1, balance + 1,
                removeLeft, removeRight, current);

            current.deleteCharAt(current.length() - 1);

        }

        // Case 2: ')'
        else if (ch == ')') {

            // Remove ')'
            if (removeRight > 0) {
                dfs(s, index + 1, balance,
                    removeLeft, removeRight - 1, current);
            }

            // Keep ')' only if it won't make balance negative
            if (balance > 0) {

                current.append(')');

                dfs(s, index + 1, balance - 1,
                    removeLeft, removeRight, current);

                current.deleteCharAt(current.length() - 1);
            }

        }

        // Case 3: letter
        else {

            current.append(ch);

            dfs(s, index + 1, balance,
                removeLeft, removeRight, current);

            current.deleteCharAt(current.length() - 1);
        }
    }
}