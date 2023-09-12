class Solution {
    public int minDeletions(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray())
            map[c - 'a']++;
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < 26; i++) {
            while (map[i] > 0 && set.contains(map[i])) {
                map[i]--;
                res++;
            }
            set.add(map[i]);
        }
        return res;
    }
}

