import java.util.*;

public class AlgorithmaGraph {

    static final int INF = Integer.MAX_VALUE; 

    public static void dijkstra(int[][] graph, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> dist[i]));
        pq.add(start);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(v);
                }
            }
        }

        String[] cities = {"Malang", "Sidoarjo", "Surabaya", "Mojokerto", "Tuban"};
        System.out.println("Jarak terpendek dari kota " + cities[start] + " ke kota lainnya:");
        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) {
                System.out.println(cities[i] + ": Tidak terjangkau.");
            } else {
                System.out.println(cities[i] + ": " + dist[i] + " km");
            }
        }
    }

    public static void bfs(int[][] graph, int start, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        String[] cities = {"Malang", "Sidoarjo", "Surabaya", "Mojokerto", "Tuban"};
        System.out.println("\nBFS Traversal dari kota " + cities[start] + ":");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(cities[node] + " ");

           
            for (int i = 0; i < n; i++) {
                if (graph[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    public static void dfs(int[][] graph, int start, int n) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        String[] cities = {"Malang", "Sidoarjo", "Surabaya", "Mojokerto", "Tuban"};
        System.out.println("\nDFS Traversal dari kota " + cities[start] + ":");

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(cities[node] + " ");

          
            for (int i = 0; i < n; i++) {
                if (graph[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
        int[][] graph = {
            {0, 30, 50, 0, 0},  
            {30, 0, 20, 40, 0}, 
            {50, 20, 0, 60, 0}, 
            {0, 40, 60, 0, 30},  
            {0, 0, 0, 30, 0}     
        };

        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan kota asal:");
        System.out.println("1. Malang");
        System.out.println("2. Sidoarjo");
        System.out.println("3. Surabaya");
        System.out.println("4. Mojokerto");
        System.out.println("5. Tuban");
        System.out.print("Pilih kota (1-5): ");
        int startCity = sc.nextInt() - 1;

   
        dijkstra(graph, startCity, graph.length);

       
        bfs(graph, startCity, graph.length);

       
        dfs(graph, startCity, graph.length);
    }
}
