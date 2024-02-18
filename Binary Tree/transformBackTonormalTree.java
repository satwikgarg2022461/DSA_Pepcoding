import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class transformBackTonormalTree {
    public static class Node {
        Integer data;
        Node left;
        Node right;

        public Node(Integer data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node constructor(Integer[] a) {

        Node root = new Node(a[0], null, null);
        Pair pr = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(pr);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (a[idx] != null) {
                    Node nd = new Node(a[idx], null, null);
                    top.node.left = nd;
                    st.push(new Pair(nd, 1));
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (a[idx] != null) {
                    Node nd = new Node(a[idx], null, null);
                    top.node.right = nd;
                    st.push(new Pair(nd, 1));
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node nd) {
        if (nd == null) {
            return;
        }

        if (nd.left == null && nd.right == null) {
            System.out.println(". -> " + nd.data + " <- .");
        } else if (nd.left == null && nd.right != null) {
            System.out.println(". -> " + nd.data + " <- " + nd.right.data);
        } else if (nd.left != null && nd.right == null) {
            System.out.println(nd.left.data + " -> " + nd.data + " <- .");
        } else if (nd.left != null && nd.right != null) {
            System.out.println(nd.left.data + " -> " + nd.data + " <- " + nd.right.data);
        }

        // System.out.println(nd.left.data+" -> "+nd.data+" <- "+nd.right.data);
        display(nd.left);
        display(nd.right);
    }

    public static Node transform(Node nd) {
        if(nd == null){
            return null;
        }

        Node left = transform(nd.left.left);
        Node right = transform(nd.right);
        
        nd.left = left;
        nd.right = right;
        
        return nd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] token = str.split(" ");
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            if (token[i].equals("null")) {
                a[i] = null;
            } else {
                a[i] = Integer.parseInt(token[i]);
            }
        }

        Node root = constructor(a);
        display(root);
        System.out.println();
        root = transform(root);
        System.out.println();
        display(root);

    }
}
