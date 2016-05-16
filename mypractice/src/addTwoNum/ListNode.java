package addTwoNum;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	public ListNode add(int x){
		ListNode temp = this;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = new ListNode(x);
		return this;
	}
	
	public void printList(ListNode list){
		do {
			if(list.next ==null){
				System.out.print(list.val);
			} else {
				System.out.print(list.val+" -> ");
			}
			
			list = list.next;
		}while(list!=null);
		System.out.println();
	}
}