class Solution {
    /**
     * Approach II : Using Greedy (Cleaner Approach) Approach
     *
     * TC: O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(1)
     */
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people); // TC: O(N x log(N))
        int p = 0;
        int q = n - 1;
        int ships = 0;
        while (p <= q) { // TC: O(N)
            if (people[p] + people[q] <= limit) {
                p++;
            }
            ships++;
            q--;
        }
        return ships;
    }

    /**
     * Approach I : Using Greedy Approach
     *
     * TC: O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(1)
     */
    public int numRescueBoatsGreedy(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people); // TC: O(N x log(N))
        int p = 0;
        int q = n - 1;
        int ships = 0;
        while (p <= q) { // TC: O(N)
            if (people[p] + people[q] <= limit) {
                ships++;
                p++;
                q--;
            } else if (people[q] <= limit) {
                ships++;
                q--;
            }
        }
        return ships;
    }
}
