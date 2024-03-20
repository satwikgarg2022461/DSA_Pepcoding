import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class no_of_island {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] a = new int[n][m];

        for(int i= 0;i<n;i++){
            String st = br.readLine();
            for(int j=0;j<m;j++){
                a[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
            }
        }
        boolean[][] visited = new boolean[n][m];
        
        int c=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j] == 0 && visited[i][j] == false){
                    drawTree(a, i,j,visited);
                    c++;
                }
            }
        }
        System.out.println(c);
    }

    public static void drawTree(int[][] a, int i,int j,boolean[][] visited){

        if(i<0 || j<0 || i>=a.length || j>=a[0].length || visited[i][j] == true || a[i][j] == 1){
            return;
        }
        visited[i][j] =true;
        drawTree(a, i-1, j, visited);
        drawTree(a, i+1, j, visited);
        drawTree(a, i, j+1, visited);
        drawTree(a, i, j-1, visited);
    }
}
