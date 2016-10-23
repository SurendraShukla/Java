
public class Puzzle {


    private Puzzle instPuzzle = new Puzzle();

    public Puzzle() throws Exception {
        throw new Exception("I am here always");
    } 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

        try {

            Puzzle puzzle = new Puzzle();

            System.out.println("Print me");

        } catch (Exception ex) {
        
            System.out.println("Caught you !");
        } 
        
	}

}
