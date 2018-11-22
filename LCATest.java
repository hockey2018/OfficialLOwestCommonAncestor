package LCAOfficial;

import static org.junit.Assert.*;

import org.junit.Test;

import OfficialLowestCommonAncestor.LCA;
public class LCATest {

public void testLCA() {
		
		LCA<Integer, Integer> bst = new LCA<Integer, Integer>();
		
		assertSame("Testing LCA for null root", null, bst.LCA1(bst.root, 1, 2));
		
		bst.put(7, 7);   
		bst.put(8, 8);  // test change sb 
		bst.put(3, 3);   
		bst.put(1, 1);   //jjjjjj testststshh
		bst.put(2, 2);   //kkk
		bst.put(6, 6);   
		bst.put(4, 4);   
		bst.put(5, 5);   
		
		assertSame("Testing LCA left side", 3, bst.LCA1(bst.root, 2,6));
		assertSame("Testing LCA right side", 7, bst.LCA1(bst.root, 8,3));
		assertSame("Testing LCA where LCA is one of the nodes", 7, bst.LCA1(bst.root, 7,8));
	}

private void assertSame(String string, Object object, Integer lowestCommonAncestor) {
	// TODO Auto-generated method stub
	@Test
	public void prettyPrint() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();
		assertEquals("Checking pretty printing of empty tree",
				"-null\n", LCA.prettyPrint());

		
		LCA.put(7, 7);      //building
		LCA.put(8, 8);      //testing to send to git  test to send to hh22fjjjjjjjj
		LCA.put(3, 3);    
		LCA.put(1, 1);      
		LCA.put(2, 2);      
		LCA.put(6, 6);       
		LCA.put(4, 4);      
		LCA.put(5, 5);       
		

		String result = 
				"-7\n" +
						" |-3\n" + 
						" | |-1\n" +
						" | | |-null\n" + 
						" | |  -2\n" +
						" | |   |-null\n" +
						" | |    -null\n" +
						" |  -6\n" +
						" |   |-4\n" +
						" |   | |-null\n" +
						" |   |  -5\n" +
						" |   |   |-null\n" +
						" |   |    -null\n" +
						" |    -null\n" +
						"  -8\n" +
						"   |-null\n" +
						"    -null\n";
		assertEquals("Checking pretty printing of non-empty tree", result, LCA.prettyPrint());


	}
	@Test
	public void testDelete() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();
		LCA.delete(1);
		assertEquals("Deleting from empty tree", "()", LCA.printKeys());

		LCA.put(7, 7);   
		LCA.put(8, 8);   
		LCA.put(3, 3);   
		LCA.put(1, 1);  
		LCA.put(2, 2); 
		LCA.put(6, 6); 
		LCA.put(4, 4);   
		LCA.put(5, 5);   
		

		assertEquals("Checking order of constructed tree",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", LCA.printKeys());

		LCA.delete(9);
		assertEquals("Deleting non-existent key",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", LCA.printKeys());

		LCA.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", LCA.printKeys());

		LCA.delete(6);
		assertEquals("Deleting node with single child",
				"(((()1(()2()))3(()4(()5())))7())", LCA.printKeys());

		LCA.delete(3);
		assertEquals("Deleting node with two children",
				"(((()1())2(()4(()5())))7())", LCA.printKeys());
	}
	@Test
	public void testDelete() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();
		LCA.delete(1);
		assertEquals("Deleting from empty tree", "()", LCA.printKeys());

		LCA.put(7, 7);   
		LCA.put(8, 8);   
		LCA.put(3, 3);  
		LCA.put(1, 1); 
		LCA.put(2, 2);  
		LCA.put(6, 6);  
		LCA.put(4, 4);  
		LCA.put(5, 5); 
		

		assertEquals("Checking order of constructed tree",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", LCA.printKeys());

		LCA.delete(9);
		assertEquals("Deleting non-existent key",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", LCA.printKeys());

		LCA.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", LCA.printKeys());

		LCA.delete(6);
		assertEquals("Deleting node with single child",
				"(((()1(()2()))3(()4(()5())))7())", LCA.printKeys());

		LCA.delete(3);
		assertEquals("Deleting node with two children",
				"(((()1())2(()4(()5())))7())", LCA.printKeys());
	}
	@Test
	public void testPut() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();
		LCA.put(1, null);
		LCA.put(10, 1);
		LCA.put(15,2);
		LCA.put(15, 15);	 

		assertEquals("Putting nodes", "(()10(()15()))", LCA.printKeys());
	}
	@Test
	public void testGet() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();
		assertEquals("Testing empty", false, LCA.contains(5));
		LCA.put(1, null);
		LCA.put(10, 1);
		LCA.put(5, 9);
		LCA.put(15,2);
		LCA.put(9, 15);	 

		assertEquals("Testing left", "9", LCA.get(5).toString());
		assertEquals("Testing right then right", "2", LCA.get(15).toString());
		assertEquals("Testing right then left", "15", LCA.get(9).toString());
		assertEquals("Testing root", "1", LCA.get(10).toString());
	}
	@Test
	public void testHeight() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();

		assertEquals("Testing height", -1, LCA.treeHeight());

		LCA.put(7, 7);  

		assertEquals("Testing height", 0, LCA.treeHeight());

		LCA.put(8, 8);   
		LCA.put(3, 3);  

		assertEquals("Testing height", 1, LCA.treeHeight());

		LCA.put(1, 1);      
		LCA.put(2, 2);   

		assertEquals("Testing height", 3, LCA.treeHeight());

		LCA.put(6, 6);   
		LCA.put(4, 4);   
		LCA.put(5, 5);

		assertEquals("Testing height", 4, LCA.treeHeight());

	}
	@Test
	public void testMedian() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();
		assertEquals("Testing median", null, LCA.median());
		LCA.put(7, 7); 
		assertEquals("Testing median", "7", LCA.median().toString());
		LCA.put(8, 8);   
		LCA.put(3, 3);  
		assertEquals("Testing median", "7", LCA.median().toString());
		LCA.put(1, 1);      
		LCA.put(2, 2); 
		assertEquals("Testing median", "3", LCA.median().toString());
		LCA.put(6, 6);   
		LCA.put(4, 4);   
		LCA.put(5, 5);
		assertEquals("Testing median", "4", LCA.median().toString());
	}
	@Test
	public void testContains() {
		LCA<Integer, Integer> LCA = new LCA<Integer, Integer>();
		assertEquals("Testing contains", false, LCA.contains(1));
		LCA.put(7, 7); 
		assertEquals("Testing contains", true, LCA.contains(7));
	}
	}

private void assertEquals(String string, String string2, String printKeys) {
	// TODO Auto-generated method stub
	
}
}

