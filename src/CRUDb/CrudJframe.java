package CRUDb;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrudJframe extends JFrame implements ActionListener {

	private JTable table;
	private JTextField txtProfile;
	private JLabel lblProfile;
	private JButton b1;
	private Frame f1;
	private JPanel panel;
	private JPanel panel1;
	DefaultTableModel model;
	private JTextField txtUser;
	private JLabel lblUser;
	private JTextField txtName;
	private JLabel lblName;
	private JTextField txtSurname;
	private JLabel lblSurname;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnRemove;
	private UserDao userDao;
	private String user_before = null;

	CrudJframe() {
		this.setLayout(new BorderLayout());

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		panel.setBackground(Color.GRAY);

		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 3));
		panel1.setBackground(Color.LIGHT_GRAY);

		lblProfile = new JLabel("Profile");
		txtProfile = new JTextField();
		lblUser = new JLabel("User");
		txtUser = new JTextField();
		lblName = new JLabel("Name");
		txtName = new JTextField();
		lblSurname = new JLabel("Surname");
		txtSurname = new JTextField();

		b1 = new JButton("Bring data");
		this.setTitle("CRUDa");
		this.setSize(800, 400);
		loadTable();
		this.add(table, BorderLayout.CENTER);
		this.add(b1, BorderLayout.PAGE_START);

		panel.add(lblProfile);
		panel.add(txtProfile);
		panel.add(lblUser);
		panel.add(txtUser);
		panel.add(lblName);
		panel.add(txtName);
		panel.add(lblSurname);
		panel.add(txtSurname);

		btnInsert = new JButton("Insert");
		btnUpdate = new JButton("Update");
		btnRemove = new JButton("Remove");

		panel1.add(btnInsert);
		panel1.add(btnUpdate);
		panel1.add(btnRemove);

		this.add(panel, BorderLayout.PAGE_END);

		this.add(panel1, BorderLayout.EAST);

		this.add(new JScrollPane(table));
		b1.addActionListener(this);
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnRemove.addActionListener(this);
	}

	private void loadTable() {
		model = new DefaultTableModel();
		/* nombre columnas */
		model.addColumn("Profile");
		model.addColumn("User");
		model.addColumn("Name");
		model.addColumn("Surname");

		table = new JTable(model);

		userDao = new UserDao();
		userDao.consult(model, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String profile = String.valueOf(model.getValueAt(table.getSelectedRow(), 0));
			String user = String.valueOf(model.getValueAt(table.getSelectedRow(), 1));
			String name = String.valueOf(model.getValueAt(table.getSelectedRow(), 2));
			String surname = String.valueOf(model.getValueAt(table.getSelectedRow(), 3));

			this.user_before = user;

			txtProfile.setText(profile);
			txtUser.setText(user);
			txtName.setText(name);
			txtSurname.setText(surname);
		}

		if (e.getSource() == btnInsert) {
			userDao.insert(txtProfile.getText(), txtUser.getText(), txtName.getText(), txtSurname.getText());
			txtProfile.setText("");
			txtUser.setText("");
			txtName.setText("");
			txtSurname.setText("");
		}

		if (e.getSource() == btnUpdate) {
			userDao.update(this.user_before, txtProfile.getText(), txtUser.getText(), txtName.getText(), txtSurname.getText());
			txtProfile.setText("");
			txtUser.setText("");
			txtName.setText("");
			txtSurname.setText("");
		}

		if (e.getSource() == btnRemove) {
			userDao.remove(txtUser.getText());
			txtProfile.setText("");
			txtUser.setText("");
			txtName.setText("");
			txtSurname.setText("");
		}

		cleanTable();
		userDao.consult(model, null);
	}

	public static void main(String[] args) {
		CrudJframe crud = new CrudJframe();
		crud.setVisible(true);
	}

	private void cleanTable() {
		for (int i = 0; i < table.getRowCount(); i++) {
			model.removeRow(i);
			i -= 1;
		}
	}
}