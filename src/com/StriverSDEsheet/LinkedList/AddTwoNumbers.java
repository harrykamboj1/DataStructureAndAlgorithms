package com.StriverSDEsheet.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
     Node l1 = new Node(2);
     Node l21 = new Node(4);
     Node l22 = new Node(3);
     l1.next = l21;
     l21.next = l22;

        Node l2 = new Node(5);
        Node l11 = new Node(6);
        Node l12 = new Node(4);
        l2.next = l11;
        l11.next = l12;

        Node node = addTwoNumbers(l1,l2);
        System.out.println(node);

    }
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(2);
        Node temp = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry == 1){
            int sum = 0;
            if(l1!=null){
                sum +=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum +=l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum/10;
            Node node = new Node(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}
