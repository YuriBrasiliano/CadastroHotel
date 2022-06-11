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
import javax.swing.JTextArea;

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

	private static String gerarQuarto(){
		int qtdeMaximaCaracteres = 3;
	    String[] numeros = {"1","2","3"};
	    String[] letras = { "A", "B", "C"};
	    
		StringBuilder quarto = new StringBuilder();

        for (int i = 0; i < 1; i++) {
            int posicao = (int) (Math.random() * letras.length);
            quarto.append(letras[posicao]);
        }
        for (int i = 1; i < qtdeMaximaCaracteres; i++) {
            int posicao = (int) (Math.random() * numeros.length);
            quarto.append(numeros[posicao]);
        }
        return quarto.toString();
        
	}
	private void initialize() {
		frmHotel = new JFrame();
		frmHotel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		frmHotel.setTitle("Hotel");
		frmHotel.getContentPane().setForeground(UIManager.getColor("Button.darkShadow"));
		frmHotel.getContentPane().setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		frmHotel.setBounds(100, 100, 835, 693);
		frmHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotel.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Hospede");
		lblNome.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblNome.setBounds(88, 11, 191, 37);
		frmHotel.getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblCpf.setBounds(88, 71, 53, 25);
		frmHotel.getContentPane().add(lblCpf);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblRg.setBounds(88, 130, 42, 25);
		frmHotel.getContentPane().add(lblRg);
		
		final JComboBox comboDia_Entrada = new JComboBox();
		comboDia_Entrada.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboDia_Entrada.setBounds(342, 318, 65, 30);
		frmHotel.getContentPane().add(comboDia_Entrada);
		
		final JComboBox comboDia_Saida = new JComboBox();
		comboDia_Saida.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboDia_Saida.setBounds(342, 387, 65, 30);
		frmHotel.getContentPane().add(comboDia_Saida);
		
		final JComboBox comboMes_Entrada = new JComboBox();
		comboMes_Entrada.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboMes_Entrada.setBounds(436, 318, 170, 30);
		frmHotel.getContentPane().add(comboMes_Entrada);
		
		final JComboBox comboMes_Saida = new JComboBox();
		comboMes_Saida.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboMes_Saida.setBounds(436, 387, 170, 30);
		frmHotel.getContentPane().add(comboMes_Saida);
		
		final JComboBox comboAno_Entrada = new JComboBox();
		comboAno_Entrada.setModel(new DefaultComboBoxModel(new String[] {"", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		comboAno_Entrada.setBounds(633, 318, 99, 30);
		frmHotel.getContentPane().add(comboAno_Entrada);
		
		final JComboBox comboAno_Saida = new JComboBox();
		comboAno_Saida.setModel(new DefaultComboBoxModel(new String[] {"", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		comboAno_Saida.setBounds(633, 387, 99, 30);
		frmHotel.getContentPane().add(comboAno_Saida);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblIdade.setBounds(87, 192, 65, 25);
		frmHotel.getContentPane().add(lblIdade);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblEndereco.setBounds(88, 249, 96, 25);
		frmHotel.getContentPane().add(lblEndereco);
		
		JLabel lblNumQuarto = new JLabel("N\u00FAmero do Quarto");
		lblNumQuarto.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblNumQuarto.setBounds(322, 462, 180, 25);
		frmHotel.getContentPane().add(lblNumQuarto);
		
		textNomeHospede = new JTextField();
		textNomeHospede.setBounds(342, 15, 390, 33);
		frmHotel.getContentPane().add(textNomeHospede);
		textNomeHospede.setColumns(10);
		
		textRG = new JTextField();
		textRG.setColumns(10);
		textRG.setBounds(342, 131, 390, 33);
		frmHotel.getContentPane().add(textRG);
		
		textCPF = new JTextField();
		textCPF.setColumns(10);
		textCPF.setBounds(342, 72, 390, 33);
		frmHotel.getContentPane().add(textCPF);
		
		textIdade = new JTextField();
		textIdade.setColumns(10);
		textIdade.setBounds(342, 193, 96, 33);
		frmHotel.getContentPane().add(textIdade);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(342, 250, 390, 33);
		frmHotel.getContentPane().add(textEndereco);
		
		textNumQuarto = new JTextField();
		textNumQuarto.setBounds(277, 496, 278, 37);
		frmHotel.getContentPane().add(textNumQuarto);
		textNumQuarto.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Check-In");
		btnNewButton.addActionListener(new ActionListener() {
			private Hospede hospede;
			private Quarto quarto;
			public void actionPerformed(ActionEvent e) {
				String dia_entrada = String.valueOf(comboDia_Entrada.getSelectedItem());
				if(dia_entrada.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por Favor selecione um dia válido!");	
				}
				String mes_entrada = String.valueOf(comboMes_Entrada.getSelectedItem());
				switch (mes_entrada) {
				case "Janeiro": mes_entrada = "01";break;
				case "Fevereiro": mes_entrada = "02";break;
				case "Março": mes_entrada = "03";break;
				case "Abril": mes_entrada = "04";break;
				case "Maio": mes_entrada = "05";break;
				case "Junho": mes_entrada = "06";break;
				case "Julho": mes_entrada = "07";break;
				case "Agosto": mes_entrada = "08";break;
				case "Setembro": mes_entrada = "09";break;
				case "Outubro": mes_entrada = "10";break;
				case "Novembro": mes_entrada = "11";break;
				case "Dezembro": mes_entrada = "12";break;
				default:JOptionPane.showMessageDialog(null, "Por Favor selecione um mês válido!");	
				}
				String ano_entrada = String.valueOf(comboAno_Entrada.getSelectedItem());
				if(ano_entrada.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por Favor selecione um ano válido!");	
				}
				String dta_entrada = dia_entrada+mes_entrada+ano_entrada;
				String dia_saida = String.valueOf(comboDia_Saida.getSelectedItem());
				if(dia_saida.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por Favor selecione um dia válido!");	
				}
				String mes_saida = String.valueOf(comboMes_Saida.getSelectedItem());
				switch (mes_saida) {
				case "Janeiro": mes_saida = "01";break;
				case "Fevereiro": mes_saida = "02";break;
				case "Março": mes_saida = "03";break;
				case "Abril": mes_saida = "04";break;
				case "Maio": mes_saida = "05";break;
				case "Junho": mes_saida = "06";break;
				case "Julho": mes_saida = "07";break;
				case "Agosto": mes_saida = "08";break;
				case "Setembro": mes_saida = "09";break;
				case "Outubro": mes_saida = "10";break;
				case "Novembro": mes_saida = "11";break;
				case "Dezembro": mes_saida = "12";break;
				default:JOptionPane.showMessageDialog(null, "Por Favor selecione um mês válido!");	
				}
				String ano_saida = String.valueOf(comboAno_Saida.getSelectedItem());
				if(ano_saida.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por Favor selecione um ano válido!");	
				}
				String dta_saida = dia_saida+mes_saida+ano_saida;
				try {
					hospede = new Hospede();
					quarto = new Quarto();
					hospede.setCPF(textCPF.getText());
					String nomeHospede = textNomeHospede.getText();
					hospede.setNome(nomeHospede);
					hospede.setRG(textRG.getText());
					hospede.setIdade(Integer.parseInt(textIdade.getText()));
					hospede.setEndereco(textEndereco.getText());
					String Numquarto = textNumQuarto.getText();
					if (Numquarto.isEmpty()) {
						Numquarto = gerarQuarto();
					}
					quarto.setNumero(Numquarto);
					quarto.setDta_entrada(dta_entrada);
					quarto.setDta_saida(dta_saida);
					dao = new Metodo();
					dao.checkin(hospede,quarto);
					JOptionPane.showMessageDialog(null, "Check-In realizado com sucesso! O Senhor(a) "+nomeHospede+" ficará no quarto "+Numquarto);	
					textNumQuarto.setText(quarto.getNumero());

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Houve um erro, o quarto está em uso ou o hospede está em outro quarto, faça o check-out e tente novamente"+erro);	


				}
			}
		});
		btnNewButton.setForeground(UIManager.getColor("Button.darkShadow"));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnNewButton.setBounds(20, 577, 136, 46);
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
		btnExcluir.setBounds(180, 577, 136, 46);
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
		btnAlterar.setBounds(340, 577, 136, 46);
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
		btnCheckout.setBounds(503, 577, 136, 46);
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
		btnCheckout_1.setBounds(661, 577, 136, 46);
		frmHotel.getContentPane().add(btnCheckout_1);
		
		JLabel lblDta_Entrada = new JLabel("Data de Entrada");
		lblDta_Entrada.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblDta_Entrada.setBounds(88, 318, 159, 30);
		frmHotel.getContentPane().add(lblDta_Entrada);
		
		JLabel lblDta_Saida = new JLabel("Data de Sa\u00EDda");
		lblDta_Saida.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		lblDta_Saida.setBounds(88, 387, 136, 30);
		frmHotel.getContentPane().add(lblDta_Saida);
		

	}
}
