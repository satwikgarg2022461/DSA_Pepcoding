// package Binary Tree;
import java.util.*;
import java.io.*;

public class traversal {

    private static class Node{
        Integer data;
        Node left;
        Node right;
        public Node (Integer data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static class Pair{
        Node node;
        int state;
        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static Node constructor(Integer[] a){

        Node root = new Node(a[0], null, null);
        Pair pr = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(pr);

        int idx = 0;
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 1){
                idx ++;
                if(a[idx] != null){
                    Node nd = new Node(a[idx], null, null);
                    top.node.left = nd;
                    st.push(new Pair(nd, 1));
                }else{
                    top.node.left = null;
                }
                top.state++;
            }else if(top.state == 2){
                idx ++;
                if(a[idx] != null){
                    Node nd = new Node(a[idx], null, null);
                    top.node.right = nd;
                    st.push(new Pair(nd, 1));
                }else{
                    top.node.right = null;
                }
                top.state++;
            }else{
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node nd){
        if(nd == null){
            return;
        }

        if(nd.left == null && nd.right == null){
            System.out.println(". -> "+nd.data+" <- .");
        }else if(nd.left == null && nd.right != null){
            System.out.println(". -> "+nd.data+" <- "+nd.right.data);
        }else if(nd.left != null && nd.right == null){
            System.out.println(nd.left.data+" -> "+nd.data+" <- .");
        }else if(nd.left != null && nd.right != null){
            System.out.println(nd.left.data+" -> "+nd.data+" <- "+nd.right.data);
        }

        // System.out.println(nd.left.data+" -> "+nd.data+" <- "+nd.right.data);
            display(nd.left);
            display(nd.right);
    }

    public static void pre(Node nd){
        if(nd == null){
            return ;
        }
        System.out.println(nd.data);
        pre(nd.left);
        pre(nd.right);
    }

    public static void in(Node nd){
        if(nd == null){
            return;
        }
        in(nd.left);
        System.out.println(nd.data);
        in(nd.right);
    }

    public static void post(Node nd){
        if(nd == null){
            return;
        }
        post(nd.left);
        post(nd.right);
        System.out.println(nd.data);
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] token = str.split(" ");
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            if(token[i].equals("null")){
                a[i] = null;
            }else{
                a[i] = Integer.parseInt(token[i]);
            }
        }

        Node root = constructor(a);
        // display(root);
        pre(root);
        System.out.println();
        in(root);
        System.out.println();
        post(root);
    }
    
}
