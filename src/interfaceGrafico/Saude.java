package interfaceGrafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JDesktopPane;

import Objetos.Medico;
import conexaoBD.ConexaoMedico;
import java.awt.Toolkit;

public class Saude extends JFrame {

	private JPanel contentPane;
	JDesktopPane Fundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saude frame = new Saude();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Saude() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Luis Alves\\Downloads\\favicon.ico"));
		setTitle("Posto de saude");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 447);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Consultas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Marcar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Marcar marc;
				try {
					marc = new Marcar();
					marc.setVisible(true);
					getContentPane().add(marc);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarConsultas listar = new ListarConsultas();
				Fundo.add(listar);
			}
		});
		mnNewMenu.add(mntmListar);
		
		JMenu mnPacientes = new JMenu("Pacientes");
		menuBar.add(mnPacientes);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPaciente pac;
				try {
					pac = new CadastroPaciente();
					pac.setVisible(true);
					Fundo.add(pac);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		mnPacientes.add(mntmCadastrar);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fundo.add(new ListarPaciente());
			}
		});
		mnPacientes.add(mntmListar_1);
		
		JMenu mnMdicos = new JMenu("M\u00E9dicos");
		menuBar.add(mnMdicos);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					CadastroMedico cadastro = new CadastroMedico();
					Fundo.add(cadastro);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		mnMdicos.add(mntmCadastrar_1);
		
		JMenuItem mntmListar_2 = new JMenuItem("Listar");
		mntmListar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListarMedico listar = new ListarMedico();
				Fundo.add(listar);
				
			}
		});
		mnMdicos.add(mntmListar_2);
		
		
		Fundo = new JDesktopPane();
		Fundo.setBounds(0, 0, 450, 398);
	    setContentPane(Fundo);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
	}
	
}
