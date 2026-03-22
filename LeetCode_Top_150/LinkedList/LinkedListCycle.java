package LeetCode_Top_150.LinkedList;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 
*/


//* Definition for singly-linked list.


public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle l = new LinkedListCycle();
        System.out.println(l.hasCycle(l.arrayListNode(new int[] { 1, 2, 3, 4, 5, 6 })));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (slowPtr.next != null && fastPtr.next.next != null) {
           
            System.out.print(" SLOW VAL " + slowPtr.val);
            System.out.print(", Fast VAL " + fastPtr.val + "\n");

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
             if (slowPtr == fastPtr) {
                //return false;
            }
        }

        return true;
    }

    public ListNode arrayListNode(int[] arr) {
        ListNode l = new ListNode(arr[0]);
        ListNode head = l;
        for (int i = 1; i < arr.length; i++) {
            l.next = new ListNode(arr[i]);
            l = l.next;
        }

        return head;

    }
}
