/* Author: Lehandra Middleton
 * Assignment #4
 * Date: 2.14.2016
 * Course: COP 3530 Data Structures & Algorithms
 * UIN:	6347
 */
public class DynamicDriver {

	public static void main(String args[]) {

		DynamicList list, list2, list3; 

		list = new DynamicList();
		list2 = new DynamicList();
		list3 = new DynamicList();
		
		list.insertLast(new IntData(5));
		list.insertLast(new IntData(6));
		list.insertLast(new IntData(7));
		list.insertLast(new IntData(8));
		list.print();
		
		list2.insertLast(new IntData(5));
		list2.insertLast(new IntData(6));
		list2.insertLast(new IntData(8));
		list2.insertLast(new IntData(9));
		list2.print();
		

		for(int i = 1 ; i < 9; i ++ ){
			list3.insertLast(i);
		}
		
		list.union(list2);
		System.out.println("Union:");
		list.print();
		System.out.println("Intersection:");
		list.intersection(list2);
		list.print();
		System.out.println("Bonus:");
		list3.print();
		list3.deleteEverySecond();
		list3.print();
	}
}
