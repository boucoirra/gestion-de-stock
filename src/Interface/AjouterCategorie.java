package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import source.Categorie;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterCategorie {

	private JFrame frame;
	private JTextField code;
	private JTextField nom;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterCategorie window = new AjouterCategorie();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AjouterCategorie() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 378, 185);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		code = new JTextField();
		code.setBounds(115, 22, 219, 31);
		frame.getContentPane().add(code);
		code.setColumns(10);
		
		JLabel lblCode = new JLabel("Code :");
		lblCode.setBounds(10, 22, 94, 31);
		frame.getContentPane().add(lblCode);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(115, 62, 219, 31);
		frame.getContentPane().add(nom);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 62, 94, 31);
		frame.getContentPane().add(lblNom);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.Categories.add(new Categorie(Integer.valueOf(code.getText()),nom.getText())) ;
				application.actualiser() ;
				frame.dispose();
			}
		});
		btnAjouter.setBounds(206, 104, 125, 31);
		frame.getContentPane().add(btnAjouter);
	}
}
