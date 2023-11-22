package real_Game;

import java.util.Random;
import java.util.Scanner;






public class mainGame
{
	 
    public int x_dimension = 10;
    public int y_dimension = 10;
    public int numOfMines = 10;
    char[][][] mineSweep;
    public int score;
    
    long startTime;
	long elapsedTime;
            
    public void setValues(int x, int y, int mines) {
	    x_dimension = x;
	    y_dimension = y;
	    numOfMines = mines;
	    mineSweep = new char[x][y][4];
	} 
	
	
	int[] getCords(){
	    
	    
	    
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.printf("\n 0 - normal, 1 - flag. \n");

        int flag = myObj.nextInt();
        
        System.out.println("Enter x coardinate");

        int x_cord = myObj.nextInt();  // Read user input
	    System.out.println("Enter y coardinate");
	    int y_cord = myObj.nextInt();
	    int[] cArray = {x_cord, y_cord, flag};
	    //amyObj.close();
	    
	    return cArray;
	}
	
	int showMap(char[][][] mineSweep){
	    
	    System.out.printf("   ");
	    
	    for (int i = 0; i < mineSweep[0].length; i++){
	        if (i >= 10) {
	            System.out.printf("%d ", i );
	        }
	        else {
	            System.out.printf("%d  ", i );    
	        }
	    }
	    
	    System.out.println("\n");
	    
	    //System.out.println("    0 1 2 3 4 5 6 7 8 9\n");
	    
	    int count = 0;
	    for (int i = 0; i < mineSweep.length; i++){
		    
		    if (i >= 10) {
		        System.out.printf("%d ", i);
		    }
		    else {
		        System.out.printf("%d  ", i);    
		    }
		    for (int j = 0; j < mineSweep[i].length; j++){
		        
		         
		        
		        if (mineSweep[i][j][1] == 'y'){
		            System.out.printf("%c  ", mineSweep[i][j][0]);
		            count++;
		        }
		        
		        else if (mineSweep[i][j][2] == 'y') {
		            System.out.printf("f  ");        
		        }
		        
		        else {
		            System.out.printf("-  ");    
		        }
		        
		        
		    }
		    System.out.printf("\n");
		    
		}
		
		//System.out.printf("%d = %d ", ((mineSweep.length * mineSweep[0].length) - numOfMines), count );
		if ((mineSweep.length * mineSweep[0].length) - numOfMines == count) {
			
			score = (int)((System.currentTimeMillis() - startTime)/1000);
			System.out.printf("\nWell done! You did it in %d seconds \n", score);
		    
		    return 1;
		}
		else {
		    return 0;
		}
		
		//return count;
	} 
	
	
	
	void fillFunction(int x, int y, char[][][] mineSweep) {
		
    		if ((y + 1) < y_dimension && mineSweep[x][y + 1][0] == '0'){
    		    mineSweep[x][y + 1][0] = 'o';
    		    mineSweep[x][y + 1][1] = 'y';
    		    fillFunction(x, y + 1, mineSweep);
    		    
    		    
    		    
    		}
    		if ((x + 1) < x_dimension && mineSweep[x + 1][y][0] == '0'){
    		    mineSweep[x + 1][y][0] = 'o';
    		    mineSweep[x + 1][y][1] = 'y';
    		    fillFunction(x + 1, y, mineSweep);
    		    
    		}
    		if ((y - 1) >= 0 && mineSweep[x][y - 1][0] == '0'){
    		    mineSweep[x][y - 1][0] = 'o';
    		    mineSweep[x][y - 1][1] = 'y';
    		    fillFunction(x, y - 1, mineSweep); 
    		}
    		if ((x - 1) >= 0 && mineSweep[x - 1][y][0] == '0'){
    		    mineSweep[x - 1][y][0] = 'o';
    		    mineSweep[x - 1][y][1] = 'y';
    		    fillFunction(x - 1, y, mineSweep);    
    		}
	    
	        
	    }
	    
	void fillFunction2(int x_dimension, int y_dimension, char[][][] mineSweep){
	    for (int i = 0; i < x_dimension; i++) {

               for(int j = 0; j < y_dimension; j++) {

                    if (mineSweep[i][j][0] != 'm' && mineSweep[i][j][0] != '0' && mineSweep[i][j][0] !='o') {

                        int[][] iandj_array = { {0, 0},

                                {0, 1},

                                {0, -1},

                                {1, 0},

                                {1, 1},

                                {1, -1},

                                {-1, 0},

                                {-1, 1},

                                {-1, -1},

                                };

                        //int mineCounter = 0;

                        for (int k = 0; k < 9; k++) {

                            int temp_i = iandj_array[k][0] + i;
                            int temp_j = iandj_array[k][1] + j;

                            if (0 <= temp_i && temp_i < x_dimension && 0 <= temp_j && temp_j < y_dimension) {

                                char temp = mineSweep[temp_i][temp_j][0];

                                if (temp == 'o') {
                                    mineSweep[i][j][1] = 'y';
                                    
                                    
                                }

                            }

                        }
                        

                    }

                }

            }
	    
	}
	    
