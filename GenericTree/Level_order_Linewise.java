import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Level_order_Linewise {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        
    }

    // public static HashMap<Integer,Array/List<Integer>> ans = new HashMap<>();

    // public static HashMap<Integer,ArrayList<Integer>>  traversal(Node root,int level) {
    //     if(root== null){
    //         return ans;
    //     }
    //     if(ans.size()<=level){
    //         if(!ans.containsKey(level))
    //         {
    //             ans.put(level,new ArrayList<>());
    //         }
    //     }
    //     ans.get(level).add(root.data);
    //     for(Node child : root.children){
    //         traversal(child, level+1);
    //     }

    //     return ans;

    // }

    public static Queue<Node> pq = new LinkedList<>();
    public static Queue<Node> cq = new LinkedList<>();
    
    public static void traversal(Node nd, int level){
        pq.add(nd);
        while(pq.size()>0 || cq.size()>0){
            Node temp = pq.remove();
            System.out.print(temp.data+" ");
            
            for(Node child:temp.children){
                cq.add(child);
            }
            // System.out.println(cq);
            if(pq.isEmpty()){
                pq=cq;
                cq = new LinkedList<>();
                System.out.println();
            }
            // if(cq.isEmpty())
            // {
            //     System.out.println();
            // }
            
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

        traversal(root, 0);
        // for (Map.Entry<Integer, ArrayList<Integer>> entry : ans.entrySet()) {
        //     int key = entry.getKey();
        //     ArrayList<Integer> value = entry.getValue();
        //     System.out.println(value);
        // }
    }
}
