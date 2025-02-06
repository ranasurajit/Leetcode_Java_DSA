class Solution {
    /**
     * Using Stack Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     * 
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        Stack<String> st = new Stack<String>(); // SC: O(N)
        for (String s : pathArr) { // TC: O(N)
            if (s.equals(" ") || s.equals(".") || s.equals("")) {
                continue;
            } else if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(s);
            }
        }
        String simplifiedPath = "";
        while (!st.isEmpty()) { // TC: O(N)
            simplifiedPath = "/" + st.pop() + simplifiedPath;
        }
        return simplifiedPath.equals("") ? "/" : simplifiedPath;
    }
}
