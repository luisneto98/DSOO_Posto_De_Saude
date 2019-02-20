package interfaceGrafico;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Objetos.Medico;
import Objetos.Paciente;
import conexaoBD.ConexaoMedico;
import conexaoBD.ConexaoPaciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarPaciente extends JInternalFrame {

	private JTable table;
	private DefaultTableModel modelo;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ListarPaciente() {
		setTitle("Listar pacientes");
		setClosable(true);
		setBounds(100, 100, 565, 251);
		getContentPane().setLayout(null);
		setVisible(true);
		
		modelo = new DefaultTableModel();
		
		table = new JTable(modelo);
		
		JScrollPane rolagem = new JScrollPane(table); 
		rolagem.setBounds(10, 11, 529, 138);
		getContentPane().add(rolagem);
		
		popularModelo();
		
		
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int posi = table.getSelectedRow();
				ConexaoPaciente c = new ConexaoPaciente();
				ArrayList<Paciente> lista = c.listarPacientes();
				
				
				try {
					AlterarPaciente alter = new AlterarPaciente(lista.get(posi));
					getParent().add(alter);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAlterar.setBounds(46, 160, 89, 36);
		getContentPane().add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int posi = table.getSelectedRow();
				ConexaoPaciente c = new ConexaoPaciente();
				ArrayList<Paciente> lista = c.listarPacientes();
				c.deletarPaciente(lista.get(posi));
				modelo.removeRow(posi);
				table.repaint();
			}
		});
		btnDeletar.setBounds(413, 160, 89, 36);
		getContentPane().add(btnDeletar);
		
		JButton btnDiagnostico = new JButton("Diagnostico e cardapio");
		btnDiagnostico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int posi = table.getSelectedRow();
				ConexaoPaciente c = new ConexaoPaciente();
				ArrayList<Paciente> lista = c.listarPacientes();
				AlterarDiagnostico a = new AlterarDiagnostico(lista.get(posi));
				getParent().add(a);
				
			}
		});
		btnDiagnostico.setBounds(181, 153, 186, 51);
		getContentPane().add(btnDiagnostico);

	}
	private void popularModelo(){
		modelo.addColumn("Codigo");
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Data de nascimento");
		modelo.addColumn("Endereço");
		
		ConexaoPaciente c = new ConexaoPaciente();
		ArrayList<Paciente> lista = c.listarPacientes();
		
		for(int  i = 0;i<lista.size();i++)
			modelo.addRow(new Object[]{lista.get(i).getIdPaciente(),lista.get(i).getNome(),lista.get(i).getCpf(),lista.get(i).getDataNasci(),lista.get(i).getEndereco()});
		
	}
}
