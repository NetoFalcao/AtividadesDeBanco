package atividades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Atividade1 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url= "jdbc:sqlserver://localhost:1433";
		String user="SA";
		String passwd="<YourNewStrong!Passw0rd>";
		String dataBase="dbClass";
		String connectionUrl=url+";database="+ dataBase+";user="+user+";password="+passwd+";";
		
		Connection conn = DriverManager.getConnection(connectionUrl);
		
		String query="select name from sys.Databases";
		PreparedStatement ps =conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();
		
	rs.close();
	ps.close();
	conn.close();
	
	}
	
}