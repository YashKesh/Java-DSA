package Graph;
import  java.util.*;
import java.util.stream.Collectors;

/*
 * There are n people, each person has a unique ID between 0 and n-1. Given the arrays watchedVideos and friends, 
 * where watchedVideos[i] and friends[i] contain the list of watched videos and the list of friends for the person with ID = i.
 * 
 * Level 1 of a person is their friends. Level k of a person is level 1 of all the persons that are friends of the person and so on.
 * 
 * Two persons are friends if they have a direct connection and there is no friend request pending.
 * 
 * The watchedVideos of one person is a list of videos that the person has watched.
 * 
 * 
 * Return the list of videos with the most watched videos by friends of the person with the given id and level.
 */
class WatchedVideos {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < friends.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j : friends[i]) {
                adj.get(i).add(j);
            }
        }

        // Initialize BFS from the given id
        q.add(id);
        boolean[] visited = new boolean[friends.length];
        visited[id] = true;

        int currentLevel = 0;

        // BFS to find friends at the given level
        while (!q.isEmpty() && currentLevel < level) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int friend : adj.get(node)) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        q.add(friend);
                    }
                }
            }
            currentLevel++;
        }

        // Now q contains all friends at the given level
        Map<String, Integer> map = new HashMap<>();
        while (!q.isEmpty()) {
            int friend = q.poll();
            for (String video : watchedVideos.get(friend)) {
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }

        // Sort by frequency and then alphabetically
        LinkedHashMap<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry::getKey))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        // Convert sorted map to list
        List<String> finalAns = new ArrayList<>();
        sortedMap.forEach((k, v) -> finalAns.add(k));

        return finalAns;
    }
}
