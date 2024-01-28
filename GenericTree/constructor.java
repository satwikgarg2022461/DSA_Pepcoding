import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
}

class constructor
{
    
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
        for(int i =0;i<arr.length;i++)
        {
            if(arr[i] == -1){
                st.pop();
            }
            Node nd = new Node();
            nd.data = arr[i];
            if(st.empty()){
                root = nd;
            }else{
                st.peek().children.add(nd);
            }
            st.push(nd);
        }
    }
}