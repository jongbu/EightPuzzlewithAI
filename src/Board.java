import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Board{
	private int hValue;
	private int gValue;
	private int fValue;
	private int emptyNodeIndex;
	private int[] goal={1, 2, 3, 8, 0, 4, 7, 6, 5};
	private boolean found;
	private Board parent;
	
	Node[] n;
	//public HashMap<Integer,Node> nb;
	
	
	public Board(Node[] tiles){
		n=new Node[9];
		parent=null;
		found=false;
		
		for(int i=0;i<9;i++){
			n[i]=new Node();
			n[i]=tiles[i];//initializing the elements in the board
			
		}
		setTileNumber();
		//setNeighbours();
		//setAdjacentNeighbours();
		//calcManhattanHeuristic();
		//hValue=calcTilesOutofPlace();
		//hValue=calcManhattanHeuristic();
		hValue=calcTilesOutofPlace();
		gValue=0;
		fValue=gValue+hValue;
		//starting node
		//openList.add(n[7]);
		//AStarSearchwithTilesOutofPlace(totalHValue);
	}
	
	//sets the tile numbers for nodes to check if the element reached its goal
	public void setTileNumber(){
		n[0].tileNumber=1;
		n[1].tileNumber=2;
		n[2].tileNumber=3;
		n[3].tileNumber=8;
		n[4].tileNumber=0;
		n[5].tileNumber=4;
		n[6].tileNumber=7;
		n[7].tileNumber=6;
		n[8].tileNumber=5;
	}
	
	//prints out the PuzzleBoard
	public void printBoard(){
		int counter=0;
		System.out.println("Tiles Out of Place : "+hValue);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(n[counter++].getElement()+"  ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	public void printOutofPlaces(){
		int counter=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(n[counter++].hValue+"  ");
			}
			System.out.println();
		}
	}
	
	public void setAdjacentNeighbours(){
		//bruteforcing to set the neighbours
		n[0].adjacentNeighbours.put(2, n[1]);
		n[0].adjacentNeighbours.put(8, n[3]);
		
		n[1].adjacentNeighbours.put(1, n[0]);
		n[1].adjacentNeighbours.put(3, n[2]);
		n[1].adjacentNeighbours.put(0, n[4]);
		
		n[2].adjacentNeighbours.put(2, n[1]);
		n[2].adjacentNeighbours.put(4, n[5]);
		
		n[3].adjacentNeighbours.put(1, n[0]);
		n[3].adjacentNeighbours.put(0, n[4]);
		n[3].adjacentNeighbours.put(7, n[6]);
		
		n[4].adjacentNeighbours.put(2, n[1]);
		n[4].adjacentNeighbours.put(8, n[3]);
		n[4].adjacentNeighbours.put(6, n[7]);
		n[4].adjacentNeighbours.put(4, n[5]);
		
		n[5].adjacentNeighbours.put(3, n[2]);
		n[5].adjacentNeighbours.put(0, n[4]);
		n[5].adjacentNeighbours.put(5, n[8]);
		
		n[6].adjacentNeighbours.put(8, n[3]);
		n[6].adjacentNeighbours.put(6, n[7]);
		
		n[7].adjacentNeighbours.put(0, n[4]);
		n[7].adjacentNeighbours.put(7, n[6]);
		n[7].adjacentNeighbours.put(5, n[8]);
		
		n[8].adjacentNeighbours.put(4, n[5]);
		n[8].adjacentNeighbours.put(6, n[7]);
	}
	
	public ArrayList<Board> generateNeighbors() {
		ArrayList<Board> neighbors=new ArrayList<>();
		//get blank space
		int blankIndex=getEmptyNode();
		
		//slide down
		if(blankIndex!=0 && blankIndex!=1 && blankIndex!=2){
			slideAndStore(blankIndex-3, blankIndex, neighbors);
		}
		//slide up
		if(blankIndex!=6 && blankIndex!=7 && blankIndex!=8){
			slideAndStore(blankIndex+3, blankIndex, neighbors);
		}
		//slide left
		if(blankIndex!=2 && blankIndex!=5 && blankIndex!=8){
			slideAndStore(blankIndex+1, blankIndex, neighbors);
		}
		
		//slide right
		if(blankIndex!=0 && blankIndex!=3 && blankIndex!=6){
			slideAndStore(blankIndex-1, blankIndex, neighbors);
		}
	
		return neighbors;
		
		
	}
	private void slideAndStore(int i, int j, ArrayList<Board> neighbors) {
		Node[] newBoard=copyBoard(n);
		Node temp=newBoard[i];
		newBoard[i]=n[j];
		newBoard[j]=temp;
		neighbors.add(new Board(newBoard));
	}
	
	private Node[] copyBoard(Node[] nodeArray2) {
		Node []newB=new Node[9];
		for(int i=0; i<9; i++){
			newB[i]=nodeArray2[i];
		}
		return newB;
	}
	private int getEmptyNode() {
		for(int i=0; i<9; i++){
			if(n[i].element==0){
				return i;
			}
		}
		return 0;
	}

	public void setNeighbours(){
		//bruteforcing to set the neighbours
		n[0].neighbours.put(0, n[1]);
		n[0].neighbours.put(1, n[3]);
		n[0].neighbours.put(2, n[4]);
		
		n[1].neighbours.put(0, n[0]);
		n[1].neighbours.put(1, n[2]);
		n[1].neighbours.put(2, n[3]);
		n[1].neighbours.put(3, n[4]);
		n[1].neighbours.put(4, n[5]);
		
		n[2].neighbours.put(0, n[1]);
		n[2].neighbours.put(1, n[4]);
		n[2].neighbours.put(2, n[5]);
		
		n[3].neighbours.put(0, n[0]);
		n[3].neighbours.put(1, n[1]);
		n[3].neighbours.put(2, n[4]);
		n[3].neighbours.put(3, n[6]);
		n[3].neighbours.put(4, n[7]);
		
		n[4].neighbours.put(0, n[0]);
		n[4].neighbours.put(1, n[1]);
		n[4].neighbours.put(2, n[2]);
		n[4].neighbours.put(3, n[3]);
		n[4].neighbours.put(4, n[5]);
		n[4].neighbours.put(5, n[6]);
		n[4].neighbours.put(6, n[7]);
		n[4].neighbours.put(7, n[8]);
		
		n[5].neighbours.put(0, n[2]);
		n[5].neighbours.put(1, n[1]);
		n[5].neighbours.put(2, n[4]);
		n[5].neighbours.put(3, n[7]);
		n[5].neighbours.put(4, n[8]);
		
		n[6].neighbours.put(0, n[3]);
		n[6].neighbours.put(1, n[4]);
		n[6].neighbours.put(2, n[7]);
		
		n[7].neighbours.put(0, n[3]);
		n[7].neighbours.put(1, n[4]);
		n[7].neighbours.put(2, n[5]);
		n[7].neighbours.put(3, n[6]);
		n[7].neighbours.put(4, n[8]);
		
		n[8].neighbours.put(0, n[4]);
		n[8].neighbours.put(1, n[5]);
		n[8].neighbours.put(2, n[7]);
	}
	
	//calculates the h(n) which is the numer of tiles out of place for each nodes and sets it in the node
	public int calcManhattanHeuristic(){
		int total=0;
		for(int i=0;i<9;i++){
			if(n[i].element!=0){
				if(n[i].tileNumber!=n[i].element){
				n[i].hValue=recSearch(n[i].adjacentNeighbours,n[i].element,1);
				found=false;
				total+=n[i].hValue;
				//initialzing the bool value again for another iteration
				for(int x=0;x<9;x++){
					n[x].visited=false;
				}
			}
			}else{
				emptyNodeIndex=i;//to know where the empty tile is
			}
				
		}
		//System.out.println("total :"+total);
		return total;
	}
	public int recSearch(HashMap<Integer,Node> nc,int element,int length){
		
		if(nc.containsKey(element)){
			return length;
		}else{
			length++;
			Iterator<Map.Entry<Integer, Node>> iterator = nc.entrySet().iterator();
	        while(iterator.hasNext()){
	            Map.Entry<Integer, Node> entry = iterator.next();
	          //  System.out.printf("Tile Num%s and Value: %s %n", entry.getKey(), 
	              //                                             entry.getValue());
	            if(entry.getValue().visited==false){
	            	entry.getValue().visited=true;
	            	return recSearch(entry.getValue().adjacentNeighbours,element,length);
	            }
	            	
	            iterator.remove(); // right way to remove entries from Map, 
	                               // avoids ConcurrentModificationException
	        }
		}
		
		return 0;
	}
	public int calcTilesOutofPlace(){
		int res=0;
		for(int i=0;i<9;i++){
			if(n[i].element!=0){
				if(n[i].tileNumber!=n[i].element)
				res++;
			}else{
				emptyNodeIndex=i;//to know where the empty tile is
			}
		}
		return res;
	}
	
	
	//mutators
	public void setParent(Board b){
		parent=b.parent;
	}
	public void setHValue(int h){
		 hValue=h;
	}
	public void setGValue(int g){
		 gValue=g;
	}
	public void setFValue(){
		 fValue=gValue+fValue;
	}
	
	//accessors
	public Board getParent(){
		return parent;
	}
	public int getHValue(){
		return hValue;
	}
	public int getGValue(){
		return gValue;
	}
	public int getFValue(){
		return fValue;
	}
	

}