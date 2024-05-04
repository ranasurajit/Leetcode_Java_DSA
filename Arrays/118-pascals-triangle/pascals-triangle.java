class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalList = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            pascalList.add(new ArrayList<Integer>(i));
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    pascalList.get(i - 1).add(1);
                } else {
                    int sum = pascalList.get(i - 2).get(j - 1) + pascalList.get(i - 2).get(j);
                    pascalList.get(i - 1).add(sum);
                }
            }
        }
        return pascalList;
    }
}
