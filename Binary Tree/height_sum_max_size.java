import java.util.*;
import java.io.*;
public class height_sum_max_size {

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

    public static int mx = Integer.MIN_VALUE;
    public static int height = 0;
    public static int size = 0;
    public static int sum = 0;


    public static void general(Node nd, int d){
        if(nd == null){
            return;
        }
        mx = Math.max(nd.data,mx);
        size+=1;
        sum+=nd.data;
        height = Math.max(d, height);

        general(nd.left, d+1);
        general(nd.right, d+1);

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
        general(root, 0);
        System.out.println("sum "+sum);
        System.out.println("height "+height);
        System.out.println("sum "+sum);
        System.out.println("max "+mx);
        // display(root);

        

    }

    
}