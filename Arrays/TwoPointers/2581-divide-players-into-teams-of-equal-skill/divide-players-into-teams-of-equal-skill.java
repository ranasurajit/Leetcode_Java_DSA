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
}
