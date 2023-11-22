package real_Social;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ingameMessage{
    
    static void updateFile(String[][] arr, String filename){
        
        if (filename.equals("default")){
            filename = "C:\\Java\\mineSweeper\\src\\blog.txt";
        }
        
        try {
              
            FileWriter myWriter = new FileWriter(filename);
              
              
              
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] == null) {
                    continue;
                }
                
                myWriter.write(arr[i][0] + "\n");
                myWriter.write(arr[i][1] + "\n");
            }
              
              
              myWriter.close();
              
              
              System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }    
        
    }
    
    
    static String[][] addMessage(String[][] arr, String username){
        
        String message = ""; 
        //Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        System.out.println("Please enter a message you want to send? Type 0 to end the message");
        Scanner stdin = new Scanner(System.in);    
        while (1 == 1) {
            String tmp = stdin.nextLine();
            if (tmp.equals("0") ){
                break;
            }
            
            message = message + tmp + "\n";     
        
        }
        message = message.replace('\n', ':');
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == null) {
                arr[i][0] = message;
                arr[i][1] = username + "-" + String.valueOf(i);
                break;
                
            }
            
        }
        
        //System.out.println(message);
        return arr;
        
    }
    
    
    
    static String[][] deleteMessage(String[][] arr, String username){
        
        System.out.println("Please enter the ID of the message you want to delete");
        Scanner stdin = new Scanner(System.in); 
        
        String ID = stdin.nextLine();
        int correct = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == null){
                break;
            }
            String[] user_ID = arr[i][1].split("-");
            if (user_ID[0].equals(username) && user_ID[1].equals(ID)) {
                arr[i][0] = null;
                correct = 1;
                break;
            }
            
        
    }
    
    if (correct == 0){
                System.out.println("Please enter the ID of your own message.");
            }
            
    return arr;
    
    }
    
    static String[][] readBlogMessage(String filename){
        
        if (filename.equals("default")){
            filename = "C:\\Java\\mineSweeper\\src\\blog.txt";
        }
        
        String[][] messageArray = new String[200][2];
        
        
        //writenamestofile();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            while (myReader.hasNextLine()) {
                messageArray[count][0] = myReader.nextLine();
                messageArray[count][1] = myReader.nextLine();
                
                
                count++;
            
            }
            myReader.close();
            
              
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return messageArray;
        
    }
    
    
    static void printMessages(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == null) {
                break;
            }
            String tmp = arr[i][0].replace(':', '\n');
            System.out.printf("%s \n -> %s\n", tmp, arr[i][1]);
            System.out.println("------------------");
        }
        
    }
    
    
    static void addPrivateMessage(String username, String friend){
        
         
        
        try {
              
              FileWriter myWriter = new FileWriter("privatemessage.txt", true);
              
              
              
              String appendString = username + "-" + friend + "\n";
              
              myWriter.write(appendString);
              myWriter.close();
              System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }    
        
    }
    
    static String checkIfPrivate(String username, String friend){
        
            String exists = "no";
        
        try {
            File myObj = new File("privatemessage.txt");
            Scanner myReader = new Scanner(myObj);
            String string1 = username + "-" + friend;
            String string2 = friend + "-" + username;
            
            
            while (myReader.hasNextLine()) {
                 
                String tmp = myReader.nextLine();
                if (tmp.equals(string1) || tmp.equals(string2)){
                    exists = tmp + ".txt";
                    break;
                }
                
                
                
                
                
            
            }
            myReader.close();
            
              
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return exists;
        
    }
    
    static String createNewPrivate(String username, String friend){
        String filename = "";
        try {
          filename = username + "-" + friend + ".txt";
          File myObj = new File(filename);
          if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        return filename;
    
    }
    
    
    
    static String allPrivateMessageTogether(String username, String friend){
        String exists = checkIfPrivate(username, friend);
        if (exists.equals("no")){
            addPrivateMessage(username, friend);
            exists = createNewPrivate(username, friend);
            
            
        }
        
        System.out.println(exists);
        return exists;
        
    }
    
    
    public void seeMessage(String username, String friend)
    {
        String filename = "default";
        if (!(friend.equals("default"))) {
            filename = allPrivateMessageTogether(username, friend);        
        }
        String[][] arr = readBlogMessage(filename);
        printMessages(arr);
    }
    
    public void add_Message(String username, String friend){
        String filename = "default";
        if (!(friend.equals("default"))) {
            filename = allPrivateMessageTogether(username, friend);        
        }
        String[][] arr = readBlogMessage(filename);
        arr = addMessage(arr, username);
        updateFile(arr, filename);
        printMessages(arr);
    }
    
    public void removeMessage(String username, String friend){
        String filename = "default";
        if (!(friend.equals("default"))) {
            filename = allPrivateMessageTogether(username, friend);        
        }
        String[][] arr = readBlogMessage(filename);
        arr = deleteMessage(arr, username);
        updateFile(arr, filename);
        printMessages(arr);
    }
    
    
}
