import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class TicTacToe{
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe game !!!");
        System.out.println("This program is created By Rasheed M !!");
        char [][] gameBoard = {{' ','|',' ','|', ' '}, 
        {'-','+','-','+', '-'},
        {' ','|',' ','|', ' '},
        {'-','+','-','+', '-'},
        {' ','|',' ','|', ' '}};
        printing_board(gameBoard);
       while(true){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the position from 1-9 : ");
        int player_pos = sc.nextInt();
        while(playerPositions.contains(player_pos)||cpuPositions.contains(playerPositions)){
            System.out.print("Position Taken !!! Enter the correct postion ");
            player_pos = sc.nextInt();
        }
        placing(gameBoard, player_pos, "PLAYER");
        String winner_game = winner();
        if(winner_game.length() > 0){
            System.out.println(winner_game);
            break;
        }
        Random rand = new Random();
        int cpu_pos = rand.nextInt(9)+1;
        while(playerPositions.contains(cpu_pos)||cpuPositions.contains(cpu_pos)){
            cpu_pos = rand.nextInt(9)+1;
        }
        placing(gameBoard, cpu_pos, "CPU");
        printing_board(gameBoard);
        winner_game = winner();
        if(winner_game.length() > 0){
            System.out.println(winner_game);
            break;
        }
    }
    }
    public static void printing_board(char[][] gameBoard) {
        for(char[] row : gameBoard){
            for(char col : row){
                System.out.print(col);
            }
            System.out.println();
            }
        }  
    

    public  static void placing(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if(user.equals("PLAYER")){
            symbol = 'X';
            playerPositions.add(pos);
        }else if(user.equals("CPU")){
            symbol = 'O';
            cpuPositions.add(pos);
        }
        
        switch(pos){
            case 1 :
                gameBoard[0][0] = symbol;
                break;
            case 2 :
                gameBoard[0][2] = symbol;
                break;
            case 3 :
                gameBoard[0][4] = symbol;
                break;
            case 4 :
                gameBoard[2][0] = symbol;
                break;
            case 5 :
                gameBoard[2][2] = symbol;
                break;
            case 6 :
                gameBoard[2][4] = symbol;
                break;
            case 7 :
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9 :
                gameBoard[4][4] = symbol;
                break;
            default :
                break;
        }
    }


    public static String winner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftcol = Arrays.asList(1, 4, 7);
        List midcol = Arrays.asList(2, 5, 8);
        List rightcol = Arrays.asList(3, 6, 9);
        List diag1 = Arrays.asList(1, 5, 9);
        List diag2 = Arrays.asList(3, 5, 7);
        List<List> winningCondition = new ArrayList<List>();
        winningCondition.add(topRow);
        winningCondition.add(midRow);
        winningCondition.add(botRow);
        winningCondition.add(leftcol);
        winningCondition.add(midcol);
        winningCondition.add(rightcol);
        winningCondition.add(diag1);
        winningCondition.add(diag2);
        for(List l: winningCondition){
            if(playerPositions.containsAll(l)){
                return "Congratulations you won !";
            }else if(cpuPositions.containsAll(l)){
                return "CPU wins";
            }else if(playerPositions.size() + cpuPositions.size() == 9){
                return "Its a tie !!!";
            }
        }
        return "";
    }
}
