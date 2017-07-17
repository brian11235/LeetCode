package leetcode.linkedList;

import leetcode.linkedList.DeleteLinkedList.ListNode;

public class reverseLinkedList {
	public static class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
		 }
	public static ListNode reverseList(ListNode head) {
		ListNode buffetNode = null;
		ListNode finallyNode = null;
		if(head==null){
			return null;
		}
//		while(head != null){
//			buffetNode= new ListNode(head.val);
//			head=head.next;
//			if(finallyNode==null){
//				finallyNode=buffetNode;
//			}else{
//				buffetNode.next=finallyNode;
//				finallyNode=buffetNode;
//			}	
//		}	
		while(head != null){
			//buffetNode= new ListNode(head.val);
			//head=head.next;
			buffetNode=head;
			head=head.next;
			if(finallyNode==null){
				finallyNode=buffetNode;
				finallyNode.next=null;
			}else{
				buffetNode.next=finallyNode;
				finallyNode=buffetNode;
			}	
		}
		return finallyNode;
	}
	public static void main(String[] args){
		ListNode l1 = null;
		l1=new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(8);
		l1.next.next.next=new ListNode(7);
		l1.next.next.next.next=new ListNode(1);
		reverseList(l1);
	}
	
}
