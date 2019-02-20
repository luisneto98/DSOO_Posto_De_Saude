package interfaceGrafico;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Objetos.Consulta;
import Objetos.Medico;
import Objetos.Paciente;
import conexaoBD.ConexaoConsulta;
import conexaoBD.ConexaoMedico;
import conexaoBD.ConexaoPaciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarConsultas extends JInternalFrame {

	private JTable table;
	private DefaultTableModel modelo;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ListarConsultas() {
		setTitle("Listar pacientes");
		setClosable(true);
		setBounds(100, 100, 595, 251);
		getContentPane().setLayout(null);
		setVisible(true);
		modelo = new DefaultTableModel();
		
		table = new JTable(modelo);
		
		JScrollPane rolagem = new JScrollPane(table); 
		rolagem.setBounds(10, 11, 559, 138);
		getContentPane().add(rolagem);
		
		popularModelo();
		
		
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posi = table.getSelectedRow();
				ConexaoConsulta c = new ConexaoConsulta();
				ArrayList<Consulta> lista = c.listarConsulta();
				
				
				try {
					AlterarConsulta alter = new AlterarConsulta(lista.get(posi));
					getParent().add(alter);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnAlterar.setBounds(133, 175, 89, 23);
		getContentPane().add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int posi = table.getSelectedRow();
				ConexaoConsulta c = new ConexaoConsulta();
				ArrayList<Consulta> lista = c.listarConsulta();
				c.deletarConsulta(lista.get(posi));
				modelo.removeRow(posi);
				table.repaint();
			
			}
		});
		btnDeletar.setBounds(355, 175, 89, 23);
		getContentPane().add(btnDeletar);

	}
	
	private void popularModelo(){
		modelo.addColumn("Paciente");
		modelo.addColumn("Medico");
		modelo.addColumn("Data");
		
		ConexaoConsulta conexao = new ConexaoConsulta();
		ArrayList<Consulta> lista = conexao.listarConsulta();
		
		for(int  i = 0;i<lista.size();i++)
			modelo.addRow(new Object[]{lista.get(i).getNomePaciente(),lista.get(i).getNomeMedico(),lista.get(i).getData()});
		
	}

}
