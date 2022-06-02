package databaseConnections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import units.Korpskveld;

public class MedlemstimerSQLConnection {
	public static void MedlemsTimerInsertion(Connection connection, Korpskveld KorpskveldInn, int aktivitetsID) {
		Statement stmt = null;
		String query = null;
		Integer[] medlemsID = new Integer[KorpskveldInn.deltakere.length];

		for (int i = 0; i < KorpskveldInn.deltakere.length; i++) {
			try {
				stmt = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			query = (("SELECT Navn FROM Medlemmer WHERE Navn LIKE '" + KorpskveldInn.deltakere[i].navnUt + "';"));
			try {
				ResultSet result = (stmt.executeQuery(query));
				if (result.first() == false) {
					System.out.println("Fant ikke navnet");
					stmt.executeUpdate(
							"INSERT INTO Medlemmer (Navn) VALUES ('" + KorpskveldInn.deltakere[i].navnUt + "');");
					System.out.println("La til navnet");
				}
				query = (("SELECT ID FROM Medlemmer WHERE Navn LIKE '" + KorpskveldInn.deltakere[i].navnUt + "';"));
				result = stmt.executeQuery(query);

				ResultSetMetaData rsmd = result.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				while (result.next()) {
					for (int j = 1; j <= columnsNumber; j++) {
						if (j > 1)
							System.out.print(",  ");
						String columnValue = result.getString(j);
						medlemsID[i] = Integer.parseInt(columnValue);
						System.out.print(columnValue + " " + rsmd.getColumnName(j));
					}
					System.out.println("");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < KorpskveldInn.deltakere.length; i++) {
			query = "INSERT INTO Aktivitetstimer (IDMedlem, IDAktivitet, Timer) values ('" + medlemsID[i] + "','"
					+ aktivitetsID + "','" + KorpskveldInn.deltakere[i].timerUt + "');";
			try {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
