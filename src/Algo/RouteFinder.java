import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class RouteFinder {
	private static int [][] input = {{2,3,5},{1,4,3},{1,4,2}};
	private static int rowLength = 3;
	private static int colLength = 3;
	
	class Model{
		List<Index> possibleOutcomes;
		Index parentIndex;
		Index selfIndex;
		
		public Model(List<Index> possibleOutcomes, Index parentIndex, Index selfIndex) {
			this.possibleOutcomes = possibleOutcomes;
			this.parentIndex = parentIndex;
			this.selfIndex = selfIndex;
		}
	}
	
	class Index{
		int row;
		int column;
		
		public Index(int row, int column) {
			this.row = row;
			this.column = column;
		}
		
		@Override
		public boolean equals(Object obj) {
			Index index = (Index)obj;
			if(index.row == this.row && index.column == this.column){
				return true;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return (row + ":" + column).hashCode();
		}
		
		@Override
		public String toString() {
			return row + ":" + column;
		}
		
	}
	
	public void startProcessing(){
		for(int i = 0 ; i < rowLength ; i ++){
			for(int j = 0 ; j < colLength ; j++){
				Index startIndex = new Index(i, j);
				System.out.println("---------------------------------------");
				System.out.println("Routes starting from " + startIndex.toString() + " : " + getValue(startIndex));
				Model model = new Model(findAvailableRoutes(startIndex, null), null, startIndex);
				Set<Index> routes = new LinkedHashSet<>();
				routes.add(startIndex);
				process(model, routes);
			}
		}
	}
	
	public static void main(String[] args) {
		RouteFinder finder = new RouteFinder();
		finder.startProcessing();
	}
	
	private int getValue(Index index){
		return input[index.row][index.column];
	}
	
	private void printRoute(Set<Index> route){
		StringBuilder output = new StringBuilder();
		Iterator<Index> iterator = route.iterator();
		while(iterator.hasNext()){
			output.append(getValue(iterator.next())).append(" ");
		}
		System.out.println(output.toString());
	}
	
	private void process(Model model, Set<Index> route){
		if(model.possibleOutcomes.isEmpty()){
			printRoute(route);
			route.remove(model.selfIndex);
			return;
		}
		
		List<Index> outcomes = model.possibleOutcomes;
		for (Index index : outcomes) {
			if(route.add(index)){
				Model newModel = new Model(findAvailableRoutes(index, model.selfIndex), model.selfIndex, index);
				process(newModel, route);
			}else{
				continue;
			}
		}
		route.remove(model.selfIndex);
	}
	
	private List<Index> findAvailableRoutes(Index index, Index parentIndex){
		List<Index> list = new ArrayList<Index>();
		//x+1
		addNext(index, new Index(index.row + 1, index.column), list, parentIndex);
		
		//y+1
		addNext(index, new Index(index.row, index.column + 1), list, parentIndex);
		
		//x-1
		addNext(index, new Index(index.row - 1, index.column), list, parentIndex);
		
		//y-1
		addNext(index, new Index(index.row, index.column - 1), list, parentIndex);
		
		return list;
	}
	
	private void addNext(Index oldIndex, Index newIndex,List<Index> list, Index parentIndex){
		if(isValid(newIndex) && getValue(newIndex) <= getValue(oldIndex) && (parentIndex == null || !newIndex.equals(parentIndex)))
			list.add(newIndex);
	}
	
	private boolean isValid(Index index){
		if(index.row >= 0 && index.row < rowLength &&  index.column >= 0 && index.column < colLength){
			return true;
		}
		return false;
	}
	
}
