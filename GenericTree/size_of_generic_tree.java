import java.util.*;


class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
}



public class size_of_generic_tree {

    public static int c =0;
    public static void size(Node nd){
        // c++;
        for(Node child: nd.children)
        {
            c++;
        }
        for(Node child:nd.children){
            size(child);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = scn.nextInt();
        }
        Stack<Node> st = new Stack<>();
        Node root = null;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] == -1)
            {
                st.pop();
            }else{
                Node nd = new Node();
                nd.data=arr[i]; 
                if(st.empty())
                {
                    root = nd;
                }else{
                    st.peek().children.add(nd);
                }
                st.push(nd);
            }
            
        }
        size(root);
        System.out.println(c+1);
    }
}
