package interfaceGrafico;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JButton;

public class Listar extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Listar() {
	show();

	}
	public void show(){
		setBounds(100, 100, 450, 251);
		getContentPane().setLayout(null);
		setVisible(true);
		table = new JTable();
		table.setBounds(10, 11, 414, 138);
		getContentPane().add(table);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(85, 175, 89, 23);
		getContentPane().add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(259, 175, 89, 23);
		getContentPane().add(btnDeletar);
	}
}
