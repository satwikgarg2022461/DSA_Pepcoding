import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class predecessor_successor {
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
    public static Node pre,suc;
    public static int state;
    
    public static void pre_post(Node nd,int k){
        if(state == 0){
            if(nd.data == k){
                state =1;
            }else{
                pre = nd;
            }
        }else if(state == 1){
            state =2;
            suc = nd;
        }

        for(Node child : nd.children){
            pre_post(child,k);
        }

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
        pre = null;
        suc = null;
        state=0;
        pre_post(root1,k);
        System.out.println(pre.data);
        System.out.println(suc.data);


        



    }
}
