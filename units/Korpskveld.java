package units;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Korpskveld {
	public String navn;
	public Date dag;
	public Medlem[] deltakere;
	public String beskrivelse;
	public int aktivitetsType;

	public Korpskveld(String navnIn, Date dagIn, Medlem[] deltakereIn, String beskrivelseIn, int j) {
		navn = navnIn;
		dag = dagIn;
		deltakere = deltakereIn;
		beskrivelse = beskrivelseIn;
		aktivitetsType = j;
		
		System.out.println("Korpskveldens navn er " + navn);

		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
		System.out.println("Dato: " + sdf.format(dag));
		System.out.println("Deltakere er som følger");

		for (int i = 0; i < deltakere.length; i++) 
		{
			System.out.println(deltakere[i].navnUt + " " + deltakere[i].timerUt);
		}

		return;
	}
}
