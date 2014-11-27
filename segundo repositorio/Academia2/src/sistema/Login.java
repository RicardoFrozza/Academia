package sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField jtfLogin;
	private JPasswordField jtfSenha;

	private String Login = "bio";
	private String Senha = "456";

	private Cadastro cadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 355);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.RED);
		lblLogin.setBounds(76, 107, 70, 15);
		contentPane.add(lblLogin);

		jtfLogin = new JTextField();
		jtfLogin.setBounds(149, 107, 172, 19);
		contentPane.add(jtfLogin);
		jtfLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.RED);
		lblSenha.setBounds(76, 162, 70, 15);
		contentPane.add(lblSenha);

		jtfSenha = new JPasswordField();
		jtfSenha.setBounds(149, 158, 172, 19);
		contentPane.add(jtfSenha);
		jtfSenha.setColumns(10);

		final JButton btnOk = new JButton("OK!");
		btnOk.setForeground(Color.BLUE);
		btnOk.setBounds(184, 241, 117, 25);
		contentPane.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jtfLogin.getText().equals("bio")) {
					if (jtfSenha.getText().equals("456")) {
						Cadastro frame = new Cadastro();
						frame.setVisible(true);
						dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "login incorreto");
					jtfLogin.setText("");
					jtfSenha.setText("");
				}
			}
		});
		getContentPane().add(btnOk);

		JLabel lblBioritmoAcademia = new JLabel("BIORITMO ACADEMIA");
		lblBioritmoAcademia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBioritmoAcademia.setForeground(Color.RED);
		lblBioritmoAcademia.setBounds(163, 24, 147, 15);
		contentPane.add(lblBioritmoAcademia);
	}
}