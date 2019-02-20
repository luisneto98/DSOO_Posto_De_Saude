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

import conexaoBD.ConexaoMedico;
import Objetos.Medico;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarMedico extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	private JTextField txtNome;
	private JTextField txtEspecializacao;
	private JFormattedTextField txtHoraEntrada;
	private JFormattedTextField txtHoraSaida;
	private JFormattedTextField txtDatNasciDia;
	private JFormattedTextField txtDatNasciMes;
	private JFormattedTextField txtDatNasciAno;
	Medico medico;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AlterarMedico(Medico med) throws ParseException {
		setVisible(true);
		setClosable(true);
		
		medico = med;
		
		MaskFormatter mascaraDiaMes = new MaskFormatter("##");
		MaskFormatter mascaraHoraMin = new MaskFormatter("##");
		MaskFormatter mascaraAno = new MaskFormatter("####");
		
		setBounds(100, 100, 359, 196);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblEspecializao = new JLabel("Especializa\u00E7\u00E3o:");
		lblEspecializao.setBounds(10, 36, 78, 14);
		getContentPane().add(lblEspecializao);
		
		JLabel lblHoraDeEntrada = new JLabel("Hora de entrada:");
		lblHoraDeEntrada.setBounds(10, 61, 83, 14);
		getContentPane().add(lblHoraDeEntrada);
		
		JLabel lblHoraDeSaida = new JLabel("Hora de sa\u00EDda:");
		lblHoraDeSaida.setBounds(173, 61, 78, 14);
		getContentPane().add(lblHoraDeSaida);
		
		txtNome = new JTextField();
		txtNome.setBounds(74, 8, 242, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(medico.getNome());
		
		txtEspecializacao = new JTextField();
		txtEspecializacao.setBounds(98, 33, 218, 20);
		getContentPane().add(txtEspecializacao);
		txtEspecializacao.setColumns(10);
		txtEspecializacao.setText(medico.getEspecializacao());
		
		txtHoraEntrada = new JFormattedTextField(mascaraHoraMin);
		txtHoraEntrada.setBounds(117, 58, 46, 20);
		getContentPane().add(txtHoraEntrada);
		txtHoraEntrada.setColumns(10);
		txtHoraEntrada.setText(medico.getHoraEntrada());
		
		txtHoraSaida = new JFormattedTextField(mascaraHoraMin);
		txtHoraSaida.setBounds(270, 58, 46, 20);
		getContentPane().add(txtHoraSaida);
		txtHoraSaida.setColumns(10);
		txtHoraSaida.setText(medico.getHoraSaida());
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 86, 106, 14);
		getContentPane().add(lblDataDeNascimento);
		
		
		
			    
		
		txtDatNasciDia = new JFormattedTextField(mascaraDiaMes);
		txtDatNasciDia.setBounds(127, 83, 36, 20);
		getContentPane().add(txtDatNasciDia);
		txtDatNasciDia.setText(String.valueOf(medico.getDataNasci().getDay()));
		
		txtDatNasciMes = new JFormattedTextField(mascaraDiaMes);
		txtDatNasciMes.setBounds(183, 83, 36, 20);
		getContentPane().add(txtDatNasciMes);
		txtDatNasciMes.setText(String.valueOf(medico.getDataNasci().getMonth()));
		
		txtDatNasciAno = new JFormattedTextField(mascaraAno);
		txtDatNasciAno.setBounds(238, 83, 78, 20);
		getContentPane().add(txtDatNasciAno);
		txtDatNasciAno.setText(String.valueOf(medico.getDataNasci().getYear()));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexaoMedico conexao = new ConexaoMedico();
				int test = JOptionPane.showConfirmDialog(null, "Deseja continuar operação?");
				if(test == JOptionPane.YES_OPTION){
					String dataString = txtDatNasciDia.getText()+"/"+txtDatNasciMes.getText()+"/"+txtDatNasciAno.getText();
				      
				    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");  
				    java.sql.Date data = new Date(1998, 05, 05);
					try {
						data = new java.sql.Date(fmt.parse(dataString).getTime());  
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
					
					conexao.alterarMedico(new Medico(medico.getIdMedico(), txtNome.getText(),txtEspecializacao.getText(), 
							txtHoraEntrada.getText(), txtHoraSaida.getText(),
							data));
					
					dispose();
				}
				
			}
		});
		btnAlterar.setBounds(130, 133, 89, 23);
		getContentPane().add(btnAlterar);

	}
}
