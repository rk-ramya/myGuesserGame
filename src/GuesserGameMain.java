
import java.util.Scanner;

class Guesser {
	int guessNum;
	
	int guessNum(){
		Scanner sc=new Scanner(System.in);
		System.out.println("[[Guesser]] Kindly guess the number");
		
		do {
			System.out.println("Number should be less than 999");
		    guessNum=sc.nextInt();
		}while(guessNum>=1000);
		return (guessNum);
	}
}


class Player{
	int guessNum;
	
	int guessNum(int i,int flag){
		Scanner sc=new Scanner(System.in);
		System.out.println("\n[[Player "+ (i+1)+"]] Kindly guess the number (Score=10 points)");
		
		if(flag==0)
			System.out.println("enter -1 for hint(minus 5 points)");
		do {
			System.out.println("number should be less than 999");
			guessNum=sc.nextInt();
			}while(guessNum>=1000);
			return (guessNum);
	}
}


class GuesserGameMain{
	
	int numFromGuesser;
	int[] numFromPlayer;
	int[] hintsFlag;
	int[] result;
	int numPlayers;
	int round;
	void collectNumFromGuesser() {
		Guesser gs=new Guesser();
		numFromGuesser=gs.guessNum();
	}
	
	int[] collectNumFromPlayers(int round) {
	
		Scanner sc=new Scanner(System.in);
		if(numPlayers==0) {
			do {
			System.out.println("Enter the number of players(atleast 2 players):");
			numPlayers=sc.nextInt();
			}while(numPlayers<=1);
		}
		Player[] players=new Player[numPlayers];
		numFromPlayer=new int[numPlayers];
		hintsFlag=new int[numPlayers];
		for(int i=0;i<numPlayers;i++) {
			players[i]=new Player();
			numFromPlayer[i]=players[i].guessNum(i,0);
			hintsFlag[i]=0;
			if(numFromPlayer[i]==-1) {
				playerHints(numFromGuesser);
				do {
				System.out.println("\nHint already used! ");
				hintsFlag[i]=1;
				numFromPlayer[i]=players[i].guessNum(i,1);
				}while(numFromPlayer[i]==-1);
		}
		}


		return findWinner(numPlayers,hintsFlag,round);
		}
	
	
	 int[] findWinner(int n,int[] hints_flag,int round) {
		result=new int[n];
		int i=0;
		while(i<n) {
			if(numFromPlayer[i]==numFromGuesser&& hints_flag[i]==1) {
			result[i]+=5;
			i++;
        	}
		else if(numFromPlayer[i]==numFromGuesser&& hints_flag[i]==0) {
			result[i]+=10;
			i++;
        	}
		else{
			result[i]+=0;
			i++;
        	}
			
		}
		System.out.println("\n**********ROUND "+round+" SCORE BOARD*************");
		for(i=0;i<result.length;i++)
			System.out.print("Player "+(i+1) +" Score: "+result[i]+"\n");
		System.out.println("\n***************************************");
		
		return result;
		
	}

    
    
	void playerHints(int n) {
       int flag=0;
	   int noOfDigits=(n/10==0)?1:((n/100==0)?2:(n/1000==0?3:-1));
	   
	   do {
		   int hintRandom= (int) (Math.random()*6); 
		   flag=0;
		   switch(hintRandom) {
		   case 1: if(!provideHints(n)||noOfDigits==1) {
			          flag=1;
			          break;
		                }
	 		        System.out.println("Hint::It is "+noOfDigits+"-digit palindrome number");
	 		        break;
		   case 2:  if(!provideHints(n,noOfDigits)){
			          flag=1;
			          break;
		             }
			     System.out.println("Hint::It is "+noOfDigits+"-digit ODD NUMBER");
			      break;
			      
		   case 3:  if(!provideHints(n,"isEven?")){
		          flag=1;
		          break;
	              }
			      System.out.println("Hint::It is "+noOfDigits+"-digit EVEN NUMBER");
			      break;
			      
		   case 4: if(!(n>0&&n<50)){
		          flag=1;
		          break;
	              }
			      System.out.println("Hint::It is digit below 50");
			      break;
			      
		   case 5: if(!(n>=50&&n<100)){
		          flag=1;
		          break;
	               }
			       System.out.println("Hint::It is digit between 50-100");
			       break;
			       
		   default: if(!(n>=100&&n<200)){
		           flag=1;
		           break;
	               }
			       System.out.println("Hint::It is digit between 100-200");   
		           break;
		   } 
	   }while(flag==1);
	   
	}
	
	boolean provideHints(int n) {
		int r,sum=0,temp;    		  
		  temp=n;    
		  while(n>0){    
		   r=n%10;
		   sum=(sum*10)+r;    
		   n=n/10;    
		  }    
		  if(temp==sum)    
		   return true; 
		  else    
		   return false;
		}   

	boolean provideHints(int n,int noOfDigits) {
		return (n%2==0)?false:true;
	}
	
	boolean provideHints(int n,String res) {
		return (n%2!=0)?false:true;
	}
	
	
void printResults(int[] finalResults) {	

	int i,playerWon=0,drawFlag=0;
	int n=finalResults.length;
	int playersDraw[]=new int[n];
	for(i=1;i<finalResults.length;i++) 
		if(finalResults[i]>finalResults[playerWon])
			playerWon=i;
		
	for(i=0;i<finalResults.length;i++) {
		if(finalResults[i]==finalResults[playerWon]&&finalResults[i]>0&& i!=playerWon) {
			playersDraw[i]=-1;
			playersDraw[playerWon]=-1;
			drawFlag=1;
		}
	}
	

		if(drawFlag==1) {
			System.out.println("RESULTS ===>GAME DRAW between : ");
		    for(int k=0;k<playersDraw.length;k++)
		    	if(playersDraw[k]==-1)
		    	   System.out.print("Player "+(k+1)+ " ,");
		}
		else if(finalResults[playerWon]!=0)
		  System.out.print("\n ==> CONGRATULATIONS!! Player "+(playerWon+1)+" won the game!!");
		else
			System.out.println("All players lost the game,better luck next time!!");
		
	
}

	public static void main(String args[]) {
		GuesserGameMain obj=new GuesserGameMain();
		Scanner sc=new Scanner(System.in);
		int[] result,result1=null,resultfinal = null;
		int rematch=0;
		System.out.println("~~~~~~~~~~WELCOME TO GUESSER GAME~~~~~~~~~~~~\n");
		
		int rounds=1;
		do {
	       while(rounds<3) {
	    	   System.out.println("---------Round "+rounds+" BEGINS--------");
				obj.collectNumFromGuesser();
				result=obj.collectNumFromPlayers(rounds);
				if(rounds==1)
					result1=result;	
				if(rounds==2) {
					obj.numPlayers=result.length;
					resultfinal=new int[result.length];
					for(int i=0;i<result.length;i++)
					  resultfinal[i]=result[i]+result1[i];
			}
			rounds++;	
	      }
			System.out.println("\n%%%%%%%%%% FINAL SCORE BOARD%%%%%%%%%%%%");
			for(int i=0;i<resultfinal.length;i++)
				System.out.print("Player "+(i+1) +" Score: "+resultfinal[i]+"\n");
			System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			obj.printResults(resultfinal);
			System.out.println("\n\n[[Enter 1 for re-match, anyother key to quit]]");
			rematch=sc.nextInt();
			if(rematch==1) 
				rounds=1;
		}while(rematch==1);
		System.out.println("****Game Exit::Until next time!!********");
		sc.close();
	}

}
