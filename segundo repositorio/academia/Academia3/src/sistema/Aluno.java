package sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import sistema.dao.AlunoDAO;
import sistema.dao.factory.DaoFactory;

import java.awt.Color;

public class Aluno extends JFrame {

	private JPanel contentPane;
	private JTextField jtfCPF;
	private JTextField jtfTelefone;
	private JTextField jtfEndereco;
	private JTextField jtfCEP;
	private JTextField jtfRG;
	private JTextField jtfCelular;
	private JTextField jtfCidade;
	private JTextField jtfEmail;
	
	
	private Cadastro cadastro;
	private AlunoDAO alunoDao=DaoFactory.get().alunoDao();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aluno frame = new Aluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Aluno() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Cadastro Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 526);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAluno = new JLabel("Aluno");
		lblAluno.setForeground(Color.RED);
		lblAluno.setFont(new Font("Dialog", Font.BOLD, 22));
		lblAluno.setBounds(323, 28, 117, 25);
		contentPane.add(lblAluno);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.RED);
		lblNome.setBounds(70, 143, 70, 15);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.RED);
		lblCpf.setBounds(70, 233, 70, 15);
		contentPane.add(lblCpf);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setForeground(Color.RED);
		lblRg.setBounds(401, 233, 70, 15);
		contentPane.add(lblRg);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.RED);
		lblTelefone.setBounds(70, 271, 70, 15);
		contentPane.add(lblTelefone);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setForeground(Color.RED);
		lblCelular.setBounds(401, 271, 70, 15);
		contentPane.add(lblCelular);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.RED);
		lblCep.setBounds(401, 381, 70, 15);
		contentPane.add(lblCep);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setForeground(Color.RED);
		lblEndereco.setBounds(70, 314, 86, 15);
		contentPane.add(lblEndereco);

		final JTextField jtfNome = new JTextField();
		jtfNome.setBounds(169, 141, 214, 19);
		contentPane.add(jtfNome);
		jtfNome.setColumns(10);

		jtfCPF = new JTextField();
		jtfCPF.setBounds(169, 231, 214, 19);
		contentPane.add(jtfCPF);
		jtfCPF.setColumns(10);

		jtfTelefone = new JTextField();
		jtfTelefone.setBounds(169, 269, 214, 19);
		contentPane.add(jtfTelefone);
		jtfTelefone.setColumns(10);

		jtfEndereco = new JTextField();
		jtfEndereco.setBounds(169, 312, 471, 19);
		contentPane.add(jtfEndereco);
		jtfEndereco.setColumns(10);

		jtfCEP = new JTextField();
		jtfCEP.setBounds(469, 379, 171, 19);
		contentPane.add(jtfCEP);
		jtfCEP.setColumns(10);

		jtfRG = new JTextField();
		jtfRG.setBounds(469, 231, 171, 19);
		contentPane.add(jtfRG);
		jtfRG.setColumns(10);

		jtfCelular = new JTextField();
		jtfCelular.setBounds(469, 269, 171, 19);
		contentPane.add(jtfCelular);
		jtfCelular.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.RED);
		lblCidade.setBounds(70, 383, 70, 15);
		contentPane.add(lblCidade);

		jtfCidade = new JTextField();
		jtfCidade.setBounds(169, 383, 214, 19);
		contentPane.add(jtfCidade);
		jtfCidade.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(Color.RED);
		lblSexo.setBounds(70, 190, 70, 15);
		contentPane.add(lblSexo);

		final JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setForeground(Color.BLUE);
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
		comboBoxSexo.setToolTipText("");
		comboBoxSexo.setBounds(169, 185, 214, 24);
		contentPane.add(comboBoxSexo);
		
		final JComboBox comboBoxDiaDaSemana = new JComboBox();
		comboBoxDiaDaSemana.setModel(new DefaultComboBoxModel(new String[] {"2 Dias", "3 Dias", "5 Dias"}));
		comboBoxSexo.setToolTipText("");
		comboBoxDiaDaSemana.setBounds(528, 187, 112, 20);
		contentPane.add(comboBoxDiaDaSemana);
		 

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.RED);
		lblEmail.setBounds(70, 354, 70, 15);
		contentPane.add(lblEmail);

		jtfEmail = new JTextField();
		jtfEmail.setBounds(169, 350, 471, 19);
		contentPane.add(jtfEmail);
		jtfEmail.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("bio.jpg"));
		label.setBounds(10, 26, 200, 95);
		contentPane.add(label);

		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				sistema.model.aluno aluno=new sistema.model.aluno();
				aluno.setNome(jtfNome.getText());
				aluno.setSexo(comboBoxSexo.getSelectedItem().toString());
				aluno.setCpf(Long.valueOf(jtfCPF.getText()));
				aluno.setRg(Long.valueOf(jtfRG.getText()));
				aluno.setTelefone(Long.valueOf(jtfTelefone.getText()));
				aluno.setCelular(Long.valueOf(jtfCelular.getText()));
				aluno.setEndereco(jtfEndereco.getText());
				aluno.setEmail(jtfEmail.getText());
				aluno.setCidade(jtfCidade.getText());
				aluno.setCep(jtfCEP.getText());
				aluno.setCep(jtfCEP.getText());
				
				
				alunoDao.salvar(aluno);
				JOptionPane.showMessageDialog(null, "Aluno cadastrado com Sucesso!");
				dispose();
			}
		});
		btnSalvar.setIcon(new ImageIcon("salvar.gif"));
		btnSalvar.setBounds(307, 429, 35, 35);
		contentPane.add(btnSalvar);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtfNome.setText("");
				jtfCPF.setText("");
				jtfTelefone.setText("");
				jtfEndereco.setText("");
				jtfCidade.setText("");
				jtfRG.setText("");
				jtfCelular.setText("");
				jtfCEP.setText("");
				jtfEmail.setText("");
			}
		});
		btnLimpar.setIcon(new ImageIcon("download.jpg"));
		btnLimpar.setBounds(432, 439, 86, 25);
		contentPane.add(btnLimpar);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon("voltar_icone.png"));
		btnVoltar.setBounds(618, 439, 57, 25);
		contentPane.add(btnVoltar);
		
		JLabel lblQuantidadesDeDias = new JLabel("Quantidades de dias:");
		lblQuantidadesDeDias.setForeground(Color.RED);
		lblQuantidadesDeDias.setBounds(401, 177, 117, 41);
		contentPane.add(lblQuantidadesDeDias);
		
		
		
		
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				dispose();
				cadastro = new Cadastro();
				cadastro.setVisible(true);
			}
		});

	}
}