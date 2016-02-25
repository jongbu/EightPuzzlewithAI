/*
 * Jongbu
 * CS363- Artificial Intelligence
 * 8-Puzzle Solver
 * Prof. Changhe Yuan
 * Submitted on: 
 */

public class Source {
	
	//main function 
	public static void main(String args[]){
		long begin,end; 
		
		int[] tiles={1,3,4,8,6,2,7,0,5};//easy
		//int[] tiles={5,6,7,4,0,8,3,2,1};//worst
		
		Node[] n=new Node[9];

		for(int i=0;i<9;i++){
			n[i]=new Node();
			n[i].element=tiles[i];//initializing the elements in the board
			
		}
		
		
		//Begin A* with f(n)=g(n)+h(n) heuristics
		begin= System.nanoTime();
		AStar a=new AStar(n);
		a.AStarSearchwithTilesOutofPlace();
		end=System.nanoTime();
		System.out.println("TilesOutOfPlace Heuristics solved in "+(end-begin)+" nanoseconds.");
		/*
		//Begin A* 	with Manhattan Heuristics
		for(int i=0;i<9;i++){
			n[i]=new Node();
			n[i].element=tiles[i];//initializing the elements in the board
			
		}
		begin= System.nanoTime();
		AStar b=new AStar(n);
		b.AStarSearchwithManhattanHeuristics();
		end=System.nanoTime();
		System.out.println("Manhattan Heuristics solved in "+(end-begin)+" nanoseconds.");
		*/
	}
	
	
}
