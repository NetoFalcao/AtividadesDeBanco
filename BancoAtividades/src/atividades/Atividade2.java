package atividades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Atividade2 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://35.225.28.202:1433";
		String user = "SA";
		String passwd = "<YourNewStrong!Passw0rd>";
		String dataBase = "dbClass";
		String connectionUrl = url + ";database=" + dataBase + ";user=" + user + ";password=" + passwd + ";";

		Connection conn = DriverManager.getConnection(connectionUrl);

		Statement st = conn.createStatement();

		int numeroDecoisas = st.executeUpdate(readArquivoTabela());
		System.out.print(numeroDecoisas);

		st.close();
		conn.close();
	}

	public static String readArquivoTabela() throws IOException {
		BufferedReader br = null;
		FileReader fr = null;

		fr = new FileReader("C:/Users/jose.falcao/Downloads/Tabelas_Hotel.sql");
		br = new BufferedReader(fr);

		String leiaLinha = null;

		while (br.readLine() != null) {
			leiaLinha = br.readLine();
		}

		br.close();
		fr.close();
		return leiaLinha;
	}

}
