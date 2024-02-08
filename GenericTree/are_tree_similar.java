import java.util.*;

public class are_tree_similar {

    private static class Node{
        int data;
        ArrayList<Node> children =  new ArrayList<>();
    }

    public static Node Tree(int[] arr){
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

        return root;
    }

    public static boolean similiar(Node nd1, Node nd2){
        if(nd1.children.size() != nd2.children.size() ){
            return false;
        }

        for(int i=0;i<nd1.children.size();i++){
            if(!similiar(nd1.children.get(i), nd2.children.get(i))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr1[i] = scn.nextInt();
        }
        
        int m = scn.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scn.nextInt();
        }

        Node root1 = Tree(arr1);
        Node root2 = Tree(arr2);

        System.out.println(similiar(root1, root2));



    }
}
