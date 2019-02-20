package conexaoBD;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class FabricaConexao {
	
	static Connection conectarBD(){
		
		String URL = "jdbc:mysql://localhost/postodesaudebd";
		Connection con = null;
		
		try {
		
			
			con = (Connection) DriverManager.getConnection(URL,"root","21051998");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!");
			
		}
		
		return con;
		
	}
	
	
	
}
