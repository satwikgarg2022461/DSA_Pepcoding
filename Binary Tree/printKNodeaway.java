import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class printKNodeaway {
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


    public static ArrayList<Node> pathToRoot(Node nd, int k){
        if(nd.data == k){
            ArrayList<Node> t = new ArrayList<>();
            t.add(nd);
            return t;
        }

        if(nd.left != null){
            ArrayList<Node> left = pathToRoot(nd.left,k);
            left.add(nd);
            return left; 
        }

        if(nd.right != null){
            ArrayList<Node> right = pathToRoot(nd.right, k);
            right.add(nd);
            return right;
        }

        return new ArrayList<>();
    } 


    public static void Kleveldown(Node nd, int k, int blocker, int level){
        if(k< 0 || k == blocker || nd == null){
            return;
        }

        if(k == level){
            System.out.print(nd.data+" ");
        }

        Kleveldown(nd.left, k-1, blocker, level);
        Kleveldown(nd.right, k-1, blocker, level);
    }

    public static void kNodeAway(Node nd, int data,int k){
        ArrayList<Node> path =pathToRoot(nd, data);
        for(int i=0;i<path.size();i++){
            Kleveldown(path.get(i), k-i, i == 0? -1000:path.get(i-1).data, 0);
        }
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
        
        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = constructor(a);
        // display(root);
        // System.out.println(pathToRoot(root, k));
        kNodeAway(root, data, k);
        

    }
}
