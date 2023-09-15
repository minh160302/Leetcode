class Solution {    
    public String alienOrder(String[] words) {
        // init
        HashMap<Character, Integer> indegrees = new HashMap<>();
        HashMap<Character, List<Character>> topoMap = new HashMap<>(); // key -> what comes before key
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegrees.put(c, 0);
                topoMap.put(c, new ArrayList<>());
            }
        }

        // build: strings in words are sorted lexicographically        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            boolean flag = true;
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);
                if (parent != child) {
                    indegrees.put(child, indegrees.get(child) + 1);
                    topoMap.get(parent).add(child);
                    flag = false;
                    break;
                }
            }

            if (flag && w1.length() > w2.length())
                return "";
        }

        // topological sort
        StringBuilder sb = new StringBuilder();
        while (!indegrees.isEmpty()) {
            boolean hasCycle = true;
            for (char key : indegrees.keySet()) {                
                if (indegrees.get(key) == 0) {
                    sb.append(key);       
                    for (char child: topoMap.get(key)) {    // -1 degree
                        indegrees.put(child, indegrees.get(child) - 1);
                    }
                    indegrees.remove(key);  // pop
                    hasCycle = false;
                    break;
                }
            }

            if (hasCycle)
                return "";
        }
        return sb.toString();
    }
}