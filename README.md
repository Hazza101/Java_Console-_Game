# Java Minesweeper console game

This was a university project to learn about java, software design and object oriented programming. It is a minesweeper game with users, different difficulties and a social media system.

## Features
- Create user and login
- play minesweeper
  - easy, medium and difficult options
- view leaderboard for minesweeper
- view, post and delete blogs
- add and remove friends

## How to Install

### Step by step

1. **Clone the repository**
   ```bash
   git clone https://github.com/Hazza101/Java_Console-_Game.git
   ```
2. **compile the program**
   ```bash
   cd src
   javac main.java -d ../bin
   cd ../bin
   java main
   ```

## Running the program

### Login and Menus

You can login or create a new user. Once logged in navigation is handled by a series of nested menus.

<img width="1427" height="755" alt="login-and-menu" src="https://github.com/user-attachments/assets/d08019a3-2f15-4e14-b575-6938cfe886a8" />

### Minesweeper

You play minesweeper by first choosing whether to place a flag or click on a spot. Then you specify your x and y coordinates.

<img width="1357" height="880" alt="minesweeper" src="https://github.com/user-attachments/assets/7baa4436-4ea7-4b1d-ab86-065b98a90e88" />

### Leaderboards

Leaderboards store users best time for each difficulty.

<img width="1306" height="617" alt="leaderboards" src="https://github.com/user-attachments/assets/d401cdbc-d28f-4055-b258-da3f50e90772" />

### Blogs

You can view, create and delete blog posts.

<img width="1895" height="794" alt="blogposts" src="https://github.com/user-attachments/assets/3d26585b-3c01-4977-af92-7c867fa6e8b4" />


## Folder structure

```text
├── files
|  ├── blog.txt
|  ├── database.txt
|  ├── friends.txt
|  └── java.txt
├── src
|  ├── real_Game
|  ├── real_leaderboard
|  ├── real_Login
|  ├── real_Menus
|  ├── real_Registration
|  ├── real_Social
|  └── main.java
├── filename.txt
├── java.txt
├── leaderboard.txt
└── README.md
```
## Future plans
- Clean up code
