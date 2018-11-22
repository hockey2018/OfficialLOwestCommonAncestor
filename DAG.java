package LCAOfficial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DAG {
	private int numberOfVertices;           
	private int numberOfEdges;             
	private ArrayList<Integer>[] adjacency;    
	private int[] inDegreeOfVertex;        
	private boolean mark[];		
	private boolean cycle;		
    private boolean stack[];		
    private int[] edgeToShortest;      
    private int[] distanceTo;      

    


	
	public DAG(int V)
	{
		if (V < 0) throw new IllegalArgumentException("Cant have a non negative number of vertices");
	    this.numberOfVertices = V;
	    this.numberOfEdges = 0;
	    inDegreeOfVertex = new int[V];
	    mark = new boolean[V];
	    stack = new boolean[V];
	    adjacency = (ArrayList<Integer>[]) new ArrayList[V];
	    for (int v = 0; v < V; v++) {
	        adjacency[v] = new ArrayList<Integer>();
	    }              
	}

	//Returns current vertex
	public int V() {
		return numberOfVertices;	
	}
	
	public int E() {
        return numberOfEdges;
    }

	
	
	//Adds a directed edge from v->w
	public void addEdge(int v, int w)
	{
	    if((validateVertex(v)>0)&&(validateVertex(w)>0))
	    {
	    	adjacency[v].add(w);
	    	inDegreeOfVertex[w]++;
	    	numberOfEdges++;
	    }
	    else{
	    	System.out.println("Vertices entered must be between 0 the total -1");
	    }
	    	
	}
	
	private int validateVertex(int v) {
        if (v < 0 || v >= numberOfVertices)
        	return -1;
        else
        	return 1;}

	
	
	public int indegree(int v) {
		//this will return the number of vertices
		if(validateVertex(v)<0){
			return -1;
		}
		else{
			return inDegreeOfVertex[v];
		}
	}
	
	
	public int outdegree(int v) {
		//this will return the number of edges
		
		if(validateVertex(v)<0){
			return -1;
		}
		else{
			return adjacency[v].size();
		}
    }
		
	
	
	public Iterable<Integer> adj(int v)
	//returns adjacent vertices
	{ 
		return adjacency[v]; 
		}
	
	public int findLCA(int v, int w){
		//say if it is not a directed acrylic graph
		findCycle(0);
		if(cycle){
			
			return -1;
		}
		
		DAG backwards = reverse();
		
		//find two points on the graph
		ArrayList<Integer> vPath = backwards.BFS(v);
		ArrayList<Integer> wPath = backwards.BFS(w);
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();
		boolean found = false;
		
		
		//return first node found
		for(int i = 0; i<vPath.size(); i++){
				for(int t = 0; t<wPath.size(); t++){		
					if(vPath.get(i)==wPath.get(t)){
						commonAncestors.add(vPath.get(i));	
						found = true;
					}
			}
		}

		if(found)
			return commonAncestors.get(0);
		else
			return -1;
	}
	
    public DAG reverse() {
    	//need to transverse graph backwards to get LCA 
        DAG reverse = new DAG(numberOfVertices); 
        for (int v = 0; v < numberOfVertices; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v); 
            }
        }
        return reverse;
    }
    
	public ArrayList<Integer> BFS(int s)
    {
       
        boolean visited[] = new boolean[numberOfVertices];
 
        LinkedList<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> order= new ArrayList<Integer>();
 
        visited[s]=true;
        queue.add(s);
        
 
        while (queue.size() != 0)
        {
           
            s = queue.poll();           
            order.add(s);
            
            Iterator<Integer> i = adjacency[s].listIterator();
            while (i.hasNext())
            {
            	//this will get all adjacent vertexes abd mark it if it has not been vistied
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        
        return order;
        
    }
	
	public boolean hasCycle() {

        return cycle;
    }
	
	 public void findCycle(int v) {

	        mark[v] = true;
	        stack[v] = true;

	        for (int w : adj(v)) {
	            if(!mark[w]) {
	                findCycle(w);
	            } else if (stack[w]) {
	                cycle = true;
	                return;
	            }
	        }

	        stack[v] = false;
	    }
	 
	 
}
