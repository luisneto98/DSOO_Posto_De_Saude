package Objetos;

public class Diagnostico {

	int idDiagnostico;
	String recomendacoes;
	String diagnostico;
	int idPaciente;
	int idMedico;
	
	public Diagnostico() {
		// TODO Auto-generated constructor stub
	}
	
	public Diagnostico(	int idDiagnostico,String recomendacoes,String diagnostico,int idPaciente,int idMedico) {
		
		this.idDiagnostico = idDiagnostico;
		this.recomendacoes = recomendacoes;
		this.diagnostico = diagnostico;
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		
	}

	public int getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public String getRecomendacoes() {
		return recomendacoes;
	}

	public void setRecomendacoes(String recomendacoes) {
		this.recomendacoes = recomendacoes;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	
	
	
}
