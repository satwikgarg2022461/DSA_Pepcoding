import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class LinearizeTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node nd){
        if(nd == null){
            return ;
        }
        System.out.print(nd.data+" -> ");
        for(Node child:nd.children){
            System.out.print(child.data + " ");
        }
        System.out.println();
        for(Node child:nd.children){
            display(child);
        }
    }

    public static void linearize(Node nd) {
        for(Node child:nd.children){
            linearize(child);
        }

        while(nd.children.size()>1){
            Node lc = nd.children.remove(nd.children.size()-1);
            Node slc = nd.children.get(nd.children.size()-1);
            Node slt = getTail(slc);
            slt.children.add(lc);
        }
    }

    private static Node getTail(Node nd){
        while(nd.children.size() ==  1){
            nd = nd.children.get(0);
        }
        return nd;
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
                if (st.size()>0) {
                    st.peek().children.add(nd);
                } else {
                    root = nd;
                }
                st.push(nd);
            }
        }
        display(root);
        linearize(root);
        System.out.println();
        display(root);
    }
}
