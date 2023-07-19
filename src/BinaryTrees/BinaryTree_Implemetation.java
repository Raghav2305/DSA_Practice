package BinaryTrees;

import java.util.Scanner;

public class BinaryTree_Implemetation {

    public BinaryTree_Implemetation(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root value: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate_helper(scanner, root);

    }

    private void populate_helper(Scanner scanner, Node root) {
        System.out.println("Do you want to enter the node left to " + root.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the left node value: ");
            int left_val = scanner.nextInt();
            root.left = new Node(left_val);
            populate_helper(scanner, root.left);
        }

        System.out.println("Do you want to enter the node right to " + root.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the right node value: ");
            int right_val = scanner.nextInt();
            root.right = new Node(right_val);
            populate_helper(scanner, root.right);
        }
    }

    public void display(){
        display(root, "");
    }
    private  void display(Node root, String indent){
        if(root == null) return;
        System.out.println(indent + root.value);
        display(root.left , indent + "\t");
        display(root.right , indent + "\t");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree_Implemetation bt = new BinaryTree_Implemetation();
        bt.populate(scanner);
        bt.display();
    }
}
