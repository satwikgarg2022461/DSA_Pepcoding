import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class height_Of_generic_tree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    
    public static int heigth(Node nd){
        int h = -1;
        for(Node child:nd.children)
        {
            int ch = heigth(child);
            h = Math.max(h,ch);
            System.out.println(h);
        }
        h += 1;
        return h;
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
        System.out.println(heigth(root));
        
    }
    
}
