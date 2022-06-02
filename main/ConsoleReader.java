package main;

import java.util.Scanner;

import units.Medlem;

public class ConsoleReader {
	String navn;
	int timer;

	public ConsoleReader(Medlem MedIn, Scanner myScan) {
		System.out.println("Enter username");
		navn = myScan.nextLine();

		System.out.println("Enter timer");
		timer = Integer.parseInt(myScan.nextLine());
		MedIn.navnUt = navn;
		MedIn.timerUt = timer;
	}
}
