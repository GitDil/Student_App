import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StudentUi extends JFrame {

    JTable tblStudent;
    JComboBox cmbSearchGender;
    JTextField txtSearchName;
    Vector vd1;
    JComboBox cmbStream;

    Color initial;
    Color valid;
    Color invalid;

    Student student = new Student();

    JTextField txtName;
    JTextField txtAddress;
    JTextField txtNic;
    JComboBox cmbGender;

    JButton btnAdd;
    JButton btnUpdate;
    JButton btnClear;
    JButton btnDelete;

    List<Student> stulist;
    List<Stream> stmlist ;
    List<Gender> genlist;

    Student oldStudent;

    StudentUi() {

        setTitle("Student- App   == Delete ");
        setLocation(500, 300);
        setSize(530, 300);

        initial = Color.PINK;
        valid =Color.GREEN;
        invalid = Color.RED;

        vd1 = new Vector<>();
        vd1.add("Name");
        vd1.add("Address");
        vd1.add("Nic");
        vd1.add("Gender");
        vd1.add("Stream");
        

        Vector data = new Vector<>();

        JLabel lblSName =new  JLabel("Name");
        txtName = new JTextField(10);
        JLabel lblAddress = new JLabel("Address");
        txtAddress= new JTextField(10);
        JLabel lblNic = new JLabel("Nic");
        txtNic = new JTextField(13);
        cmbGender = new JComboBox<>();
        cmbStream = new JComboBox<>();

         btnAdd = new JButton("Add");
         btnUpdate = new JButton("Update");
        btnClear= new JButton("Clear");
         btnDelete = new JButton("Delete");


        txtSearchName = new JTextField(10);
        JLabel lblName = new JLabel("Search By Name ");
        JLabel lblGender = new JLabel("Search Gender");
        cmbSearchGender = new JComboBox<>();
        cmbStream = new JComboBox<>();
        JButton btnSearch = new JButton("Search");
        JButton btnClearSearch = new JButton("ClearSearch");

        tblStudent = new JTable();
        DefaultTableModel tblModel = new DefaultTableModel(data, vd1);
        tblStudent.setModel(tblModel);

        JScrollPane jsptable = new JScrollPane();
        jsptable.setPreferredSize(new Dimension(550, 150));
        jsptable.setViewportView(tblStudent);

        JTableHeader tableHeader = tblStudent.getTableHeader();
        tableHeader.setBackground(Color.ORANGE);

        Font headerFont = new Font("TimesNewRomance", Font.BOLD, 14);
        tableHeader.setFont(headerFont);

        tblStudent.setSelectionBackground(Color.YELLOW);
        tblStudent.setSelectionForeground(Color.MAGENTA);

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);

        con.add(lblSName);
        con.add(txtName);
        con.add(lblAddress);
        con.add(txtAddress);
        con.add(lblNic);
        con.add(txtNic);
        con.add(cmbStream);
        con.add(cmbGender);

        con.add(btnAdd);
        con.add(btnUpdate);
        con.add(btnClear);
        con.add(btnDelete);


        con.add(lblName);
        con.add(txtSearchName);
        con.add(lblGender);
        con.add(cmbSearchGender);
        
        con.add(btnSearch);
        con.add(btnClearSearch);
        
        con.add(jsptable);

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSearchAp(e);
            }
        });

        btnClearSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnClearSearchAp(e);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                btnAddAp(e);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnClearAp(e);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnUpdateAP(e);
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnDeleteAp(e);
            }
        });

        tblStudent.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                tblStudentVC(e);
            }

        });


    //======Seprate methods for Name,Nic,Address,Gender,Stream========

        txtName.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                txtNameKR(e);
            }
        });

        txtAddress.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                txtAddressKR(e);
            }
        });

        txtNic.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                txtNicKR(e);
            }
        });

        cmbStream.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cmbStreamAp(e);
            }
        });

        cmbGender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cmbGenderAp(e);
            }
        });

        initialize();
    }

    public void initialize() {
        loadView();
        loardForm();
    }

    public void loadView() {
        stulist = StudentController.get(null);
        //System.out.println(stulist);
        fillTable(stulist);

        List<Gender> genlist = GenderContoller.get();
        System.out.println(genlist);

        Vector<Object> genders = new Vector<>();
        genders.add("Select a gender");
        for (Gender gen : genlist) {
            genders.add(gen);
        }

        DefaultComboBoxModel<Object> genModel1 = new DefaultComboBoxModel<>(genders);
        cmbSearchGender.setModel(genModel1);

        stmlist = StreamController.get();

         Vector<Object> streams = new Vector<>();
         streams.add("Select Stream");
         for(Stream stm :stmlist){
            streams.add(stm);
         }

         DefaultComboBoxModel<Object> stmModel = new DefaultComboBoxModel<>(streams);
         cmbStream.setModel(stmModel);
    }

    public void loardForm(){

        genlist = GenderContoller.get();

        Vector<Object> genders = new Vector<>();
        genders.add("Select a gender");
        oldStudent = null;
        for (Gender gen : genlist) {
            genders.add(gen);
        }

         DefaultComboBoxModel<Object> genModel1 = new DefaultComboBoxModel<>(genders);
         cmbGender.setModel(genModel1);

         setColor(initial);

         stmlist = StreamController.get();

         Vector<Object> streams = new Vector<>();
         streams.add("Select Stream");
         for(Stream stm :stmlist){
            streams.add(stm);
         }

         DefaultComboBoxModel<Object> stmModel = new DefaultComboBoxModel<>(streams);
         cmbStream.setModel(stmModel);

         txtName.setText("");
         txtAddress.setText("");
         txtNic.setText("");
         setColor(initial);
         enbaleButtons(true, false,false,true);
    }

    public void setColor(Color colr){
        txtName.setBackground(colr);
        cmbStream.setBackground(colr);
        txtNic.setBackground(colr);
        txtAddress.setBackground(colr);
        cmbGender.setBackground(colr);
    }

    public void enbaleButtons(boolean add, boolean upd, boolean del,boolean cle) {
        btnAdd.setEnabled(add);
        btnUpdate.setEnabled(upd);
        btnDelete.setEnabled(del);
        btnClear.setEnabled(cle);
    }

    public void fillTable(List<Student> stulist) {

        Vector data = new Vector<>();
        for (Student stu : stulist) {
            Vector row = new Vector<>();
            row.add(stu.getName());
            row.add(stu.getAddress());
            row.add(stu.getNic());
            row.add(stu.getGender().getName());
            row.add(stu.getStream().getName());
            
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, vd1);
        tblStudent.setModel(model);
    }

    public void btnSearchAp(ActionEvent e) {
        System.out.println("kitty");
        Gender gender = null;
        String sname = txtSearchName.getText();

        Hashtable<String, Object> ht = new Hashtable<>();
        ht.put("sname", sname);

        Object sitem = cmbSearchGender.getSelectedItem();

        if (!sitem.equals("Select a gender"))
            gender = (Gender) sitem;

        if (gender != null) {
            ht.put("gender", gender);
        }
        List<Student> students = StudentController.get(ht);

        fillTable(students);
    }

    public void btnClearSearchAp(ActionEvent e) {
        System.out.println("kitty");
        cmbSearchGender.setSelectedIndex(0);
        txtSearchName.setText("");

        List<Student> students = StudentController.get(null);

        fillTable(students);

    }

    public void txtNameKR(KeyEvent e){
        String name =txtName.getText();
            if(name.matches("^[A-Z][a-z]{3,}$")){
                student.setName(name);
                txtName.setBackground(valid);
            }else{
                
                txtName.setBackground(invalid);
            }
   }

    public void txtAddressKR(KeyEvent e){

        String address =txtAddress.getText();
            if(address.matches("^[A-Za-z\\s]+$")){
                student.setAddress(address);
                txtAddress.setBackground(valid);    
            }else{
                txtAddress.setBackground(invalid);
            }
    }

    public void txtNicKR(KeyEvent e){
        String nic =txtNic.getText();
            if(nic.matches("^[0-9]{12}$")){
                student.setNic(nic);
                txtNic.setBackground(valid);
            }else{
                txtNic.setBackground(invalid);
            }
    }

    public void cmbStreamAp(ActionEvent e){
        int sitem = cmbStream.getSelectedIndex();
            if(sitem!=0){
                student.setStream((Stream) cmbStream.getSelectedItem());
                cmbStream.setBackground(valid);
            } else {
                cmbStream.setBackground(invalid);
        }
    }

    public void cmbGenderAp(ActionEvent e){
        int sitem = cmbGender.getSelectedIndex();
            if(sitem!=0){
                student.setGender((Gender) cmbGender.getSelectedItem());
                cmbGender.setBackground(valid);
            } else {
                cmbGender.setBackground(invalid);
        }
    }

    public void btnAddAp(ActionEvent e){
        System.out.println("kitty");

        String error = getError();

        if (error.isEmpty()) {

            String cnfmsg = "";

            cnfmsg = cnfmsg + "Name: " + student.getName() + "\n";
            cnfmsg = cnfmsg + "Address: " + student.getAddress() + "\n";
            cnfmsg = cnfmsg + "Nic: " + student.getNic() + "\n";
            cnfmsg = cnfmsg + "Stream: " + student.getStream().getName()+"\n";
            cnfmsg = cnfmsg + "Gender: " + student.getGender().getName();


            int op = JOptionPane.showConfirmDialog(null, "Are you Sure to Save Follwing Employee ?\n\n" + cnfmsg);

            if (op == 0) {

                String sts = StudentController.post(student);
                if (sts.equals("1")) {
                    JOptionPane.showMessageDialog(null, "Successfully Saved");
                    loadView();
                    loardForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Faild to Save as" + sts);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "You have Following Errors:\n" + error);
        }
    }

    public void btnClearAp(ActionEvent e) {

        int op = JOptionPane.showConfirmDialog(null, "Are you sure you Sure want to clear this Form?");

        if (op == 0) {
            loardForm();

        }
    }

    public void FillForm(Student stu) {

        oldStudent = stu;

        //uda null nisa ekknk hdnwa
        student = new Student();
        student.setName(stu.getName());
        student.setAddress(stu.getAddress());
        student.setNic(stu.getNic());
        student.setGender(stu.getGender());
        student.setStream(stu.getStream());

        txtName.setText(stu.getName());
        txtAddress.setText(stu.getAddress());
        txtNic.setText(stu.getNic());

        for (Gender gen : genlist) {
            if (gen.equals(stu.getGender())) {
                cmbGender.setSelectedItem(gen);
                break;
            }
        }

        for (Stream stm : stmlist) {
            if (stm.equals(stu.getStream())) {
                cmbStream.setSelectedItem(stm);
                break;
            }
        }


        enbaleButtons(false, true, true,false);
        setColor(valid);
    }

    public void tblStudentVC(ListSelectionEvent e) {

        int row = tblStudent.getSelectedRow();
       
        if (row > -1) {
            Student student = stulist.get(row);
            FillForm(student);
             

        }
    }

    public void btnUpdateAP(ActionEvent e){
        System.out.println("Kitty");

        String errors = getError();
        student.setID(oldStudent.getID());

        if (errors.isEmpty()) {

            String updates = getUpdates();

            if (!updates.isEmpty()) {

                int op = JOptionPane.showConfirmDialog(null,
                        "Are You Sure to Update Following Details\n\n" + updates);
                if (op == 0) {
                    String sts = StudentController.put(student);
                    if (sts.equals("1")) {
                        JOptionPane.showMessageDialog(null, "Successfully Updated..!");
                        loardForm();
                        loadView();
                    } else {
                        JOptionPane.showMessageDialog(null, "Faild to Update as" + sts);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Nothing to Update");
            }

        } else {
            JOptionPane.showMessageDialog(null, "You have Following Errors" + errors);
        }
    }
    
    public String getError(){
        String errors ="";

        if(student.getName()==null){
            errors = errors+"Invalid Name";
        }

        if(student.getNic()==null){
            errors = errors+"Invalid Nic";
        }

        if(student.getAddress()==null){
            errors = errors+"Invalid Address";
        }

        if(student.getStream()==null){
            errors = errors+"Invalid Stream";
        }

        if(student.getGender()==null){
            errors = errors+"Invalid Gender";
        }

        return errors;
    }

    public String getUpdates(){
        String updates = "";

        System.out.println(student.getName());

        if(!student.getName().equals(oldStudent.getName())){
            updates = updates + "\nName is updated"+ student.getName();
        }

        if(!student.getAddress().equals(oldStudent.getAddress())){
            updates = updates + "\nAddress is updated"+ student.getAddress();
        }

        if(!student.getNic().equals(oldStudent.getNic())){
            updates = updates + "\nNic is updated"+ student.getNic();
        }

        if(!student.getGender().equals(oldStudent.getGender())){
            updates = updates + "\nGender is updated"+ student.getGender();
        }

        if(!student.getStream().equals(oldStudent.getStream())){
            updates = updates + "\nStream is updated"+ student.getStream();
        }

        return updates;
    }

    public void btnDeleteAp(ActionEvent e) {
        // System.out.println("Test-OK");

        int op = JOptionPane.showConfirmDialog(null,
                "Are You Sure to Delete Follwoing Employee\n\n?" + oldStudent.getName());

        if (op == 0) {
            String sts = StudentController.delete(oldStudent);
            if (sts.equals("1")) {
                JOptionPane.showMessageDialog(null, "Successfully Deleted!  Good Bye!");
                loardForm();
                loadView();
            } else {
                JOptionPane.showMessageDialog(null, "Faild to Delete as" + sts);
            }
        }

    }
}
