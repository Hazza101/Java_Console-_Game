import java.util.Scanner;

import real_Menus.*;
import real_leaderboard.leaderboard;
import real_Login.loginClass;
import real_Registration.registrationClass;
import real_Social.friendList;



class mainMenu{
	
	public void mainMenuFunction(String username) {
		
		int number = 1;
	    //String username = "Harri";
	    while (number == 1) {
	        
	        minesweeperMenu function_M = new minesweeperMenu();
	        blogMenu function_B = new blogMenu();
	        leaderboardMenu function_L = new leaderboardMenu();
	        friendMenu function_F = new friendMenu();
	        
	        
	    	
	    	
	    	System.out.println("Homepage2 \n a - minesweeper \n b - social \n c - friends \n d - leaderboards \n  x - Exit \n");
	
	        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	
	        System.out.println("?");
	
	        String answer = myObj.nextLine();
	
	        switch(answer){
	
	            case "a":
	            	
	                
	            	
	            	function_M.minesweeperMenuFunction(username);
	            	
	                break;
	
	            case "b":
	
	                
	            	//System.out.println("social beebop");
	            	function_B.blogMenuFunction(username);
	                break;
	            
	            case "c":
	
	            	
	            	function_F.friendMenuFunction(username);
	            	
	            	//System.out.println("leaderboards beebop");
	                break;
	                
	            case "d":
	            	
	            	function_L.leaderboardMenuFunction(username);
	            	//System.out.println("settings beebop");
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







public class main {

	    
	    
	
	public static void main(String[] args) {
		
		int number = 1;
		String score = "";
		
		
	    
	    while (number == 1) {
	        
	    	
	    	loginClass function_Log = new loginClass();
	    	registrationClass function_Reg = new registrationClass();
	    	friendList function_F = new friendList();
	    	leaderboard function_Lead = new leaderboard();
	    	mainMenu function_Main = new mainMenu();
	    	
	    	
	        
	        
	        System.out.println("Login page \n a - Login \n b - Create an account \n x - Exit \n");
	
	        Scanner myObj = new Scanner(System.in);  
	
	        System.out.println("?");
	
	        String answer = myObj.nextLine();
	
	        switch(answer){
	
	            case "a":
	
	                System.out.println("Easy");
	                
	                
	                String[] tmp = function_Log.checkAccount();
	                if (tmp[1].equals("0") ) {
	                	System.out.println("Please try again");
	                }
	                else {
	                	function_Main.mainMenuFunction(tmp[0]);
	                }
	
	                break;
	
	            case "b":
	
	                
	            	 
	            	 
	            	 
	            	 //list of pre-existing usernames
	            	 
	            	 String[] list = function_Log.listUsernames();
	            	 
	            	 //register
	            	 
	            	 String[] userdata = function_Reg.registrationAll(list);
	            	 
	            	 
	            	 
	            	 //add to database
	            	 
	            	 function_Log.addAccount(userdata);
	            	 
	            	 //add to friends
	            	 
	            	 
	            	 function_F.addNewUser(userdata[0], userdata[2]);
	            	 
	            	 
	            	 //add to leaderboard
	            	 
	            	 function_Lead.fileWrite(userdata[0]);
	                
	
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
        

