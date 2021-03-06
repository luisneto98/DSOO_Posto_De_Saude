package interfaceGrafico;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import Objetos.Paciente;
import conexaoBD.ConexaoPaciente;

public class CadastroPaciente extends JInternalFrame {
	private JTextField txtNome;
	private JFormattedTextField txtCPF;
	private JTextField txtEndereco;
	private JTextField txtCardapio;
	private JFormattedTextField txtDatNasciDia;
	private JFormattedTextField txtDatNasciMes;
	private JFormattedTextField txtDatNasciAno;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public CadastroPaciente() throws ParseException {
		setTitle("Cadastro Paciente");
		setClosable(true);
		setBounds(100, 100, 372, 300);
		getContentPane().setLayout(null);
		
		MaskFormatter mascaraDiaMes = new MaskFormatter("##");
		MaskFormatter mascaraHoraMin = new MaskFormatter("##");
		MaskFormatter mascaraAno = new MaskFormatter("####");
		MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(33, 11, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(33, 48, 46, 14);
		getContentPane().add(lblCpf);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(33, 84, 49, 14);
		getContentPane().add(lblEndereo);
		
		JLabel lblCardpio = new JLabel("Card\u00E1pio:");
		lblCardpio.setBounds(33, 125, 93, 14);
		getContentPane().add(lblCardpio);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(33, 189, 119, 14);
		getContentPane().add(lblDataDeNascimento);
		
		txtNome = new JTextField();
		txtNome.setBounds(93, 8, 253, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JFormattedTextField(mascaraCPF);
		txtCPF.setBounds(93, 45, 253, 20);
		getContentPane().add(txtCPF);
		txtCPF.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(92, 81, 254, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtCardapio = new JTextField();
		txtCardapio.setBounds(93, 122, 253, 56);
		getContentPane().add(txtCardapio);
		txtCardapio.setColumns(10);
		
		txtDatNasciDia = new JFormattedTextField(mascaraDiaMes);
		txtDatNasciDia.setBounds(191, 186, 29, 20);
		getContentPane().add(txtDatNasciDia);
		txtDatNasciDia.setColumns(10);
		
		txtDatNasciMes = new JFormattedTextField(mascaraDiaMes);
		txtDatNasciMes.setBounds(230, 186, 29, 20);
		getContentPane().add(txtDatNasciMes);
		txtDatNasciMes.setColumns(10);
		
		txtDatNasciAno = new JFormattedTextField(mascaraAno);
		txtDatNasciAno.setBounds(275, 186, 46, 20);
		getContentPane().add(txtDatNasciAno);
		txtDatNasciAno.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ConexaoPaciente conexao = new ConexaoPaciente();
				int test = JOptionPane.showConfirmDialog(null, "Deseja continuar opera��o?");
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
					conexao.salvarPaciente(new Paciente(1, txtNome.getText(), txtCPF.getText(),
						txtEndereco.getText(), data,
						txtCardapio.getText()));
				dispose();
				}
				
			}
		});
		btnSalvar.setBounds(63, 237, 89, 23);
		getContentPane().add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnSair.setBounds(251, 237, 70, 23);
		getContentPane().add(btnSair);

	}
}
