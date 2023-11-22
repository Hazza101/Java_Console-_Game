package real_Registration;

import java.util.Scanner;









public class registrationClass{
    
    String[] messageArray = {"As a leader, being loved is more important than being feared.",

            "Death is the end.",
            "Having money is the most important thing in the world.",
            "People can't change their true-selves.",
            "All the negative events in your life have made you stronger.",
            "You should always finish something you start.",
            "Blood is thicker than water."};
            
    int[] answerArray = new int[messageArray.length];
    
    int maxScore = messageArray.length * 5;
    int minScore = messageArray.length - 1;
    int range = maxScore - messageArray.length;
    int divisor = (range - (range % 4)) / 4;
    
    
    static int quizQuestions(String message){
        boolean cont = true;
        int result = 0;
        while (cont){
            System.out.println("On a scale of 1 - 5 (1 - strongly disagree, 5 - strongly agree) what do you think of the statement below");
            System.out.println(message); 
            Scanner myObj2 = new Scanner(System.in);  
            System.out.printf("?");
            result = myObj2.nextInt();
            if (result <= 5 && result >= 1){
                cont = false;        
            }
            else {
                System.out.println("Please enter a number between 1 and 5 (inclusive)");
            }
            
        }
        return result;
    }
        
        
    int gamertype(){
            
        int total = 0;
        for (int i = 0; i < messageArray.length; i++){
            answerArray[i] = quizQuestions(messageArray[i]);
            total = total + answerArray[i];
            
            
        }
        
        int type = 0;
        if (minScore < total && total <= (minScore + divisor)){
             System.out.println("You are a killer gamertype.");
             type = 0;
        }
        else if ((minScore + divisor) < total && total <= (minScore + (divisor * 2))){
            System.out.println("You are an achiever gamertype.");
            type = 1;
        }
        else if ((minScore + (divisor * 2)) < total && total <= (minScore + (divisor * 3))){
            System.out.println("You are a socializer gamertype."); 
            type = 2;
        }
        else if ((minScore + (divisor * 3)) < total && total <= maxScore){
            System.out.println("You are an explorer gamertype.");
            type = 3;
        }
        else{
            System.out.println("Something went wrong");
        }
        return type;
            
    }
    
    String[] username_password(String[] listUsernames){
        Scanner myObj = new Scanner(System.in);  
        boolean cont = true;
        String username = "";
        while (cont) {
            
            
            System.out.println("create username");
            username = myObj.nextLine();
            boolean exists = false;
            for (int i = 0; i < listUsernames.length; i++){
                if (listUsernames[i] == null) {
                	continue;
                }
            	
            	if (listUsernames[i].equals(username)){
                    System.out.println("Username already exists.");
                    exists = true;
                }        
            }
            cont = exists;
        
            
        }
        
        String password = "";
        
        cont = true;
        while (cont) {
            System.out.println("create password");
            password = myObj.nextLine();
            System.out.println("please renter password");
            String password2 = myObj.nextLine();
            if (password.equals(password2)) {
                //cont = false;
                break;
            }
            System.out.println("Your passwords do not match");
            
        }
        
        
        
        String[] uandp = {username, password};
        return uandp;
    }
    
    
    public String[] registrationAll(String[] listUsernames) {
        String[] tmplist = username_password(listUsernames);    
        String type = String.valueOf(gamertype());
        String[] list = {tmplist[0], tmplist[1], type};
        return list;
    }
    
}




