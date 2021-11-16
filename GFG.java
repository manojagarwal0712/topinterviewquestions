package com.stack;

public class GFG {

    static class DLLNode{
        DLLNode prev;
        DLLNode next;
        int data;
        public DLLNode(int data){
            this.data = data;
        }
    }

    class mystack{
        DLLNode head;
        DLLNode mid;
        int count;
    }

    public void push(mystack ms, int key){
        DLLNode newNode = new DLLNode(key);

        newNode.next = ms.head;
        newNode.prev =null;
        ms.count =ms.count+1;

        /**
         * change mid pointer in 2 cases
         * 1) Linked list is empty
         * 2) Number of nodes in linked lis is odd
         *
         */

        if(ms.count==1){
            ms.mid = newNode;
        }else {
            ms.head.prev = newNode;
            if((ms.count%2)!=0){ // Update mid if ms->count is odd
                ms.mid = ms.mid.prev;
            }
        }
        ms.head = newNode;
    }

    public int pop(mystack ms){
        if(ms.count==0){
            System.out.println("Stack overflow");
        }

        DLLNode temp = ms.head;
        int data = temp.data;
        ms.head = temp.next;
        if(ms.head!=null){
            ms.head.prev = null;
        }
        ms.count = ms.count-1;
        if(ms.count%2==0){
            ms.mid = ms.mid.next;
        }
        return data;
    }

    int findMid(mystack ms){
        if(ms.count==0){
            System.out.println("stack over flow");
            return -1;
        }
        return ms.mid.data;
    }

}
