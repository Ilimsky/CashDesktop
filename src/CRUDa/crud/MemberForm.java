package CRUDa.crud;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import CRUDa.db.dbRow;
import CRUDa.tools.Utils;
import net.miginfocom.swing.MigLayout;

public class MemberForm extends JDialog {
    private String ObjectKeyID = "";
    public MemberForm(JFrame parent, String title){
        super(parent);
        setTitle(title);
        setModal(true);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(parent);
    }
    
    private Map<String, JTextField> entries;
    private JPanel form;
    private void initComponents(){
        Border padding = BorderFactory.createEmptyBorder(5,5,5,5);
        ((JComponent) getContentPane()).setBorder(padding);
        
        entries = new HashMap<String, JTextField>();
        form = new JPanel(new MigLayout("Inserts 5"));
        addFormElement("Name", "name", new JTextField());
        addFormElement("Phone", "phone", new JTextField());
        addFormElement("Mobile", "mobile", new JTextField());
        addFormElement("Email", "email", new JTextField());
        
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MemberForm.this.save();
            }
            
        });
        form.add(btnSave, "span, right, push, gapy 10, wrap");
        
        getContentPane().add(form, BorderLayout.CENTER);
    }
    
    private void addFormElement(String label, String field, JTextField el){
        form.add(new JLabel(label));
        form.add(el, "w 200, wrap");
        entries.put(field, el);
    }
    
    public void save(){
        dbRow values = getEntries();
        Utils.stdout(values);
        if(!validate(values)){
            return;
        }
        
        if(!ObjectKeyID.equals("")){
            values.put("id", ObjectKeyID);
        }
        
        int saved = Launcher.getDatabaseConnection().save("member", "id", values);
        if(saved > 0){
            setVisible(false);
            Utils.alert("Save data");
        } else {
            Utils.alert("Failed to save data");
        }
    }
    
    private boolean validate(dbRow values){
        for(String s : values.keySet()){
            if(values.get(s).trim().isEmpty()){
                Utils.alert("All fields are required");
                return false;
            }
        }
        return true;
    }
    
    private dbRow getEntries(){
        dbRow values = new dbRow();
        for(String name : entries.keySet()){
            values.put(name, entries.get(name).getText());
        }
        
        return values;
    }
    
    public void loadData(String id){
        dbRow data = Members.getMember(id);
        if(data == null){
            setVisible(false);
            return;
        }
        
        ObjectKeyID = id;
        for(String field : data.keySet()){
            if(entries.containsKey(field)){
                entries.get(field).setText(data.get(field));
            }
        }
    }
}
