package sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import sistema.dao.jdbc.relatorio.RelatorioUtil;

import java.awt.Color;
import java.awt.Font;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private Aluno aluno;
	private Professor professor;
	private Pesquisa pesquisa;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Cadastro/Pesquisa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBioritmoAcademia = new JLabel("BIORITMO ACADEMIA");
		lblBioritmoAcademia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBioritmoAcademia.setForeground(Color.RED);
		lblBioritmoAcademia.setBounds(382, 11, 152, 25);
		contentPane.add(lblBioritmoAcademia);

		JButton btnAluno = new JButton("Aluno");
		btnAluno.setBounds(36, 196, 117, 25);
		contentPane.add(btnAluno);

		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				aluno = new Aluno();
				aluno.setVisible(true);
			}
		});

		JButton btnProfessor = new JButton("Professor");
		btnProfessor.setBounds(211, 196, 117, 25);
		contentPane.add(btnProfessor);

		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				professor = new Professor();
				professor.setVisible(true);
			}
		});

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(380, 196, 117, 25);
		contentPane.add(btnPesquisar);

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				dispose();
				pesquisa = new Pesquisa();
				pesquisa.setVisible(true);
			}
		});

		

		JLabel imgProfessor = new JLabel("");
		imgProfessor.setIcon(new ImageIcon("professor.png"));
		imgProfessor.setBounds(211, 64, 117, 114);
		contentPane.add(imgProfessor);

		JLabel imgPesquiza = new JLabel("");
		imgPesquiza.setIcon(new ImageIcon("pesquisar.png"));
		imgPesquiza.setBounds(380, 64, 117, 114);
		contentPane.add(imgPesquiza);

		JLabel imgAluno = new JLabel("");
		imgAluno.setIcon(new ImageIcon("aluno-icon.png"));
		imgAluno.setBounds(36, 64, 117, 120);
		contentPane.add(imgAluno);

		
		
		
		
		JLabel lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon("sair.jpg"));
		lblSair.setForeground(Color.WHITE);
		lblSair.setBounds(737, 64, 125, 119);
		contentPane.add(lblSair);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(740, 197, 89, 23);
		contentPane.add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		
	}
}