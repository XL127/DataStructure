
public class BinarySearchTree <AnyType extends Comparable <? super AnyType>>{
	private BinaryNode<AnyType> root;
		
	//public functions
	public BinarySearchTree(){
		root = null;
	}
	
	public void insert(AnyType element){
		root = insert(element, root);
	}
	
	public void delete(AnyType element){
		root = delete(element, root);
	}
	
	public AnyType findMax(){
		return findMax(root);
	}
	
	public AnyType findMin(){
		return findMin(root);
	}
	
	public boolean contains(AnyType element){
		return contains(element, root);
	}
	
	public boolean isEmpty(){
		if(root == null)
			return true;
		else 
			return false;
	}
	
	public void makeEmpety(){
		root = null;
	}
	
	public void PreOrder(){
		preOrder(root);
	}
	
	private BinaryNode<AnyType> preOrder(BinaryNode<AnyType> node){
		System.out.print(node.value);
		if(node.left != null){
			return preOrder(node.left);
		}
		else if (node.right != null){
			return preOrder(node.right);
		}
		else {
			return node;
		}
	}
	
	//private functions 
	private BinaryNode<AnyType> insert(AnyType element, BinaryNode<AnyType> node){
		if(node == null){
			BinaryNode<AnyType> newNode = new BinaryNode(element);
			//node = new BinaryNode(element);
			return newNode;
		}
		
		int compareResult = element.compareTo(node.value);
		
		if(compareResult < 0){
			node.left = insert(element, node.left);
		}
		else if(compareResult > 0){
			node.right =  insert(element, node.right);
		}
		else {
			node.left = insert(element, node.left);
		}
		return node;	
	}
	
	private AnyType findMax(BinaryNode<AnyType> node){
		AnyType max;
		if(node.right == null){
			return node.value;
		}
		else {
			max = findMax(node.right);
		}
		return max;
	}
	
	private AnyType findMin(BinaryNode<AnyType> node){
		AnyType min;
		if(node.left == null){
			return node.value;
		}
		else {
			min = findMin(node.left);
		}
		return min;
	}
	
	private boolean contains(AnyType target, BinaryNode<AnyType> node){
		boolean result = false;
		
		if(node.value == target){
			return true;
		}
				
		int compareResult = target.compareTo(node.value);
		
		if(compareResult < 0 && node.left !=  null) {
			result = contains(target, node.left);
		}
		else if(compareResult > 0 && node.right != null){
			result = contains(target, node.right);
		}
		else {
			result = false;
		}
	    return result;
	}
	
	private BinaryNode<AnyType> delete(AnyType target, BinaryNode<AnyType> node){
		if (node.value == target){
			if(node.right == null){
				return node.left;
			}
			else if(node.left == null){
				return node.right;
			}
			else if(node.left == null && node.right ==null){
				return null;
			}
			else {
				AnyType min = findMax(node.left);
				node.value = min;
				delete(min, node.left);
			}
		}
		else {
			int compareResult =  target.compareTo(node.value);
			if(compareResult < 0)
				node.left = delete(target, node.left);
			else if(compareResult > 0)
				node.right = delete(target, node.right);
		}
		return node;
	} 
	
	public static void main(String [] args) {
		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();
	/*	myTree.insert(1);
		myTree.insert(-9);
		myTree.insert(0);
		myTree.insert(8);
		myTree.insert(7);
		myTree.insert(4);
		myTree.delete(1);*/
		
		myTree.insert(1);
		myTree.insert(2);
		myTree.insert(5);
		myTree.insert(8);
		myTree.insert(6);
		myTree.delete(1);
		//int i = myTree.findMax();
		//sboolean contains = myTree.contains(1);
		//System.out.println(i);
		//System.out.println(contains);
		myTree.PreOrder();
	}
}
