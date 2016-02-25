import java.util.ArrayList;

public class ManhattanHeuristics {
	ArrayList<Board> openList;
	ArrayList<Board> closedList;

	public ManhattanHeuristics(Node tiles[]) {
		openList = new ArrayList<>();
		closedList = new ArrayList<>();

		// starting node
		Board initial = new Board(tiles);
		openList.add(initial);
	}

	public void AStarSearch() {

		while (true) {// until we have reached our goals
			// consider best node in the open list( with lowest f value)
			Board bestBoard = openList.get(lowestFValueKey(openList));
			bestBoard.printBoard();// print

			if (bestBoard.getHValue() == 0) {// if we reached the goal
				System.out.println("Puzzle Completed. Printing Board...");
				bestBoard.printBoard();
				break;
			} else {
				// move the current node to the closed list and consider all of
				// its neighbours
				closedList.add(bestBoard);
				openList.remove(bestBoard);

				ArrayList<Board> neighborList = bestBoard.generateNeighbors();

				for (Board neighbor : neighborList) {
					if (closedList.contains(neighbor)) {

						Board closedListNeighbor = closedList.get(closedList.indexOf(neighbor));
						if (neighbor.getGValue() < closedListNeighbor.getGValue()) {
							// move node from closed list to open list
							openList.add(neighbor);
							closedList.remove(neighbor);

							// update the neighbor with the new lower g value
							closedListNeighbor.setGValue(neighbor.getGValue());
							neighbor.setParent(bestBoard);

						}
					} else if (openList.contains(neighbor)) {
						Board openListNeighbor = openList.get(openList.indexOf(neighbor));
						if (neighbor.getGValue() < openListNeighbor.getGValue()) {

							// update neighbor with new lower g value
							openListNeighbor.setGValue(neighbor.getGValue());
							// change the neighbors parent to the current node
							neighbor.setParent(bestBoard);
						}
					} else {
						openList.add(neighbor);

						neighbor.setGValue(bestBoard.getGValue() + 1);
						neighbor.setFValue();

					}
				}
			}
		}
	}

	// returns the lowest fValue Key from the openList
	public int lowestFValueKey(ArrayList<Board> set) {
		int lowest = 0;

		for (int i = 1; i < set.size(); i++) {
			if (set.get(i).getFValue() < lowest) {
				lowest = i;
			}
		}
		return lowest;
	}

}
