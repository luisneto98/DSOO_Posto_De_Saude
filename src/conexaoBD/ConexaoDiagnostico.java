package conexaoBD;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Objetos.Diagnostico;
import Objetos.Medico;
import Objetos.Paciente;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ConexaoDiagnostico {

	private Connection con;
	private PreparedStatement conexao;
	private Statement conexaoListar;
	private ResultSet resultSet;
	
	//SALVAR
	public void salvarDiagnostico(Diagnostico diagnostico){
		String sqlSalvar = "insert into diagnostico (diagnostico,recomendacoes,idmedico,idpaciente) values(?,?,?,?)";
		
		try{
		
		con = FabricaConexao.conectarBD();
		conexao = (PreparedStatement) con.prepareStatement(sqlSalvar);
		
		conexao.setString(1, diagnostico.getDiagnostico());
		conexao.setString(2, diagnostico.getRecomendacoes());
		conexao.setInt(3, diagnostico.getIdMedico());
		conexao.setInt(4, diagnostico.getIdPaciente());
		
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
		ConexaoDiagnostico c = new ConexaoDiagnostico();
		
		Diagnostico p = new Diagnostico(1, "coma pouca maça", "hemorroida",1, 1);
		c.salvarDiagnostico(p);
		ArrayList<Diagnostico> lista = c.listarDiagnosticos();
		
		for(int i =0;i<lista.size();i++)
		System.out.println(lista.get(i).getDiagnostico());
	}
	
	//ALTERAR
	public void alterarDiagnostico(Diagnostico diagnostico){
		String sqlAlterar=" UPDATE diagnostico SET diagnostico=?,recomendacoes=?,idmedico=?,idpaciente=? WHERE iddiagnostico=?";
		
		try {
			con = FabricaConexao.conectarBD();
			conexao = (PreparedStatement) con.prepareStatement(sqlAlterar);
			
			conexao.setString(1, diagnostico.getDiagnostico());
			conexao.setString(2, diagnostico.getRecomendacoes());
			conexao.setInt(3, diagnostico.getIdMedico());
			conexao.setInt(4, diagnostico.getIdPaciente());
			conexao.setInt(5, diagnostico.getIdDiagnostico());
			
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
	
	public void deletarDiagnostico(Diagnostico diagnostico){
		String sqlDeletar = " DELETE FROM diagnostico WHERE iddiagnostico = ?";
		
		try{
			con = FabricaConexao.conectarBD();
			conexao = (PreparedStatement) con.prepareStatement(sqlDeletar);
			
			conexao.setInt(1, diagnostico.getIdDiagnostico());
			conexao.executeUpdate();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao deletar arquivo!");
			
		}
	}
	//LISTAR
	
	public ArrayList<Diagnostico> listarDiagnosticos(){
		ArrayList<Diagnostico> lista = new ArrayList<Diagnostico>();
		try{
		con = FabricaConexao.conectarBD();	
		
		conexaoListar = (Statement) con.createStatement();
		
		resultSet = conexaoListar.executeQuery("SELECT * FROM diagnostico");
	
		
		
		while(resultSet.next())
		{
			lista.add(new Diagnostico(resultSet.getInt("idDiagnostico"), resultSet.getString("recomendacoes"), resultSet.getString("diagnostico"), 
					resultSet.getInt("idPaciente"), resultSet.getInt("idMedico")));
				
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
		public Diagnostico pacienteCorrespondente(Paciente paciente){
			
		
			
			ArrayList<Diagnostico> listaDiagnostico = listarDiagnosticos();
			
			for(int i =0;i<listaDiagnostico.size();i++){
				if(listaDiagnostico.get(i).getIdPaciente() == paciente.getIdPaciente())
					return listaDiagnostico.get(i);
			}
			
			return null;
				
			
			
		}
}
