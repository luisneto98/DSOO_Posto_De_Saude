package Objetos;

import java.sql.Date;
import java.util.ArrayList;

import conexaoBD.ConexaoMedico;
import conexaoBD.ConexaoPaciente;

public class Consulta {

	private Date data;
	private int idConsulta;
	private int idMedico;
	private int idPaciente;
	
	public Consulta() {
		// TODO Auto-generated constructor stub
	}
	public Consulta(Date data,int consulta,int medico,int paciente) {
		this.data = data;
		this.idConsulta = consulta;
		this.idMedico = medico;
		this.idPaciente = paciente;
		
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNomePaciente(){
		ConexaoPaciente conexao = new ConexaoPaciente();
		ArrayList<Paciente> lista = conexao.listarPacientes();
		
		for(int i = 0;i<lista.size();i++){
			if(lista.get(i).getIdPaciente() == this.idPaciente)
				return lista.get(i).getNome();
		}
		
		return "Indeterminado";
		
	}
	public String getNomeMedico(){
		ConexaoMedico conexao = new ConexaoMedico();
		ArrayList<Medico> lista = conexao.listarMedicos();
		
		for(int i = 0;i<lista.size();i++){
			if(lista.get(i).getIdMedico() == this.idMedico)
				return lista.get(i).getNome();
		}
		
		return "Indeterminado";
		
	}
	
	
}
