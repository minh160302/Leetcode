class Solution {
    // length = prevLength + 1
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        int res = 1;
        for (String word: words) {
            int length = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder tmp = new StringBuilder(word);
                tmp.deleteCharAt(i);
                length = Math.max(length, 1 + map.getOrDefault(tmp.toString(), 0));
            }
            map.put(word, length);
            res = Math.max(res, length);
        }
        return res;
    }
}