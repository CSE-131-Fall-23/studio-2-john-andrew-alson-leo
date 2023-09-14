package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Start Amount:");
		double startAmount = in.nextDouble();
		System.out.println("Win Chance:");
		double winChance = in.nextDouble();
		System.out.println("Win Limit:");
		double winLimit = in.nextDouble();
		System.out.println("Total simulations: ");
		int totalSimulations = in.nextInt();
		int countSuc = 0;
		int countRuin = 0;
		for (int i = 0; i < totalSimulations; i++) {
			int countPlays = 0;
			double currentAmount = startAmount;
			while (currentAmount > 0 && currentAmount < winLimit) {
				if (Math.random() <= winChance) {
					currentAmount++;
				} 
				else 
				{
					currentAmount--;
				}
				countPlays++;
			}
			if (currentAmount == 0) {
				//System.out.println("Lose " + countPlays);
				countRuin++;
			} 
			else 
			{
				//System.out.println("Win " + countPlays);
				countSuc++;
			}
		}
		System.out.println("Days: " + totalSimulations + "; Loses: " + countRuin + "; Wins: " + countSuc);
		double ruinRate = countRuin / (double) totalSimulations;
		System.out.println("Ruin Rate from Simulation: " + ruinRate);
		double expectedRuin;
		if (winChance == 0.5) {
			expectedRuin = 1 - (startAmount / winLimit);
		} 
		else {
			double a = (1 - winChance) / winChance;
			expectedRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit));
		}
		System.out.println("Expected Ruin Rate: " + expectedRuin);
	}
}
