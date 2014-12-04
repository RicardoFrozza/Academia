package sistema;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import sistema.dao.AlunoDAO;
import sistema.dao.ProfessorDAO;
import sistema.dao.factory.DaoFactory;

import sistema.model.Professor;
import sistema.model.aluno;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Resultado extends JFrame {

	private static final String DELETE = null;
	private JPanel contentPane;
	private DefaultTableModel dtmTabela=new DefaultTableModel();
	private JTable jtbTabela=new JTable();
	private ScrollPane scpRolagem=new ScrollPane();
	private ProfessorDAO professorDao=DaoFactory.get().professorDao();
	private AlunoDAO alunoDao=DaoFactory.get().alunoDao();
	
	private final JButton btnvoltar = new JButton("voltar");
	
	private JTable tabela;
	
	
	private JTextField jtfNome;
	private JTextField jtfCPF;
	private JTextField jtfTelefone;
	private JTextField jtfEndereco;
	private JTextField jtfCEP;
	private JTextField jtfRG;
	private JTextField jtfCelular;
	private JTextField jtfCidade;
	private JTextField jtfEmail;
	private JComboBox comboBoxSexo;
	private Aluno Objeto;
	private boolean editando;
	private Container dao;
	private JTable jtbDados = new JTable();
	private Cadastro cadastro;

	
	public void setValor(Integer linha){
		jtbTabela.getSelectionModel().clearSelection();
		jtbTabela.addRowSelectionInterval(linha, linha);
	}
	
	public Resultado() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 809, 10);
		contentPane.add(panel);
		
		scpRolagem.setBounds(6, 16, 733, 425);
		jtbTabela.setModel(dtmTabela);
		scpRolagem.add(jtbTabela);
		getContentPane().add(scpRolagem);
		
		dtmTabela.setRowCount(1);
		dtmTabela.setColumnCount(11);
		dtmTabela.setValueAt("Nome",0,0);
		dtmTabela.setValueAt("Funcao", 0, 1);
		dtmTabela.setValueAt("Endereco", 0, 2);
		dtmTabela.setValueAt("CPF", 0, 3);
		dtmTabela.setValueAt("Telefone", 0, 4);
		dtmTabela.setValueAt("Endereco", 0, 5);
		dtmTabela.setValueAt("E-mail", 0, 6);
		dtmTabela.setValueAt("RG", 0, 7);
		dtmTabela.setValueAt("Celular", 0, 8);
		dtmTabela.setValueAt("Cidade", 0, 9);
		dtmTabela.setValueAt("Sexo", 0, 10);
		
		
		int linha=1;
	
		for(aluno aluno:alunoDao.listarTodos()){
			dtmTabela.setRowCount(dtmTabela.getRowCount()+1);
			dtmTabela.setValueAt(aluno.getNome(), linha, 0);
			dtmTabela.setValueAt("Aluno", linha, 1);
			dtmTabela.setValueAt(aluno.getEndereco(), linha, 2);
			dtmTabela.setValueAt(aluno.getCpf(), linha, 3);
			dtmTabela.setValueAt(aluno.getTelefone(), linha, 4);
			dtmTabela.setValueAt(aluno.getEndereco(), linha, 5);
			dtmTabela.setValueAt(aluno.getEmail(), linha, 6);
			dtmTabela.setValueAt(aluno.getRg() , linha, 7);
			dtmTabela.setValueAt(aluno.getCelular(),linha, 8);
			dtmTabela.setValueAt(aluno.getCidade(),linha, 9);
			dtmTabela.setValueAt(aluno.getSexo(),linha, 10);
			
			linha++;
		}
		
		for(Professor professor:professorDao.listarTodos()){
			dtmTabela.setRowCount(dtmTabela.getRowCount()+1);
			dtmTabela.setValueAt(professor.getNome(), linha, 0);
			dtmTabela.setValueAt("Professor", linha, 1);
			dtmTabela.setValueAt(professor.getEndereco(), linha, 2);
			dtmTabela.setValueAt(professor.getCpf(), linha, 3);
			dtmTabela.setValueAt(professor.getTelefone(), linha, 4);
			dtmTabela.setValueAt(professor.getEndereco(), linha, 5);
			dtmTabela.setValueAt(professor.getEmail(), linha, 6);
			dtmTabela.setValueAt(professor.getRg(), linha, 7);
			dtmTabela.setValueAt(professor.getCelular(),linha,8);
			dtmTabela.setValueAt(professor.getCidade(),linha,9);
			dtmTabela.setValueAt(professor.getSexo(),linha,10);
			
			linha++;
		}
		
		JButton button = new JButton("");
		button.setBounds(5,440,809,10);
		button.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent evento) {
				dispose();
				Cadastro tela = new Cadastro();
				tela.setVisible(true);
				
			}
		});
		
		
		JButton btnvoltar = new JButton("Sair");
		btnvoltar.setBounds(740, 197, 89, 23);
		contentPane.add(btnvoltar);
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				dispose();
				cadastro = new Cadastro();
				cadastro.setVisible(true);
			}
		});
		
		

		
		

		
	}
}