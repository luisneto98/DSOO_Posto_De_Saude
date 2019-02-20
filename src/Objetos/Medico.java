package Objetos;

import java.sql.Date;

public class Medico {

	private int idMedico;
	private String nome;
	private String especializacao;
	private String horaEntrada;
	private String horaSaida;
	private Date dataNasci;
	
	public Medico() {
		// TODO Auto-generated constructor stub
	}
	
	public Medico(int idMedico,String nome,String especializacao,String horaEntrada,String horaSaida,Date dataNasci) {
		
		
		this.idMedico = idMedico;
		this.nome = nome;
		this.especializacao = especializacao;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.dataNasci = dataNasci;
		
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Date getDataNasci() {
		return dataNasci;
	}

	public void setDataNasci(Date dataNasci) {
		this.dataNasci = dataNasci;
	}
	
	
}
