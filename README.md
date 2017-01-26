# JavaProgram
programs are written in other branches!

The Game Basics and Its Representation

Here's a list of the features that your game should have:

The rectangular game board (must be represented in your program as a 2-dimensional array) is sized by the user at the start of a game.
A ship will consist of three consecutive (vertical or horizontal, but not diagonal) board locations chosen randomly by your program at start-up. The locations of the ships will be indicated in the 2-dimensional array.  Be careful that ships do not get positioned partially off the board!  See item 4 below for the number of ships to include.
In addition to the hidden ships, there should also be randomly placed mines on the board. If the user hits a mine, the user will get a message that a mine exploded and the user will be charged an extra turn.  Be sure that mines and ships are not placed in the same board locations!  See the next item for the number of mines to include.
The board size is minimally 3 X 3 (9 locations), and the maximum size is 10 X 10 (100 locations). For board sizes containing between 9 and 16 locations, 1 ship and 1 mine should be hidden, for board sizes containing between 17 and 36 locations, 2 ships and 2 mines should be hidden, and for board sizes containing more than 36 locations, 3 ships and three mines should be hidden.
The user should be told how many ships are hidden once the board dimensions are entered by the user, but the locations are not revealed to the user.
The user is given as many chances as needed to locate and sink the ships.  However, the objective is to sink the ships in as few moves as possible.
On each turn, the user should enter a set of board coordinates. If the location specified by the coordinates entered is occupied by a ship, this is considered a "hit." If the coordinates do not correspond to a location that is occupied by a ship, the turn is a "miss." 
A ship is sunk when all three of the ship's (consecutive) board locations have been selected ("hit") by the user. The game is over when all ships have been sunk.
The program should keep score by tracking the total number of attempts it takes until the ships are sunk. If the user selects the same coordinates more than once, each subsequent selection of previously selected coordinates counts as two turns instead of one (because it is a waste of ammunition). 
For example: if the player targets (5,5), it counts as 1 turn. But if the player targets (5,5) again during the game, it counts as 2 turns each time (after the first) it is targeted.  In addition, if the user hits a mine, it counts as 2 turns because there is a one-turn penalty for hitting a mine.
After each turn, the program should notify the user of hit/miss, a redundant strike, and total score so far. Like in golf, lower scores are better.
There needs to be a “test/debug” mode that can be selected by the user at the start of the game.  If in test/debug mode, the board will be displayed along with the ship and mine locations at the start of each game  Normally, this information is hidden from the user, but for testing and debugging purposes it is necessary to see where the ships and mines are located in order to verify that the program is working correctly.  An optional enhancement is to include a verbose mode where the board configuration is displayed after each “hit” (not miss) to show how the hit was represented on the ship.
Finally, when the ships are eventually sunk, the program must indicate that the game is over and show the final score (based on number of guesses as explained above). A nice additional feature (not required) is to ask the use if he would like to play again after the game is over by entering "yes" or "no."

Additional Implementation Requirements and Some Hints

At each turn within a game, the user will be prompted to enter a row and a column, and given a chance to enter them. You should do error checking to see if the coordinates are within the game board, but no other validation is needed. Assume that the input will be two integers, example: "1 5" is entered by the player. (You've done this in the labs before.). It is up to you to decide how you will use the array to represent to represent the board.  How will you use the game board array represent a ship, a hit, and a mine?  Will the user will enter coordinates that begin from 0..n-1 or 1..n. Please mention in the program greeting what the corner coordinates are.  For example, "The upper left coordinates in my awesome battleship game are (1,1), so enter moves between (1, 1) and (n, n).”
After each turn, your program should give an additional hint to the user in the following situations:
If a shot is within 1 square (1 location) in either direction, but not diagonal, of a part of a ship, print: "A Miss, but Very Close"
If a shot is within 2 squares in either direction, but not diagonal, of a part of a ship, print: "A Miss, but Close” Here is an illustration:
                        (The ship is labelled with 's', hits within one location are labeled as 'a', and hits within two locations are labeled as 'c')





Hint: Create a BattleShipBoard class that has a constructor that builds the board and completes all moves. But, leave I/O and user inputer to a main driver program.
Hint: The BattleShipBoard(m, n) constructor should initialize the board (of size m x n) and place the ships. Should there be a default constructor? If so, what should it do?
Hint: Use the same 2-dimensional array to keep track of hits, misses, and duplicate attack locations in addition to the ship locations.
Hint: Other than the 2-dimensional array, very few additional variables should be required to keep track of the game state. But, a point total variable should be maintained.
Note: Your final version of the project should be in such a way that clicking the run button in Eclipse would allow us to play your epic battleship game.
