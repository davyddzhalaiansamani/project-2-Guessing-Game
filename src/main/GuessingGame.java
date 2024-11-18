package main;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//fix the game(doesnt work with easy, first guess = 13); 
//return all of the winners
public class GuessingGame {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Hello and welcome to Davyd's Guessing Game"); 
        System.out.println("choose level of your game as well as number of players"); 
        System.out.println("then simply type start and let the guessing game begin");
        System.out.println("the instructions are simple, a number will be chosen");
        System.out.println("based on your guess, you will be rewarded with a score");
        System.out.println("the player with the highest score wins!!!");
        
        System.out.println("input your desired level of the game : ");
        String desiredLevel = scanner.nextLine(); 
        while (!desiredLevel.equals ( "Easy" ) && !desiredLevel.equals("Medium") && !desiredLevel.equals("Hard")) {
            System.out.println ("Error, invalid game level, try again : "); 
            desiredLevel = scanner.nextLine(); 
        }

        System.out.println("input your desired amount of players : ");
        int desiredAmountofPlayers = scanner.nextInt(); 
        scanner.nextLine(); 
        
        Set <Player> participantsOfTheGame = new HashSet <>(); 
        for (int i=0; i<desiredAmountofPlayers; i++) { 
            System.out.println ("input a nickname for player number " + (i+1)) ;
            String name = scanner.nextLine(); 
            Player pi = new Player (name);  
            participantsOfTheGame.add(pi); 
        }

        System.out.println ("All set, Ready when you are: ") ;
        Game g = new Game(desiredLevel,participantsOfTheGame); 
            while (true) { 
                for (Player i : g.players) {
                    System.out.println ("what's your guess " + i.nickName + " :" ); 
                    int guessedNumber = scanner.nextInt();
                    scanner.nextLine();  
                    i.generateGuess(guessedNumber);
                } 
                //System.out.println("fuck"); 
                g.gameIteration();
                //System.out.println("the target was " + g.target); 
                g.gameScoreboard();
                if (g.bestGuessDiff == 0) {
                    break; 
                }
                System.out.println ("would you like to continue ? (yes / no)"); 
                if (scanner.nextLine().equals("no")) {
                    System.out.println ("the winner is " + g.winner.nickName + " with the guess difference of " + g.winner.guessDifference); 
                    break; 
                }
            } 
        //}

        scanner.close(); 
    }   
}
