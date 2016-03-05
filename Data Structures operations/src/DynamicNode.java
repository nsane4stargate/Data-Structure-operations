/* Author: Lehandra Middleton
 * Assignment #4
 * Date: 2.14.2016
 * Course: COP 3530 Data Structures & Algorithms
 * UIN:	6347
 */
public class DynamicNode {
	Object info;
	DynamicNode next;
	/* getInfo(), setInfo(), setNext(), getNext() */

	// constructor
		public DynamicNode() {
			
		}
	
	// constructor
	public DynamicNode(Object x, DynamicNode n) {
		info = x;
		next = n;
			}

	// get data in a node
	public Object getInfo() {
		return info;
	}

	// get reference in a node
	public DynamicNode getNext() {
		return next;
	}

	// set value of the object
	public void setInfo(Object x) {
		info = x;

	}

	// set reference to a node
	public void setNext(DynamicNode n) {

		next = n;
	}
	
}// end dynamic node class
