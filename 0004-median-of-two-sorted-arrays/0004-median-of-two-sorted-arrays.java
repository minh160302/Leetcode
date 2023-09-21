class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int center = (m + n) / 2;
        if ((m + n) % 2 == 1)
            return 1.0 * helper(nums1, nums2, m, n, center);
        else
            return (1.0 * helper(nums1, nums2, m, n, center - 1) + 1.0 * helper(nums1, nums2, m, n, center)) / 2;
    }

    public int helper(int[] nums1, int[] nums2, int m, int n, int targetIndex) {
        int p = 0;
        int p1 = 0, p2 = 0;
        int val = -1;
        while (p <= targetIndex && p1 < m && p2 < n) {            
            if (nums1[p1] < nums2[p2]) {
                val = nums1[p1];
                p1++;
            }
            else {
                val = nums2[p2];
                p2++;
            }
            p++;
        }
        if (p <= targetIndex) {                
            if (p1 < m) {
                val = nums1[p1 + targetIndex - p];
            }                
            else {
                val = nums2[p2 + targetIndex - p];
            }                
        }
        return val;
    }
}