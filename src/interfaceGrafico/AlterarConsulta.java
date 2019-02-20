package interfaceGrafico;

import java.awt.EventQueue;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;

import Objetos.Consulta;
import conexaoBD.ConexaoConsulta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarConsulta extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private JTextField txtMedico;
	private JFormattedTextField txtDatDia;
	private JFormattedTextField txtDatMes;
	private JFormattedTextField txtDatAno;
	private JTextField txtPaciente;
	private Consulta consulta;

	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AlterarConsulta(Consulta consul) throws ParseException {
		consulta = consul;
		
		setClosable(true);
		setVisible(true);
		setBounds(100, 100, 250, 203);
		getContentPane().setLayout(null);
		
		JLabel lblMdico = new JLabel("M\u00E9dico:");
		lblMdico.setBounds(10, 29, 46, 14);
		getContentPane().add(lblMdico);
		
		MaskFormatter mascaraDiaMes = new MaskFormatter("##");
		MaskFormatter mascaraHoraMin = new MaskFormatter("##");
		MaskFormatter mascaraAno = new MaskFormatter("####");
		
		txtMedico = new JTextField();
		txtMedico.setBounds(88, 26, 86, 20);
		getContentPane().add(txtMedico);
		txtMedico.setColumns(10);
		txtMedico.setText(String.valueOf(consul.getIdMedico()));
		
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setBounds(10, 70, 75, 14);
		getContentPane().add(lblPaciente);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 109, 46, 14);
		getContentPane().add(lblData);
		
		txtDatDia = new JFormattedTextField(mascaraDiaMes);
		txtDatDia.setBounds(88, 106, 31, 20);
		getContentPane().add(txtDatDia);
		txtDatDia.setColumns(10);
		
		txtDatMes = new JFormattedTextField(mascaraDiaMes);
		txtDatMes.setBounds(125, 106, 31, 20);
		getContentPane().add(txtDatMes);
		txtDatMes.setColumns(10);
		
		txtDatAno = new JFormattedTextField(mascaraAno);
		txtDatAno.setBounds(160, 106, 46, 20);
		getContentPane().add(txtDatAno);
		txtDatAno.setColumns(10);
		
		txtPaciente = new JTextField();
		txtPaciente.setBounds(88, 67, 86, 20);
		getContentPane().add(txtPaciente);
		txtPaciente.setColumns(10);
		
		txtPaciente.setText(String.valueOf(consul.getIdPaciente()));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexaoConsulta conexao = new ConexaoConsulta();
				int test = JOptionPane.showConfirmDialog(null, "Deseja confirmar a operação?");
				if(test == JOptionPane.YES_OPTION){
					
					String dataString = txtDatDia.getText()+"/"+txtDatMes.getText()+"/"+txtDatAno.getText();
				    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");  
				    java.sql.Date data = new Date(1998, 05, 05);
					
				    try {
						data = new java.sql.Date(fmt.parse(dataString).getTime());  
					} catch (ParseException erro) {
						// TODO Auto-generated catch block
						erro.printStackTrace();
					}  
					
				    conexao.alterarConsulta(new Consulta(data,
							consulta.getIdConsulta(),Integer.parseInt(txtMedico.getText()), Integer.parseInt(txtPaciente.getText())));
					
					dispose();
				}
			}
		});
		btnAlterar.setBounds(85, 140, 89, 23);
		getContentPane().add(btnAlterar);

	}
}
