package conexaoBD;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Objetos.Consulta;
import Objetos.Diagnostico;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ConexaoConsulta {

	private Connection con;
	private PreparedStatement conexao;
	private Statement conexaoListar;
	private ResultSet resultSet;
	
	//SALVAR
	public void salvarConsulta(Consulta consulta){
		String sqlSalvar = "insert into consulta (data,idmedico,idpaciente) values(?,?,?)";
		
		try{
		
		con = FabricaConexao.conectarBD();
		conexao = (PreparedStatement) con.prepareStatement(sqlSalvar);
		
		conexao.setDate(1, consulta.getData());
		conexao.setInt(2, consulta.getIdMedico());
		conexao.setInt(3, consulta.getIdPaciente());
		
		conexao.executeUpdate();
		
		JOptionPane.showMessageDialog(null,"Arquivo salvo com sucesso!");
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo!");
			
		}finally{
		try {
			con.close();
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		}
		
	
		
	}
	
	public static void main(String[] args) {
		ConexaoConsulta c = new ConexaoConsulta();
		
		Consulta p = new Consulta(new Date(21,05,1998),1,1, 1);
		c.salvarConsulta(p);
		//ArrayList<Diagnostico> lista = c.listarDiagnosticos();
		
		//for(int i =0;i<lista.size();i++)
		//System.out.println(lista.get(i).getDiagnostico());
	}
	
	//ALTERAR
	public void alterarConsulta(Consulta consulta){
		String sqlAlterar=" UPDATE consulta SET data=?,idmedico=?,idpaciente=? WHERE idconsulta=?";
		
		try {
			con = FabricaConexao.conectarBD();
			conexao = (PreparedStatement) con.prepareStatement(sqlAlterar);
			
			conexao.setDate(1, consulta.getData());
			conexao.setInt(2, consulta.getIdMedico());
			conexao.setInt(3, consulta.getIdPaciente());
			conexao.setInt(4, consulta.getIdConsulta());
			
			conexao.executeUpdate();
		
			JOptionPane.showMessageDialog(null, "Alteração feita com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao alterar arquivo!");
		}finally{
			try {
				con.close();
				conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	//DELETAR
	
	public void deletarConsulta(Consulta consulta){
		String sqlDeletar = " DELETE FROM consulta WHERE idconsulta = ?";
		
		try{
			con = FabricaConexao.conectarBD();
			conexao = (PreparedStatement) con.prepareStatement(sqlDeletar);
			
			conexao.setInt(1, consulta.getIdConsulta());
			conexao.executeUpdate();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao deletar arquivo!");
			
		}
	}
	//LISTAR
	
	public ArrayList<Consulta> listarConsulta(){
		ArrayList<Consulta> lista = new ArrayList<Consulta>();
		try{
		con = FabricaConexao.conectarBD();	
		
		conexaoListar = (Statement) con.createStatement();
		
		resultSet = conexaoListar.executeQuery("SELECT * FROM consulta");
	
		
		
		while(resultSet.next())
		{
			lista.add(new Consulta(resultSet.getDate("data"), resultSet.getInt("idconsulta"), resultSet.getInt("idmedico"), resultSet.getInt("idpaciente")));
				
		}
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Erro ao listar");
			
		}finally{
			try {
				con.close();
				conexaoListar.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
			
		}
		
		
	}
	
			
}
