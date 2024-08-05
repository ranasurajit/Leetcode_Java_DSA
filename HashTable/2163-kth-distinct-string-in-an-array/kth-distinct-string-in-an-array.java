class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (hm.get(arr[i]) == 1) {
                k--;
                if (k == 0) {
                    result = arr[i];
                }
            }
        }
        return result;
    }
}
