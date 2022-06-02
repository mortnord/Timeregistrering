package main;

import java.sql.Connection;
import java.util.Scanner;

import aktiviteter.RegistrereKorpskveld;
import databaseConnections.ConnectToSQL;

public class Timeregistrering 
{
	public static void main (String args[])
	{
		ConnectToSQL.OpenConnection();
		Connection ConnectionUrl = ConnectToSQL.OpenConnection();
		System.out.println(ConnectionUrl);
		Scanner myScan = new Scanner(System.in);

		System.out.println("Tast 1 for Korpskveld, 2 for Sanitetsvakt, 3 for Leteaksjonsregistrering, 4 for annet");
		int typeRegistrering = Integer.parseInt(myScan.nextLine());
		if(typeRegistrering == 1);
		{
			new RegistrereKorpskveld(myScan,1);
		}
		
		myScan.close();
		ConnectToSQL.CloseConnection();
	}
}
