package com.StriverSDEsheet.LinkedList;

public class Node {
      int val;
      Node next;
      Node(int val) {
            this.val = val;
            next = null;
      }

      static Node insertNode(Node head,int val) {
            Node newNode = new Node(val);

            if(head == null) {
                  head = newNode;
                  return head;
            }

            Node temp = head;
            while(temp.next != null) temp = temp.next;

            temp.next = newNode;
            return head;
      }
      //utility function to print linked list created
      static void printList(Node head) {
            while(head.next != null) {
                  System.out.print(head.val+"->");
                  head = head.next;
            }
            System.out.println(head.val);
      }

}

