package real_Social;

import java.util.Random;
import java.io.FileWriter;   
import java.io.IOException;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.io.BufferedInputStream;

//remember to change all the file paths to relative paths
public class friendList{
    
    public void addNewUser(String username, String num){
        
        Random rand = new Random(); 
        //String[] usernameArray = {"Harri", "Carlos", "Julie", "John", "Anna", "Kai", "Mike", "Paddy"};
        try {
              
              FileWriter myWriter = new FileWriter("C:\\Java\\mineSweeper\\src\\friends.txt", true);
              
              
              //String username = "Harri";
              //String num = String.valueOf(1 + rand.nextInt(10));
              
              //String appendString = username + "," + num + "," + usernameArray[rand.nextInt(usernameArray.length)] + "," + usernameArray[rand.nextInt(usernameArray.length)] + "," + usernameArray[rand.nextInt(usernameArray.length)] + "," + usernameArray[rand.nextInt(usernameArray.length)] + "\n" ;
              String appendString = username + "," + num + "\n";
              myWriter.write(appendString);
              myWriter.close();
              System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }    
        
    }
    
    
    
    static String[][] readFriendList(){
        
        String[][] friendsArray = new String[200][20];
        
        
        //writenamestofile();
        try {
            File myObj = new File("C:\\Java\\mineSweeper\\src\\friends.txt");
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataArray = data.split(",");
                //friendsArray[count] = data.split(",");
                //original method got rid of all the null values in the array
                for (int i = 0; i < dataArray.length; i++){
                    friendsArray[count][i] = dataArray[i];    
                }
                //System.out.println(leaderArray[count][0]);
                count++;
            
            }
            myReader.close();
            
              
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return friendsArray;
        
    }
    
    
    static void printFriendArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == null) {
                break;
            }
            System.out.printf("Name = %s : Gamer Type = %s\n", arr[i][0], arr[i][1]);
        }
        
    }
    
    static void printFriendList(String[][] arr, String username){
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == null) {
                break;
            }
            if (arr[i][0].equals(username)) {
                System.out.printf("FriendList for %s \n", arr[i][0]);
                for (int j = 2; j < arr[i].length; j++){
                    if (arr[i][j] == null){
                        continue;
                    }
                    System.out.printf("-- %s -- \n",  arr[i][j]);
                }
                break;
            }
        }
        
        
        
        
    }
    
    
    static String[][] deleteFriend(String[][] arr, String username, String friend){
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == null) {
                break;
            }
            if (arr[i][0].equals(username)) {
                
                for (int j = 2; j < arr[i].length; j++){
                    if (arr[i][j] == null){
                        continue;
                    }
                    if (arr[i][j].equals(friend)){
                        arr[i][j] = null;
                    }
                    
                }
                break;
            }
        }
        return arr;
        
    }
    
    static String[][] addFriend(String[][] arr, String username, String friend){
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == null) {
                break;
            }
            
            
            if (arr[i][0].equals(username)) {
                
                for (int j = 2; j < arr[i].length; j++){
                    
                    if (arr[i][j] == null){
                        arr[i][j] = friend;
                        break;
                    }
                    
                    
                }
                break;
            }
            
        }
        return arr; 
        
    }
    
    static void fileUpdate(String [][] arr){
        
        try {
            FileWriter myWriter = new FileWriter("C:\\Java\\mineSweeper\\src\\friends.txt");
            
            
            
            
            for (int i = 0; i < arr.length; i++) {
            //System.out.println(i);
                if (arr[i][0] == null) {
                    break;
                }
                String data = arr[i][0];
                
                for (int j = 1; j < arr[i].length; j++){
                    if (arr[i][j] == null){
                        continue;
                    }
                    data = data + "," + arr[i][j]; 
                }
                
                //String data = String.join(",", arr[i]);
                myWriter.write(data + "\n");
            
            }
            
            
            
            
            
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        
        
    }
    
    public void see_Friends(String username) {
    	String[][] arr = readFriendList();
    	printFriendList(arr, username);
    }
    public void add_Friend(String username, String friend) {
    	String[][] arr = readFriendList();
    	arr = addFriend(arr, username, friend);
    	fileUpdate(arr);
    	
    	
    	
    }
    public void delete_Friend(String username, String friend) {
    	String[][] arr = readFriendList();
    	arr = deleteFriend(arr, username, friend);
    	fileUpdate(arr);
    }
         
    
    
}


/**
class Main
{
	
	
	static String friendName(){
	    
	    Scanner myObj = new Scanner(System.in);  

        System.out.println("What is your friend's name?");

        String answer = myObj.nextLine();
        
        return answer;
	    
	}
	
	
	
	public static void main(String[] args) {
		
    
    
    //String[][] arr = function1.readBlogMessage();
    //function1.printMessages(arr);
    //arr = function1.deleteMessage(arr, "Harri");
    //function1.addMessage(arr, "Harri");
    //function1.updateFile(arr);
    //function1.addPrivateMessage("Harri", "Jamie");
    //System.out.println(function1.checkIfPrivate("Jamie", "Harris"));
    //function1.createNewPrivate("Harri", "Jamie");
    //function1.allPrivateMessageTogether("Jamie", "John");  
	
	
	String username = "Harri";
	int number = 1;
	while (number == 1) {
	    
	    ingameChat function1 = new ingameChat(); 
	    System.out.println("Homepage \n a - seePrivate \n b - addPrivate \n c - deletePrivate \n d - seePublic \n e - addPublic \n f - deletePublic \n x - Exit \n");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("?");

        String answer = myObj.nextLine();

        switch(answer){

            case "a":

                
                function1.seeMessage(username, friendName());
                

                break;

            case "b":

                function1.add_Message(username, friendName());

                break;
                
            case "c":

                 function1.removeMessage(username, friendName());

                break;
            
            case "d":

                function1.seeMessage(username, "default");

                break;
            
            case "e":

                function1.add_Message(username, "default");

                break;
            
            case "f":

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

**/
