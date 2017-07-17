package leetcode;

public class MergeSort {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { 
	    	 val = x; 
	    }
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        
        
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }
        
        return dummy.next;
    }
//	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		ListNode totalList = null;
//		while(l1!=null||l2!=null){
//			if(l1.val>=l2.val){
//				totalList=addFuc(totalList,l2);
//				l2=deleteFuc(l2);
//			}else{
//				totalList=addFuc(totalList,l1);
//				l1=deleteFuc(l1);
//			}
//		}
//		return totalList;
//    }
//	public static ListNode deleteFuc(ListNode ln){
//		ListNode newlistnode = new ListNode(0);
//		newlistnode.val=ln.next.val;
//		newlistnode.next=ln.next.next;
//		return newlistnode;
//	}
//	public static ListNode addFuc(ListNode totalList,ListNode l){
//		if(totalList!=null){
//			totalList.next=l;
//		}else{
//			totalList=new ListNode(0);
//			totalList.val=l.val;
//		}
//		totalList=totalList.next;
//		return totalList;
//	}
	public static void main(String[] args) throws ClassNotFoundException {
		ListNode l1 = null;
		ListNode l2 =null;
		l1=new ListNode(1);
		l1.next=new ListNode(3);
		l1.next.next=new ListNode(4);
		l1.next.next.next=new ListNode(7);
		l2=new ListNode(2);
		l2.next=new ListNode(9);
		l2.next.next=new ListNode(10);
		l2.next.next.next=new ListNode(11); 
		
		mergeTwoLists(l1,l2);
	}
}
