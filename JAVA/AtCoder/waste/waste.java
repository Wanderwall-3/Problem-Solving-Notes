import java.util.*;

public class waste {
    static class Pair {
        int node;
        long cost;

        Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        long X = sc.nextLong();

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> revGraph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            graph.get(u).add(v);
            revGraph.get(v).add(u);
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        Deque<Pair> deque = new ArrayDeque<>();
        
        deque.addFirst(new Pair(1, 0));
        dist[1] = 0;

        while (!deque.isEmpty()) {
            Pair cur = deque.pollFirst();
            int node = cur.node;
            long cost = cur.cost;

            if (cost > dist[node]) continue;
            
            for (int next : graph.get(node)) {
                if (dist[next] > cost + 1) {
                    dist[next] = cost + 1;
                    deque.addLast(new Pair(next, cost + 1));
                }
            }
            for (int next : revGraph.get(node)) {
                if (dist[next] > cost + X) {
                    dist[next] = cost + X;
                    deque.addLast(new Pair(next, cost + X));
                }
            }
        }

        System.out.println(dist[N]);
        sc.close();
    }
}
