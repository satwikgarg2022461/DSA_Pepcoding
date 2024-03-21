import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstra {
    public static class Edge {
        int src, des, wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vt = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vt];
        for (int i = 0; i < vt; i++) {
            graph[i] = new ArrayList<>();
        }
        int edge = Integer.parseInt(br.readLine());
        for (int i = 0; i < edge; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int des = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vt];
        for(int i = 0 ;i<vt;i++){
            visited[i] = false;
        }
        algo(graph, src, des, visited);
    
    }
    public static class Pair implements Comparable<Pair>{
        int vt;
        String path;
        int wt;
        public Pair(int vt, String path, int wt){
            this.vt = vt;
            this.path = path;
            this.wt = wt;
        }
        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static Pair ans;

    public static void algo(ArrayList<Edge>[] graph, int src, int des, boolean[] visited){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(src, src+"", 0));

        while(q.size()>0){
            Pair rm = q.remove();
            if(rm.vt == des){
                System.out.println(rm.path+" "+rm.wt);
                break;
            }
            if(visited[rm.vt] == true){
                continue;
            }
            visited[rm.vt] = true;
            // System.out.println(rm.path+" "+rm.wt);
            for(Edge e : graph[rm.vt]){
                if(visited[e.des] == false){
                    q.add(new Pair(e.des, rm.path+e.des, rm.wt+e.wt));
                }
            }
        }
    }
}
