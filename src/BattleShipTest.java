
import java.util.Scanner;
public class BattleShipTest {

	
	public static void main(String[] args) {
	    Scanner keyboard=new Scanner(System.in);
	    System.out.println("what is the length(>=3and <=10) do you want to create a board");
	    
	    int k=keyboard.nextInt();
	    BattleShip newgame=new BattleShip(k);
	    
	    if(k<=4)
	    System.out.println("you have 1 ship and 1 mine");
	    else if(k<=6)
	    	System.out.println("you have 2 ships and 2 mines");
	    else if(k<=10)
	   	System.out.println("you have 3 ships and 3 mines");
	    	
	    
	    System.out.println("now game begins,you are not allowed to watch the picture above util you finsh the game!");
	    
	    newgame.displaylocation();
	    
	    boolean icheck=newgame.checkfinishgame();
	    while(icheck==false)
	    { System.out.println("now please enter the location you want to choose?");
	      System.out.print("the row(<="+k +"): ");
	      int row=keyboard.nextInt();
	      System.out.print("please enter the column(<="+k+"): ");
	      int column=keyboard.nextInt();
	      newgame.game(row, column);
	      icheck=newgame.checkfinishgame();
	      if(icheck==true)
	      { System.out.println("well done! you have sunk all the ships now");
	        System.out.println("you have spent "+newgame.getcounting()+" times to finish this game");
	        
	      }
	    }
}
}
