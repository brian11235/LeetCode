package leetcode.linkedList;

import leetcode.MergeSort.ListNode;

public class DeleteLinkedList {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
public static ListNode removeElements(ListNode head, int val) {
		ListNode newList=new ListNode(0);
		ListNode li=newList;
		li.next=head;
		if(head==null){
			return null;
		}
		while(head!=null){
			if(head.val==val){
				li.next=li.next.next;
				head=head.next;
			}else{
				head=head.next;
				li=li.next;
			}
		}
		return newList.next;
//	ListNode dummy = new ListNode(0);
//    dummy.next = head;
//    head = dummy;
//    
//    while (head.next != null) {
//        if (head.next.val == val) {
//            head.next = head.next.next;
//        } else {
//            head = head.next;
//        }
//    } 
//    return dummy.next;
	
    }
	public static void main(String[] args){
		ListNode l1 = null;
		l1=new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(8);
		l1.next.next.next=new ListNode(7);
		l1.next.next.next.next=new ListNode(1);
		removeElements(l1,1);
	}
	
}
