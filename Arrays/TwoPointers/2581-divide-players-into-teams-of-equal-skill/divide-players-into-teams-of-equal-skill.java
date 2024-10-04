class Solution {
    /**
     * TC: O(Nlog(N) + N / 2) ~ O(Nlog(N)
     * SC: O(1)
     */
    public long dividePlayers(int[] skill) {
        int n = skill.length; // n is always even
        if (n == 2) {
            return (long) skill[0] * (long) skill[1];
        }
        Arrays.sort(skill); // TC: O(Nlog(N))
        long sum = 0L;
        int p = 0;
        int q = n - 1;
        long totalSkill = skill[p] + skill[q];
        while (p <= q) { // TC: O(N / 2)
            long currentSkill = skill[p] + skill[q];
            if (totalSkill == currentSkill) {
                sum += (long) skill[p] * (long) skill[q];
            } else {
                return -1L;
            }
            p++;
            q--;
        }
        return sum;
    }
}
