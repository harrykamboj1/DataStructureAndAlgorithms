package com.StriverSDEsheet.LinkedList;

import java.util.HashSet;

import static com.StriverSDEsheet.LinkedList.Node.insertNode;
import static com.StriverSDEsheet.LinkedList.Node.printList;

public class IntersectionOfLinkedList {
    public static void main(String[] args) {
        Node head = null;
        head=insertNode(head,1);
        head=insertNode(head,3);
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,4);
        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec=insertNode(headSec,3);
        Node head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: "); printList(head1);
        System.out.print("List2: "); printList(head2);
        //checking if intersection is present
        Node answerNode = interestPoint(head1,head2);
        if(answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is "+answerNode.val);
    }

    private static Node intersectionPresent(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();
        while (head1!=null){
            set.add(head1);
            head1 = head1.next;
        }
        while (head2!=null){
            if(set.contains(head2))return head2;
            head2   = head2.next;
        }
        return null;
    }
    static int getDifference(Node head1,Node head2){
        int len1 = 0,len2 = 0;
        while(head1!=null || head2!=null){
            if(head1!=null){
                len1++;
                head1 = head1.next;
            }
            if(head2!=null) {
                len2++;
                head2 = head2.next;
            } }
        return len1-len2;
    }
    static Node interestPoint(Node head1,Node head2){
        int diff = getDifference(head1,head2);
        if(diff<0){
            while (diff++ != 0){
                head2 = head2.next;
            }
        }else{
            while (diff-- != 0)head1 = head1.next;
        }
        while (head1!=null){
            if(head1 == head2) return head1;
            head2 = head2.next;
            head1 = head1.next; }
        return head1;
    }
}
