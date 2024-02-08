import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class find_an_element {
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

    public static boolean find(Node nd ,int k) {
        if(nd.data == k){
            return true;
        }

        for(Node child : nd.children){
            if(find(child, k)){
                return true;
            }
        }

        return false;
    }

    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int k= scn.nextInt();

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
        // display(root);
        // find(root, k);
        // System.out.println();
        // display(root);
        System.out.println(find(root,k));
    }

}
