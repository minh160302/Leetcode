class Solution {
    // 
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        HashMap<String, Integer> map = new HashMap<>();
        int res = 1;
        for (String word: words) {
            int longestChain = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                if (map.containsKey(sb.toString())) {
                    longestChain = Math.max(longestChain, map.get(sb.toString()) + 1);
                }
            }
            map.put(word, longestChain);
            res = Math.max(res, longestChain);
        }
        return res;
    }
}