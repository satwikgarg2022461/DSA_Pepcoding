
import java.util.*;



public class removeLeaf {

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

    public static void removeLeaf(Node nd) {


        for(int i=nd.children.size()-1;i>=0;i--){
            // System.out.println("nd "+nd.data);
            Node temp = nd.children.get(i);
            if(temp.children.size() == 0){
                // System.out.println("remove element "+temp.data);
                nd.children.remove(temp);
            }
        }

        for(Node child:nd.children){
            removeLeaf(child);
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
                if (st.size()>0) {
                    st.peek().children.add(nd);
                } else {
                    root = nd;
                }
                st.push(nd);
            }
        }
        display(root);
        removeLeaf(root);
        System.out.println();
        display(root);
    }
    
}
