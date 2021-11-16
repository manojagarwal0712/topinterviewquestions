package com.lists;

import com.sun.org.apache.bcel.internal.generic.LUSHR;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

public class LinkedList {
    static ListNode head;
    static ListNode head1;

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public  ListNode addInFront(int data, ListNode head) {
        ListNode temp = head;
        head = new ListNode(data);
        head.next = temp;
        return head;
    }

    public static void addAfterGivenNode(int data, ListNode prevNode) {
        if (prevNode == null) {
            throw new IllegalArgumentException("Prev node can not be null");
        }
        ListNode newNode = new ListNode(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void endOfList(int data, ListNode head){
        ListNode temp = head;
        while(head!=null && head.next!=null){
            head = head.next;
        }
        head.next = new ListNode(data);

    }

    public static void deleteNode(int data, ListNode head){
        ListNode prevNode = null;
        ListNode temp = head;

        //if head itself have the key
        if(head!=null && head.data==data){
            head = head.next;
        }

        // find the prev node of which next node having data
        while(temp!=null && temp.data!=data){
            prevNode = temp;
            temp = temp.next;
        }
        if(prevNode == null){
            throw new IllegalArgumentException("Key not present in the list");
        }
        prevNode.next = prevNode.next.next;
    }

    public static void deleteAtGivePosition(int pos){
        int temp =0;
        if(pos == 0 && head!=null){
            head = head.next;
        }

        for (int i=0; i<pos-1 && head!=null; i++){
            head = head.next;
        }

        //if position is greater then number of nodes
        if(head==null && head.next ==null){
            return;
        }
        head.next = head.next.next;

    }

    public static int findLengthOfListRecursive(ListNode head){
        if(head==null)
            return 0;
        return 1+ findLengthOfListRecursive(head.next);
    }

    public static boolean searchElementInLinkedList(int key, ListNode head){
        if(head!=null && head.data==key){
            return true;
        }
        if(head==null){
            return false;
        }
        return searchElementInLinkedList(key, head.next);
    }

    public static void getNthNodeInList(int index, ListNode head){

        for (int i =0; i<=index-1 && head!=null;i++){
            head = head.next;
        }

        if(head ==null)
            throw new IllegalArgumentException("Index is greater then number of nodes");
        System.out.println(head.data);
    }

    /**
     * Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
     * When the fast pointer reaches end slow pointer will reach middle of the linked list.
     * @param head
     */
    public static void printMiddle(ListNode head){
        ListNode slow, fast;
        slow = head;
        fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }

    /**
     * 1) when slow will be at middle node, temp will have the previuos of slow.
     * 2) replace temp.next to middle's next (which is slow's next)
     * @param head
     */
    public static void deleteMiddle(ListNode head){
        ListNode slow, fast;
        slow = head;
        fast = head;
        ListNode temp = null;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }
        temp.next = slow.next;
    }


    public static ListNode removeDuplicateFromSortedlist(ListNode head){

        if (head==null)
            return null;

        if(head.next!=null){
            if(head.data==head.next.data){
                head.next=head.next.next;
                removeDuplicateFromSortedlist(head);
            }
            else {
                removeDuplicateFromSortedlist(head.next);
            }
        }
        return  head;

    }

    public static ListNode addOneUtil(ListNode head){
        ListNode res=head;
        ListNode temp=null, prev=null;

        int carry =1, sum;
        while (head!=null){
            sum = carry+head.data;
            carry = (sum>=10)?1:0;
            sum = sum %10;
            head.data = sum;
            temp = head;
            head = head.next;
        }
        if (carry>0){
            temp.next=new ListNode(carry);
        }
        return res;
    }
    public static ListNode addOne(ListNode head){
        // Reverse linked list
        head = reverseList(head);
        // Add one from left to right of reversed
        // list
        head = addOneUtil(head);
        return reverseList(head);

    }

    public static ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode current = head;
        ListNode next = null;

        while (current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return  head;
    }

    /**
     * reverse a list recrusively
     * @param head
     * @return
     */
    public ListNode reverseListRec(ListNode head){
        if (head==null)
            return null;
        else if (head.next==null)
            return head;
        else{
            ListNode temp = reverseListRec(head.next);
            temp.next.next = temp.next;
            temp.next=null;
            return temp;
        }
    }


    /**
     * Pint list in reverse
     * @param head
     */
    public void printListReverseRec(ListNode head){
        if (head==null)
            return;
        printListReverseRec(head.next);
        System.out.println(head.data);

    }

    public static boolean detectLop(ListNode head){

        if (head==null)
            return false;
        ListNode fast, slow;
        fast =slow = head;

        while (slow!=null && fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }

    /**
     * https://www.youtube.com/watch?v=JsVGDy0u1u8
     * 
     * @param head
     */
    public void detectAndFixLoop(ListNode head){
        if (head==null)
            return;
        ListNode fast, slow;
        fast =slow = head;

        while (slow!=null && fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
            if (slow==fast){
                break;
            }
        }

        // if slow == fast that mean loop exist.
        // now we have to find out whats the point where the loop exist.
        if(slow==fast){
            slow = head;
            while (slow.next!=fast.next){
                slow=slow.next;
                fast=fast.next;
            }
            //sinc fast.next is the looping point break it.
            fast.next=null; // remove lopp.
        }
    }

    public static void nthNodeFromEnd(ListNode head, int n){
        int size = sizeOfList(head);
        // nth node from last mean size-n from start
        int index = size-n+1;
        while (index>1){
            head = head.next;
            index--;
        }
        System.out.println(head.data);
    }

    public static int sizeOfList(ListNode head){
        if (head==null)
            return 0;
        return 1+sizeOfList(head.next);
    }

    /**
     * Delete last occurrence of an item from linked list
     *
     *
     */
    public static void deleteLastOccurance(ListNode head,int key){
        ListNode lastOccurance=null;
        ListNode res = head;
        ListNode prev=null;
        ListNode current=head;

        if(current==null)
            return;
        if (current.next==null && current.data==key) {
            current = null;
            return;
        }
        while (current!=null && current.next!=null){
            if(current.data==key){
                lastOccurance = head;
            }
            prev=current;
            current=current.next;

        }
        if(lastOccurance==null && current.data==key){
            prev.next=null;
        }
        if (lastOccurance!=null){
            lastOccurance.data=lastOccurance.next.data;
            lastOccurance.next=null;
        }
        printList(res);
    }

    /**
     * Rotate a Linked List
     * Input: 10->20->30->40->50->60
     * OutPut: 50->60->10->20->30->40
     * 1) just obsever the above rotated list
     * 2) To rorate we actually need kth node.next to null
     * 3) last node would have would have previous head
     * 4) head would have (k+1)th node
     *
     * So we have to maintaine 3 pointers kth, k+1, last
     */
    public static ListNode rotateAList(ListNode head, int n){

        ListNode kth=null;
        ListNode k1th =null;
        ListNode lastNode=null;
        ListNode temp = head;
        int index=1;
        while (head!=null){
            if(n==index){
                kth = head;
                k1th = head.next;
            }
            head = head.next;
            index++;
        }
        lastNode = head;
        if(kth!=null && k1th!=null){
            kth.next=null;
            lastNode = temp;
            temp = k1th;
        }
        return temp;

    }

    public void addTwoNumberList(ListNode head1, ListNode head2){
        ListNode node1 = reverseList(head1);
        ListNode node2 = reverseList(head2);
        ListNode res=null;
        ListNode prev=null;

        int sum=0;
        int carry=0;
        while (node1!=null || node2!=null){
            sum = carry + (node1!=null?node1.data:0)
                    + (node2!=null?node2.data:0);
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            if(res==null){
                res = newNode;
            }else {
                prev.next=newNode;
            }
            prev = newNode;

            if (node1!=null){
                node1=node1.next;
            }
            if (node2!=null){
                node2=node2.next;
            }
        }
        if (carry>0){
            ListNode newNode = new ListNode(sum%10);
            prev.next = newNode;
        }
    }

    int carry;
    public void addSameSizeList(ListNode head1, ListNode head2){
        //since both the list would be same size so have any one of them for below condition
        if (head1==null)
            return;

        addSameSizeList(head1.next,head2.next);
        int sum = head1.data+head2.data+carry;
        int carry = sum/10;
        sum = sum%10;
    }

    /**
     * https://www.geeksforgeeks.org/rearrange-a-linked-list-such-that-all-even-and-odd-positioned-nodes-are-together/
     * https://www.youtube.com/watch?v=C_LA6SOwVTM
     *
     * Arrange lisnked list element in such a way that odd position are in left and even are in right.
     *
     * @param head
     */
    public void arrangeOddEve(ListNode head){

        if (head==null)
            return;

        ListNode oddNode = head;
        ListNode evenNode =head.next;
        ListNode evenFirst = evenNode;

        while (evenNode!=null || evenNode.next!=null){
            oddNode.next = evenNode.next;
            oddNode = evenNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next=evenFirst;
    }

    /**
     * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
     * Reverse a Linked List in groups of given size
     * Or : Given a singly linked list, write a recursive method to reverse every 3 nodes in the lis
     *
     *
     */
    public ListNode reversek(ListNode head, int k){

        if (head==null)
            return null;

        int count =0;
        ListNode current = head;
        ListNode next=head;
        ListNode prev =null;

        while (count<k && head!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next!=null){
            head.next = reversek(next,k);
        }

        return prev;
    }

    public static ListNode addTwoList(ListNode l1, ListNode l2){
        if (l1==null){
            return l2;
        }
        if (l2==null)
            return l1;
        ListNode res=null;
        ListNode l1r = reverseList(l1);
        ListNode l2r = reverseList(l2);
        int carry=0;
        while (l1r!=null || l2r!=null){
            int sum  = carry+l1r.data + l2r.data;
            carry = sum/10;
            sum = sum %10;
            ListNode newNode = new ListNode(sum);
            if (res==null){
                res=newNode;
            }else {
                ListNode temp = res;
                newNode.next=temp;
                res = newNode;
            }
            l1r = l1r.next;
            l2r = l2r.next;
        }

        while (l1r!=null){
            int sum  = carry+l1r.data;
            carry = sum/10;
            sum = sum %10;

            ListNode newNode = new ListNode(sum);
            if (res==null){
                res=newNode;
            }else {
                ListNode temp = res;
                newNode.next=temp;
                res = newNode;
            }
            l1r = l1r.next;
        }
        while (l2r!=null){
            int sum  = carry+l2r.data;
            carry = sum/10;
            sum = sum %10;

            ListNode newNode = new ListNode(sum);
            if (res==null){
                res=newNode;
            }else {
                ListNode temp = res;
                newNode.next=temp;
                res = newNode;
            }
            l2r = l2r.next;
        }
        if (carry>0){
            ListNode newNode = new ListNode(carry);
            if (res==null){
                res=newNode;
            }else {
                ListNode temp = res;
                newNode.next=temp;
                res = newNode;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new ListNode(3);
        /*head.next = new ListNode(15);
        head.next.next = new ListNode(35);
        //head.next.next.next = new ListNode(56);*/
        head = linkedList.addInFront(6, head);
        head = linkedList.addInFront(5, head);

        linkedList.head1 = new ListNode(2);
        head1 = linkedList.addInFront(4, head1);
        head1 = linkedList.addInFront(8, head1);

        //printList(head);
        //addAfterGivenNode(9,head.next.next.next);
        //endOfList(8, head);
        //printList(head);
        //deleteNode(6, head);
        //printList(head);
        //System.out.println(findLengthOfListRecursive(head));
        //System.out.println(searchElementInLinkedList(5,head));
        //printList(addOne(head));
        //linkedList.printListReverseRec(head);
        //nthNodeFromEnd(head,4);
        //printList(head);
        //deleteLastOccurance(head,16);
        ListNode head2 = addTwoList(head, head1);
        printList(head2);

    }
}


