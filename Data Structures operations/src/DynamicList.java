/* Author: Lehandra Middleton
 * Assignment #4
 * Date: 2.14.2016
 * Course: COP 3530 Data Structures & Algorithms
 * UIN:	6347
 */
public class DynamicList {

	private DynamicNode list; 

	
	public DynamicList() {
		list = null;
	}

	
	public boolean isEmpty() {
		return list == null;
	}

	
	public void insertFirst(Object x) {
		DynamicNode q = new DynamicNode(x, null);
		if (!isEmpty())
			q.setNext(list); 
		list = q; 
	}

	public void insertAfter(DynamicNode p, Object x) {
		if (p == null) {
			System.out.println("void insertion");
			System.exit(1);
		}
		DynamicNode q = new DynamicNode(x, p.getNext()); 
		p.setNext(q); 
	}

	
	public Object deleteFirst() {
		if (isEmpty()) {
			System.out.println("void deletetion");
			System.exit(1);
		}
		Object temp = list.getInfo(); 
		if (list.getNext() == null) 
			list = null;
		else
			list = list.getNext(); 
		return temp; 
	}

	
	public Object deleteAfter(DynamicNode p) {
		if (p == null || p.getNext() == null) { 
			System.out.println("void deletion");
			System.exit(1);
		}
		DynamicNode q = p.getNext(); 
		Object temp = q.getInfo(); 
		p.setNext(q.getNext()); 
		return temp;
	} 

	
	public void place(Sortable x) {
		DynamicNode p, q = null;
		for (p = list; p != null && x.compareTo(p.getInfo()) > 0; p = p.getNext())
			q = p;
		if (q == null)
			insertFirst(x);
		else
			insertAfter(q, x);
	}

	
	public void insertLast(Object x) {
		DynamicNode p = new DynamicNode(x, null);
		DynamicNode q = null;

		if (isEmpty())
			list = p;
		else {
			for (q = list; q.getNext() != null; q = q.getNext());
				q.setNext(p);
				}
	}
	
	
	public DynamicNode search(Object x) {
		DynamicNode p;
		for (p = list; p != null; p = p.getNext()) 
			if (p.getInfo().equals(x)) 
				return p;

		return null; 
	} // end search

	
	public void removeX(Object x) {
		DynamicNode p = list, q = null;
		while (p != null) {
			if (p.getInfo().equals(x)) {
				p = p.getNext();
				if (q == null)
					deleteFirst(); 
				else
					deleteAfter(q);
			} else {
				// advance to the next node in the list
				q = p;
				p = p.getNext();
			}
		} // end while
	}// end removex

	public void reverseIteratively(){
		DynamicNode tempList = list;
		DynamicNode oldList = null;
		list = null;
		for (oldList = tempList; oldList!= null; oldList = oldList.getNext()) {
			 insertFirst(oldList.getInfo());
		}
	}

	public void print() {
		DynamicNode current = null;
		for (current = list; current!= null; current = current.getNext()) {
				System.out.print(current.getInfo());
		}
		System.out.println();
	}
	
	public void Concat(DynamicList list2) {
		DynamicNode p = null;
		for(p = list2.list; p != null; p = p.getNext()){
			insertLast(p.getInfo());
		}
	}

	public char[] SumList() {
		int c = 0;
		String k;
		char [] sum = new char [2];
		DynamicNode current = list;
		while(list.getNext()!= null){
			c += Integer.parseInt((String.valueOf(current.getInfo()))); 
			current = current.getNext();
			if(current == null){
				break;
		  	}
		}
		k = String.valueOf(c);
		for(int i = 0; i < 2; i ++){
			sum[i]= k.charAt(i);
		}
		return sum;
	}
	
	public void union(DynamicList x){
		DynamicNode p = null;
		DynamicNode q = list;
		IntData n = new IntData(Integer.parseInt(String.valueOf(q.getInfo())));
		/*
		 * p is the second list. q = list and n  = list.getInfo()
		 * if n and p are the same, q becomes q.getNext() and 
		 * n = a the new q.
		 */
		for(p = x.list; p!= null; p = p.getNext()){
			if(n.equals(p.getInfo())){
				q = q.getNext();
				n = new IntData(Integer.parseInt(String.valueOf(q.getInfo())));
			}else{
				/*
				 * check to see if the current node in list1 is greater
				 * then the node in list2
				 */
				if((n.compareTo(p.getInfo()) < 0) && q.getNext()!= null){
					 q = q.getNext();
				}
				else{
					insertLast(p.getInfo());
				}
			}
		}
	}
	
	public void intersection(DynamicList x){
		DynamicNode tempList = list;
		DynamicNode temp = null; 
		DynamicNode p = x.list;
		IntData n = new IntData(Integer.parseInt(String.valueOf(p.getInfo())));
		list = null;
		/*
		 * Since list is now Union, list2 is compare to list except 
		 * for the number 9
		 */
		for(temp = tempList; temp != null; temp=temp.getNext()){
			IntData s = new IntData(Integer.parseInt(String.valueOf(temp.getInfo())));
			if((n.equals(temp.getInfo()))&&(s.getData()!= 9)){
				insertLast(p.getInfo());
				p = p.getNext();
				n = new IntData(Integer.parseInt(String.valueOf(p.getInfo())));
			}
		}
	}
	
	public void deleteEverySecond(){
		DynamicNode tempList = list;
		DynamicNode temp = null;
		list = null;
		IntData n;
		/*
		 * Takes the info for each node, parses it in and then find if the
		 * remainder is equals 0
		 */
		for(temp = tempList; temp != null; temp = temp.getNext()){
			n = new IntData(Integer.parseInt(String.valueOf(temp.getInfo())));
			if(n.getData()%2 == 1){
				insertLast(temp.getInfo());
			} 
		}
	}
	
} // end dynamic list
