package com.lists;

import java.util.List;
import java.util.Stack;

public class PracticeLinkedList {

    public boolean palLinkedList(ListNode head){
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp!=null){
            stack.add(temp.data);
            temp=temp.next;
        }
        while (head!=null){
            if (head.data!=stack.pop()){
                return false;
            }
            head=head.next;
        }
        return true;

    }

    public void reverseAList(ListNode head){
        ListNode headRev;
        ListNode prev=null;
        ListNode current = head;
        ListNode next = head;

        while (next!=null){
            next = current.next;
            current.next =prev;
            prev = current;
            current = next;
        }
        headRev = prev;
    }

    public void rearangeListOddEven(ListNode head){
        if (head==null)
            return;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenFirst = even;

        while (even!=null && even.next!=null){
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next=evenFirst;

    }

    public ListNode mergeSorteList(ListNode head1, ListNode head2){
        if (head1==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }

        if (head1.data<head2.data){
            head1.next = mergeSorteList(head1.next,head2);
            return head1;
        }else {
            head2.next = mergeSorteList(head1,head2.next);
            return head2;
        }



    }

    public ListNode reverseList(ListNode head){
        if (head==null)
            return null;
        ListNode prev=null;
        ListNode current = head;
        ListNode next = head;

        while (current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        PracticeLinkedList practiceLinkedList = new PracticeLinkedList();
        LinkedList linkedList = new LinkedList();

        linkedList.head = new ListNode(1);
        linkedList.endOfList(2,linkedList.head);
        linkedList.endOfList(3,linkedList.head);
        linkedList.endOfList(2,linkedList.head);
        linkedList.endOfList(1,linkedList.head);
        linkedList.endOfList(2,linkedList.head);
        practiceLinkedList.rearangeListOddEven(linkedList.head);
    }
}
