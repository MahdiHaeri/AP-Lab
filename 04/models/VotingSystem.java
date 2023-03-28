package models;

import java.util.ArrayList;

public class VotingSystem {
   private ArrayList<Voting> votingList;

   public VotingSystem() {
      votingList = new ArrayList<Voting>();
   }

   public Voting getVoting(int index) {
      return votingList.get(index);
   }

   public ArrayList<Voting> getVotingList() {
      return votingList;
   }

   public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices) {
      Voting newVoting = new Voting(type, question, isAnonymous);
      
      for (String choice: choices) {
         newVoting.createChoice(choice);
      }

      votingList.add(newVoting);
   }

   public void printResult(int index) {
      if (0 > index || index >= votingList.size()) {
         System.out.println("There is no such index in voting list.");
         return;
      }

      System.out.println("Voting (" + index + ")");
      votingList.get(index).printResult();
   }

   public void printVoters(int index) {
      if (0 > index || index >= votingList.size()) {
         System.out.println("There is no such index in voting list.");
         return;
      }

      System.out.println("voters " + index);
      votingList.get(index).printVoters();
   }

   public void printVoting(int index) {
      if (0 > index || index >= votingList.size()) {
         System.out.println("There is no such index in voting list.");
         return;
      }
      
      System.out.println(votingList.get(index).getQuestion());
      System.out.println("--------------------------------------------");
      ArrayList<String> choices = votingList.get(index).getChoices();

      for (int i = 0; i < choices.size(); i++) {
         System.out.println(i + ": " + choices.get(i));
      }
   }

   public void vote(int index, Person voter, ArrayList<String> choices) {
      if (0 < index || index >= votingList.size()) {
         System.out.println("There is no such index in voting list.");
         return;
      }

      votingList.get(index).vote(voter, choices);
   }

   public void vote(int index, Person person) {
      if (0 < index || index >= votingList.size()) {
         System.out.println("There is no such index in voting list.");
         return;
      }

      votingList.get(index).vote(person);
   }
}
