import java.util.*;
import java.util.Scanner;

class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
}


public class display_a_generic_tree {

    public static void display(Node nd)
    {
        System.out.print(nd.data +" -> ");
        for(Node child : nd.children)
        {
            System.out.print(child.data+" ");
        }
        System.out.println();
        for(Node child : nd.children)
        {
            display(child);
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
        display(root);
    }
}