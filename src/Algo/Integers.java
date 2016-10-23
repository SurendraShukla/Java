package Algo;

public class Integers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integer firstInt = 123;
        Integer seconInt = 123;
        Integer thirdInt = new Integer(123);
 
        System.out.println(firstInt == seconInt);
        System.out.println(firstInt == thirdInt); 
        
        try{
        	System.out.print("hello ");
        	System.exit(0);
        }catch(Exception e){
        	System.out.print("oops! ");
        }
        finally{
        	System.out.print("bye ");
        }
        
        char c = 0x000A;
        System.out.println(c); 
        
	}

}
