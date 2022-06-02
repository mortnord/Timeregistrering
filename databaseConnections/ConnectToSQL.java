package databaseConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import units.Korpskveld;

public class ConnectToSQL {
	public static Connection connection = null;

	public static Connection OpenConnection() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mariadb://varkno01.mysql.domeneshop.no:3306/varkno01?user=varkno01&password=Innbo-knip-djupe-fjesk-90");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void CloseConnection() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void registrereAktivitetKorpskveld(Korpskveld KorpskveldInn) 
	{
		int aktivitetsID = KorpskveldSQLConnection.KorpskveldInsertionAndKeyRetrieval(connection, KorpskveldInn);
		MedlemstimerSQLConnection.MedlemsTimerInsertion(connection, KorpskveldInn, aktivitetsID);
	}
}
