import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class hamiltonianPathCycle {
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
        // boolean[] visited = new boolean[vt];
        // for(int i = 0 ;i<vt;i++){
        //     visited[i] = false;
        // }
        HashSet<Integer> visited = new HashSet<>();
        HPC(graph, src, visited, src, src+"");

    }

    public static void HPC(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, int osrc,String path){
        if(visited.size() == graph.length -1){
            boolean cycle = false;
            for(Edge e : graph[src]){
                if(e.des == osrc){
                    cycle =  true;
                }
            }
            if(!cycle){
                System.out.println(path+".");
            }else{
                System.out.println(path+"*");
            }
            return;
        }

        visited.add(src);
        for(Edge e: graph[src]){
            if(!visited.contains(e.des)){
                HPC(graph, e.des, visited, osrc, path+e.des);
            }
        }
        visited.remove(src);
    }
    
}
