package edu.progmatic.backend.MatchGameSpring.module;

import edu.progmatic.backend.MatchGameSpring.model.Person;
import edu.progmatic.backend.MatchGameSpring.model.Player;
import edu.progmatic.backend.MatchGameSpring.model.Robot;
import edu.progmatic.backend.MatchGameSpring.model.Strategy;
import edu.progmatic.backend.MatchGameSpring.util.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SettingsManager {
    Printer printer;

    @Autowired
    public SettingsManager(Printer printer) {
        this.printer = printer;
    }


    public Player setupPlayer(){

        Scanner scanner = new Scanner(System.in);
        printer.printSetupMessage();
        String letter = scanner.next();
        printer.getNameMessage();
        String name = scanner.next();
        switch (letter.toLowerCase()){
        case "p" :
            return  new Person(name);

        case "r" : {
            Robot robot = new Robot(name);

            printer.getStrategyMessage();
            String letter2 = scanner.next();
            switch (letter2.toLowerCase()){
            case "r": robot.setStrategy(Strategy.RANDOM);
                return robot;
            case "o": robot.setStrategy(Strategy.ONE_BY_ONE);
                return robot;
            case "m": robot.setStrategy(Strategy.MATH);
                return robot;
            }
        }
        }
        return null;
    }


}
