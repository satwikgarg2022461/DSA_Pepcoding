import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class diameter {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }


    public static int mx_dia = Integer.MIN_VALUE;

    public static int dia(Node nd){
        int dch =-1;
        int sdch =-1;

        for(Node child : nd.children){
            int ch = dia(child);
            if(ch>dch){
                sdch = dch;
                dch = ch;
            }else if(ch > sdch){
                sdch = ch;
            }
        }

        int cand = dch+sdch+2;
        if(cand>mx_dia){
            mx_dia = cand;
        }
        dch+=1;
        return dch;
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
        dia(root);
        System.out.println(mx_dia);
        
    }
}
