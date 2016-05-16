package addTwoNum;

public class AddTwoNum {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static void main(String[] arg){
		String input = "(2 -> 4 -> 3) + (5 -> 6 -> 4)";
		ListNode first = new ListNode(0);
		ListNode second = new ListNode(7);
		second.add(3);
		first.printList(first);
		second.printList(second);
		ListNode newlist = addTwoNum(first,second);
		newlist.printList(newlist);
		
	}
	
	public static ListNode addTwoNum(ListNode l1,ListNode l2){
		ListNode newlist = new ListNode(0);
		ListNode temp = newlist;
		int upNum = 0;
		do {
			if(l1==null){
				temp.val = (0+l2.val+upNum)%10;
				upNum = (0+l2.val+upNum)/10;
				l2 = l2.next;
				if(l2!=null){
					temp.next = new ListNode(0);
					temp = temp.next;
				}
			} else if(l2==null){
				temp.val = (l1.val+0+upNum)%10;
				upNum = (l1.val+0+upNum)/10;
				l1 = l1.next;
				if(l1!=null){
					temp.next = new ListNode(0);
					temp = temp.next;
				}
			} else {
				temp.val = (l1.val+l2.val+upNum)%10;
				upNum = (l1.val+l2.val+upNum)/10;
				l1 = l1.next;
				l2 = l2.next;
				if(l1!=null||l2!=null){
					temp.next = new ListNode(0);
					temp = temp.next;
				}
			}
		}while(l1!=null||l2!=null);
		if(upNum!=0){
			temp.next = new ListNode(upNum);
		}
		return newlist;
	}
}
