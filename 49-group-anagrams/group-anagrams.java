class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word : strs) {
            int[] freq = new int[26];
            for(int i = 0; i < word.length(); i++) {
                freq[word.charAt(i) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int count : freq) {
                key.append(count).append('#');
            }
            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}