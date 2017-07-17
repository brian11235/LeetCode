package leetcode.linkedList;

import leetcode.linkedList.reverseLinkedList.ListNode;

public class LinkedListCycle {
			public static class ListNode {
			     int val;
			     ListNode next;
			     ListNode(int x) { val = x; }
			 }
			public static ListNode reverseList(ListNode head) {
					ListNode fast = head;
			        ListNode slow = head;
			 
			        while(fast != null && fast.next != null){
			            slow = slow.next;
			            fast = fast.next.next;
			 
			            if(slow == fast)
			                return slow;
			        }
			 
			        return null;
		}
			public static void main(String[] args){
				ListNode l1 = null;
				l1=new ListNode(3);
				l1.next=new ListNode(2);
				l1.next.next=new ListNode(0);
				l1.next.next.next=new ListNode(-4);
				reverseList(l1);
			}
}
