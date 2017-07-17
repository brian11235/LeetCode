package leetcode.linkedList;

import leetcode.linkedList.DeleteLinkedList.ListNode;

public  class interSectionLinkedlisted {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	      val = x;
	      next = null;
	      }
	  }
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode newNode=null;
		Integer countNumber;
		if(headA ==null || headB == null){
			return null;
		}
		countNumber=getCompareNumber(headA,headB);
		//A大
		if(countNumber>0){
			while(countNumber!=0){
				headA=headA.next;
				countNumber--;
			}
		}else{
			while(countNumber!=0){
				headB=headB.next;
				countNumber++;
			}
		}
		//找出interSection
		while(headA!=null){
			if(headA.val==headB.val){
				if(newNode==null){
					newNode=headA;
				}
				headA=headA.next;
				headB=headB.next;
			}else{
				newNode=null;
				headA=headA.next;
				headB=headB.next;
			}
		}
		return newNode;
    }
	public static Integer getCompareNumber(ListNode headA, ListNode headB){
		Integer countA=0;
		Integer countB=0;
		while(headA!=null){
			headA=headA.next;
			countA=countA+1;
		}
		while(headB!=null){
			headB=headB.next;
			countB=countB+1;
		}
		return countA-countB;
		
	}
	public static void main(String[] args){
		ListNode l1 = null;
		ListNode l2 = null;
		l1=new ListNode(1);
		//l1.next=new ListNode(2);
		l1.next=new ListNode(8);
		l1.next.next=new ListNode(7);
		l1.next.next.next=new ListNode(1);
		l2=new ListNode(2);
		l2.next= new ListNode(4);
		l2.next.next=new ListNode(8);
		l2.next.next.next=new ListNode(7);
		l2.next.next.next.next=new ListNode(1);
//		l1=new ListNode(1);
//		l1.next=new ListNode(7);
//		l1.next.next=new ListNode(8);
//		l1.next.next.next=new ListNode(7);
//		l1.next.next.next.next=new ListNode(1);
//		l2=new ListNode(1);
//		l2.next=new ListNode(7);
//		l2.next.next=new ListNode(8);
//		l2.next.next.next=new ListNode(4);
//		l2.next.next.next.next=new ListNode(1);
		getIntersectionNode(l1,l2);
	}
}
