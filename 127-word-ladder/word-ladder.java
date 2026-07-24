import java.util.*;

class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> st = new HashSet<>();

        for (String word : wordList) {
            st.add(word);
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        st.remove(beginWord);

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            String word = curr.word;
            int steps = curr.steps;

            if (word.equals(endWord))
                return steps;

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;
                    String newWord = new String(arr);

                    if (st.contains(newWord)) {
                        q.offer(new Pair(newWord, steps + 1));
                        st.remove(newWord);
                    }
                }

                arr[i] = original;
            }
        }

        return 0;
    }
}