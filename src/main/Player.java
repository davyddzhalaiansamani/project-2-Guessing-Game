package main;
public class Player {
    int currentGuess; 
    String score; 
    String nickName; 
    double guessDifference;
    
    public Player (String name){
        this.nickName = name;  
    }

    public void generateGuess (int guessValue) {
        this.currentGuess =  guessValue; 
    }

    public void judge (Game a) {
        double diff = (double)a.target - (double)this.currentGuess; 
        if (diff > 0) {this.score = ("too low"); } 
        if (diff < 0) {this.score = ("too high"); } 
        if (diff == 0) {this.score = ("right on"); } 
        this.guessDifference = Math.abs (diff); 
    }

    public void printInformation () {
        System.out.println (this.nickName + "'s guess was " + this.score ); 
    }
}