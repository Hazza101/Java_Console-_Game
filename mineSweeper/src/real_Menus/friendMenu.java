package real_Menus;

import java.util.Scanner;

import real_Social.friendList;
import real_Social.ingameMessage;

public class friendMenu {
	
static String friendName(){
	    
	    Scanner myObj = new Scanner(System.in);  

        System.out.println("What is your friend's name?");

        String answer = myObj.nextLine();
        
        return answer;
	    
	}
	
	
	
	public void friendMenuFunction(String username) {
		
    
    
    
	
		
	//String username = "Harri";
	int number = 1;
	while (number == 1) {
	    
	    ingameMessage function1 = new ingameMessage();
	    friendList function2 = new friendList();
	    
	    System.out.println("Homepage \n a - seePrivate \n b - addPrivate \n c - deletePrivate \n d - seefriends \n e - addfriends \n f - deletefriends \n x - Exit \n");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("?");

        String answer = myObj.nextLine();

        switch(answer){

            case "a":

            	System.out.println("||||||||||||||||||||||||||||||||||||||");
            	System.out.println("Currently under maintenance.");
            	System.out.println("||||||||||||||||||||||||||||||||||||||");
                //function1.seeMessage(username, friendName());
                

                break;

            case "b":
            	
            	System.out.println("||||||||||||||||||||||||||||||||||||||");
            	System.out.println("Currently under maintenance.");
            	System.out.println("||||||||||||||||||||||||||||||||||||||");
                //function1.add_Message(username, friendName());

                break;
                
            case "c":
            	
            	System.out.println("||||||||||||||||||||||||||||||||||||||");
            	System.out.println("Currently under maintenance.");
            	System.out.println("||||||||||||||||||||||||||||||||||||||");
                 //function1.removeMessage(username, friendName());

                break;
            
            case "d":
            	//System.out.println("Hello World");

                //function1.seeMessage(username, "default");
            	function2.see_Friends(username);
            	

                break;
            
            case "e":
            	
            	//System.out.println("Hello World");
            	function2.add_Friend(username, friendName());

                //function1.add_Message(username, "default");

                break;
            
            case "f":

            	//System.out.println("Hello World");
            	function2.delete_Friend(username, friendName());
            	//function1.removeMessage(username, "default");

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
