class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < rooms.get(0).size(); i++) {
            queue.offer(rooms.get(0).get(i));
            visited[0] = 1;
        }
        while (!queue.isEmpty()) {
            Integer currentRoom = queue.poll();
            if (visited[currentRoom] == 0) {
                visited[currentRoom] = 1;
                for (Integer it : rooms.get(currentRoom)) {
                    if (visited[it] == 0) {
                        queue.offer(it);
                    }
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
