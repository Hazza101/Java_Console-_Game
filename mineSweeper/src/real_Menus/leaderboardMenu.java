package real_Menus;

import java.util.Scanner;

import real_leaderboard.leaderboard;

public class leaderboardMenu {
	
	public void leaderboardMenuFunction(String username) {
		int number = 1;
		String score = "";
		
		//leaderboardFunction.function1("Harri");
	    
	    while (number == 1) {
	        
	        //mainGame minesweeper = new mainGame();
	        leaderboard leaderboardFunction = new leaderboard();
	        //String username = "Harri";
	        
	        System.out.println("View Leaderboards \n a - easy Leaderboard \n b - medium Leaderboard \n c - difficult Leaderboard\n x - Exit \n");
	
	        Scanner myObj = new Scanner(System.in);  
	
	        System.out.println("?");
	
	        String answer = myObj.nextLine();
	
	        switch(answer){
	
	            case "a":
	
	                //System.out.println("Easy");
	                leaderboardFunction.function2(1);
	                
	
	                break;
	
	            case "b":
	
	                
	            	 //System.out.println("medium");
	            	 leaderboardFunction.function2(2);
	                
	
	                break;
	            
	            case "c":
	
	                
	            	 //System.out.println("difficult");
	            	 leaderboardFunction.function2(3);
	                
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
