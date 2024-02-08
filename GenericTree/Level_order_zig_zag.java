import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Level_order_zig_zag {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        
    }

    public static List<List<Integer>> ans = new ArrayList<>();

    public static Stack<Node> ps = new Stack<>();
    public static Stack<Node> cs = new Stack<>();

    public static void traversal(Node nd) {
    if(nd == null){
        return;
    }
    int level = 0;
    ps.push(nd);
    while(ps.size()>0 || cs.size()>0){
        Node temp = ps.pop();
        System.out.print(temp.data+" ");
        if(level%2 ==0){
            for(Node child: temp.children){
                cs.push(child);
            }
        }else{
            for(int i=temp.children.size()-1;i>=0;i--){
                cs.push(temp.children.get(i));
            }
        }
        if(ps.isEmpty()){
            System.out.println();
            ps=cs;
            cs=new Stack<>();
            level++;
        }
    }


        




    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        Stack<Node> st = new Stack<>();
        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node nd = new Node();
                nd.data=arr[i];
                // System.out.println();
                if (st.size()>0) {
                    // System.out.println(root.data);
                    st.peek().children.add(nd);
                    // System.out.println(st);
                } else {
                    root = nd;
                }
                st.push(nd);
            }
        }
        // System.out.println(root.children);

        traversal(root);
    }

}
