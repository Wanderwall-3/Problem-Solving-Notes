package Leetcode802;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode802 {


    public boolean dfs(int[][] graph, int i, HashMap<Integer, Boolean> dp, HashMap<Integer, Boolean> loop){
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        if(loop.containsKey(i)){
            return false;
        }
        loop.put(i, true);
        for(int j=0;j<graph[i].length;j++){
            if(!dfs(graph, graph[i][j], dp, loop)){
                dp.put(i, false);
                loop.remove(i);
                return false;
            }
        }
        dp.put(i, true);
        loop.remove(i);
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, Boolean> dp = new HashMap<>();
        HashMap<Integer, Boolean> loop = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(dfs(graph, i, dp, loop)){
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        Leetcode802 leetcode802 = new Leetcode802();
        System.out.println(leetcode802.eventualSafeNodes(graph));
        // leetcode802.eventualSafeNodes(graph);
    }
}
