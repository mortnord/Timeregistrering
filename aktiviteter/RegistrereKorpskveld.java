package aktiviteter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import databaseConnections.ConnectToSQL;
import main.ConsoleReader;
import units.Korpskveld;
import units.Medlem;

public class RegistrereKorpskveld {
	public RegistrereKorpskveld(Scanner myScan, int j) {
		String navn = null;
		int timer = 0;
		Date date = null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		System.out.println("Eksempel: DD-MM-YYYY");
		System.out.print("skriv in dato: ");

		
		String str = myScan.nextLine();

		try {
			date = sdf.parse(str);

			sdf = new SimpleDateFormat("EEE, d MMM yyyy");
			System.out.println("Dato: " + sdf.format(date));
		} catch (ParseException e) {
			System.out.println("Parse Exception");
		}
		System.out.println("Hva er temaet for korpskvelden?");
		String korpskveldNavn = myScan.nextLine();
		System.out.println("Vil du beskrive aktiviteten? isåfall skriv her, eller bare trykk enter.");
		String beskrivelse = myScan.nextLine() + " ";
		System.out.println("Enter antall deltakere");
		int deltakere = Integer.parseInt(myScan.nextLine());
		Medlem navnDeltakere[] = new Medlem[deltakere];
		Medlem Med1;
		for (int i = 0; i < deltakere; i++) {
			Med1 = new Medlem(navn, timer);
			new ConsoleReader(Med1, myScan);
			navnDeltakere[i] = Med1;
		}

		ConnectToSQL.registrereAktivitetKorpskveld(new Korpskveld(korpskveldNavn, date, navnDeltakere, beskrivelse, j));

	}
}
