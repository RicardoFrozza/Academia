package sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;

import sistema.dao.AlunoDAO;
import sistema.dao.ProfessorDAO;
import sistema.dao.factory.DaoFactory;

public class Pesquisa extends JFrame {

	private JPanel jlselecione;
	private JTextField jtfNome;
	private Cadastro cadastro;
	private List alunoProfessor=new ArrayList();
	private ProfessorDAO professorDao=DaoFactory.get().professorDao();
	private AlunoDAO alunoDao=DaoFactory.get().alunoDao();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisa frame = new Pesquisa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Pesquisa() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Pesquisar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 357);
		jlselecione = new JPanel();
		jlselecione.setBackground(Color.BLACK);
		jlselecione.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jlselecione);
		jlselecione.setLayout(null);
		
		JLabel lblPesquisa = new JLabel("Pesquisa");
		lblPesquisa.setForeground(Color.RED);
		lblPesquisa.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPesquisa.setBounds(265, 28, 107, 15);
		jlselecione.add(lblPesquisa);
		
		final JRadioButton rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.setForeground(Color.BLUE);
		rdbtnAluno.setBounds(65, 142, 72, 23);
		jlselecione.add(rdbtnAluno);
		
		final JRadioButton rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setForeground(Color.BLUE);
		rdbtnProfessor.setBounds(65, 169, 94, 23);
		jlselecione.add(rdbtnProfessor);
		
		JLabel lblSelecione = new JLabel("Selecione:");
		lblSelecione.setForeground(Color.RED);
		lblSelecione.setBounds(65, 92, 94, 15);
		jlselecione.add(lblSelecione);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.RED);
		lblNome.setBounds(233, 171, 70, 15);
		jlselecione.add(lblNome);
		
		jtfNome = new JTextField();
		jtfNome.setBounds(293, 169, 291, 19);
		jlselecione.add(jtfNome);
		jtfNome.setColumns(10);
		
		alunoProfessor.addAll(alunoDao.listarTodos());
		alunoProfessor.addAll(professorDao.listarTodos());
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon("icon_pesq.gif"));
		btnPesquisar.setBounds(313, 280, 94, 31);
		jlselecione.add(btnPesquisar);
		
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!rdbtnAluno.isSelected()&&!rdbtnProfessor.isSelected()){
					JOptionPane.showMessageDialog(null, "Escolha a forma de pesquisa");
				}
				else if(jtfNome.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Digite o nome da pessoa que deseja pesquisar");
				}
				else{
					int linha=-1;
					for(int i=0;i<alunoProfessor.size();i++){
						if(alunoProfessor.get(i) instanceof sistema.model.Aluno){
							sistema.model.Aluno aluno= new sistema.model.Aluno();
							aluno=(sistema.model.Aluno)alunoProfessor.get(i);
							if(aluno.getNome().equals(jtfNome.getText())){
								linha=i+1;
								break;
							}
						}
						if(alunoProfessor.get(i) instanceof sistema.model.Professor){
							sistema.model.Professor professor=new sistema.model.Professor();
							professor=(sistema.model.Professor)alunoProfessor.get(i);
							if(professor.getNome().equals(jtfNome.getText())){
								linha=i+1;
								break;
							}
						}
					}
					if(linha==-1){
						if(rdbtnAluno.isSelected()){
							JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado");
						}
						if(rdbtnProfessor.isSelected()){
							JOptionPane.showMessageDialog(null, "Nenhum professor encontrado");
						}
					}
					else{
						Resultado tela=new Resultado();
						tela.setValor(linha);
						tela.setVisible(true);
						dispose();
					}
				}
			}
		});
		
		JButton btnvoltar = new JButton("");
		btnvoltar.setIcon(new ImageIcon("voltar_icone.png"));
		btnvoltar.setBounds(492, 280, 57, 25);
		jlselecione.add(btnvoltar);
		
		ButtonGroup btgEscolha=new ButtonGroup();
		btgEscolha.add(rdbtnProfessor);
		btgEscolha.add(rdbtnAluno);
		
		JLabel logo = new JLabel("New label");
		logo.setIcon(new ImageIcon("bio.jpg"));
		logo.setBounds(0, 0, 200, 93);
		jlselecione.add(logo);
		
		btnvoltar.addActionListener(    
				   new ActionListener(){    
				      public void actionPerformed(ActionEvent evento){    
				    	   dispose();   
				    	  cadastro = new Cadastro();  
				             cadastro.setVisible(true);  
				      }    
				   }    
				);  
	}
}