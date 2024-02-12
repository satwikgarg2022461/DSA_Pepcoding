import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class kth_largest {
    private static class Node{
        int data;
        ArrayList<Node> children =  new ArrayList<>();
    }

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
    public static int ceil,floor;
    // public static int diff;
    
    public static void floor_ceil(Node nd,int k){
        if(nd.data > k){
            if(nd.data<ceil){
                ceil = nd.data;
            }
        }
        if(nd.data < k){
            if(nd.data > floor){
                
                floor = nd.data;
            }
        }

        for(Node child : nd.children){
            floor_ceil(child,k);
        }

    }

    public static int kLarget(Node nd,int k){
        int f = Integer.MAX_VALUE;
        for(int i = 0;i<k;i++){
            floor_ceil(nd, f);
            f = floor;
            floor = Integer.MIN_VALUE;
        }
        return f;
    }
    

    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr1[i] = scn.nextInt();
        }

        int  k =scn.nextInt();
        
        // int m = scn.nextInt();
        // int[] arr2 = new int[m];
        // for (int i = 0; i < m; i++) {
        //     arr2[i] = scn.nextInt();
        // }

        Node root1 = Tree(arr1);
        // Node root2 = Tree(arr2);
        // display(root1);
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        // diff = Integer.MAX_VALUE;
        // floor_ceil(root1, 120);
        System.out.println(kLarget(root1, k));
        // System.out.println(floor);
        // System.out.println(ceil);


        



    }
}
