package com.company.leetcode.linkedList;

/*
141. Linked List Cycle

Given head, the head of a linkedList, determine if the linkedList has a cycle in it.

There is a cycle in a linkedList if there is some node is the list that can be reached again by
continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
input: head = [3,2,0,-4] pos=1
output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

 */

import java.util.List;

public class LinkedListCycle {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(-4);
        ListNode node2 = new ListNode(0, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(3, node3);
        node1.next = node3;
        int i = 0;
        System.out.println("Example 1");
        while (i < 10) {
            System.out.print(node4.val + " ");
            node4 = node4.next;
            i++;
        }
        System.out.println(hasCycle(node4));
    }
    static boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
