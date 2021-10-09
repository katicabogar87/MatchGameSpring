package edu.progmatic.backend.MatchGameSpring.module;



import edu.progmatic.backend.MatchGameSpring.model.MatchBox;
import edu.progmatic.backend.MatchGameSpring.model.Player;
import edu.progmatic.backend.MatchGameSpring.util.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Controller {


    MatchBox matchBox;
    SettingsManager settingsManager;
    Printer printer;

    private List<Player> players = new ArrayList<>();

    @Autowired
    public Controller(MatchBox matchBox, SettingsManager settingsManager, Printer printer ) {
        this.matchBox = matchBox;
        this.settingsManager = settingsManager;
        this.printer = printer;

        Player player1 = settingsManager.setupPlayer();
        Player player2 = settingsManager.setupPlayer();

        players = List.of(player1, player2);


        printer.printWinner(playGame());

    }

    public Player playGame(){
        System.out.println("Let's start the game.");
        System.out.println("There are "+ matchBox.getCurrentNumOfMatches() + " matches on the table");
        Player winner = null;
       while (winner==null){
           for (Player player:players) {
               int pick = player.pickSomeMatches(matchBox);
               System.out.println(player + "'s pick: "+pick);
               matchBox.decrementCurrentNumOfMatches(pick);
               System.out.println("Remaining matches: "+matchBox.getCurrentNumOfMatches());
               if(matchBox.getCurrentNumOfMatches()==1){winner = player;}
               else
               if(matchBox.getCurrentNumOfMatches()==0){
                   for (Player currentPlayer:players) {
                       if(!currentPlayer.equals(player)){
                           winner = currentPlayer;
                       }
                   }
               }
           }
       }


        return winner;
    }

    public int pickStarter(){
        Player winner = null;
        int num =  (int)(Math.random() * (100)) + 1;

        return num%2;
    }


}
