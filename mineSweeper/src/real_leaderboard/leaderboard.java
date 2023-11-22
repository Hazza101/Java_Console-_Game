package real_leaderboard;

import java.util.Random;
import java.io.FileWriter;   
import java.io.IOException;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 



public class leaderboard{
    public void fileWrite(String username){
        Random rand = new Random();
        try {
              
              FileWriter myWriter = new FileWriter("C:\\Java\\mineSweeper\\src\\java.txt", true);
              //int n1 = rand.nextInt(50);
              //int n2 = rand.nextInt(50);
              //int n3 = rand.nextInt(50);
              
              //String n1 = String.valueOf(rand.nextInt(50));
              //String n2 = String.valueOf(rand.nextInt(50));
              //String n3 = String.valueOf(rand.nextInt(50));
              
              //String appendString = username + "," + n1 + "," + n2 + "," + n3 + "\n" ;
              String appendString = username + ",0,0,0\n" ;
              
              myWriter.write(appendString);
              myWriter.close();
              //.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }    
    }
    
    
    static String[][] fileRead(){
        
        String[][] leaderArray = new String[200][4]; 
        //writenamestofile();
        try {
            File myObj = new File("C:\\Java\\mineSweeper\\src\\java.txt");
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            while (myReader.hasNextLine()) {
                //System.out.println("Hello World");
            	String data = myReader.nextLine();
                leaderArray[count] = data.split(",");
                //System.out.println(leaderArray[count][0]);
                count++;
            
            }
            myReader.close();
            
              
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return leaderArray;
        
    }
    
    static void printLeaderBoard(int difficulty, String[][] arr){
        
        System.out.println("|||||||||||||||||||||||||||||||||||||||");
    	
    	String score = "";
        if (difficulty == 1){
            score = "Easy";
        }
        else if (difficulty == 2){
            score = "Medium";
        }
        else if (difficulty == 3){
            score = "Difficult";
        }
        
        
        System.out.println("Name | " + score);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == null) {
                break;
            }
            
            
            String tmp = arr[i][difficulty];
            if (tmp.equals("0")){
            	continue;
            }
            System.out.printf("%s : %s seconds \n", arr[i][0], tmp );
        }
        System.out.println("|||||||||||||||||||||||||||||||||||||||");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Type any character to return.");
        myObj.next().charAt(0);
    }
    
    static String[][] sortleaderBoard(int difficulty, String[][]arr){
        int limit = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == null) {
                limit = i;
                break;
            }
            
        }
        for (int i = 0; i < limit; i++)   
        {  
            for (int j = i + 1; j < limit; j++)   
            {  
                
                int number1 = 0;
                int number2 = 0;
                
                try{
                number1 = Integer.parseInt(arr[i][difficulty]);
                
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
                try{
                number2 = Integer.parseInt(arr[j][difficulty]);
                
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
            
            
            
            
                String[] tmp = new String[4];  
                if (number1 > number2 )   
                {  
                    //System.out.printf("i = %d and j = %d \n%s : %s and %s : %s\n",i ,j,  arr[i][0], arr[i][difficulty], arr[j][0], arr[j][difficulty]);
                    
                    tmp = arr[i];  
                    arr[i] = arr[j];  
                    arr[j] = tmp;  
                }  
            }  
        }
        return arr;
    }
    
    
    static String[][] changeValue (String[][] arr, int difficulty, String username, String score){
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(i);
            if (arr[i][0] == null) {
                break;
            }
            if (arr[i][0].equals(username) ){
                if (Integer.parseInt(score) < Integer.parseInt(arr[i][difficulty]) || Integer.parseInt(arr[i][difficulty]) == 0 ) {
                    //System.out.printf("name = %s, score = %s", arr[i][0], score);
                    arr[i][difficulty] = score;
                    break;
                }
            }
        }
        return arr;
    }
    
    static void fileUpdate(String [][] arr){
         try {
            FileWriter myWriter = new FileWriter("C:\\Java\\mineSweeper\\src\\java.txt");
            
            
            
            
            for (int i = 0; i < arr.length; i++) {
            //System.out.println(i);
                if (arr[i][0] == null) {
                    break;
                }
                String data = String.join(",", arr[i]);
                myWriter.write(data + "\n");
            
            }
            
            
            
            
            
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        
    }
    
    //////used for random creation
    
    /**
    
    public void function1(String username){
        fileWrite("Harri");
        fileWrite("Julie");
        fileWrite("Kai");
        fileWrite("Anna");
        fileWrite("Carlos");     
    }
    
    **/
    
    public void function2(int difficulty){
        String[][] arr = fileRead();
        arr = sortleaderBoard(difficulty, arr);
        printLeaderBoard(difficulty, arr);
        
        
    }
    
    public void function3(int difficulty, String username, String score){
        String[][] arr3 = fileRead();
        arr3 = changeValue(arr3, difficulty, username, score);
        fileUpdate(arr3);
    }
    
}






