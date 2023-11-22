# Java_Console-_Game

SID 2217262


Important

reminder some file paths won't work unless you unzip this "mineSweeper" folder to "C:\Java\. This is because only absolute file paths worked on my PC. 
You can either rename the file references in the code or unzip to C:\Java\. Sorry for the inconvience. 

About livebrief one:
	My individual project differs from the one designed in the group project.
	My java project is based on the "coding task" section within 010 assigment.
	There is a list of requirements such as a leaderboard, gamertype  quiz which I have completed.
	I think there was a fundamental misunderstanding on my behalf. I understood(until too late) the individual
	projects to be seperate from the group projects as the "requirements" on assigment 010 canvas page
	seemed to be talking about very different projects. I took "base java project" on module 011 canvas page to mean
	the coding task described in assigment 010.

How the application works:
	when running the application, you will encounter a homepage with the option to login or register. You should choose register
	because otherwise you have no account to login in with. Once you enter your username and password you will be asked a series of
	questions to help determine your gamertype. This is saved as a number but unfortunatley, it is not integrated into the friends 
	section of the game. Afterwards you can login in with the username and password you just created. Here there are several options 
	to choose from. "minesweeper" option takes you to a menu where you can play 3 different difficulties of the game.
	If you select a difficulty, you will be shown an empty grid and asked to enter a 0 or 1(first round this number doesn't matter). 
	0 if you want to select a coordinate like normal and 1 if you want to flag a coordinate. Afterwards you have to enter the x_coordinate 
	which corresponds to the row and then the y_coordinate which corresponds to the column. (don't try to enter all these values on the same line).
	It will show you an updated map with the information(like regular minesweeper). And repeat the part above. This time it matters whether you enter
	a 0 or a 1 for the first question. There is a cheat code built in because I know it is tedious to complete an entire game. When the game asks for 
	a 0 or a 1 please enter 99, and then enter random x_cords and y_cords(aslong as they are in range). This will solve the game for you and give you 
	a score. Go back to "Homepage2" after this. You can check you score on the leaderboard option. Please select the corresponding leaderboard to 
	the difficulty you just played(otherwise you won't see your score). Pressing 'b' takes you to the social blog. Here anyone can post
	messages, like a groupchat with everyone in the game. There will be some random messages in there already from people who tested
	the application. "seePublic" let's you see the message board. "addPublic" allows you to add a new message. This message can be multi-line.
	When you've written the last line, press enter then type 0 then press enter again to save the file.(only way I could find to do multi-line 
	user input). Selecting "deletePublic" allows you to remove one of your previous messages with the ID-number next to your username.
	The last section is 'c', the friends section. options 'a', 'b' and 'c' in the friend section don't work at the moment. I was hoping to add
	private-messaging between just 2 friends. I did most of the heavylifting in my code but ran out of time to implement it properly(You can see
	how I planned to implement it in package:real_Social class:ingameMessage). Options 'd', 'e', 'f' are self-explanatory.
	There is one unfinished bug. You can add friends that don't exist in the game. If you type any name "addfriends" 
	it will add it to your friend list. To exit each menu just type x. You can just type 'x' until the program ends.


Other notes:
	unfortunately some aspects of my code don't follow Java conventions. This was a mixture of naivety on my part and being new to classes.
	There is also a large lack of comments in my actual code. Because I challenge myself to try and make my code as readable as possible.
	It is one of my weaknesses(lack of comments ) and I hope I can really improve it soon.
	The rough idea of my code is that I created 5 main classes which are all indpendent (mainGame.java, loginClass.java, registration.java, leaderboard.java
	(friendlist.java, ingameMessage.java)). Then i created a package(real_Menus) containing four classes (blogMenu.java, friendMenu.java,
	leaderboardMenu.java, minesweeperMenu.java) that allow the 5 main classes to interface and share attributes with eachother.  
    	These 4 classes are used in 'main.java'. Which creates the inital homepage and the 'Homepage 2' which you access after you correctly login.
	The last thing to explain are the textfiles used to store userdata. 'blog.txt' is where I store the public messages people post with their name
	and message ID. 'Java.txt' stores the leaderboard highscores with the name of the user( lower time is better however). 'friends.txt' stores username
	, gamertype(as a number from 1 to 4) and the usernames of each users friends. 'database.txt' stores the username and password for every user.

reminder some file paths won't work unless you unzip this "mineSweeper" folder to "C:\Java\. This is because only absolute file paths worked on my PC. 
