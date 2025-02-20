package com.company.leetcode.linkedList;

/*
206 - Reverse LinkedList
Given the head of a singly linked list, reverse the list, and return the reversed list.


 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


public class RevertLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode newList = null;
        ListNode nextNode;
        while(head != null){
            nextNode = head.next;
            head.next = newList;
            newList = head;
            head = nextNode;
        }
        return newList;
    }

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode;
        listNode = reverseList(listNode2);
        while(listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}