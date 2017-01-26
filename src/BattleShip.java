
public class BattleShip {
    private char[][] matrix;
    private int counting=0;
    
    private int length;
   
    private int[][] location;
    private int[][] finallocation;
   
    public BattleShip()
    {
	   
	   length=3;
	   matrix=new char[8][8];
	   location=new int[3][3];
	   
	   for(int i=0;i<3;i++)
	   for(int j=0;j<3;j++)
		   location[i][j]=0;
	     defineboard(3);
	     
	     finallocation=new int[length+4][length+4];
	     for(int i=0;i<finallocation.length;i++)
	     for(int j=0;j<finallocation[i].length;j++)
	    	 finallocation[i][j]=0;
	     
	     finallocation=changelocation(finallocation,location,3);
	     finalmatrix(finallocation,length);
	     
	  }   
	 
	   
  
   
    public BattleShip(int newlength)   // given a length, I need to use this method to be a constructor
     {    
        length=newlength;
        location=new int[length][length];
        
        matrix=new char[length+4][length+4];
        
        for(int i=0;i<length;i++)
        for(int j=0;j<length;j++)
            location[i][j]=0;
          
        defineboard(length);
        
        finallocation=new int[length+4][length+4];
        for(int i=0;i<finallocation.length;i++)
   	    for(int j=0;j<finallocation[i].length;j++)
   	    	 finallocation[i][j]=0;
        
        finallocation=changelocation(finallocation, location,length);
        finalmatrix(finallocation,length);
     }    	
        
    public int getcounting()// this is used to get how many times does this player spend finishing the game
    { return counting;}
    
   public void game(int i,int j)
   {   if(matrix[i+1][j+1]=='n')
         { counting++;
            
              System.out.print("nothing happening");
         }
       if(matrix[i+1][j+1]=='s')
       {
    	   counting++;
    	   matrix[i+1][j+1]='n';
    	   System.out.println("you hit it");
       }
	   if(matrix[i+1][j+1]=='m')
	   {   counting+=2;
	        System.out.println("what? you hit a mine!");
		   
	   }
	   
	   if(matrix[i+1][j+1]=='c')
	   {   counting++;
	       System.out.println("missed but close");
		   
	   }
       
	   //if(checkfinishgame())
	   //{   System.out.println("o ha, you have sunk all the ships! well done!");
	       //System.out.println("you spend "+counting+" times"+ " to finish the game");
	       
	   //}
   }
   

   
   public boolean checkfinishgame()// this is used to check whether the player have sunk all the ships
   {    boolean check=true;
        
        for(int i=0;i<matrix.length;i++)
        for(int j=0;j<matrix[i].length;j++)
        { if(matrix[i][j]=='s')
        	check=false;
        }	
        
	   
        return check;
   }
    
   
    public void finalmatrix(int[][] finalloc,int numlength)//this is used to transform multi-dimensional int array to multidimensional char array, so that we can use char array to check the matrix. 
    {   for(int i=0;i<length+4;i++)
    	for(int j=0;j<length+4;j++)
    	   {if(finalloc[i][j]==0)
    		   matrix[i][j]='n';
            if(finalloc[i][j]==3)
        	    matrix[i][j]='c';
    	    if(finalloc[i][j]==1)
    	    	matrix[i][j]='s';
    	    if(finalloc[i][j]==2)
    	    	matrix[i][j]='m';
    	   }
    	
    }
          
    public int[][] changelocation(int[][] finalloc, int[][] oldloc,int numlength)
    {    for(int i=0;i<numlength;i++)
    	  for(int j=0;j<numlength;j++)
    	  {
    		  finalloc[i+2][j+2]=oldloc[i][j];
    	  }
    
         for(int i=2;i<numlength+2;i++)
         for(int j=2;j<numlength+2;j++)
         {   if(finalloc[i][j-1]==1&&finalloc[i][j]==0)
        	    finalloc[i][j]=3;
             if(finalloc[i][j-2]==1&&finalloc[i][j]==0)
    	        finalloc[i][j]=3;
             if(finalloc[i-1][j]==1&&finalloc[i][j]==0)
            	 finalloc[i][j]=3;
             if(finalloc[i-2][j]==1&&finalloc[i][j]==0)
            	 finalloc[i][j]=3;
             if(finalloc[i][j+1]==1&&finalloc[i][j]==0)
            	 finalloc[i][j]=3;
             if(finalloc[i][j+2]==1&&finalloc[i][j]==0)
            	 finalloc[i][j]=3;
             if(finalloc[i+1][j]==1&&finalloc[i][j]==0)
            	 finalloc[i][j]=3;
             if(finalloc[i+2][j]==1&&finalloc[i][j]==0)
            	 finalloc[i][j]=3;
         }
         return finalloc;
    }
    
    
       
	   
   
   
  
