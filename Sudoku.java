public class Sudoku {

    public static void main(String[] args)
    {

//initialize 2D Array
   int arr[][]= {  {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		   		   {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		   		   {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		   		   {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		   		   {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		   		   {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		   		   {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		   		   {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		   		   {0, 0, 5, 2, 0, 6, 3, 0, 0} };
   
   				System.out.println("\t GIVEN PROBLEM ");
			    print_initial(arr, arr.length);
			    sudoku(arr);
			    System.out.println();
			    System.out.println();
			    System.out.print("\t    SOLUTION       ");
			    print(arr, arr.length);
    }


     public static int[] Unassigned(int[][] arr)
     {
        int[] ra = new int[2];//getting the position of first unassigned position
        ra[0] = -1;
        ra[1] = -1;

        for (int row = 0; row < arr.length; row++) 
        {
            for (int col = 0; col < arr.length; col++)
            {
                if (arr[row][col] == 0) 
                {
                    ra[0] = row;
                    ra[1] = col;
                    return ra;
                }
            }
        }

        return ra;

    }
//checks for occurrence of number in Row
    public static boolean usedInRow(int[][] grid, int row, int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == num) {
                return true;
            }
        }
        return false;
    }
//checks for occurrence of number in Coloumn
    public static boolean usedIncol(int[][] grid, int col, int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == num) {
                return true;
            }
        }
        return false;
    }
  
    //checks for occurrence of number in box
    public static boolean usedInBox(int[][] grid, int row1Start, int col1Start, int num) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (grid[row + row1Start][col + col1Start] == num) {
                    return true;
                }
        return false; 
    }  
    
    
//checks for above three condition and returns true if number is not present in all cases
public static boolean Verify(int[][] grid, int row, int col, int num) 
{

    return (!usedIncol(grid, col, num) && !usedInRow(grid, row, num) && !usedInBox(grid, row - row % 3, col - col % 3, num));

}

	public static boolean sudoku(int[][] grid)//actual work is done in this
    {
        int[] ra = Unassigned(grid);
        if (ra[0] == -1)
        {
            return true;
        }

        int row = ra[0];
        int col = ra[1];

        for (int num = 1; num <= 9; num++)
        {
            if (Verify(grid, row, col, num)) 
            {
                grid[row][col] = num;
                boolean check = sudoku(grid);
                if (check == true)
                {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }
    public static void print_initial(int[][] arr, int N){// prints the sudoku
        for (int i = 0; i < N; i++) {
        	if(i==0)
        	{
        		System.out.println("------------------------------- ");
        	}
        	else if (i % 3 == 0  ) 
            {
            	System.out.println("----------|---------|---------");
            }
            for (int j = 0; j < N; j++)
            {	
            	if (j % 3 == 0) {
                    System.out.print("|");
                }
                if(arr[i][j]==0){
                    System.out.print(" " + "-" + " ");
                }
                else 
                {
                    System.out.print(" " + arr[i][j] + " ");
                }

            }
            
            
            	System.out.print("|");
            
              System.out.println();
        }
        System.out.print("------------------------------- ");

    }
 
    public static void print(int[][] arr, int N) {
    	System.out.println();// prints the Sudoku
        for (int i = 0; i < N; i++) {
        	if(i==0)
        	{
        		System.out.println("------------------------------- ");
        	}
        	else if (i % 3 == 0 && i != 0) {
                System.out.println("----------|---------|---------");
        }
            for (int j = 0; j < N; j++) 
            {
            		if (j % 3 == 0)
            		{	
                    System.out.print("|");
                    }
                    System.out.print(" " + arr[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print("------------------------------- ");

    } 
}

