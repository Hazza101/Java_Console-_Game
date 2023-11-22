package real_Login;



import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

import java.io.IOException;

import java.io.FileWriter;









 

public class loginClass {

	static String userName;
	
	static String[][] fileReader() {

			String[][] dataBase = new String[50][2];
			dataBase[0][0] = "username";
			try {

	            File myfile = new File("C:\\Java\\mineSweeper\\src\\database.txt");
	            Scanner openfile = new Scanner(myfile);
	
	            int index = 0;
	
	            while (openfile.hasNextLine()) {
	
	               String filedata = openfile.nextLine();
	               String[] filedata2 = filedata.split(",");
	               dataBase[index] = filedata2;
	               index++;

            }

            openfile.close();

                                }

	        catch (FileNotFoundException e) {
	
	            System.out.println("Error.");
	            e.printStackTrace();
	
	        }

        return dataBase;

	}                 

	
	static void pleaseWork(String [] userDetails){

		try {

			FileWriter myWriter = new FileWriter("C:\\Java\\mineSweeper\\src\\database.txt", true);
	
	             /**for (int i = 0; i < dataBase.length; i++){
	
	            	 if (dataBase[i][0] == null){
	            		 
	            		 break;
	
	            	 }
	
	            	 myWriter.write(dataBase[i][0] + "," + dataBase[i][1]  + "\n");
	
	              }
	              **/
				myWriter.write(userDetails[0] + "," + userDetails[1]  + "\n");
	             myWriter.close();
	
	             //System.out.println("Successfully wrote to the file.");
	
		} catch (IOException e) {
	
			System.out.println("An error occurred.");
	
			e.printStackTrace();
	
	    }

               

}   

	
	
	
	
	
	static void fileWrite(String [][] dataBase){

			try {

				FileWriter myWriter = new FileWriter("C:\\Java\\mineSweeper\\src\\database.txt");
		
		             for (int i = 0; i < dataBase.length; i++){
		
		            	 if (dataBase[i][0] == null){
		            		 
		            		 break;
		
		            	 }
		
		            	 myWriter.write(dataBase[i][0] + "," + dataBase[i][1]  + "\n");
		
		              }
		
		             myWriter.close();
		
		             //System.out.println("Successfully wrote to the file.");
		
			} catch (IOException e) {
		
				System.out.println("An error occurred.");
		
				e.printStackTrace();
		
		    }

                   

	}   

               

	

               

	static String[] loginFunction(String[][] dataBase) {

			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	
	        System.out.println("Enter your details below:");
	
	        System.out.println("Username:");
	
	        String userName = myObj.nextLine();
	
	        System.out.println("Password:");
	
	        String passWord = myObj.nextLine();
	
	    	String[] correct = {"0", "0"};

	    	for (int i = 0; i < dataBase.length; i++){
			
			           
			
				if (dataBase[i][0] == null){
					break;
				}
				
                if (dataBase[i][0].equals(userName) && dataBase[i][1].equals(passWord)){

                    System.out.println("Correct credentials.");
                    correct[0] = userName;
                    correct[1] = "1";
                    return correct;

                }
			
    		}
			
	        if (correct[1] == "0"){
	
	            System.out.println("Incorrect credentials.");
	            return correct;
	
	        }
	        return correct;

    }

       

    static String[][] registrationFunction(String[][] dataBase, String[] userDetails){

        
        
        for (int i = 0; i < dataBase.length; i++){

    		if (dataBase[i][0] == null){

	            dataBase[i][0] = userDetails[0];
	
	            dataBase[i][1] = userDetails[1];
	
	            
	
	            System.out.println("Created an account");
	
	            break;

    		}		
        }
        return dataBase;
        

    }

    
    
    public void addAccount(String[] userDetails){
        //String[][] dataBase = fileReader();
        //dataBase = registrationFunction(dataBase, userDetails);
        //fileWrite(dataBase);
    	pleaseWork(userDetails);
        
    }
    
    public String[] checkAccount(){
        String[][] dataBase = fileReader();
        return loginFunction(dataBase);
    }
    
    public String[] listUsernames(){
        String[][] dataBase = fileReader();
        String[] listUsers = new String[dataBase.length];
        //String[] listUsers;
        
        for (int i = 0; i < dataBase.length; i++ ){
            if (dataBase[i][0] == null){
            
                break;
            }
            
            listUsers[i] = dataBase[i][0];
            
        }
        return listUsers;
    }

}





