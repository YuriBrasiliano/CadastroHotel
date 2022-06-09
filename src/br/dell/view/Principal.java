package br.dell.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import br.dell.dao.Metodo;
import br.dell.model.Hospede;
import br.dell.model.Quarto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Principal {

	private JFrame frmHotel;
	private JTextField textNomeHospede;
	private JTextField textRG;
	private JTextField textCPF;
	private JTextField textIdade;
	private JTextField textEndereco;
	private JTextField textNumQuarto;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnCheckout;
	private JButton btnCheckout_1;
	private Hospede Hospede;
	private Quarto	quarto;
	private Metodo dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmHotel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHotel = new JFrame();
		frmHotel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		frmHotel.setTitle("Hotel");
		frmHotel.getContentPane().setForeground(UIManager.getColor("Button.darkShadow"));
		frmHotel.getContentPane().setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		frmHotel.setBounds(100, 100, 891, 562);
		frmHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotel.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Hospede");
		lblNome.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblNome.setBounds(108, 11, 191, 37);
		frmHotel.getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblCpf.setBounds(108, 71, 53, 25);
		frmHotel.getContentPane().add(lblCpf);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblRg.setBounds(108, 130, 42, 25);
		frmHotel.getContentPane().add(lblRg);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblIdade.setBounds(107, 192, 65, 25);
		frmHotel.getContentPane().add(lblIdade);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblEndereco.setBounds(108, 249, 96, 25);
		frmHotel.getContentPane().add(lblEndereco);
		
		JLabel lblNumQuarto = new JLabel("N\u00FAmero do Quarto");
		lblNumQuarto.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblNumQuarto.setBounds(315, 323, 180, 25);
		frmHotel.getContentPane().add(lblNumQuarto);
		
		textNomeHospede = new JTextField();
		textNomeHospede.setBounds(362, 15, 390, 33);
		frmHotel.getContentPane().add(textNomeHospede);
		textNomeHospede.setColumns(10);
		
		textRG = new JTextField();
		textRG.setColumns(10);
		textRG.setBounds(362, 131, 390, 33);
		frmHotel.getContentPane().add(textRG);
		
		textCPF = new JTextField();
		textCPF.setColumns(10);
		textCPF.setBounds(362, 72, 390, 33);
		frmHotel.getContentPane().add(textCPF);
		
		textIdade = new JTextField();
		textIdade.setColumns(10);
		textIdade.setBounds(362, 193, 96, 33);
		frmHotel.getContentPane().add(textIdade);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(362, 250, 390, 33);
		frmHotel.getContentPane().add(textEndereco);
		
		textNumQuarto = new JTextField();
		textNumQuarto.setBounds(270, 357, 278, 37);
		frmHotel.getContentPane().add(textNumQuarto);
		textNumQuarto.setColumns(10);
		
		JButton btnNewButton = new JButton("Check-In");
		btnNewButton.addActionListener(new ActionListener() {
			private Hospede hospede;
			private Quarto quarto;
			public void actionPerformed(ActionEvent e) {
				try {
					hospede = new Hospede();
					quarto = new Quarto();
					hospede.setCPF(textCPF.getText());
					hospede.setNome(textNomeHospede.getText());
					hospede.setRG(textRG.getText());
					hospede.setIdade(Integer.parseInt(textIdade.getText()));
					hospede.setEndereco(textEndereco.getText());
					quarto.setNumero(textNumQuarto.getText());
					dao = new Metodo();
					dao.checkin(hospede,quarto);
					JOptionPane.showMessageDialog(null, "Cadastro salvado com sucesso!");	


				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Houve um erro, o quarto está em uso ou o hospede está em outro quarto, faça o check-out e tente novamente");	


				}
			}
		});
		btnNewButton.setForeground(UIManager.getColor("Button.darkShadow"));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnNewButton.setBounds(43, 443, 136, 46);
		frmHotel.getContentPane().add(btnNewButton);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String CPF = (textCPF.getText());
					dao = new Metodo();
					dao.excluir_checkout(CPF);
					JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!");
				} catch (Exception erro) {

				}
			}
		});
		btnExcluir.setForeground(UIManager.getColor("Button.darkShadow"));
		btnExcluir.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnExcluir.setBounds(203, 443, 136, 46);
		frmHotel.getContentPane().add(btnExcluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			private Hospede hospede;
			private Quarto quarto;
			public void actionPerformed(ActionEvent arg0) {
				try {
					hospede = new Hospede();
					quarto = new Quarto();
					hospede.setNome(textNomeHospede.getText());
					hospede.setRG(textRG.getText());
					hospede.setIdade(Integer.parseInt(textIdade.getText()));
					hospede.setEndereco(textEndereco.getText());
					quarto.setNumero(textNumQuarto.getText());
					hospede.setCPF(textCPF.getText());
					dao = new Metodo();
					dao.alterarcadastro(hospede, quarto);
					JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Houve um erro, por favor verifique as informações e tente novamente!");	

				}

			}
		});
		btnAlterar.setForeground(UIManager.getColor("Button.darkShadow"));
		btnAlterar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnAlterar.setBounds(363, 443, 136, 46);
		frmHotel.getContentPane().add(btnAlterar);
		
		btnCheckout = new JButton("Consultar");
		btnCheckout.addActionListener(new ActionListener() {
			private Hospede hospede;
			private Quarto quarto;
			public void actionPerformed(ActionEvent e) {
				try {
					String CPF = (textCPF.getText());
					dao = new Metodo();	
					hospede = dao.consultarhospede(CPF);
					quarto = dao.consultarquarto(CPF);								
					textNomeHospede.setText(hospede.getNome());
					textEndereco.setText(hospede.getEndereco());
					String idade = String.valueOf(hospede.getIdade());  
					textIdade.setText(idade);					
					textRG.setText(hospede.getRG());
					textNumQuarto.setText(quarto.getNumero());
					
					JOptionPane.showMessageDialog(null, "Consulta realizada com sucesso!");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Por favor verifique o CPF e tente novamente");
}

			}
		});

		btnCheckout.setForeground(UIManager.getColor("Button.darkShadow"));
		btnCheckout.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnCheckout.setBounds(526, 443, 136, 46);
		frmHotel.getContentPane().add(btnCheckout);
		
		btnCheckout_1 = new JButton("Check-Out");
		btnCheckout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String CPF = (textCPF.getText());
					dao = new Metodo();
					dao.excluir_checkout(CPF);
					JOptionPane.showMessageDialog(null, "Check-Out realizado com sucesso!");
				} catch (Exception erro) {

				}
			}
		});
		
		btnCheckout_1.setForeground(UIManager.getColor("Button.darkShadow"));
		btnCheckout_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnCheckout_1.setBounds(684, 443, 136, 46);
		frmHotel.getContentPane().add(btnCheckout_1);
	}
}
