class Solution {
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] distribute = new int[k];
        backtrack(distribute, cookies, k, 0);
        return res;
    }

    public void backtrack(int[] distribute, int[] cookies, int k, int i) {
        if (i == cookies.length) {
            int tmp = 0;
            for (int val : distribute) {
                tmp = Math.max(tmp, val);
            }
            res = Math.min(tmp, res);
            return;
        }        

        for (int c = 0; c < k; c++) {
            distribute[c] += cookies[i];
            backtrack(distribute, cookies, k, i + 1);
            distribute[c] -= cookies[i];
        }
    }
}