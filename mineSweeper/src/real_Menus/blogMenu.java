package real_Menus;

import java.util.Scanner;

import real_Social.ingameMessage;

public class blogMenu {
	
	public void blogMenuFunction(String username) {
		//String username = "Harri";
		int number = 1;
		while (number == 1) {
		    
		    ingameMessage function1 = new ingameMessage(); 
		    System.out.println("Social blog \n a - seePublic \n b - addPublic \n c - deletePublic \n x - Exit \n");

	        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

	        System.out.println("?");

	        String answer = myObj.nextLine();

	        switch(answer){

	            case "a":

	                
	            	function1.seeMessage(username, "default");
	                

	                break;

	            case "b":

	            	function1.add_Message(username, "default");

	                break;
	                
	            case "c":

	                function1.removeMessage(username, "default");
	                break;
	            
	            

	            case "x":

	                System.out.println("Exited the program");

	                number = 0;

	                break;

	            default:

	               

	                System.out.println("Enter appropriate input");

	        }

	    }

	}

}
