package main;
import java.util.HashSet;
import java.util.Set;

public class Game {
    String type; 
    int target; 
    Player winner = new Player ("winningNickname");  
    double bestGuessDiff; 
    int mxValue; 
    Set<Player>players = new HashSet<>();
    
    public Game (String type, Set<Player>participants) {
        this.type = type;
        if (this.type.equals("Easy")) {
            this.mxValue = 20 ; 
            this.bestGuessDiff = 20;  
        }
        else if (this.type.equals("Medium")) {
            this.mxValue = 50 ;  
            this.bestGuessDiff = 50;
        }
        else {
            this.mxValue = 100 ; 
            this.bestGuessDiff = 100; 
        }
        if (this.type.equals("Easy")) {
            this.target = (int) (Math.random()*20);   
        }
        else if (this.type.equals("Medium")) {
            this.target = (int) (Math.random()*50); 
        }
        else {
            this.target = (int) (Math.random()*100); 
        }
        this.players = participants; 
    }

    public void gameIteration () {
        for (Player i : players) {
            i.judge (this);  
            if (i.guessDifference < bestGuessDiff) {
                winner = i; 
                bestGuessDiff = i.guessDifference; 
            }
        }
        if (bestGuessDiff == 0) {
            System.out.println ("player " + winner.nickName + " guessed the number correctly!"); 
            System.out.println ("Game is over with following scores : "); 
            //gameScoreboard(); 
        }
    }

    public void gameScoreboard () {
        for (Player i : players) {
            i.printInformation (); 
        }
    }
    
    public void currentWinner () {
        System.out.println ("The current Winner is " + winner.nickName + " with the guess difference of " + bestGuessDiff); 
    }
}