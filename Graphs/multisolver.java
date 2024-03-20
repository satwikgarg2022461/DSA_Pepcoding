import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class multisolver {
    public static class Edge {
        int src, des, wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int wt;
        String path;
        
        public Pair(int wt, String path){
            this.wt = wt;
            this.path = path;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static int spathwt = Integer.MAX_VALUE;
    public static String spath = "";
    public static int lpathwt = Integer.MIN_VALUE;
    public static String lpath = "";
    public static int cpathwt = Integer.MAX_VALUE;
    public static String cpath = "";
    public static int fpathwt = Integer.MIN_VALUE;
    public static String fpath = "";
    public static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void multisolve(ArrayList<Edge>[] graph, int src, int des, int cret, boolean[] visited, int k, int wt,
            String path) {
        if (src == des) {

            if(wt > lpathwt){
                lpathwt = wt;
                lpath = path;
            }

            if(wt < spathwt){
                spathwt = wt;
                spath = path;
            }

            if(wt>cret){
                if(cpathwt>wt){
                    cpathwt = wt;
                    cpath = path;
                }
            }

            if(wt < cret){
                if(fpathwt < wt){
                    fpathwt = wt;
                    fpath = path;
                }
            }

            if(pq.size() < k){
                pq.add(new Pair(wt, path));
            }else{
                if(pq.peek().wt < wt){
                    pq.remove();
                    pq.add(new Pair(wt, path));
                }
            }

            return;
        }

        visited[src] = true;
        for (Edge e : graph[src]) {
            if (visited[e.des] == false) {
                multisolve(graph, e.des, des, cret, visited, k, wt + e.wt,path+e.des);
            }
        }
        visited[src] = false;
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
        int cret = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vt];
        for (int i = 0; i < vt; i++) {
            visited[i] = false;
        }

        multisolve(graph, src, des, cret, visited, k, 0, "0");

        System.out.println("smallest path "+spath+" "+spathwt);
        System.out.println("largest path "+lpath+" "+lpathwt);
        System.out.println("ciel "+cpath+" "+cpathwt);
        System.out.println("floor "+fpath+" "+fpathwt);
        System.out.println("k largest "+pq.peek().path);

    }

    
}
