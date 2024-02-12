import java.util.*;

class Task_1
{
    public static void main(String[] args)
    {
      Scanner obj=new Scanner(System.in);
      
      

    int ans=1;
    do
    {
      TicTacToe t=new TicTacToe();
      t.display_board();
      HumanPlayer p1=new HumanPlayer("Krishna",'X');
      HumanPlayer p2=new HumanPlayer("Vaishnavi",'O');

      HumanPlayer cp;
      cp=p1;

      while(true)
      {
      System.out.println(cp.name + "'s turn.");
      cp.makeMove();
      TicTacToe.display_board();
      if(TicTacToe.checkColwin() || TicTacToe.checkRowwin() || TicTacToe.checkDiagonalwin())
      {
        System.out.println(cp.name + " win's the game!!");
        break;
      }
      else
      {
        if(cp==p1)
        {
          cp=p2;
        }
        else
        {
          cp=p1;
        }
      }
      }
      System.out.println("Enter 1 if you want to play again else 0:");
      ans=obj.nextInt();

    }while(ans==1);
  }
}

class TicTacToe
{
       static char board[][];

       public TicTacToe()
       {
           board = new char[3][3];
           initBoard();
       }

       void initBoard()
       {
            for(int i=0;i<board.length;i++)
            {
                  for(int j=0;j<board.length;j++)
                  {
                    board[i][j]=' ';
                  }
            }
       }

      static void display_board()
       {
        System.out.println("-------------");
        for(int i=0;i<board.length;i++)
        {
            System.out.print("| ");
              for(int j=0;j<board[i].length;j++)
              {
                 System.out.print(board[i][j] +" | ");
              }

              System.out.println();
              System.out.println("-------------");
        }
       }

      static void placeMark(int row,int col,char mark)
       {
          if(row>=0 && row<=2 && col>=0 && col<=2)
          {
            board[row][col]=mark;
          }
          else
          {
            System.out.println("Invalid position");
          }
       }

      static boolean checkColwin()
       {
        for(int j=0;j<=2;j++)
        {
            if(board[0][j]!=' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
            return true;
        }
        return false;
       }

       static boolean checkRowwin()
       {
        for(int i=0;i<=2;i++)
        {
            if(board[i][0]!=' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
            return true;
        }
        return false;
       }

      static boolean checkDiagonalwin()
       {
        for(int i=0;i<=2;i++)
        {
            if(board[0][0]!=' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] ||board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
            return true;
        }
        return false;
       }
}

class HumanPlayer
{
  String name;
  char mark;

  HumanPlayer(String name,char mark)
  {
       this.name=name;
       this.mark=mark;
  }

  void makeMove()
  {
      Scanner sc=new Scanner(System.in);
      int row;
      int col;

      do{
        System.out.println("enter the row and col:");
        row=sc.nextInt();
        col=sc.nextInt();
      }while(!isValidMove(row, col));

      TicTacToe.placeMark(row, col, mark);

  }

  boolean isValidMove(int row,int col)
  {
    if(row>=0 && row<=2 && col>=0 && col<=2)
    {
      if(TicTacToe.board[row][col]==' ')
      {
        return true;
      }
    }
    return false;
  }
}