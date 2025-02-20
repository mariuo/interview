package com.company.leetcode.linkedList;

/*
876. Middle of the Linked List
Given the head of a singly linkedList, return the middle node of the linkedlist.

If the are two middle nodes, return the second middle node.

Example 1:
input: head = [1,2,3,4,5]
output: [3,4,5]
Explanation: The middle node of the list is node 3.

example 2:
input: head = [1,2,3,4,5,6]
output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
public class MiddleOfTheLinkedList {


    public static void main(String[] args) {

        ListNode listNode2 = new com.company.leetcode.linkedList.ListNode(1,new com.company.leetcode.linkedList.ListNode(2, new com.company.leetcode.linkedList.ListNode(3, new com.company.leetcode.linkedList.ListNode(4, new com.company.leetcode.linkedList.ListNode(5)))));
        ListNode listNode3 = new com.company.leetcode.linkedList.ListNode(1,new com.company.leetcode.linkedList.ListNode(2, new com.company.leetcode.linkedList.ListNode(3, new com.company.leetcode.linkedList.ListNode(4, new com.company.leetcode.linkedList.ListNode(5, new ListNode(6))))));
        ListNode listNode;
        listNode = middleNode(listNode2);
        System.out.println("Example 1");
        while(listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println("");
        System.out.println("Example 2");
        listNode = middleNode(listNode3);
        while(listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;

        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode aHead = head;

        while(aHead != null && aHead.next !=null){
            aHead = aHead.next.next;
            head = head.next;
        }
        return head;
    }
}
