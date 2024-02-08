import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Level_order_traversal {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        
    }

    public static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> traversal(Node root,int level) {
        // if (root == null) {
        //     return;
        // }

        // Queue<Node> q = new ArrayDeque<>();
        // q.add(root);

        // while (!q.isEmpty()) {
        //     Node current = q.poll();
        //     System.out.print(current.data + " ");

        //     for (Node child : current.children) {
        //         q.add(child);
        //     }
        // }

        if(root== null){
            return ans;
        }
        if(ans.size()<=level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.data);
        for(Node child : root.children){
            traversal(child, level+1);
        }

        return ans;




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

        System.out.println(traversal(root, 0));
    }
}
