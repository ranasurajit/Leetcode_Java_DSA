class Solution {
    /**
     * Optimal Approach - Using Trie
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        BitTrie trie = new BitTrie();
        for (int i = 0; i < n; i++) { // TC: O(N)
            trie.insert(nums[i]);
        }
        // it's time to compare and get the maximum XOR
        int maxXOR = 0;
        for (int i = 0; i < n; i++) {
            maxXOR = Math.max(maxXOR, trie.getMaxXORPossible(nums[i]));
        }
        return maxXOR;
    }

    class BitTrie {

        BitTrieNode root;

        class BitTrieNode {
            BitTrieNode left; // store 0 bit
            BitTrieNode right; // store 1 bit
        }

        public BitTrie() {
            root = new BitTrieNode();
        }

        /**
         * TC: O(32) ~ O(1)
         * SC: O(1)
         */
        public void insert(int digit) {
            BitTrieNode crawler = root;
            // loop from most significant bit (left to right i.e. index 31 to 0)
            for (int i = 31; i >= 0; i--) {
                int ithBit = (digit >> i) & 1;
                if (ithBit == 0) {
                    // move to left child of BitTrie
                    if (crawler.left == null) {
                        crawler.left = new BitTrieNode();
                    }
                    crawler = crawler.left;
                } else {
                    // move to right child of BitTrie
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
        public int getMaxXORPossible(int digit) {
            BitTrieNode crawler = root;
            int maxXOR = 0;
            // loop from most significant bit (left to right i.e. index 31 to 0)
            for (int i = 31; i >= 0; i--) {
                int ithBit = (digit >> i) & 1;
                if (ithBit == 0) {
                    // we can get max XOR if we perform XOR with bit 1 so move right
                    if (crawler.right != null) {
                        maxXOR += (int) Math.pow(2, i);
                        crawler = crawler.right;
                    } else {
                        // we have no option but to move left
                        crawler = crawler.left;
                    }
                } else {
                    // we can get max XOR if we perform XOR with bit 0 so move left
                    if (crawler.left != null) {
                        maxXOR += (int) Math.pow(2, i);
                        crawler = crawler.left;
                    } else {
                        // we have no option but to move right
                        crawler = crawler.right;
                    }
                }
            }
            return maxXOR;
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
