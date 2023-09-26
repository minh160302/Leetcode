class Solution {
    public String removeDuplicateLetters(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 'a']++;
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(p))
                p = i;
            arr[s.charAt(i) - 'a']--;
            if (arr[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 
            ? "" 
            : s.charAt(p) + removeDuplicateLetters(s.substring(p+1).replaceAll(String.valueOf(s.charAt(p)), ""));
    }
}