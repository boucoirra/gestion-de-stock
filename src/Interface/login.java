package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField txtBachir;
	private JPasswordField pwdBachir;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public login() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 359, 174);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		txtBachir = new JTextField();
		txtBachir.setText("bachir");
		txtBachir.setBounds(115, 24, 215, 29);
		frame.getContentPane().add(txtBachir);
		txtBachir.setColumns(10);
		
		pwdBachir = new JPasswordField();
		pwdBachir.setText("bachir");
		pwdBachir.setBounds(115, 64, 215, 29);
		frame.getContentPane().add(pwdBachir);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 24, 134, 29);
		frame.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(10, 64, 134, 29);
		frame.getContentPane().add(lblPrenom);
		
		JButton btnConnexion = new JButton("connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtBachir.getText().equals("bachir") &&pwdBachir.getText().equals("bachir") ) {
					application.main(null);
					frame.dispose();
				}else
					JOptionPane.showMessageDialog(null," le  motpass  ou  nom incorecte ", " erreur ",JOptionPane.WARNING_MESSAGE);

			}
		});
		btnConnexion.setBounds(231, 104, 99, 23);
		frame.getContentPane().add(btnConnexion);
		
		JButton btnQuiter = new JButton("Quiter");
		btnQuiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnQuiter.setBounds(115, 104, 106, 23);
		frame.getContentPane().add(btnQuiter);
	}
}
