class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = Arrays.copyOf(nums1, m + n);
        int p1 = 0, p2 = 0, p = 0;
        while (p1 < m && p2 < n) {
            if (copy[p1] < nums2[p2]) {
                nums1[p] = copy[p1];
                p1++;
                p++;
            }
            else {
                nums1[p] = nums2[p2];
                p2++;
                p++;
            }
        }

        if (p1 < m) {
            for (int i = p1 ; i < m; i++)
                nums1[n + i] = copy[i];
        }
        if (p2 < n) {
            for (int i = p2; i < n; i++)
                nums1[m + i] = nums2[i];
        }
    }
}