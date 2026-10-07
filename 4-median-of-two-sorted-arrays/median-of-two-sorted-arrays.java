class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while (low <= high) {

            // Partition nums1
            int cut1 = low + (high - low) / 2;

            // Partition nums2
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Odd total length
                if ((n1 + n2) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even total length
                int leftMax = Math.max(left1, left2);
                int rightMin = Math.min(right1, right2);

                return (leftMax + rightMin) / 2.0;
            }

            // We have taken too many elements from nums1
            if (left1 > right2) {
                high = cut1 - 1;
            }

            // We need to take more elements from nums1
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}