package interfaceGrafico;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import conexaoBD.ConexaoDiagnostico;
import Objetos.Diagnostico;
import Objetos.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarDiagnostico extends JInternalFrame {
	private JTextField txtMedico;

	/**
	 * Launch the application.
	 */
	
	Diagnostico diagnostico;
	JTextPane txtRecomendacoes;
	JTextPane txtDiagnostico;
	JLabel lblDiagnostico;

	/**
	 * Create the frame.
	 */
	public AlterarDiagnostico(Paciente paciente) {
		setClosable(true);
		setVisible(true);
		setBounds(100, 100, 450, 413);
		getContentPane().setLayout(null);
		
		
		ConexaoDiagnostico conexao =new ConexaoDiagnostico();
        diagnostico = conexao.pacienteCorrespondente(paciente);
		if(diagnostico == null){
			diagnostico = new Diagnostico(1, "", "", paciente.getIdPaciente(), 0);
			conexao.salvarDiagnostico(diagnostico);
		}
		
		lblDiagnostico = new JLabel("Diagnostico:");
		lblDiagnostico.setBounds(10, 34, 67, 21);
		getContentPane().add(lblDiagnostico);
		
		txtDiagnostico = new JTextPane();
		txtDiagnostico.setBounds(10, 66, 414, 91);
		getContentPane().add(txtDiagnostico);
		txtDiagnostico.setText(diagnostico.getDiagnostico());
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexaoDiagnostico conexao =new ConexaoDiagnostico();
				conexao.alterarDiagnostico(new Diagnostico(diagnostico.getIdDiagnostico(), txtRecomendacoes.getText(), 
						txtDiagnostico.getText(), diagnostico.getIdPaciente() ,Integer.parseInt(txtMedico.getText())));
				
			}
		});
		btnSalvar.setBounds(166, 350, 89, 23);
		getContentPane().add(btnSalvar);
		
		JLabel lblMedico = new JLabel("Medico:");
		lblMedico.setBounds(10, 167, 55, 21);
		getContentPane().add(lblMedico);
		
		txtMedico = new JTextField();
		txtMedico.setBounds(62, 168, 86, 20);
		getContentPane().add(txtMedico);
		txtMedico.setText(String.valueOf(diagnostico.getIdMedico()));
		
		txtMedico.setColumns(10);
		
		txtRecomendacoes = new JTextPane();
		txtRecomendacoes.setBounds(10, 243, 414, 91);
		getContentPane().add(txtRecomendacoes);
		txtRecomendacoes.setText(diagnostico.getRecomendacoes());
		
		JLabel lblRecomendaes = new JLabel("Recomenda\u00E7\u00F5es:");
		lblRecomendaes.setBounds(10, 210, 98, 34);
		getContentPane().add(lblRecomendaes);
		

	}
}
