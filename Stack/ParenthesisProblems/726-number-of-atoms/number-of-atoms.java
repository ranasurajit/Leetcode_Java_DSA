class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<HashMap<String, Integer>> st = new Stack<HashMap<String, Integer>>();
        st.push(new HashMap<String, Integer>());
        int index = 0;
        while (index < n) {
            char ch = formula.charAt(index);
            if (ch == '(') {
                // start of new formula
                st.push(new HashMap<String, Integer>());
                index++;
            } else if (ch == ')') {
                // end of a formula
                HashMap<String, Integer> cm = st.pop();
                index++;
                StringBuilder sb = new StringBuilder();
                while (index < n && Character.isDigit(formula.charAt(index))) {
                    sb.append(formula.charAt(index));
                    index++;
                }
                if (sb.length() > 0) {
                    int multiplier = Integer.parseInt(sb.toString());
                    for (String key : cm.keySet()) {
                        cm.put(key, cm.get(key) * multiplier);
                    }
                }
                for (String key : cm.keySet()) {
                    st.peek().put(key, st.peek().getOrDefault(key, 0) + cm.get(key));
                }
            } else {
                // the character is an alphabet
                StringBuilder sb = new StringBuilder();
                sb.append(formula.charAt(index));
                index++;
                while (index < n && Character.isLowerCase(formula.charAt(index))) {
                    sb.append(formula.charAt(index));
                    index++;
                }
                String atomName = sb.toString();
                // the character is a number
                StringBuilder num = new StringBuilder();
                while (index < n && Character.isDigit(formula.charAt(index))) {
                    num.append(formula.charAt(index));
                    index++;
                }
                int count = num.length() > 0 ? Integer.parseInt(num.toString()) : 1;
                st.peek().put(atomName, st.peek().getOrDefault(atomName, 0) + count);
            }
        }
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
        HashMap<String, Integer> hm = st.pop();
        StringBuilder result = new StringBuilder();
        for (String key : hm.keySet()) {
            tm.put(key, hm.get(key));
        }
        for (String key : tm.keySet()) {
            result.append(key);
            if (tm.get(key) > 1) {
                result.append(tm.get(key));
            }
        }
        return result.toString();
    }
}
