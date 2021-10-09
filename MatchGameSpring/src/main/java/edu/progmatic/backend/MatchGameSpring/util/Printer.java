package edu.progmatic.backend.MatchGameSpring.util;

import edu.progmatic.backend.MatchGameSpring.model.MatchBox;
import edu.progmatic.backend.MatchGameSpring.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Printer {
    MatchBox matchBox;

    @Autowired
    public Printer(MatchBox matchBox) {
        this.matchBox = matchBox;
    }

    public void printSetupMessage(){
        System.out.println("Setup player: press \"P\" for person or press \"R\" for robot ");
    }

    public void getNameMessage(){
        System.out.println("type in a name");
    }

    public void getStrategyMessage(){
        System.out.println("Setup robot: press \"R\" for random mode  \n" +
                         " \"O\" for one-by-one mode \n" +
                            "\"M\" for math mode");
    }

    public void printWinner(Player winner){
        System.out.println("Winner is: " + winner.toString());
    }

}
