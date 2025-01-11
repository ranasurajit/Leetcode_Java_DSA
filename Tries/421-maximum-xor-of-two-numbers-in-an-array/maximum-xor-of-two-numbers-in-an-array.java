class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        BitTrie trie = new BitTrie();
        for (int i = 0; i < n; i++) { // TC: O(N)
            trie.insert(nums[i]);     // TC: O(1)
        }
        int maxXOR = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            maxXOR = Math.max(maxXOR, trie.getMaxXORValue(nums[i])); // TC: O(1)
        }
        return maxXOR;
    }

    class BitTrie {
        BitTrieNode root;

        class BitTrieNode {
            BitTrieNode left;  // store 0 bit
            BitTrieNode right; // store 1 bit

            public BitTrieNode() {}
        }

        public BitTrie () {
            root = new BitTrieNode();
        }

        /**
         * TC: O(32) ~ O(1)
         * SC: O(1)
         */
        public void insert(int digit) {
            BitTrieNode crawler = root;
            // iterate through 32 bits from most significate bit (left to right)
            for (int i = 31; i >= 0; i--) { // TC: O(32) ~ O(1)
                int ithBit = (digit >> i) & 1;
                if (ithBit == 0) {
                    // store it in left node of BitTrie
                    if (crawler.left == null) {
                        crawler.left = new BitTrieNode();
                    }
                    crawler = crawler.left;
                } else {
                    // store it in right node of BitTrie
                    if (crawler.right == null) {
                        crawler.right = new BitTrieNode();
                    }
                    crawler = crawler.right;
                }
            }
        }

        /**
         * TC: O(32) ~ O(1)
         * SC: O(1)
         */
        public int getMaxXORValue(int digit) {
            BitTrieNode crawler = root;
            int result = 0;
            // iterate through 32 bits from most significate bit (left to right)
            for (int i = 31; i >= 0; i--) {
                int ithBit = (digit >> i) & 1;
                if (ithBit == 0) {
                    if (crawler.right != null) {
                        result += (int) Math.pow(2, i);
                        crawler = crawler.right;
                    } else {
                        crawler = crawler.left;
                    }
                } else {
                    if (crawler.left != null) {
                        crawler = crawler.left;
                        result += (int) Math.pow(2, i);
                    } else {
                        crawler = crawler.right;
                    }
                }
            }
            return result;
        }
    }

    /**
     * Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int findMaximumXORBruteForce(int[] nums) {
        int n = nums.length;
        int maxXOR = 0;
        for (int i = 0; i < n; i++) {         // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                maxXOR = Math.max(maxXOR, nums[i] ^ nums[j]);
            }
        }
        return maxXOR;
    }
}
