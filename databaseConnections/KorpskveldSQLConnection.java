package databaseConnections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import units.Korpskveld;

public class KorpskveldSQLConnection {
	public static int KorpskveldInsertionAndKeyRetrieval(Connection connectionIn, Korpskveld KorpskveldInn) {
		Statement stmt = null;
		try {
			stmt = connectionIn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int aktivitetsID = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(KorpskveldInn.dag));
		System.out.println(KorpskveldInn.navn);

		try {
			aktivitetsID = stmt.executeUpdate(
					"INSERT INTO Aktivitet (Aktivititetsnavn, Dato, Beskrivelse, AktivitetsType) VALUES ('" + KorpskveldInn.navn + "','"
							+ sdf.format(KorpskveldInn.dag) + "','" + KorpskveldInn.beskrivelse + "','" + KorpskveldInn.aktivitetsType + "');",
					Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				aktivitetsID = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(aktivitetsID + " er aktivitetsIDen");
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aktivitetsID;
	}
}