   public void defineboard(int numlength) 
   {    
        
	    if((numlength==3)||(numlength==4))
	      { board34(numlength,location);
            fillmines(numlength);
            
	      }
        if(numlength>4&&numlength<=6)
        	{ board56(numlength);
        	  fillmines(numlength);
        	  fillmines(numlength);
        	}
	    if (numlength>=7)
	    	{ board7(numlength);
	          fillmines(numlength);
	          fillmines(numlength);
	          fillmines(numlength);
	    	}
	    	
   }
   
   public void fillmines(int numlength)
   {   int[] loc=new int[2];
        loc=Definelocationmines(numlength);
        int i=loc[0];
        int j=loc[1];
        while(location[i][j]==1)
        {
        	loc=Definelocationmines(numlength);
        	i=loc[0];
        	j=loc[1];
        }
        
        location[i][j]=2;
        
	   
   }
   
   public void board7(int numlength)//if the length is >=7, use this method to define the board.
   {   int[] loc=new int[2];
       loc=Definelocationships(numlength);
	   int i=loc[0];
	   int j=loc[1];
	   location[i][j]=1;
	   int random1;
	   int random2;
	   random1=Randominteger(4);
	   finishships(random1,i,j);
	   random2=Randominteger(4);
	   while (random1==random2)
	   {
		   
		   random2=Randominteger(4);
	   }
	   
	   finishships(random2,i,j);
	   int[] loc1=new int[2];
	   loc1=Definelocationships(numlength);
	   i=loc1[0];
	   j=loc1[1];
	   while(location[i][j]==1)
	   {
		   loc1=Definelocationships(numlength);
		   i=loc1[0];
		   j=loc1[1];
		   
	   }
	   location[i][j]=1;
	   
	   int count=0;
       
	   while(count<2)
       {   if(location[i][j-1]!=1)
       	   { location[i][j-1]=1;
                count++;
                }
       else if(location[i-1][j]!=1)
           {    location[i-1][j]=1;
           	  count++;
           	
           }
       else   if(location[i][j+1]!=1)
           {
           	location[i][j+1]=1;
           	count++;
           
           }
       	
       else  if(location[i+1][j]!=1)
           {location[i+1][j]=1;
             count++;
            
           }
       }
	   int[] loc2=new int[2];
	   loc2=Definelocationships(numlength);
	   i=loc2[0];
	   j=loc2[1];
	   while(location[i][j]==1||checkshiplocation(loc2,i,j)==false)
	   {
		   loc2=Definelocationships(numlength);
	       i=loc2[0];
	       j=loc2[1];
	   }
	   location[i][j]=1;
	   
	   count=0;
       while(count<2)
       {   if(location[i][j-1]!=1)
       	   { location[i][j-1]=1;
                count++;
                }
       else if(location[i-1][j]!=1)
           {    location[i-1][j]=1;
           	  count++;
           	 
           }
       else  if(location[i][j+1]!=1)
           {
           	location[i][j+1]=1;
           	count++;
           
           }
       	
       else  if(location[i+1][j]!=1)
           {location[i+1][j]=1;
             count++;
             
           }
       }
	   
	   
   }
   
