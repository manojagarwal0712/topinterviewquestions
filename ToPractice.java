package com.tree;

import apple.laf.JRSUIUtils;
import com.lists.ListNode;

import java.util.*;

public class ToPractice {


    public static void inorderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        if(root!=null) {
            inorderTravel(root.left);
            System.out.println(root.data);
            inorderTravel(root.right);
        }
    }

    public static void postOrderTravel(TreeNode root){
        if(root==null){
            return;
        }

        postOrderTravel(root.left);
        postOrderTravel(root.right);
        System.out.println(root.data);

    }

    public static void preorderTravel(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        postOrderTravel(root.left);
        postOrderTravel(root.right);
    }

    public static void levelOrderTravel(TreeNode root){
        if(root==null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.add(temp);
        while(!queue.isEmpty()){
            temp = queue.remove();

            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);

            System.out.println(temp.data);

        }

    }

    public static int findDepth(TreeNode root){

        if(root==null){
            return 0;
        }

        int lDepth = findDepth(root.left);
        int rDepth = findDepth(root.right);

        /* use the larger one */
        if (lDepth > rDepth)
            return (lDepth + 1);
        else
            return (rDepth + 1);

    }


    public void inOrderTraversalIterative(TreeNode root){

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while (true){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else {
                if (stack.isEmpty()){
                    break;
                }
                root=stack.pop();
                System.out.println(root.data);;
                root = root.right;
            }
        }

    }

    public void iterativePostOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            root = stack.pop();
            stack1.push(stack.pop());
            if(root.left!=null){
                stack.push(root.left);
            }
            if (root.right!=null){
                stack.push(root.right);
            }

        }

        while (!stack1.isEmpty()){
            System.out.println(stack1.pop().data);
        }
    }

    public void iterativePreOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            System.out.println(root.data);
            if(root.left!=null){
                stack.push(root.left);
            }
            if (root.right!=null){
                stack.push(root.right);
            }
        }
    }

    public int search(int []in, int root,int start,int end){
        for (int i =start; i <end;i++){
            if(in[i]==root){
                return i;
            }
        }
        return -1;
    }



    /**
     * Print Postorder traversal from given Inorder and Preorder traversals
     * https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
     * Input:
     * Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
     * Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}
     *
     * Output:
     * Postorder traversal is {4, 5, 2, 6, 3, 1}
     *
     * 1) Idea is to search root (first item in preorder) in inOrder (root will be in middle)
     * 2) call printpostoder recursively on left sub tree and right subtree
     */
    static int preIndex =0;
    public void printPostOrder(int in[], int pre[],int start, int end){

        int index = search(in,pre[preIndex++], start,end);
        printPostOrder(in, pre,start,index-1);
        printPostOrder(in,pre, index+1,end);
        System.out.println(in[index]);
    }

    public void findPostOrderIUtil(int pre[], int n, int min, int max){
        //if the array is already traveesed then return
        if (preIndexVal==n)
            return;
        if (pre[preIndexVal]<min || pre[preIndexVal]>max){
            return;
        }

        int val = pre[preIndexVal];
        preIndexVal++;
        //all value b/w min and val would be left subtree
        findPostOrderIUtil(pre,n,min,val);

        //all value b/w val and max would be right subtree
        findPostOrderIUtil(pre,n,val,max);
        System.out.println(val);
    }

    public void printLevleOrderTraversal(TreeNode root){

        if (root==null)
            return;;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            System.out.println(temp.data);
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
        }
    }
    public void printTreeinSpairal(TreeNode root){
        //stack to print from right to left
        Stack<TreeNode> stack = new Stack<>();
        //stack to print from left to right
        Stack<TreeNode> stack1 = new Stack();
        stack.add(root);
        while (!stack.isEmpty() || !stack1.isEmpty()){

            while (!stack.isEmpty()){
                TreeNode temp = stack.pop();
                if (temp.right!=null)
                    stack1.add(temp.right);
                if (temp.left!=null)
                    stack1.add(temp.left);
            }

            while (!stack1.isEmpty()){
                TreeNode temp = stack.pop();
                if (temp.left!=null)
                    stack.add(temp.left);
                if (temp.right!=null)
                    stack.add(temp.right);
            }
        }

    }

    public static void levelOrderLineByLine(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() || !queue1.isEmpty()){
            while (!queue.isEmpty()){
                TreeNode temp = queue.remove();
                System.out.print(temp.data);
                if (temp.left!=null)
                    queue1.add(temp.left);
                if (temp.right!=null)
                    queue1.add(temp.right);
            }
            System.out.println();
            while (!queue1.isEmpty()){
                TreeNode temp = queue1.remove();
                System.out.print(temp.data);
                if (temp.left!=null)
                    queue.add(temp.left);
                if (temp.right!=null)
                    queue.add(temp.right);
            }
            System.out.println();


        }

    }

    public void travelBoundry(TreeNode root){
        printLeft(root);
        printLeaf(root);
        printRight(root.right);
    }

    public void printLeft(TreeNode root){
        if (root==null)
            return;
        if (root.left==null && root.right==null)
            return;

        System.out.println(root.data);
        printLeft(root.left);


    }

    public void printRight(TreeNode root){
        if (root==null)
            return;
        if (root.left==null && root.right==null)
            return;

        System.out.println(root.data);
        printLeft(root.right);
    }

    public void printLeaf(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            System.out.println(root.data);
        else {
            printLeaf(root.left);
            printLeaf(root.right);
        }
    }
    class TreeNodeWithHeight{
       TreeNode node;
       int height;

        public TreeNodeWithHeight(TreeNode node, int height){
            this.node=node;
            this.height = height;
        }
    }
    public void diagonalTravel(TreeNode root){
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNodeWithHeight> queue = new LinkedList<>();
        queue.add(new TreeNodeWithHeight(root,0));

        while (!queue.isEmpty()){
            TreeNodeWithHeight temp = queue.remove();
            if (temp.node.left!=null){
                queue.add(new TreeNodeWithHeight(root.left,(temp.height)+1));

            }
            if (temp.node.right!=null){
                queue.add(new TreeNodeWithHeight(root.right,temp.height));
            }

            if (map.containsKey(temp.height)){
                List<Integer> list1 = map.get(temp.height);
                list1.add(temp.node.data);
                map.put(temp.height,list1);
            }
            else {
                List<Integer> list1 = new LinkedList<>();
                list1.add(temp.node.data);
                map.put(temp.height,list1);
            }
        }
    }

    /**
     * Level order traversal and ensure left most node in the level gets print
     * Its similar to level by level print and ensure only left most element is printed
     * @param root
     */

    public static void printLeftView(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> queue1 = new LinkedList<>();
        boolean flag =true;
        while (!queue.isEmpty() || !queue1.isEmpty()) {

            while (!queue.isEmpty()) {
                TreeNode temp = queue.remove();
                if (temp.left!=null)
                    queue1.add(temp.left);
                if (temp.right!=null)
                    queue1.add(temp.right);
                if (flag){
                    System.out.println(temp.data);
                    flag=false;
                }

            }
            flag =true;
            while (!queue1.isEmpty()){
                TreeNode temp = queue1.remove();
                if (temp.left!=null)
                    queue.add(temp.left);
                if (temp.right!=null)
                    queue.add(temp.right);
                if (flag) {
                    System.out.println(temp.data);
                    flag =false;
                }
            }
            flag=true;
        }
    }

    public static void printLeftViewWithOneQueue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean flag = true;

        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if (temp!=null){
                if (temp.left!=null)
                    queue.add(temp.left);
                if (temp.right!=null)
                    queue.add(temp.right);
                if (flag){
                    System.out.println(temp.data);
                    flag=false;
                }
            }else {
                if (!queue.isEmpty()){
                    queue.add(null);
                    flag=true;
                }
            }

        }

    }

    public static void printRightViewWithOneQueue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean flag = true;

        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if (temp!=null){
                if (temp.right!=null)
                    queue.add(temp.right);
                if (temp.left!=null)
                    queue.add(temp.left);
                if (flag){
                    System.out.println(temp.data);
                    flag=false;
                }
            }else {
                if (!queue.isEmpty()){
                    queue.add(null);
                    flag=true;
                }
            }

        }

    }

    /**
     * veritcal order traversal order
     */

    class TreeNodeWithDistance{
        TreeNode node;
        int dis;
        public TreeNodeWithDistance(TreeNode node, int dis){
            this.node = node;
            this.dis=dis;
        }
    }
    public  void topview(TreeNode root){
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNodeWithDistance> queue = new LinkedList<>();
        queue.add(new TreeNodeWithDistance(root,0));

        while (!queue.isEmpty()){
            TreeNodeWithDistance temp = queue.remove();
            if (temp.node.left!=null)
                queue.add(new TreeNodeWithDistance(temp.node.left,(temp.dis)-1));
            if (temp.node.right!=null)
                queue.add(new TreeNodeWithDistance(temp.node.right,(temp.dis)+1));

            if (!map.containsKey(temp.dis)){
                map.put(temp.dis,temp.node.data);
            }

        }
        System.out.println(map);
    }

    public  void bottomView(TreeNode root){
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNodeWithDistance> queue = new LinkedList<>();
        queue.add(new TreeNodeWithDistance(root,0));

        while (!queue.isEmpty()){
            TreeNodeWithDistance temp = queue.remove();
            if (temp.node.left!=null)
                queue.add(new TreeNodeWithDistance(temp.node.left,(temp.dis)-1));
            if (temp.node.right!=null)
                queue.add(new TreeNodeWithDistance(temp.node.right,(temp.dis)+1));

            map.put(temp.dis,temp.node.data);

        }
        System.out.println(map);
    }

    public void countNumberOfLeafNode(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count =0;
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if (temp.left==null && temp.right==null){
                count++;
            }
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
        }
        System.out.println(count);
    }

    public int countNumberOfLeafNodeRec(TreeNode root){
        if (root==null)
            return 0;
        if (root.left==null && root.right==null)
            return 1;
        return countNumberOfLeafNodeRec(root.left)+countNumberOfLeafNodeRec(root.right);
    }

    public int numberOfNodesInATree(TreeNode root){
        if (root==null)
            return 0;
        return 1+numberOfNodesInATree(root.left)+numberOfNodesInATree(root.right);
    }

    public int heightOfTree(TreeNode root){
        if (root==null)
            return 0;
        return 1+ Math.max(heightOfTree(root.left),heightOfTree(root.right));
    }

    public void mirrorOfBinaryTree(TreeNode root){

        mirrorOfBinaryTree(root.left);
        mirrorOfBinaryTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    public void levelOrderTravelDel(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
            System.out.println(temp.data);
        }
    }
    /**
     * Find postorder traversal of BST from preorder traversal
     * @param
     */
    static int preIndexVal=0;
    public void findPostOrderFromPre(int pre[], int n){
        findPostOrderIUtil(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * dist(n1,n2) = dist(lca, n1) + dist(lca, n2);
     *
     * @param root
     * @param n1
     * @param n2
     */
    public int distanceBtwTwoNodesBinaryTree(TreeNode root, TreeNode n1, TreeNode n2){
        TreeNode lca = findLCA(root,n1,n2);
        int d1 = findLevel(root,n1,0);
        int d2 = findLevel(root,n2,0);

        return d1+d2;
    }

    public int findLevel(TreeNode root, TreeNode n1, int level){
        if (root==null)
            return -1;
        if (root.data==n1.data){
            return level;
        }
        int left = findLevel(root.left,n1,level+1);
        if (left==-1){
            findLevel(root.right,n1,level+1);
        }
        return left;
    }

    public TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2){

        if (root==null)
            return null;
        if (root==n1 || root==n2){
            return  root;
        }
        TreeNode leftLCA = findLCA(root.left,n1,n2);
        TreeNode righLCA = findLCA(root.right,n1,n2);

        if (leftLCA==null && righLCA==null){
            return null;
        }
        if (leftLCA!=null && righLCA!=null){
            return root;
        }
        return leftLCA!=null?leftLCA:righLCA;
    }

    public boolean findIdentical(TreeNode root, TreeNode subRoot){
        if (root==null || subRoot ==null){
            return false;
        }
        if (subRoot==null && root==null)
            return true;
        return root.data==subRoot.data && findIdentical(root.left,subRoot.left)
                && findIdentical(root.right,subRoot.right);

    }

    /**
     * vertical sum of a binary tree
     * @param root
     */
    public void verticalSumBinaryTree(TreeNode root){
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNodeWithDistance> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        list.add(0);
        queue.add(new TreeNodeWithDistance(root,0));

        while (!queue.isEmpty()){
            TreeNodeWithDistance temp = queue.remove();
            if (temp.node.left!=null){
                queue.add(new TreeNodeWithDistance(temp.node.left,temp.dis-1));
            }
            if (temp.node.right!=null){
                queue.add(new TreeNodeWithDistance(temp.node.right,temp.dis+1));
            }
            if (map.containsKey(temp.dis)){

                map.put(temp.dis,map.get(temp.dis)+temp.node.data);
            }else {
                map.put(temp.dis,temp.node.data);
            }
        }
        System.out.println(map);
    }

    public void printSpiral(TreeNode root){
        Stack<TreeNode> stackLR = new Stack<>();
        Stack<TreeNode> stackRL = new Stack<>();
        stackLR.add(root);
        while (!stackLR.isEmpty() || !stackRL.isEmpty()) {
            while (!stackLR.isEmpty()) {
                TreeNode temp = stackLR.pop();
                if (temp.right != null) {
                    stackRL.push(temp.right);
                }
                if (temp.left != null)
                    stackRL.push(temp.left);
                System.out.print(temp.data);
            }
            System.out.println();
            while (!stackRL.isEmpty()) {
                TreeNode temp = stackRL.pop();
                if (temp.left != null) {
                    stackLR.push(temp.left);
                }
                if (temp.right != null)
                    stackLR.push(temp.right);
                System.out.print(temp.data);
            }
            System.out.println();
        }
    }

    static int maxLavel=0;
    public void rightViewOfTree(TreeNode root, int level){
        if (root==null)
            return;

        if (maxLavel<level){
            System.out.println(root.data);
            maxLavel = level;
        }
        rightViewOfTree(root.right,level+1);
        rightViewOfTree(root.left,level+1);
    }

    public void mirrorTree(TreeNode root){
        if (root==null)
            return;

        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    public boolean findIfMirrorTree(TreeNode root1, TreeNode root2){
        if (root1==null||root2==null)
            return false;

        if (root1==null && root2==null)
            return true;

        return root1.data==root1.data && findIfMirrorTree(root1.left,root2.right)
                && findIfMirrorTree(root1.right,root2.left);
    }

    public static void main(String[] args) {
        ToPractice toPractice = new ToPractice();
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);

        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        /*binaryTree.root.left.right.left = new TreeNode(8);


        binaryTree.root.right.left = new TreeNode(6);
        binaryTree.root.right.right = new TreeNode(7);
        binaryTree.root.right.right.right = new TreeNode(9);*/

        tree.root1 = new TreeNode(1);
        tree.root1.left = new TreeNode(3);
        tree.root1.right = new TreeNode(2);

        tree.root1.left.left = new TreeNode(5);
        tree.root1.left.right = new TreeNode(5);

        //System.out.println(findDepth(tree.root));
        //int a =toPractice.heightOfTree(tree.root);
        //System.out.println(a);
        //toPractice.rightViewOfTree(tree.root,1);
        System.out.println(toPractice.findIfMirrorTree(tree.root,tree.root1));

    }
}