	void Initialisation() {
	    
		
		
		
		Random rand = new Random();
        
        //int x_dimension = 10;
		//int y_dimension = 10;
		int[] array_cords = new int[x_dimension * y_dimension];

        
        //char[][][] mineSweep = new char[x_dimension][y_dimension][2];
        
        //System.out.printf("%d, %d \n", x_dimension, y_dimension);
        
        for (int i = 0; i < x_dimension; i++) {

               for(int j = 0; j < y_dimension; j++) {
               
                   mineSweep[i][j][1] = 'n';
                   mineSweep[i][j][2] = 'n';
                   
               }
               
        }
        
        
        for (int i = 0; i < array_cords.length; i++) {
		    array_cords[i] = i;
        }
        
        showMap(mineSweep);
        
        int[] cArray = getCords();
        
        startTime = System.currentTimeMillis();
		elapsedTime = 0L;
        
		//mineSweep[cArray[0]][cArray[1]][0] = 'o';
        mineSweep[cArray[0]][cArray[1]][1] = 'y';
        
        
        
        for (int j = 0; j < numOfMines; j++){
		    
		    int upperbound = array_cords.length - j;
		    int ranNum = rand.nextInt(upperbound);
		    int i = array_cords[ranNum]; 
		    
		    int x_cord = i % x_dimension;
		    int y_cord = (i / (x_dimension)) % y_dimension;
		    
		    if (mineSweep[x_cord][y_cord][1] == 'y'){
		        j--;    
		    }
		    else {
		        mineSweep[x_cord][y_cord][0] = 'm';
		    }
		    int temp = array_cords[ranNum];
		    array_cords[ranNum] = array_cords[upperbound - 1];
		    array_cords[upperbound - 1] = temp;
		    
		    
		}

        

        

        for (int i = 0; i < x_dimension; i++) {

               for(int j = 0; j < y_dimension; j++) {

                    if (mineSweep[i][j][0] != 'm') {

                        int[][] iandj_array = { {0, 0},

                                {0, 1},

                                {0, -1},

                                {1, 0},

                                {1, 1},

                                {1, -1},

                                {-1, 0},

                                {-1, 1},

                                {-1, -1},

                                };

                        int mineCounter = 0;

                        for (int k = 0; k < 9; k++) {

                            int temp_i = iandj_array[k][0] + i;
                            int temp_j = iandj_array[k][1] + j;

                            if (0 <= temp_i && temp_i < x_dimension && 0 <= temp_j && temp_j < y_dimension) {

                                char temp = mineSweep[temp_i][temp_j][0];

                                if (temp == 'm') {

                                    mineCounter++;
                                    
                                }

                            }

                        }
                        mineSweep[i][j][0] = (char)(mineCounter + '0');

                    }

                }

            }
		
		
		
		
	    
	    fillFunction(cArray[0], cArray[1], mineSweep);
	    fillFunction2(x_dimension, y_dimension, mineSweep);
	    
	    
	    
	    
	    
	    
	}
	
	int eachRound(){
	    int[] cArray = getCords();
	    
	    
	    if (cArray[2] == 99) {
	    	solveIt();
	    	
	    }
	    
	    if (cArray[2] == -99) {
	        System.out.println("No score");
	        return 2;    
	    }
	    
	    
	    
	    
	    if (cArray[2] == 1) {
	        if (mineSweep[cArray[0]][cArray[1]][2] == 'y'){
	            mineSweep[cArray[0]][cArray[1]][2] = 'n';    
	        }    
	        else  {
	            mineSweep[cArray[0]][cArray[1]][2] = 'y';
	        }
	        
	        return 0;
	        
	    }
	    
	    
	     
	    else if ((mineSweep[cArray[0]][cArray[1]][1] == 'y')) {
	        System.out.println("Please enter coordinates you havent chosen.");
	        return 0;
	    }  
	    
	    
	    else if (mineSweep[cArray[0]][cArray[1]][0] == 'm') {
	        System.out.println("Gameover");
	        return 1;
	        
	    }
	    
	    else if (mineSweep[cArray[0]][cArray[1]][0] == '0') {
	        fillFunction(cArray[0], cArray[1], mineSweep);
	        fillFunction2(x_dimension, y_dimension, mineSweep);    
	        return 0;
	        
	    }
	    
	    else {
	        mineSweep[cArray[0]][cArray[1]][1] = 'y';
	        return 0;
	    }
	}
	
	
	void solveIt() {
		for (int i = 0; i < x_dimension; i++) {

            for(int j = 0; j < y_dimension; j++) {

                 if (mineSweep[i][j][0] != 'm') {
               	  mineSweep[i][j][1] = 'y';
                 }
            }
		 }
	}
	
	
	
	
	public String gameMethod() {
	
		 
		
	
		 
            
            
            
            
        
        Initialisation();
        int bomb = 0;
        while (bomb == 0) {
            bomb = showMap(mineSweep);
            if (bomb == 1) {
                break;
            }
            
            if (bomb == 2) {
                score = 0;
            }
            
            bomb = eachRound();
        }
	     
        String tmp_score = String.valueOf(score);
        return tmp_score;   
            //gameFunction();
        
	    
	    
	}
}


		
        
        
        
        
        
        
        
            
 
