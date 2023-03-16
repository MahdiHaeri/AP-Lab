package models;

import java.util.ArrayList;

public class VotingSystem {
   private ArrayList<Voting> votingList;

   public VotingSystem() {

   }

   public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices) {
      Voting newVoting = new Voting(type, question, isAnonymous);
      
      for (String choice: choices) {
         newVoting.createChoice(choice);
      }

      votingList.add(newVoting);
   }
}