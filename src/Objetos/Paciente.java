package Objetos;

import java.sql.Date;

public class Paciente {

	private int idPaciente;
	private String nome;
	private String cpf;
	private String endereco;
	private String cardapio;
	private Date dataNasci;
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}
	public Paciente(int idPaciente,String nome,String cpf,String endereco,Date dataNasci,String cardapio) {
		
		this.idPaciente = idPaciente;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataNasci = dataNasci;
		this.cardapio = cardapio;
		
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCardapio() {
		return cardapio;
	}
	public void setCardapio(String cardapio) {
		this.cardapio = cardapio;
	}
	public Date getDataNasci() {
		return dataNasci;
	}
	public void setDataNasci(Date dataNasci) {
		this.dataNasci = dataNasci;
	}
	
}
