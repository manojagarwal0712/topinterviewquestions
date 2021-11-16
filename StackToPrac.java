package com.stack;


import java.util.Stack;

// 1) stack is last in first out LIFO
public class StackToPrac {
    StackNode root;

    class StackNode{
        int data;
        StackNode next;

        public StackNode(int data){
            this.data=data;
        }

    }

    public boolean isEmpty(){
        if (root==null)
            return true;
        return  false;
    }

    public void push(int data){
        StackNode newNode = new StackNode(data);

        if (root==null)
            root = newNode;
        else {
            newNode.next = root;
            root = newNode;
        }
    }

    public int pop(){
        if (root==null)
            throw new StackOverflowError("Stack over flow");
        else {
            int data = root.data;
            root = root.next;
            return data;
        }

    }

    public int peek(){
        if (root==null)
            throw new StackOverflowError("Stack over flow");
        else {
            return root.data;
        }
    }

    public boolean checkIfExpressionIsBalanced(String str){

        Stack<Character> stack = new Stack();

        for (int i =0; i<str.length();i++){

            if(str.charAt(i)=='('
                    || str.charAt(i)=='{'
            || str.charAt(i)=='['){
                stack.push(str.charAt(i));
            }
            if(str.charAt(i)==')'
                    || str.charAt(i)=='}'
                    || str.charAt(i)==']'){
                if(stack.isEmpty()){
                    return false;
                }
                if((stack.peek()=='(' && str.charAt(i)!=')')
                    && (stack.peek()=='{' && str.charAt(i)!='}')
                    && (stack.peek()=='[' && str.charAt(i)!=']')){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }

}
