class Solution {

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    Map<String, List<String>> parent = new HashMap<>();

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return ans;
        }

        // BFS
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            Set<String> usedThisLevel = new HashSet<>();

            for (int k = 0; k < size; k++) {

                String word = q.poll();

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[i] = ch;

                        String newWord = new String(arr);

                        if (!set.contains(newWord)) {
                            continue;
                        }

                        // First time seeing this word
                        if (!visited.contains(newWord)) {

                            visited.add(newWord);
                            usedThisLevel.add(newWord);

                            q.offer(newWord);

                            parent.putIfAbsent(
                                newWord,
                                new ArrayList<>()
                            );

                            parent.get(newWord).add(word);

                        }

                        // Another shortest parent
                        else if (usedThisLevel.contains(newWord)) {

                            parent.get(newWord).add(word);
                        }

                        if (newWord.equals(endWord)) {
                            found = true;
                        }
                    }

                    arr[i] = original;
                }
            }

            // Remove words only after completing level
            for (String word : usedThisLevel) {
                set.remove(word);
            }
        }

        if (!visited.contains(endWord)) {
            return ans;
        }

        // DFS from endWord back to beginWord
        path.add(endWord);

        dfs(endWord, beginWord);

        return ans;
    }

    private void dfs(String word, String beginWord) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);

            Collections.reverse(temp);

            ans.add(temp);

            return;
        }

        if (!parent.containsKey(word)) {
            return;
        }

        for (String p : parent.get(word)) {

            path.add(p);

            dfs(p, beginWord);

            path.remove(path.size() - 1);
        }
    }
}