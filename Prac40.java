class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(bank == null || bank.length == 0) {
            return -1;
        }
        
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int result = 0;
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int sz = queue.size();
            //System.out.println(set);
            for(int i = 0; i < sz; i++) {
                String current = queue.poll();
                if(current.equals(end)) {
                    return result;
                }
                for(String s: bank) {
                    int count = 0;
                    for(int j = 0; j < s.length(); j++) {
                        if(s.charAt(j) != current.charAt(j)) {
                            count++;
                        }
                    }
                    //System.out.println(count);
                    if(count == 1 && !visited.contains(s)) {
                        queue.add(s);
                        visited.add(s);
                    }
                    
                }
            }
            result++;
        }
        return -1;
    }
}