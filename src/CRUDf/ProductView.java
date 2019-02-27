package CRUDf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ProductView extends JFrame{
    private static final long serialVersionUID = -6371598699261801930L;
    private JPanel contentPane;
    private JTextField txtAmount;
    private JTextField txtWhy;
    private JTextField txtDescription;
    private JTextField txtCode;
    private JTable table;
    private JTextField txtSearch;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductView frame = new ProductView();
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
    public ProductView() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(ProductView.class.getResource("/IMG/iconfinder_java_386470.png")));
        setTitle("CRUD JAVA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 608, 592);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCode = new JLabel("CODE");
        lblCode.setBounds(29, 55, 46, 14);
        contentPane.add(lblCode);

        JLabel lblDescription = new JLabel("DESCRIPCTION");
        lblDescription.setBounds(29, 102, 72, 14);
        contentPane.add(lblDescription);

        JLabel lblWhy = new JLabel("WHY");
        lblWhy.setBounds(29, 143, 46, 14);
        contentPane.add(lblWhy);

        JLabel lblAmount = new JLabel("AMOUNT");
        lblAmount.setBounds(29, 187, 83, 14);
        contentPane.add(lblAmount);

        txtAmount = new JTextField();
        txtAmount.setBounds(122, 184, 355, 20);
        contentPane.add(txtAmount);
        txtAmount.setColumns(10);

        txtWhy = new JTextField();
        txtWhy.setBounds(122, 140, 355, 20);
        contentPane.add(txtWhy);
        txtWhy.setColumns(10);

        txtDescription = new JTextField();
        txtDescription.setBounds(122, 99, 355, 20);
        contentPane.add(txtDescription);
        txtDescription.setColumns(10);

        txtCode = new JTextField();
        txtCode.setEditable(false);
        txtCode.setBounds(122, 52, 355, 20);
        contentPane.add(txtCode);
        txtCode.setColumns(10);

        JButton btnSave = new JButton("Save");
        btnSave.setIcon(new ImageIcon(ProductView.class.getResource("/IMG/iconfinder_floppy_285657 (2).png")));
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(txtCode.getText().equals("")) {
                    Product product = new Product();
                    ProductDAO dao  = new ProductDAO();
                    product.setDescription(txtDescription.getText());
                    product.setWhy(Double.parseDouble(txtWhy.getText().replace(",",".")));
                    product.setAmount(Double.parseDouble(txtAmount.getText().replace(",",".")));
                    dao.insert(product);
                    showTable();
                    clean();
                }else {
                    Product product = new Product();
                    ProductDAO dao  = new ProductDAO();
                    product.setCode(Integer.parseInt(txtCode.getText()));
                    product.setDescription(txtDescription.getText());
                    product.setWhy(Double.parseDouble(txtWhy.getText().replace(",",".")));
                    product.setAmount(Double.parseDouble(txtAmount.getText().replace(",",".")));
                    dao.change(product);
                    showTable();
                    clean();
                }
            }
        });
        btnSave.setBounds(122, 235, 97, 23);
        contentPane.add(btnSave);

        JButton btnClean = new JButton("Clean");
        btnClean.setIcon(new ImageIcon(ProductView.class.getResource("/IMG/iconfinder_sign-info_299086.png")));
        btnClean.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clean();
            }
        });
        btnClean.setBounds(379, 235, 97, 23);
        contentPane.add(btnClean);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setIcon(new ImageIcon(ProductView.class.getResource("/IMG/iconfinder_sign-error_299045 (1).png")));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int i = JOptionPane.showConfirmDialog(null, "Do you really want to remove", "Do you want to remove", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    ProductDAO dao = new ProductDAO();
                    dao.delete(Integer.parseInt(txtCode.getText()));
                    JOptionPane.showMessageDialog(null,"O Product"+ txtDescription.getText() + "was successfully removed");
                    clean();
                }
            }
        });
        btnDelete.setBounds(250, 235, 97, 23);
        contentPane.add(btnDelete);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 296, 547, 246);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                selectData();
            }
        });
        scrollPane.setViewportView(table);

        txtSearch = new JTextField();
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent arg0) {
                String description = txtSearch.getText();
                searchTable(description);
            }
        });
        txtSearch.setBounds(122, 269, 355, 20);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);

        JLabel lblSearch = new JLabel("Search");
        lblSearch.setIcon(new ImageIcon(ProductView.class.getResource("/IMG/iconfinder_search_285651.png")));
        lblSearch.setBounds(29, 272, 83, 14);
        contentPane.add(lblSearch);

        /*JButton btnCreateDatabase = new JButton("Create Table");
        btnCreateDatabase.setIcon(new ImageIcon(ProductView.class.getResource("/IMG/iconfinder_Database_4_40097.png")));
        btnCreateDatabase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ProductDAO dao = new ProductDAO();
                dao.createDatabase();
            }
        });
        btnCreateDatabase.setBounds(29, 11, 155, 23);
        contentPane.add(btnCreateDatabase);*/

        showTable();
    }

    public void showTable() {

        DefaultTableModel model = new DefaultTableModel(){
            //bloqueia editat coluna
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        model.addColumn("CODE");
        model.addColumn("DESCRIPTION");
        model.addColumn("WHY");
        model.addColumn("AMOUNT");
        table.setModel(model);

        ProductDAO dao = new ProductDAO();
        List<Product> listProduct = new ArrayList<>();
        listProduct = dao.listAll();

        for (Product prod : listProduct) {
            String[] line = new String[5];
            line[0] = Integer.toString(prod.getCode());
            line[1] = prod.getDescription();
            line[2] = prod.getWhy().toString().replace(".",",");
            line[3] = prod.getAmount().toString().replace(".",",");
            model.addRow(line);
        }

    }

    public void searchTable(String description) {

        DefaultTableModel model = new DefaultTableModel(){
            //bloqueia editat coluna
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        model.addColumn("CODE");
        model.addColumn("DESCRIPTION");
        model.addColumn("WHY");
        model.addColumn("AMOUNT");
        table.setModel(model);

        ProductDAO dao = new ProductDAO();
        List<Product> listProduct = new ArrayList<>();
        listProduct = dao.listDescription(description);

        for (Product prod : listProduct) {
            String[] line = new String[5];
            line[0] = Integer.toString(prod.getCode());
            line[1] = prod.getDescription();
            line[2] = prod.getWhy().toString().replace(".",",");
            line[3] = prod.getAmount().toString().replace(".",",");
            model.addRow(line);
        }

    }
    public void selectData() {
        int row = table.getSelectedRow();
        txtCode.setText((String) table.getValueAt(row, 0));
        txtDescription.setText((String) table.getValueAt(row, 1));
        txtWhy.setText((String) table.getValueAt(row, 2));
        txtAmount.setText((String) table.getValueAt(row, 3));
    }
    public void clean() {
        txtCode.setText("");
        txtDescription.setText("");
        txtWhy.setText("");
        txtAmount.setText("");
    }
}
