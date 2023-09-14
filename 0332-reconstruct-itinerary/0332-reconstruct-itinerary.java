class Solution {
    HashMap<String, List<String>> flights = new HashMap<>();
    HashMap<String, boolean[]> visited = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            List<String> lst = flights.getOrDefault(src, new ArrayList());
            lst.add(dst);
            flights.put(src, lst);
        }

        for (String key : flights.keySet()) {
            Collections.sort(flights.get(key));
            visited.put(key, new boolean[flights.get(key).size()]);
        }

        int n = tickets.size();
        List<String> route = new ArrayList<>();
        route.add("JFK");
        backtrack(route, "JFK", n);
        return res;
    }

    public boolean backtrack(List<String> route, String current, int n) {
        if (route.size() == n + 1) {
            res = new ArrayList<>(route);
            return true;
        }
        if (!flights.containsKey(current))
            return false;
        
        boolean[] vst = visited.get(current);
        for (int i = 0; i < flights.get(current).size(); i++) {
            String next = flights.get(current).get(i);
            boolean found = false;
            if (!vst[i]) {
                vst[i] = true;
                route.add(next);
                found = backtrack(route, next, n);
                vst[i] = false;
                route.remove(route.size() - 1);
            }
            if (found)
                return true;
        }
        return false;
    }
}