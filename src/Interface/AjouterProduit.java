package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import source.Categorie;
import source.Produit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterProduit {

	private JFrame frame;
	private JTextField code;
	private JTextField nom;
	private JTextField des;
	private JTextField quantite;
	private JTextField seul;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterProduit window = new AjouterProduit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AjouterProduit() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 369, 343);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		code = new JTextField();
		code.setHorizontalAlignment(SwingConstants.CENTER);
		code.setBounds(115, 16, 219, 31);
		frame.getContentPane().add(code);
		code.setColumns(10);
		
		nom = new JTextField();
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setColumns(10);
		nom.setBounds(115, 63, 219, 31);
		frame.getContentPane().add(nom);
		
		des = new JTextField();
		des.setHorizontalAlignment(SwingConstants.CENTER);
		des.setColumns(10);
		des.setBounds(115, 110, 219, 31);
		frame.getContentPane().add(des);
		
		quantite = new JTextField();
		quantite.setHorizontalAlignment(SwingConstants.CENTER);
		quantite.setColumns(10);
		quantite.setBounds(115, 157, 219, 31);
		frame.getContentPane().add(quantite);
		
		seul = new JTextField();
		seul.setHorizontalAlignment(SwingConstants.CENTER);
		seul.setColumns(10);
		seul.setBounds(115, 204, 219, 31);
		frame.getContentPane().add(seul);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Categorie  cat :application.Categories ) {
					if(cat.getNom().equals(application.boxCategorie.getSelectedItem()))
				cat.list.add(new Produit( Integer.valueOf(code.getText()),nom.getText(),  des.getText(),Integer.valueOf(quantite.getText()), Integer.valueOf(seul.getText()) )) ;	
				}
				application.actualiserTable();
				frame.dispose();
				
			}
		});
		btnAjouter.setBounds(205, 251, 125, 31);
		frame.getContentPane().add(btnAjouter);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 63, 94, 31);
		frame.getContentPane().add(lblNom);
		
		JLabel lblCode = new JLabel("Code :");
		lblCode.setBounds(10, 16, 94, 31);
		frame.getContentPane().add(lblCode);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(10, 110, 94, 31);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblQuantite = new JLabel("Quantite  :");
		lblQuantite.setBounds(10, 157, 94, 31);
		frame.getContentPane().add(lblQuantite);
		
		JLabel lblSeuil = new JLabel("Seuil :");
		lblSeuil.setBounds(10, 204, 94, 31);
		frame.getContentPane().add(lblSeuil);
	}
}
