package sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sistema.dao.ProfessorDAO;
import sistema.dao.factory.DaoFactory;

import java.awt.Color;

public class Professor extends JFrame {
	private JTextField jtfNome;
	private JTextField jtfCPF;
	private JTextField jtfTelefone;
	private JTextField jtfendereco;
	private JTextField jtfCEP;
	private JTextField jtfRG;
	private JTextField jtfCelular;
	private JTextField jtfCidade;
	private JTextField jtfEmail;
	private JPanel jtfPainel;
	private Cadastro cadastro;
	private ProfessorDAO professorDao=DaoFactory.get().professorDao();
	
	public Professor() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Cadastro Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 526);
		jtfPainel = new JPanel();
		jtfPainel.setBackground(Color.BLACK);
		jtfPainel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jtfPainel);
		jtfPainel.setLayout(null);

		JLabel lblAluno = new JLabel("Professor");
		lblAluno.setForeground(Color.RED);
		lblAluno.setFont(new Font("Dialog", Font.BOLD, 22));
		lblAluno.setBounds(307, 24, 148, 25);
		jtfPainel.add(lblAluno);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.RED);
		lblNome.setBounds(70, 143, 70, 15);
		jtfPainel.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.RED);
		lblCpf.setBounds(70, 233, 70, 15);
		jtfPainel.add(lblCpf);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setForeground(Color.RED);
		lblRg.setBounds(401, 233, 70, 15);
		jtfPainel.add(lblRg);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.RED);
		lblTelefone.setBounds(70, 271, 70, 15);
		jtfPainel.add(lblTelefone);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setForeground(Color.RED);
		lblCelular.setBounds(401, 271, 70, 15);
		jtfPainel.add(lblCelular);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.RED);
		lblCep.setBounds(401, 381, 70, 15);
		jtfPainel.add(lblCep);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setForeground(Color.RED);
		lblEndereco.setBounds(70, 314, 86, 15);
		jtfPainel.add(lblEndereco);

		jtfNome = new JTextField();
		jtfNome.setBounds(169, 141, 214, 19);
		jtfPainel.add(jtfNome);
		jtfNome.setColumns(10);

		jtfCPF = new JTextField();
		jtfCPF.setBounds(169, 230, 214, 19);
		jtfPainel.add(jtfCPF);
		jtfCPF.setColumns(10);

		jtfTelefone = new JTextField();
		jtfTelefone.setBounds(169, 269, 214, 19);
		jtfPainel.add(jtfTelefone);
		jtfTelefone.setColumns(10);

		jtfendereco = new JTextField();
		jtfendereco.setBounds(169, 312, 471, 19);
		jtfPainel.add(jtfendereco);
		jtfendereco.setColumns(10);

		jtfCEP = new JTextField();
		jtfCEP.setBounds(469, 378, 171, 19);
		jtfPainel.add(jtfCEP);
		jtfCEP.setColumns(10);

		jtfRG = new JTextField();
		jtfRG.setBounds(469, 231, 171, 19);
		jtfPainel.add(jtfRG);
		jtfRG.setColumns(10);

		jtfCelular = new JTextField();
		jtfCelular.setBounds(469, 269, 171, 19);
		jtfPainel.add(jtfCelular);
		jtfCelular.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.RED);
		lblCidade.setBounds(70, 383, 70, 15);
		jtfPainel.add(lblCidade);

		jtfCidade = new JTextField();
		jtfCidade.setBounds(169, 383, 214, 19);
		jtfPainel.add(jtfCidade);
		jtfCidade.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(Color.RED);
		lblSexo.setBounds(70, 190, 70, 15);
		jtfPainel.add(lblSexo);

		final JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setForeground(Color.BLUE);
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
		comboBoxSexo.setToolTipText("");
		comboBoxSexo.setBounds(169, 185, 214, 24);
		jtfPainel.add(comboBoxSexo);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.RED);
		lblEmail.setBounds(70, 354, 70, 15);
		jtfPainel.add(lblEmail);

		jtfEmail = new JTextField();
		jtfEmail.setBounds(169, 350, 471, 19);
		jtfPainel.add(jtfEmail);
		jtfEmail.setColumns(10);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("bio.jpg"));
		logo.setBounds(10, 26, 300, 93);
		jtfPainel.add(logo);

		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sistema.model.Professor professor=new sistema.model.Professor();
				professor.setNome(jtfNome.getText());
				professor.setSexo(comboBoxSexo.getSelectedItem().toString());
				professor.setCpf(Long.valueOf(jtfCPF.getText()));
				professor.setRg(Long.valueOf(jtfRG.getText()));
				professor.setTelefone(Long.valueOf(jtfTelefone.getText()));
				professor.setCelular(Long.valueOf(jtfCelular.getText()));
				professor.setEndereco(jtfendereco.getText());
				professor.setEmail(jtfEmail.getText());
				professor.setCidade(jtfCidade.getText());
				professor.setCep(jtfCEP.getText());
				professorDao.salvar(professor);
				JOptionPane.showMessageDialog(null, "Professor cadastrado com Sucesso!");
				dispose();
			}
		});
		btnSalvar.setIcon(new ImageIcon("salvar.gif"));
		btnSalvar.setBounds(307, 429, 35, 35);
		jtfPainel.add(btnSalvar);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtfNome.setText("");
				jtfCPF.setText("");
				jtfTelefone.setText("");
				jtfendereco.setText("");
				jtfCidade.setText("");
				jtfRG.setText("");
				jtfCelular.setText("");
				jtfCEP.setText("");
				jtfEmail.setText("");
			}
		});
		btnLimpar.setIcon(new ImageIcon("download.jpg"));
		btnLimpar.setBounds(432, 439, 86, 25);
		jtfPainel.add(btnLimpar);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon("voltar_icone.png"));
		btnVoltar.setBounds(612, 439, 50, 25);
		jtfPainel.add(btnVoltar);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				dispose();
				cadastro = new Cadastro();
				cadastro.setVisible(true);
			}
		});

	}

}