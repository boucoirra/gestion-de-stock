package Interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import source.Categorie;
import source.Produit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class application {

	private JFrame frame;
	static  JTable table;
	private JTextField cherche;
	static JComboBox boxCategorie,cherche_par ;
	static ArrayList<Categorie> Categories =  new ArrayList<Categorie>() ;
	private JTextField seuil;
	private JTextField quantite;
	int index ;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					application window = new application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@SuppressWarnings("serial")
	static JTable getNTable(final JTable table) { // pour changer la color de la table  
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
		public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
       

                	if(Integer.valueOf(table.getModel().getValueAt(row,3 ).toString())<=Integer.valueOf(table.getModel().getValueAt(row,4 ).toString())){
                		setBackground(Color.red);
                        setForeground(Color.WHITE);

                	}else {
                		setBackground(Color.WHITE);
                        setForeground(Color.BLACK);
                	}
                
              
  
                return this;}});
        return table; }

	
	
	void cherche(int a) {
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
	    table.setRowSorter(sorter);
		if(a==0) {
		    

			List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(0);
		 filters.add(RowFilter.regexFilter("(?i)" + cherche.getText().toString()));

	@SuppressWarnings("unused")
	RowFilter<TableModel, Object>  compoundRowFilter = RowFilter.andFilter(filters); 
	 RowFilter<Object,Object> serviceFilter = RowFilter.andFilter(filters);
	  sorter.setRowFilter(serviceFilter);
			}
		if(a==1) {

			List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(1);

		 filters.add(RowFilter.regexFilter("(?i)" + cherche.getText().toString()));

	@SuppressWarnings("unused")
	RowFilter<TableModel, Object>  compoundRowFilter = RowFilter.andFilter(filters); 
	 RowFilter<Object,Object> serviceFilter = RowFilter.andFilter(filters);
	  sorter.setRowFilter(serviceFilter);
			}
 }


	public application() {
		initialize();

		actualiserTable() ;
		
	}

	static void actualiser() {
		boxCategorie.removeAllItems();boxCategorie.addItem("tous") ;
		for(Categorie cat :Categories) {
			boxCategorie.addItem(cat.getNom()) ;
		}	
	}
	
	static void actualiserTable() {
		TableModel MonModel = table.getModel();
		 ((DefaultTableModel) MonModel).getDataVector().removeAllElements();
		for(Categorie cat :Categories) {
		if(boxCategorie.getSelectedIndex()==0) {
		for(int i=0 ;i<cat.list.size();i++) {
		 ((DefaultTableModel) MonModel).addRow(new Object[] {cat.list.get(i).getCode(),cat.list.get(i).getNom(),cat.list.get(i).getDescription(),cat.list.get(i).getQuantite(),cat.list.get(i).getSeuil(),cat.getCode(),cat.getNom()});
		}}
		else {
			if(cat.getNom().equals(boxCategorie.getSelectedItem())) {
			for(int i=0 ;i<cat.list.size();i++) {
				 ((DefaultTableModel) MonModel).addRow(new Object[] {cat.list.get(i).getCode(),cat.list.get(i).getNom(),cat.list.get(i).getDescription(),cat.list.get(i).getQuantite(),cat.list.get(i).getSeuil(),cat.getCode(),cat.getNom()});
				}}
		}}
			table.setModel(MonModel);
		
	}
	


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1018, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 112, 938, 283);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(){
			public boolean isCellEditable(int row, int column) {
				return false;}};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					  index = table.getSelectedRow();
					 seuil.setText(table.getModel().getValueAt(index, 4).toString());
					 quantite.setText(table.getModel().getValueAt(index, 3).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code Produit", "Nom", "Description", "Quantite", "Seuil", "Code Categorie", "Categorie"
			}
		));
		table.getColumnModel().getColumn(6).setMinWidth(30);
		scrollPane.setViewportView(getNTable(table));
		JButton btnAjouterProduit = new JButton("Ajouter Produit");
		btnAjouterProduit.setVisible(false);
		btnAjouterProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterProduit.main(null);
			}
		});
		btnAjouterProduit.setBounds(242, 54, 140, 33);
		frame.getContentPane().add(btnAjouterProduit);
		 
		 JButton btnSuavegader = new JButton("sauvegarder");
		 btnSuavegader.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		for(int j=0;j<Categories.size();j++) {
		 			if(Categories.get(j).getCode()==Integer.valueOf(table.getValueAt(index, 0).toString()))
		 			for(int i=0 ;i<Categories.get(j).list.size();i++) {
		 				if(Categories.get(j).getCode()==Integer.valueOf((table.getValueAt(index, 5).toString()))) {
		 					Categories.get(j).list.get(i).setSeuil(Integer.valueOf(seuil.getText()));		
		 					Categories.get(j).list.get(i).setQuantite(Integer.valueOf(quantite.getText()));		
		 				}
		 						
		 			}}
		 		
		 			actualiserTable();}
		 	
		 });
		 btnSuavegader.setBounds(443, 406, 140, 33);
		 frame.getContentPane().add(btnSuavegader);
		
		cherche = new JTextField();
		cherche.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				cherche(cherche_par.getSelectedIndex()) ;
			}
		});
		cherche.setBounds(720, 68, 258, 33);
		frame.getContentPane().add(cherche);
		cherche.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Ajouter Categorie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AjouterCategorie.main(null);
				
			}
		});
		btnNewButton.setBounds(242, 11, 140, 33);
		frame.getContentPane().add(btnNewButton);
		
		 boxCategorie = new JComboBox();
		 boxCategorie.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actualiserTable() ;
		 		if(boxCategorie.getSelectedIndex()==0)
		 			btnAjouterProduit.setVisible(false);
		 		else
		 			btnAjouterProduit.setVisible(true);	
		 	}
		 });
		 boxCategorie.setModel(new DefaultComboBoxModel(new String[] {"tous"}));
		 boxCategorie.setSelectedIndex(0);
		 boxCategorie.setBounds(25, 11, 207, 33);
		 frame.getContentPane().add(boxCategorie);
		
		JLabel lblCherche = new JLabel("Cherche par  :");
		lblCherche.setBounds(467, 68, 97, 33);
		frame.getContentPane().add(lblCherche);
		
		 cherche_par = new JComboBox();
		cherche_par.setModel(new DefaultComboBoxModel(new String[] {"Code", "Nom"}));
		cherche_par.setBounds(591, 68, 119, 33);
		frame.getContentPane().add(cherche_par);
		
		seuil = new JTextField();
		seuil.setHorizontalAlignment(SwingConstants.CENTER);
		seuil.setBounds(136, 406, 86, 33);
		frame.getContentPane().add(seuil);
		seuil.setColumns(10);
		
		JLabel lblSeuil = new JLabel("Seuil :");
		lblSeuil.setBounds(50, 412, 86, 20);
		frame.getContentPane().add(lblSeuil);
		
		quantite = new JTextField();
		quantite.setHorizontalAlignment(SwingConstants.CENTER);
		quantite.setColumns(10);
		quantite.setBounds(347, 406, 86, 33);
		frame.getContentPane().add(quantite);
		
		JLabel lblQuantite = new JLabel("Quantite :");
		lblQuantite.setBounds(251, 412, 86, 20);
		frame.getContentPane().add(lblQuantite);
	}
}
