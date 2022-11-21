class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        
        int ans = 0;
        
        while (!queue.isEmpty()) {
            int qsize = queue.size();
            for (int j = 0; j < qsize; j++) {
                String s = queue.remove();
                if (s.equals(end)) {
                    return ans;
                }

                for (char c: new char[] {'A', 'C', 'G', 'T'}) {
                    for (int i = 0; i < s.length(); i++) {
                        String neighbor = s.substring(0, i) + c + s.substring(i + 1);
                        if (!set.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                            queue.add(neighbor);
                            set.add(neighbor);
                        }
                    }
                }
            }
            
            ans++;
        }
        
        return -1;
    }
}