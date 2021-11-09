import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Hangman{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner keyborad = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------");
        System.out.println("This is an Hangman Single/Multi player Game !!");
        System.out.println("This program is created by Mohammed Rasheed M");
        System.out.println("------------------------------------------------------------------");
        System.out.print("Single player(CPU) or Multiplayer(2 player) (1 or 2): ");
        String players = keyborad.nextLine();
        String word;
        if(players.equals("1")){
        Scanner sc = new Scanner(new File("words_alpha.txt"));
        List<String> words = new ArrayList<String>();
        while(sc.hasNext()){
            words.add(sc.nextLine());
        }
        Random rand = new Random();
        word = words.get(rand.nextInt(words.size()));
    }
    else{
        System.out.print("player 1, Please Enter the Word : ");
        word = keyborad.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Ready for the player 2! ");

    }
    
    
    //System.out.println(word);
        
        List<Character> playerGusses = new ArrayList<>();
        int wrongcount = 0;
        
        while(true){
            printHangedMan(wrongcount);
            if( wrongcount >= 6){
                System.out.println("sad !! You lose !!");
                System.out.println("The word was : "+word);
                break;
            }
            printWordState(word, playerGusses);
            if(!getPlayerGuess(keyborad, word, playerGusses)){
                wrongcount++;
            };
            
            if(printWordState(word, playerGusses)){
                System.out.println();
                System.out.println("Congratulations !! you won !!");
                break;
            };
            System.out.print("Please enter your guess for the word : ");
            if(keyborad.nextLine().equals(word)){
                System.out.println();
                System.out.println("Congratulations !! you won !!");
                break;
            }
            else{
                System.out.println("Nope !! try again !!");
            }
        }


    }

    private static void printHangedMan(int wrongcount) {
        System.out.println(" ------- ");
        System.out.println(" |     | ");
        if(wrongcount >= 1){
            System.out.println(" O");
        }
        if(wrongcount >= 2){
            System.out.print("\\ ");
            if(wrongcount >= 3){
                System.out.println("/");
            }
            else{
                System.out.println("");
            }
        }
        if(wrongcount >= 4){
            System.out.println(" |");
        }
        if(wrongcount >= 5){
            System.out.print("/ ");
            if(wrongcount >= 6){
                System.out.println("\\");
            }
            else{
                System.out.println("");
            }
        }
        System.out.println();
        System.out.println();
    }

    private static boolean getPlayerGuess(Scanner keyborad, String word, List<Character> playerGusses) {
        System.out.print("Please enter a letter : ");
        String letterguess = keyborad.nextLine();
        playerGusses.add(letterguess.charAt(0));
        
        return word.contains(letterguess);
    }

    private static boolean printWordState(String word, List<Character> playerGusses) {
        int correctcount = 0;
        for(int i = 0; i<word.length();i++){
            if(playerGusses.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                correctcount++;
            }
            else{
                System.out.print("-");
            }
        }
        System.out.println();
        return(word.length() == correctcount);
    }
}
