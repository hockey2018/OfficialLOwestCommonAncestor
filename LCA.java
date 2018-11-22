package LCAOfficial;

import org.w3c.dom.Node;

public class LCA <Key extends Comparable<Key>, Value>{
	Node root; 
	//this is the class for the lowest common ancestor 
	class Node {
		private Key key;           				
		private Value value;         				
		private Node left; 
		private Node right; 				
		private int Int1;  
		

		public Node(Key key, Value value, int Int1) {
			this.key = key;
			this.value = value;
			this.Int1 = Int1;
		}

	}
	private int sizeCheck() {
		return sizeCheck(); //root
		
	}
	public boolean checkEmpty() { 
		return sizeCheck() == 0; 
	}
	
	
		private int sizeCheck(Node x) {
			// returns the number of key valued pairs rooted at x in the BST
			if (x == null) return 0;

			else return x.Int1;
		}
		
		public boolean contains(Key key) {
			//search BST for a given tree, return true of found or else return false
			return getKey(key) != null;
		}
		
		public Value getKey(Key key) { 
			return getKey(root, key); 
		}
		private Value getKey(Node node, Key key) {
			if (node == null) return null;
			int cmp = key.compareTo(node.key);
			if      (cmp < 0) return getKey(node.left, key);
			else if (cmp > 0) return getKey(node.right, key);
			else return node.value;
			
		}

	
		public void putIntoBST(Key key, Value val) {
			//insert key value pair into BST, if it already exists update it 
			if (val == null) { 
				delete(key); return; 
				}
				root = put(root, key, val);
		}
		
		
	
	
		
		void delete(Key key) {
			// TODO Auto-generated method stub
			
		}
		private Node put(Node node, Key key, Value val) {
			if (node == null) return new Node(key, val, 1); //new bst
			int cmp = key.compareTo(node.key);
			if      (cmp < 0) node.left  = put(node.left,  key, val);
			else if (cmp > 0) node.right = put(node.right, key, val);
			else              node.value   = val; //updating value
			node.Int1 = 1 + sizeCheck(node.left) + sizeCheck(node.right); // value child1 + value child2 + 1
			return node;
		}
		
		//tree height- asymptopic worst case running time

		public int treeHeight() { 
			return treeheight(root); 
		}
	
		
		private int treeheight(Node x) {
			if (x == null) {
				return -1;
			}
			else {
				return 1 + Math.max(treeheight(x.left), treeheight(x.right));
			}
		}
		
		
		// return the median key or null if it is empty
		public Key medianKey() {
			if (checkEmpty()) return null; //returning null if the bst is empty

			else {
				int median=(((sizeCheck(root)+1)/2)-1);   //add 1 to size(root)	
				//need to change int to key?
				return intToKey(median);
			}
		}
		private Key intToKey(int median) {
			// TODO Auto-generated method stub
			return null;
		}

	
		private Node intToKey(Node node, int passedInt) {     
			int leftSize = (sizeCheck(node.left));  
			
			//to find the node with the right key passed into it, check whether it is in the left or right subtree
			if (leftSize > passedInt) {
				return intToKey(node.left,  passedInt); 
			}
			else if (leftSize < passedInt) {
				return intToKey(node.right, passedInt-leftSize-1); 
			}
			else {
				return node; 
			}
			}
			
			
			public String printOutKeys() {
				//this will print out a string with all the keys in order with parenthisis
				String res= "";
				if (isEmpty()){
					return res += "()";
				}
				else {
					return res = printOutKeys(root);
				}
			
			}
		private boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
		
		 private String printOutKeys(Node node) {
			 String res = "";
			 if (node == null) {
				 return res += "()";
			 }
			 
			 else {
				return res += ("(" + printOutKeys(node.left) + node.key.toString() + printOutKeys(node.right) + ")");
			 }
			 
		 }
		 
		 public String printKeys() {
			 //print each node in the tree
				if(checkEmpty()) return "-null\n";
			     return prettyPrint(root,"");
			}
		 private String prettyPrint(Node node, String prefix) {
				if (node == null) {
					return (prefix + "-null\n");
				}
				else {
					
					return (prefix+"-"+node.key.toString()+"\n" +prettyPrint(node.left,(prefix+" |"))+ prettyPrint(node.right,(prefix+"  ")));
		    	}
				
			}
		 
		 public void delete1(Key key) {
			 //should delete the key
		 
				root = delete1(root, key);	
			}
			
			private Node delete1 (Node node, Key key) {
				if (node == null) { 
					return null;
				}
				 int compare = key.compareTo(node.key);
			        
			        if   (compare > 0) {
			        	node.right = delete1(node.right, key);
			        	node.left  = delete1(node.left,  key);
			        }
			        else if (compare < 0) {
			        	node.left  = delete1(node.left,  key);
			        }
			        else {
			        	if (node.right == null) {
			        		return node.left;
			        	}
			            if (node.left  == null) {
			            	return node.right;
			            }
			            Node temp = node;
			            node = maxDelete(temp.left);                              
			            node.left = maxDelete(temp.left);                 
			            node.right = temp.right; 
			        }
			        
			        node.Int1 = sizeCheck(node.left) + sizeCheck(node.right) + 1;
			        return node;
					
				}
				
			private Node maxDelete(Node node) 
		    {
		        if (node.right == null) return node.left;
		        node.right = maxDelete(node.right);
		        node.Int1 = sizeCheck(node.left) + sizeCheck(node.right) + 1;                                 
		        return node;
		    }
			
			public Node maxDelete1(Node node)
			   {
			     if(node.right!=null) {
			       return maxDelete(node.right);
			     }
			     return node;
			   }
			
			class DAG {
				//this will be used for DAG  test and class
				private Node root;
				public DAG(Node root) {
					this.root = root;
				}
			}
			
			public Key LCA1 (Node node, Key key1, Key key2){
		 		if (node == null)
		             return null;
		 		if (node.key == key1) {
		 			return node.key;
		 		}
		 		if (node.key == key2) {
		 			return node.key;
		 		}
		 		int cmp1 = node.key.compareTo(key1);
		 		int cmp2 = node.key.compareTo(key2);
		 		
		         if (cmp1 >= 0 && cmp2 >= 0)
		             return LCA1(node.left, key1, key2);
		   
		         if (cmp1 <= 0 && cmp2 <= 0)
		             return LCA1(node.right, key1, key2);
		   
		         return node.key;
		 	}
			public void put(int i, int j) {
				// TODO Auto-generated method stub
				
			}
				
			}


