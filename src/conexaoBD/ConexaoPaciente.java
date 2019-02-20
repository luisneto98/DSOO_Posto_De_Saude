package conexaoBD;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import Objetos.Paciente;

public class ConexaoPaciente {

	private Connection con;
	private PreparedStatement conexao;
	private Statement conexaoListar;
	private ResultSet resultSet;
	
	//SALVAR
	public void salvarPaciente(Paciente paciente){
		String sqlSalvar = "insert into paciente (nome,datnasci,endereco,cpf,cardapio) values(?,?,?,?,?)";
		
		try{
		
		con = FabricaConexao.conectarBD();
		conexao = (PreparedStatement) con.prepareStatement(sqlSalvar);
		
		conexao.setString(1, paciente.getNome());
		conexao.setDate(2, paciente.getDataNasci());
		conexao.setString(3, paciente.getEndereco());
		conexao.setString(4, paciente.getCpf());
		conexao.setString(5, paciente.getCardapio());
		
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
		ConexaoPaciente c = new ConexaoPaciente();
		Paciente p = new Paciente(1, "José", "612.111.223-10", "rua 1", new Date(24, 07, 1972),"jantar");
		//c.salvarPaciente(p);
		ArrayList<Paciente> lista = c.listarPacientes();
		
		for(int i =0;i<lista.size();i++)
		System.out.println(lista.get(i).getNome());
	}
	
	//ALTERAR
	public void alterarPaciente(Paciente paciente){
		String sqlAlterar=" UPDATE paciente SET nome=?,datnasci=?,endereco=?,cpf=?,cardapio=? WHERE idpaciente=?";
		
		try {
			con = FabricaConexao.conectarBD();
			conexao = (PreparedStatement) con.prepareStatement(sqlAlterar);
			
			conexao.setString(1, paciente.getNome());
			conexao.setDate(2, paciente.getDataNasci());
			conexao.setString(3, paciente.getEndereco());
			conexao.setString(4, paciente.getCpf());
			conexao.setString(5, paciente.getCardapio());
			conexao.setInt(6, paciente.getIdPaciente());
			
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
	
	public void deletarPaciente(Paciente paciente){
		String sqlDeletar = " DELETE FROM paciente WHERE idpaciente = ?";
		
		try{
			con = FabricaConexao.conectarBD();
			conexao = (PreparedStatement) con.prepareStatement(sqlDeletar);
			
			conexao.setInt(1, paciente.getIdPaciente());
			conexao.executeUpdate();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao deletar arquivo!");
			
		}
	}
	//LISTAR
	
	public ArrayList<Paciente> listarPacientes(){
		ArrayList<Paciente> lista = new ArrayList<Paciente>();
		try{
		con = FabricaConexao.conectarBD();	
		
		conexaoListar = (Statement) con.createStatement();
		
		resultSet = conexaoListar.executeQuery("SELECT * FROM paciente");
	
		
		
		while(resultSet.next())
		{
			lista.add(new Paciente(resultSet.getInt("idpaciente"), resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("endereco"),
					resultSet.getDate("datnasci"), resultSet.getString("cardapio")));
				
		}
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Erro ao listar pacientes");
			
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