   public boolean checkshiplocation(int[] a,int row,int column)
   {   boolean check=false;
       int i=row;
       int j=column;
       int count=0;
       if(location[i][j-1]==0)
          count++;
          
       
       if(location[i-1][j]==0)
    	   count++;
       if(location[i][j+1]==0)
    	   count++;
       if (location[i+1][j]==0)
    	   count++;
       if(count>=2)
    	   check=true;
       
       return check;
	   
   }
   public void board56(int numlength)//if the length of the matrix is 5 or 6, use this method to define the board.
   {   int[] loc=new int[2];
        loc=Definelocationships(numlength);
        int i=loc[0];
        int j=loc[1];
        location[i][j]=1;
        int random1;
        int random2;
        random1=Randominteger(4);
        random2=Randominteger(4);
        while(random1==random2)
        { random1=Randominteger(4);
          random2=Randominteger(4);
        }
        finishships(random1,i,j);
        finishships(random2,i,j);
        int[] loc1=new int[2];
        loc1=Definelocationships(numlength);
        i=loc1[0];
        j=loc1[1];
        while(location[i][j]==1)
        {   loc1=Definelocationships(numlength);
            i=loc1[0];
            j=loc1[1];
        }              	
        location[i][j]=1;
        int count=0;
        while(count<2)
        	
        {   if(location[i][j-1]!=1)
        	   { location[i][j-1]=1;
                 count++;
                 }
        else  if(location[i-1][j]!=1)
            {    location[i-1][j]=1;
            	  count++;
            	  
            }
        else   if(location[i][j+1]!=1)
            {
            	location[i][j+1]=1;
            	count++;
            	
            }
        	
        else   if(location[i+1][j]!=1)
            {location[i+1][j]=1;
              count++;
              
            }
        }
        
     }   
        
	   
  
   
   public void finishships(int random,int locationi, int locationj)
   {
	     int i=locationi;
	     int j=locationj;
	     if(random==0)
	    	 location[i][j-1]=1;
	     else if(random==1)
	    	 location[i-1][j]=1;
	     else if(random==2)
	    	 location[i][j+1]=1;
	     else if(random==3)
	    	 location[i+1][j]=1;
   }
   
   public void  board34(int numlength,int[][] location) // when the length =3or 4,we need to use this method to define ships.
   {   int randomnumber1;
       int randomnumber2;
       int[] loc=new int[2];
       randomnumber1=Randominteger(4);
       loc=Definelocationships(numlength);
       int i=loc[0];
       int j=loc[1];
       location[i][j]=1;
       if(randomnumber1==0)
      	 location[i][j-1]=1;
       else if(randomnumber1==1)
           location[i-1][j]=1;
       else if(randomnumber1==2)
      	 location[i][j+1]=1;
       else if(randomnumber1==3)
      	 location[i+1][j]=1;
       randomnumber2=Randominteger(4);
       while(randomnumber2==randomnumber1)
      	 randomnumber2=Randominteger(4);
       if(randomnumber2==0)
      	 location[i][j-1]=1;
       else if(randomnumber2==1)
           location[i-1][j]=1;
       else if(randomnumber2==2)
      	 location[i][j+1]=1;
       else if(randomnumber2==3)
      	 location[i+1][j]=1;
	   
   }
   
   
   public int[] Definelocationships(int numlength)//this is used to set the location of the ships
   {     int[] intarray=new int[2];
         int column;
         column=randomnumber(numlength);
         int row;
         row=randomnumber(numlength);
         intarray[0]=row;
         intarray[1]=column;
         return intarray;
   }      
	   
   
   
   
   public int[] Definelocationmines(int numlength)//this is used to set mines
   {    int column=0;
        column=Randominteger(numlength);
        int row=Randominteger(numlength);
        row=Randominteger(numlength);
        
        int[] x=new int[2];
        x[0]=row;
        x[1]=column;
        return x;
        
	   
   }
   
   
   public int randomnumber(int num)//used to return a random number between 1 and numlength-2;
   {
	   double x;
	   x=Math.random()*(num-2);
       int y=(int)Math.floor(x)+1;
         return y;
   }
   
   public int Randominteger(int numlength)//used to return the number between 0 and numlength-1;
   {   double x;
       x=Math.random()*numlength;
       int y=(int)Math.floor(x);
       return y;
	   
   }
   
    public void displaylocation()//used to display the location[][] I created
   {  for(int i=2;i<matrix.length-2;i++)
       { { for(int j=2;j<matrix[i].length-2;j++)
	        System.out.print(matrix[i][j]+" ");
	      }
          System.out.println();
	   
       }
	   
   }
}