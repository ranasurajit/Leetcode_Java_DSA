class Solution {
    /**
     * Optimal Approach
     * TC: O(2N) ~ O(N)
     * SC: O(1)
     */
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        // SC: O(1001) ~ O(1)
        int[] skillFreq = new int[1001]; // as per constraints 1 <= skill[i] <= 1000
        long sum = 0L;
        for (int it : skill) { // TC: O(N)
            skillFreq[it]++;
            sum += (long) it;
        }
        if (n == 2) {
            return (long) skill[0] * (long) skill[1];
        }
        if (sum % (n / 2) != 0) { // total skill sum should be even to form team pairs
            return -1L;
        }
        long skillPerTeam = sum / (n / 2);
        long chemistry = 0L;
        // loop and check if teams can be formed
        for (int it : skill) { // TC: O(N)
            int partnerSkill = (int) skillPerTeam - it;
            if (skillFreq[partnerSkill] == 0) {
                return -1L;
            } else {
                chemistry += (long) it * (long) partnerSkill;
                skillFreq[partnerSkill]--;
            }
        }
        return chemistry / 2;
    }

    /**
     * Using Two Pointers and Sorting
     * TC: O(Nlog(N) + N / 2) ~ O(Nlog(N))
     * SC: O(1)
     */
    public long dividePlayersBetter(int[] skill) {
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
