package sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Font;

public class Boleto extends JFrame {

	private JPanel contentPane;
	private JTextField jtfcodigoaluno;
	private Cadastro cadastro;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boleto frame = new Boleto();
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
	public Boleto() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Boleto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 325);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGerarBoleto = new JLabel("Gerar Boleto");
		lblGerarBoleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGerarBoleto.setForeground(Color.RED);
		lblGerarBoleto.setBounds(251, 30, 113, 15);
		contentPane.add(lblGerarBoleto);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.setForeground(Color.BLUE);
		btnGerar.setBounds(240, 219, 117, 25);
		contentPane.add(btnGerar);
		
		JLabel lblCodigoDoAluno = new JLabel("Codigo do Aluno:");
		lblCodigoDoAluno.setForeground(Color.RED);
		lblCodigoDoAluno.setBounds(65, 105, 122, 15);
		contentPane.add(lblCodigoDoAluno);
		
		jtfcodigoaluno = new JTextField();
		jtfcodigoaluno.setBounds(226, 103, 138, 19);
		contentPane.add(jtfcodigoaluno);
		jtfcodigoaluno.setColumns(10);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\Marcos\\workspace 3\\Academia\\imagens\\voltar_icone.png"));
		btnVoltar.setBounds(487, 219, 57, 25);
		contentPane.add(btnVoltar);
		
		JLabel jlbLogo = new JLabel("New label");
		jlbLogo.setIcon(new ImageIcon("C:\\Users\\Marcos\\workspace 3\\Academia\\imagens\\logo bio.png"));
		jlbLogo.setBounds(-15, 33, 159, 41);
		contentPane.add(jlbLogo);
		
		btnVoltar.addActionListener(    
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
