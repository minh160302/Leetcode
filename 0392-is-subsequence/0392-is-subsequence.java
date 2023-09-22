class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            if (s.charAt(p1) != t.charAt(p2)) {
                p2++;
            }
            else {
                p1++;
                p2++;
            }
        }

        return p1 == m;
    }
}