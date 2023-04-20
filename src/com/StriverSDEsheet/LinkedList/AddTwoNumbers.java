package com.StriverSDEsheet.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
     ListNode l1 = new ListNode(2);
     ListNode l21 = new ListNode(4);
     ListNode l22 = new ListNode(3);
     l1.next = l21;
     l21.next = l22;

        ListNode l2 = new ListNode(5);
        ListNode l11 = new ListNode(6);
        ListNode l12 = new ListNode(4);
        l2.next = l11;
        l11.next = l12;

        ListNode node = addTwoNumbers(l1,l2);
        System.out.println(node);

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
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
            ListNode node = new ListNode(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}
