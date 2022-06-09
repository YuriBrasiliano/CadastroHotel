package br.dell.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.dell.model.Quarto;
import br.dell.model.Hospede;
import br.dell.util.ConnectionFactory;

public class Metodo {


		private Hospede hospede;
		private Quarto quarto;
		private Connection conn; // conecta com o banco de dados
		private PreparedStatement ps; // permite executar querys
		private ResultSet rs; // tabela

		public Metodo() throws Exception {
			try {
				conn = ConnectionFactory.getConnection();

			} catch (Exception erro) {
				throw new Exception("Erro " + erro.getMessage());
			}
		}

		public void checkin(Hospede hospede, Quarto quarto) throws Exception {
			try {
				String sql = "INSERT INTO hospede(CPF, Nome, RG, Idade, Endereco) values (?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, hospede.getCPF());
				ps.setString(2, hospede.getNome());
				ps.setString(3, hospede.getRG());
				ps.setInt(4, hospede.getIdade());
				ps.setString(5, hospede.getEndereco());
				ps.executeUpdate();
				
			} catch (Exception erro) {
				throw new Exception("Erro " + erro.getMessage());
			}
			try {
				String sql = "INSERT INTO quarto values (?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, quarto.getNumero());
				ps.setString(2, hospede.getNome());
				ps.setString(3, hospede.getCPF());
				ps.executeUpdate();
				
			} catch (Exception erro) {
				throw new Exception("Erro " + erro.getMessage());
			}
		}

		public void alterarcadastro(Hospede hospede, Quarto quarto) throws Exception {
			try {
				String sql = "UPDATE hospede SET Nome=?, RG=?, Idade=?, Endereco=?" 
							+ "WHERE CPF=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, hospede.getNome());
				ps.setString(2, hospede.getRG());
				ps.setInt(3, hospede.getIdade());
				ps.setString(4, hospede.getEndereco());
				ps.setString(5, hospede.getCPF());
				ps.executeUpdate();
			} catch (Exception erro) {
				throw new Exception("Erro " + erro.getMessage());
			}
			try {
				String sql = "UPDATE quarto SET hospede=?, numero=? WHERE CPF=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, hospede.getNome());
				ps.setString(2, quarto.getNumero());
				ps.setString(3, hospede.getCPF());
				ps.executeUpdate();
			} catch (Exception erro) {
				throw new Exception("Erro " + erro.getMessage());
			}
		}

		public void excluir_checkout(String CPF) throws Exception {
			try {
				String sql = "DELETE FROM hospede " + "WHERE CPF=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, CPF);
				ps.executeUpdate();
			} catch (Exception erro) {
				throw new Exception("Erro " + erro.getMessage());
			}
			try {
				String sql = "DELETE FROM quarto WHERE CPF=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, CPF);
				ps.executeUpdate();
			} catch (Exception erro) {
				throw new Exception("Erro " + erro.getMessage());
			}

		}

		
		public Hospede consultarhospede(String CPF) throws Exception {

			try {

				hospede = new Hospede();
				String sql = "SELECT * FROM hospede WHERE CPF=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, CPF);
				rs = ps.executeQuery();

				while (rs.next()) {
					hospede = new Hospede();
					hospede.setCPF(rs.getString(1));
					hospede.setNome(rs.getString(2));
					hospede.setIdade(rs.getInt(3));
					hospede.setEndereco(rs.getString(4));
					hospede.setRG(rs.getString(5));

				}


				return hospede;
			} catch (Exception e) {
				throw new Exception("Erro: " + e.getMessage());
			}
		}
		public Quarto consultarquarto(String CPF) throws Exception {
			try {

				quarto = new Quarto();
				String sql = "SELECT numero FROM quarto WHERE CPF=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, CPF);
				rs = ps.executeQuery();

				while (rs.next()) {
					quarto = new Quarto();
					quarto.setNumero(rs.getString(1));

				}


				return quarto;
			} catch (Exception e) {
				throw new Exception("Erro: " + e.getMessage());
			}
			

		}
	

		}



