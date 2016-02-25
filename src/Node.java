import java.util.HashMap;

public class Node {
	
	public int gValue;
    public int hValue;
    public int fValue;
    public boolean visited;//for search
    public HashMap<Integer,Node> neighbours;
    public HashMap<Integer,Node> adjacentNeighbours;
    public int element;
    public int tileNumber;
    public Node parent;
	Node() {
		this(0,0);// returns a pointer
	}

	public Node(int g, int h) {
		parent=null;
		neighbours=new HashMap<>();
		adjacentNeighbours=new HashMap<>();
		element = 0;
		gValue=0;
		hValue = h;
		fValue=g+h; // f(n)=g(n)+h(n)
		visited=false;
		
	}
	
	public int getElement(){
        return element;
	}
}
