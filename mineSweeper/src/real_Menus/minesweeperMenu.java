package real_Menus;

import java.util.Scanner;

import real_Game.mainGame;
import real_leaderboard.leaderboard;

public class minesweeperMenu {
	public void minesweeperMenuFunction(String username) {
			int number = 1;
			String score = "";
		    
		    while (number == 1) {
		        
		        mainGame minesweeper = new mainGame();
		        leaderboard leaderboardFunction = new leaderboard();
		        //String username = "Harri";
		        
		        System.out.println("Homepage \n a - easy \n b - medium \n c - difficult \n x - Exit \n");
		
		        Scanner myObj = new Scanner(System.in);  
		
		        System.out.println("?");
		
		        String answer = myObj.nextLine();
		
		        switch(answer){
		
		            case "a":
		
		                
		                minesweeper.setValues(9, 9, 10);
		                score = minesweeper.gameMethod();
		                int num = 1;
		                leaderboardFunction.function3(num, username, score);
		
		                break;
		
		            case "b":
		
		                
		                minesweeper.setValues(16, 16, 40);
		                score = minesweeper.gameMethod();
		                int num2 = 2;
		                leaderboardFunction.function3(num2, username, score);
		                
		
		                break;
		            
		            case "c":
		
		                
		                minesweeper.setValues(16, 30, 99);
		                score = minesweeper.gameMethod();
		                int num3 = 3;
		                leaderboardFunction.function3(num3, username, score);
		                
		                
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
