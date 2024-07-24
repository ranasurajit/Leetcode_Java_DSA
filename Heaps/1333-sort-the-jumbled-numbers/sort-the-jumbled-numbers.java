class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> {
            if (p.mappedNum == q.mappedNum) {
                return p.index - q.index;
            } else {
                return p.mappedNum - q.mappedNum;
            }
        });
        for (int i = 0; i < n; i++) {
            Pair currentPair = getMappedNumber(nums[i], i, mapping);
            System.out.println(currentPair.num + "-" + currentPair.index + "-" + currentPair.mappedNum);
            pq.offer(currentPair);
        }
        int[] sorted = new int[n];
        int index = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            sorted[index] = pair.num;
            index++;
        }
        return sorted;
    }

    private Pair getMappedNumber(int num, int index, int[] mapping) {
        int current = num;
        double mapVal = 0;
        int pow = 0;
        if (current == 0) {
            mapVal = mapping[current];
        }
        while (current > 0) {
            int rem = current % 10;
            current = current / 10;
            int mappedRem = mapping[rem];
            mapVal += mappedRem * Math.pow(10, pow++);
        }
        return new Pair(num, index, (int) mapVal);
    }

    class Pair {
        int num;
        int index;
        int mappedNum;
        public Pair(int num, int index, int mappedNum) {
            this.num = num;
            this.index = index;
            this.mappedNum = mappedNum;
        }
    }
}
