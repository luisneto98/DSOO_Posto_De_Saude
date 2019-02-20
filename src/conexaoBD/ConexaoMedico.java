package conexaoBD;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Objetos.Medico;
import Objetos.Paciente;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ConexaoMedico {

	private Connection con;
	private PreparedStatement conexao;
	private Statement conexaoListar;
	private ResultSet resultSet;
	
	//SALVAR
	public void salvarMedico(Medico medico){
		String sqlSalvar = "insert into medico (nome,especializacao,hora_entrada,hora_saida,datanasci) values(?,?,?,?,?)";
		
		try{
		
		con = FabricaConexao.conectarBD();
		conexao = (PreparedStatement) con.prepareStatement(sqlSalvar);
		
		conexao.setString(1, medico.getNome());
		conexao.setString(2, medico.getEspecializacao());
		conexao.setString(3, medico.getHoraEntrada());
		conexao.setString(4, medico.getHoraSaida());
		conexao.setDate(5, medico.getDataNasci());
		
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
		ConexaoMedico c = new ConexaoMedico();
	
		Medico m = new Medico(1, "Paulo Ricardo", "pediatria", "14h", "15h", new Date(21, 12, 1998));
		c.deletarMedico(m);
		ArrayList<Medico> lista = c.listarMedicos();
		
		for(int i =0;i<lista.size();i++)
		System.out.println(lista.get(i).getNome());
	}
	
	//ALTERAR
	public void alterarMedico(Medico medico){
		String sqlAlterar=" UPDATE medico SET nome=?,especializacao=?,hora_entrada=?,hora_saida=?,datanasci=? WHERE idmedico=?";
		
		try {
			con = FabricaConexao.conectarBD();
			conexao = (PreparedStatement) con.prepareStatement(sqlAlterar);
			
			conexao.setString(1, medico.getNome());
			conexao.setString(2, medico.getEspecializacao());
			conexao.setString(3, medico.getHoraEntrada());
			conexao.setString(4, medico.getHoraSaida());
			conexao.setDate(5, medico.getDataNasci());
			conexao.setInt(6, medico.getIdMedico());
			
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
	
	public void deletarMedico(Medico medico){
		String sqlDeletar = " DELETE FROM medico WHERE idmedico = ?";
		
		try{
			con = FabricaConexao.conectarBD();
			conexao = (PreparedStatement) con.prepareStatement(sqlDeletar);
			
			conexao.setInt(1, medico.getIdMedico());
			conexao.executeUpdate();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao deletar arquivo!");
			
		}
	}
	//LISTAR
	
	public ArrayList<Medico> listarMedicos(){
		ArrayList<Medico> lista = new ArrayList<Medico>();
		try{
		con = FabricaConexao.conectarBD();	
		
		conexaoListar = (Statement) con.createStatement();
		
		resultSet = conexaoListar.executeQuery("SELECT * FROM medico");
	
		
		
		while(resultSet.next())
		{
			lista.add(new Medico(resultSet.getInt("idmedico"), resultSet.getString("nome"), resultSet.getString("especializacao"),
					resultSet.getString("hora_entrada"), resultSet.getString("hora_saida"),resultSet.getDate("datanasci")));
				
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
