class Solution {
    /**
     * Approach II : Using Binary Search on Answers Approach
     *
     * TC: O(N1 x log(Range) x log(N2))
     * SC: O(1)
     *
     * Accepted (112 / 112 testcases passed)
     */
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // the low and high values as per constraints -10^5 <= nums1[i], nums2[j] <= 10^5 is
        long low = (long) -1e10;
        long high = (long) 1e10;
        long result = 0L;
        while (low <= high) { // TC: O(log(Range)), where Range = (H - L)
            long mid = low + (high - low) / 2;
            long countProducts = getCountOfProductsLessThanMid(nums1, nums2, mid); // TC: O(N1 x log(N2))
            if (countProducts >= k) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * Using Binary Search Approach
     *
     * TC: O(N1 x log(N2))
     * SC: O(1)
     */
    private long getCountOfProductsLessThanMid(int[] nums1, int[] nums2, long midProduct) {
        long count = 0L;
        int n = nums2.length;
        for (int a : nums1) { // TC: O(N1)
            if (a >= 0) {
                int low = 0;
                int high = n - 1;
                int pos = -1; // invalid index
                while (low <= high) { // TC: O(log(N2))
                    int mid = low + (high - low) / 2;
                    long prod = (long) a * (long) nums2[mid];
                    if (prod <= midProduct) {
                        pos = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                count += (pos + 1);
            } else {
                int low = 0;
                int high = n - 1;
                int pos = n; // invalid index
                while (low <= high) { // TC: O(log(N2))
                    int mid = low + (high - low) / 2;
                    long prod = (long) a * (long) nums2[mid];
                    if (prod <= midProduct) {
                        pos = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                count += (n - pos);
            }
        }
        return count;
    }

    /**
     * Approach I : Using Brute-Force Approach
     *
     * TC: O(N1 x N2 x log(K))
     * SC: O(K)
     *
     * Time Limit Exceeded (79 / 112 testcases passed)
     */
    public long kthSmallestProductBruteForce(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        PriorityQueue<Long> pq = new PriorityQueue<Long>((a, b) -> Long.compare(b, a)); // SC: O(K)
        for (int i = 0; i < n1; i++) { // TC: O(N1)
            for (int j = 0; j < n2; j++) { // TC: O(N2)
                long prod = (long) nums1[i] * (long) nums2[j];
                if (pq.size() < k) {
                    pq.offer(prod);  // TC: O(log(K))
                } else if (prod < pq.peek()) {
                    pq.poll();
                    pq.offer(prod);  // TC: O(log(K))
                }
            }    
        }
        return pq.peek();
    }
}
