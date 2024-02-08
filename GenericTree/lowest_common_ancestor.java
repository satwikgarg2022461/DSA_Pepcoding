import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class lowest_common_ancestor {
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

    // public static ArrayList<Integer> ans = new ArrayList<>();

    public static ArrayList<Integer> ancestor(Node nd ,int k) {
        if(nd.data == k){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(nd.data);
            return ans;
        }

        for(Node child : nd.children){
            ArrayList<Integer> ans = ancestor(child,k);
            if(ans.size()>0){
                ans.add(nd.data);
                return ans;
            }
        }

        return new ArrayList<>();
    }

    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int k1 = scn.nextInt();
        int k2 = scn.nextInt();

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
        ArrayList<Integer> a1 = ancestor(root,k1);
        ArrayList<Integer> a2 = ancestor(root,k2);
        System.out.println(a1);
        a1.retainAll(a2);
        if(!a1.isEmpty())
        System.out.println(a1.get(0));
        else{
            System.out.println("[]");
        }
    }
}
