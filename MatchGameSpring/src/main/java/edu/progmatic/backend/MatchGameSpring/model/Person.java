package edu.progmatic.backend.MatchGameSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Scanner;

@AllArgsConstructor
public class Person implements Player{
    @Getter
    private String name;

    public Person() {
    }

   public int pickSomeMatches(MatchBox matchBox){
        int pick;

           Scanner scanner = new Scanner(System.in);
       System.out.println(this + ", enter your pick (1, 2 or 3)");
           pick = scanner.nextInt();
           if (!matchBox.getAllowedPicks().contains(pick)){
               System.out.println("Your pick is not in the allowed interval");
               System.out.println("Try again!");
               return pickSomeMatches(matchBox);
           }

           if (pick > matchBox.getCurrentNumOfMatches()){
               System.out.println("Your pick is too high, there are no enough matches left");
               System.out.println("Try again!");
               return pickSomeMatches(matchBox);
           }

        return pick;





   }

    @Override
    public String toString() {
        return name;
    }


}
