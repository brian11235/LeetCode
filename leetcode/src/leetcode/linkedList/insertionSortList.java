package leetcode.linkedList;

import leetcode.linkedList.LinkedListCycle.ListNode;

public class insertionSortList {
	public static class ListNode {
		   int val;
		   ListNode next;
		   ListNode(int x) { val = x; }
		  }
	 public static ListNode insertionSortList(ListNode head) {
//		 ListNode newList = null;
//		 ListNode finallyList;
////		 ListNode pointer=head;
////		 ListNode pointerNext=head.next;
//		 ListNode inOrderList = null;
//		 ListNode singleNode=null;
//		 if(head==null){
//			 return null;
//		 }
////		 while(pointerNext!=null){
////			 if(pointer.val>pointerNext.val){
////				 
////			 }
////	 	}
//		 while(head!=null){	 
//			 if(newList==null){
//				 newList=new ListNode(head.val);
//				 head=head.next;
//			 }else{
//				finallyList=newList;
//				newList=new ListNode(head.val);
//				newList.next=finallyList;
//				//前>後才需排序
//				while(newList!=null){
//					if(null!=newList.next&&newList.next.val<newList.val){
//						if(inOrderList==null){
//							inOrderList=new ListNode(newList.next.val);
//							newList.next=newList.next.next;
//							inOrderList.next=newList;
//							finallyList=newList;
//						}else{
//							singleNode=new ListNode(finallyList.next.val);
//							finallyList.next=finallyList.next.next;
//							singleNode.next=finallyList;
//							newList=singleNode;
//						}
//					}else{
//						break;
//					}
//				}
////				if(completeList!=null){
////					newList=completeList;
////					completeList=null;
////				}
//				head=head.next;
//			 }
//		 }
		 ListNode dummy = new ListNode(0);
	        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
	        // 所以这里不需要dummy.next = head;

	        while (head != null) {
	            ListNode node = dummy;
	            while (node.next != null && node.next.val < head.val) {
	                node = node.next;
	            }
	            ListNode temp = head.next;
	            head.next = node.next;
	            node.next = head;
	            head = temp;
	        }

	        return dummy.next;
		//return head;
	        
	    }
	 public static void main(String[] args){
			ListNode l1 = null;
			l1=new ListNode(3);
			l1.next=new ListNode(2);
			l1.next.next=new ListNode(1);
			l1.next.next.next=new ListNode(5);
			insertionSortList(l1);
		}
}
