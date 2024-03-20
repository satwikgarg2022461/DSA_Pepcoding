import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PerfectFriend {
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

        // int src = Integer.parseInt(br.readLine());
        // int des = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vt];
        for (int i = 0; i < vt; i++) {
            visited[i] = false;
        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        for (int i = 0; i < vt; i++) {
            if (visited[i] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTree(graph, i, comp, visited);
                comps.add(comp);
            }
        }

        System.out.println(comps);
        int ans = 0;

        for(int i=0;i<comps.size();i++){
            int l1 = comps.get(i).size();
            int l2 = 0;
            if(i+1<comps.size()){
                l2 = comps.get(i+1).size();
            }else{
                l2 =comps.get(0).size();
            }
            ans+=l1*l2;
        }
        System.out.println(ans);

    }

    public static void drawTree(ArrayList<Edge>[] graph, int i, ArrayList<Integer> comp, boolean[] visited) {
        visited[i] = true;
        comp.add(i);
        for (Edge e : graph[i]) {
            if (visited[e.des] == false) {
                drawTree(graph, e.des, comp, visited);
            }
        }
    }


}
