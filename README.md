# Implementation of the Guesser Game using JAVA

## Game Features:
1. The Guesser will be allowed to guess a number between 0 to 999.
2. The number of players will be selected in the next step.
3. There will a total of 2 rounds - the highest scorer of both rounds will be declared winner by the Umpire.
4. The score for each question right is 10.[ No negative marking for wrong guesses]
5. Players can avail hints at the cost of 5 points.
6. Score boards will be announced at each round and at the end of game with players against the scored earned.
7. Winners having a draw will be identified and announced.
8. In case, all players getting wrong guesses, none of them will be declared winners. 
9. Players can opt for rematch or quit.


## Game Flowchart:
<img width="2000" height="530" alt="GuesserGameFlowchart" src="https://user-images.githubusercontent.com/116821018/201100888-433430cc-1996-40a8-8bf5-e14c488e3c56.png">

## Some of the JAVA concepts used to implement the features:
1. Multiplayer concept using **Array of objects** for player class.
2. **Nested Loops** for various looping tasks like rematch option, checking if number below 1000,etc   
3. **Switch Case** used in hints option for executing the right case according to the guesser's number.
4. **Method overloading** used in hints option by having same method name for all hints and executing the appropriate one during compile-time based on parameters.
5. **Scanner class** used for taking inputs like guesser's number, player's number,other respective options.
6. **Nested Ternary operators**  incorporated while calculating the no. of digits in the guessed numbers,calculating the type of number, etc.
7. **String in-built functions** for string related condition checks and operations 
8. **Class and Object**  Guesser, umpire and players encapsulated as individual classes and objects instantiated to invoke their properties and methods. 


## Edge conditions tested:
1. Ensuring the player uses hint only once by displayed 'hint already used' message when attempting to use it again.
2. Detecting if multiple players won same score and if it is the highest (and checking if the score is not 0), declare GAME DRAW.
3. Checking if the number if less than 1000 and  if a number greater is entered, taking a new number repeatedly until this condition satisfies.
4. Storing the score of first round and Calculating the highest of scores of both rounds for declaring the winner.
5. The edge case of all players giving wrong guesses is taken into consideration.
6. Players who have used the hints in each round will be stored and will have minus 5 points which is used appropriately to calculate the score.
7. Atleast 2 players should be participating in the game. 

## Output Snaps:

<img width="369" alt="image" src="https://user-images.githubusercontent.com/116821018/200372922-0abe23cb-29fd-4e72-ac52-8ad7f8f5743f.png">
<img width="385" alt="image" src="https://user-images.githubusercontent.com/116821018/200373650-ee9befbc-62ad-46a7-84a6-1a253cea6838.png">

<img width="350" alt="image" src="https://user-images.githubusercontent.com/116821018/200373666-3a455e68-4a06-4b58-9543-6f9408de0d87.png">



