package main.java.addressbook;

import javax.swing.table.DefaultTableModel;

public class UI_Implementation extends UI {

	public static final long serialVersionUID = 1L;
	private UIController controller;

	private javax.swing.JTable contactTable;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField searchField;

	private static final String[] TABLEFIELDS = new String [] { "Lastname", "Firstname", "Address", "Phone" };
 
	/** Creates new form UI */
	public UI_Implementation() {
		initComponents();

	}

	public void setController(UIController controller) {
		this.controller = controller;
	}
	
	private void searchFieldActionPerformed(java.awt.event.ActionEvent e) {
		controller.searchFieldEvent(e);
	} 

	private void contactTableActionPerformed(javax.swing.event.TableModelEvent e) {
		controller.contactTableEvent(e);
	}
	
	public void setContactTable(String [][] contacts) {
		DefaultTableModel m = new DefaultTableModel(contacts, TABLEFIELDS);
		contactTable.setModel(m);
		
		searchField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				searchFieldActionPerformed(e);
			}
		});
		
		m.addTableModelListener(new javax.swing.event.TableModelListener() {
			public void tableChanged(javax.swing.event.TableModelEvent e) {
				contactTableActionPerformed(e);
			}
			}
		);
	}
	
	public String getContactTableValue(int row, int column) {
		javax.swing.table.TableModel m = contactTable.getModel();
		return (String) m.getValueAt(row, column);
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		contactTable = new javax.swing.JTable();
		searchField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		contactTable.setAutoCreateRowSorter(true);
		

		String[][] empty = new String[][] {   {null, null, null, null}   };
		setContactTable(empty);
		jScrollPane1.setViewportView(contactTable);
		
		searchField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchFieldActionPerformed(evt);
			}
		});
		
		jLabel1.setText("Filter:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(359, Short.MAX_VALUE)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
								.addComponent(jLabel1))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
		);

		pack();
	}// </editor-fold>


}

