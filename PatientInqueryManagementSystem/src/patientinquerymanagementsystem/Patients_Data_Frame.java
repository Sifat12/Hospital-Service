
package patientinquerymanagementsystem;


import com.mysql.jdbc.Statement;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Tech Land
 */
public class Patients_Data_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Patients_Data_Frame
     */
    public Patients_Data_Frame() {
        initComponents();
        Show_Products_in_jTable();
    }
    
    String ImgPath;
    int pos = 0;
    public Connection getConnection()
    {
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/patients_db","root","");
           
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
             
            return null;
        }
    }
    
    //Check input filds:
       public boolean checkInputs()
       {
           if(
               txt_id.getText() == null
                   ||
                txt_name.getText() == null
                    ||
                txt_age.getText() == null 
                   ||
                txt_address.getText() == null 
                    ||
                txt_contact.getText() == null 
                    ||
                txt_doctor.getText() == null 
                    ||
                txt_modifiedDate.getText() == null 
                    ||
                txt_modifiedTime.getText() == null 
                   )
           {
               return false;
           }
           else{
               try{
                   Integer.parseInt(txt_id.getText());
                
                  return true;
               }catch(Exception e){
                   return false;
               }
           }
       }
    private void CloseMe()
    {
        WindowEvent meClose = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(meClose);
        LoginFrame lf = new LoginFrame();
         lf.setVisible(true);
    }
     //image resize:
    
    public ImageIcon ResizeImage(String imagePath,byte[] pic)
    {
        ImageIcon myImage  = null;
        if(imagePath != null)
        {
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(bl_image.getWidth(),bl_image.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    
    //Display data in jTable:
    
    //1-Fill ArrayList With The Data 
    
       public ArrayList<Patient> getPatientList()
    {
         ArrayList<Patient> patientList  =   new ArrayList<Patient>();
            Connection con = getConnection();
            String query = "SELECT * FROM patients";
            
            java.sql.Statement st;
            ResultSet rs;
        try {
           
            st = con.createStatement();
            rs = st.executeQuery(query);
            Patient patient;
            
            while(rs.next())
            {
                patient = new Patient(rs.getInt("id"),rs.getString("name"),rs.getString("sex"),rs.getString("age"),rs.getString("contact"),
               rs.getString("address"),rs.getString("patient_Type"),rs.getString("doctor"),rs.getBytes("image"),rs.getString("modified_Date"),
                rs.getString("modified_Time"));
               patientList.add(patient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patients_Data_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patientList;
    }  
        public ArrayList<Login> getLoginList()
    {
         ArrayList<Login> loginList  =   new ArrayList<Login>();
            Connection con = getConnection();
            String query = "SELECT * FROM logininfo";
            
            java.sql.Statement st;
            ResultSet rs;
        try {
           
            st = con.createStatement();
            rs = st.executeQuery(query);
            Login login;
            
            while(rs.next())
            {
                login = new Login(rs.getString("username"),rs.getString("date"));
               loginList.add(login);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patients_Data_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loginList;
    }  
       
                                        
    
      //2- Populate The jTable
    
   public void Show_Products_in_jTable()
    {
        ArrayList<Patient> list = getPatientList();
        DefaultTableModel model = (DefaultTableModel) jTablePatient.getModel();
        //Clear jTable;
        model.setRowCount(0);
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++)
        {
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getAge();
            row[3] = list.get(i).getContactNumber();
            row[4] = list.get(i).getDoctor();
            
            model.addRow(row);
        }
    }    
    
     public void ShowItem(int index){
        txt_id.setText(Integer.toString(getPatientList().get(index).getID()));
        txt_name.setText(getPatientList().get(index).getName());
      

        txt_sex.setSelectedItem(getPatientList().get(index).getsex());
        txt_age.setText(getPatientList().get(index).getAge());
        txt_contact.setText(getPatientList().get(index).getContactNumber());
        txt_address.setText(getPatientList().get(index).getAddress());
        txt_patientType.setSelectedItem(getPatientList().get(index).getPatientType());
        txt_doctor.setText(getPatientList().get(index).getDoctor());
        bl_image.setIcon(ResizeImage(null,getPatientList().get(index).getPicture()));
        txt_modifiedDate.setText(getPatientList().get(index).getModifyDate());
        txt_modifiedTime.setText(getPatientList().get(index).getModifyTime());
        
        
    }
     public void show(int in)
     {
         txt_user.setText(getLoginList().get(in).getUsername());
         txt_user1.setText(getLoginList().get(in).getDate());
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        txt_contact = new javax.swing.JTextField();
        txt_address = new javax.swing.JTextField();
        txt_doctor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bl_image = new javax.swing.JLabel();
        btn_image = new javax.swing.JButton();
        txt_sex = new javax.swing.JComboBox<>();
        txt_patientType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePatient = new javax.swing.JTable();
        btn_insert = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_First = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_modifiedDate = new javax.swing.JTextField();
        txt_modifiedTime = new javax.swing.JTextField();
        btn_previous = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_user = new javax.swing.JLabel();
        txt_user1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1380, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel1.setText("Patient Id :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 70, 30));

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel2.setText("Name :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 60, -1));

        jLabel3.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel3.setText("Sex :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel4.setText("Age :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel5.setText("Contact No :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 80, -1));

        jLabel6.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel6.setText("Address :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 70, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Patient Type :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 100, -1));

        jLabel8.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel8.setText("Doctor :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 60, -1));

        txt_id.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 210, 30));

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 210, 30));

        txt_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ageActionPerformed(evt);
            }
        });
        getContentPane().add(txt_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 210, 30));

        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        getContentPane().add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 210, 30));

        txt_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addressActionPerformed(evt);
            }
        });
        getContentPane().add(txt_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 210, 80));
        getContentPane().add(txt_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 590, 210, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 10, 460));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 10, 460));

        bl_image.setBackground(new java.awt.Color(204, 204, 255));
        bl_image.setOpaque(true);
        getContentPane().add(bl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 320, 240));

        btn_image.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_image.setText("Choose Image");
        btn_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imageActionPerformed(evt);
            }
        });
        getContentPane().add(btn_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 320, 40));

        txt_sex.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txt_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        txt_sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sexActionPerformed(evt);
            }
        });
        getContentPane().add(txt_sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 210, 30));

        txt_patientType.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txt_patientType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select type", "Surgery", "Regular", "New Patient" }));
        getContentPane().add(txt_patientType, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 210, 30));

        jTablePatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Name", "Age", "Contact No.", "Doctor"
            }
        ));
        jTablePatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePatientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePatient);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, -1, 440));

        btn_insert.setText("Insert");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });
        getContentPane().add(btn_insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, -1, -1));

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 650, -1, -1));

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 650, -1, -1));

        btn_First.setText("First");
        btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FirstActionPerformed(evt);
            }
        });
        getContentPane().add(btn_First, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 650, -1, -1));

        btn_last.setText("Last");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });
        getContentPane().add(btn_last, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 650, -1, -1));

        btn_next.setText("Next");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        getContentPane().add(btn_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 650, -1, -1));

        jLabel9.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel9.setText("Modified Date :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 100, -1));

        jLabel10.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel10.setText("Modified Time :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 570, -1, -1));

        txt_modifiedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modifiedDateActionPerformed(evt);
            }
        });
        getContentPane().add(txt_modifiedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, 150, 30));

        txt_modifiedTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modifiedTimeActionPerformed(evt);
            }
        });
        getContentPane().add(txt_modifiedTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 570, 150, 30));

        btn_previous.setText("Previous");
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });
        getContentPane().add(btn_previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 650, -1, -1));

        jLabel11.setText("Last loged in by   ---");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton1.setText("Load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        txt_user.setBackground(new java.awt.Color(204, 204, 255));
        txt_user.setOpaque(true);
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 20));

        txt_user1.setBackground(new java.awt.Color(204, 204, 255));
        txt_user1.setOpaque(true);
        getContentPane().add(txt_user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 210, 20));

        jButton2.setText("Click here to get details of patients Treatment History");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 650, -1, -1));

        btn_search.setText("Search By Id");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("       Patient BIO and History");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 470, 50));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 40, 100, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ageActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void txt_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addressActionPerformed

    private void txt_sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sexActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        if(checkInputs() && ImgPath != null)
        {
            
            try {
                Connection con  =  getConnection() ;
                PreparedStatement ps = con.prepareStatement("INSERT INTO patients(ID,Name,Sex,Age,Contact,Address,Patient_type,"
                + "Doctor,Image,Modified_Date,Modified_Time)" + "Values(?,?,?,?,?,?,?,?,?,?,?) ");
                ps.setString(1, txt_id.getText());
                ps.setString(2, txt_name.getText());
                
                String item = txt_sex.getSelectedItem().toString();
                ps.setString(3, item);
                ps.setString(4, txt_age.getText());
                ps.setString(5, txt_contact.getText()); 
                ps.setString(6, txt_address.getText());
                String item2 = txt_patientType.getSelectedItem().toString();
                ps.setString(7, item2);
                ps.setString(8, txt_doctor.getText());
               
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(9,img);
                ps.setString(10, txt_modifiedDate.getText());
                 ps.setString(11, txt_modifiedTime.getText());
                ps.executeUpdate();
                Show_Products_in_jTable();
                JOptionPane.showMessageDialog(null, "Data Inserted");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null,"One or more field are empty");
        }
        System.out.println("Name => "+txt_name.getText());
       // System.out.println("Price => "+txt_price.getText());
        //System.out.println("Date => "+txt_AddDate.getText());
        
        System.out.println("Image => "+ImgPath);
    }//GEN-LAST:event_btn_insertActionPerformed

    private void btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FirstActionPerformed
          pos = 0;
        ShowItem(pos);
    }//GEN-LAST:event_btn_FirstActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        pos = getPatientList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imageActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new  FileNameExtensionFilter("*.image","jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path =  selectedFile.getAbsolutePath();
            bl_image.setIcon(ResizeImage(path,null));
            ImgPath = path;
        }
        else{
            System.out.println("No file selected");
        }
    }//GEN-LAST:event_btn_imageActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
         if(checkInputs() && txt_id.getText() !=null)
        {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
            
            //update without image;
            if(ImgPath == null)
            {
                 try {
                UpdateQuery = "UPDATE patients SET Name = ?,Sex = ?, Age = ?,Contact = ?,Address = ?,Patient_type = ? ,Doctor = ?,Modified_Date = ?,Modified_Time = ? where ID = ?";
               
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, txt_name.getText());
                    String item = txt_sex.getSelectedItem().toString();
                     ps.setString(2, item);
                     ps.setString(3, txt_age.getText());
                     ps.setString(4, txt_contact.getText());
                     ps.setString(5, txt_address.getText());
                     String item2 = txt_patientType.getSelectedItem().toString();
                     ps.setString(6, item2);
                     ps.setString(7, txt_doctor.getText());
                     ps.setString(8, txt_modifiedDate.getText());
                     ps.setString(9, txt_modifiedTime.getText());
                     
                     ps.setInt(10, Integer.parseInt(txt_id.getText()));
                     
                     
                     Show_Products_in_jTable();
                     JOptionPane.showMessageDialog(null, "Data Updated");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Patients_Data_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //update with Image 
            else{
                
                try {
                     InputStream  img = new FileInputStream(new File(ImgPath));
                    UpdateQuery = "UPDATE patients SET Name = ?,Sex = ?, Age = ?,Contact = ?,Address = ?,Patient_type = ? ,Doctor = ?,Image = ?,Modified_Date = ?,Modified_Time = ? where ID = ?";
                    
                     ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, txt_name.getText());
                    String item = txt_sex.getSelectedItem().toString();
                     ps.setString(2, item);
                     ps.setString(3, txt_age.getText());
                     ps.setString(4, txt_contact.getText());
                     ps.setString(5, txt_address.getText());
                     String item2 = txt_patientType.getSelectedItem().toString();
                     ps.setString(6, item2);
                     ps.setString(7, txt_doctor.getText());
                     ps.setBlob(8,img);
                     ps.setString(9, txt_modifiedDate.getText());
                     ps.setString(10, txt_modifiedTime.getText());
                     
                     ps.setInt(11, Integer.parseInt(txt_id.getText()));
                     
                     ps.executeUpdate();
                     Show_Products_in_jTable();
                     JOptionPane.showMessageDialog(null, "Data Updated");
                     
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex.getMessage());
                
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "One or more fields are empty or wrong");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
          if(!txt_id.getText().equals(""))
        {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM patients  WHERE ID = ?");
                int ID = Integer.parseInt(txt_id.getText());
                ps.setInt(1, ID);
                ps.executeUpdate();
                Show_Products_in_jTable();
                JOptionPane.showMessageDialog(null, "Data deleted");
            } 
            catch (SQLException ex) {
                Logger.getLogger(Patients_Data_Frame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Data  not deleted");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Data is not deleted :no ID to delete");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jTablePatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePatientMouseClicked
          int index = jTablePatient.getSelectedRow();
          ShowItem(index);
    }//GEN-LAST:event_jTablePatientMouseClicked

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
         pos++;
        if(pos>=getPatientList().size())
        {
             pos = getPatientList().size()-1;
        }
         ShowItem(pos);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousActionPerformed
         pos--;
        if(pos<0)
        {
            pos = 0;
        }
        ShowItem(pos);
    }//GEN-LAST:event_btn_previousActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM loginInfo");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int pos = getLoginList().size()-2;
                 show(pos);
       

            }
        } catch (SQLException ex) {
            Logger.getLogger(Patients_Data_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_modifiedTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modifiedTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modifiedTimeActionPerformed

    private void txt_modifiedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modifiedDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modifiedDateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TreatmentHistory th = new   TreatmentHistory();
        th.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
           try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM patients where ID = ?");
            int ID = Integer.parseInt(txt_id.getText());
             ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String name = rs.getString("Name");
                txt_name.setText(name);
                String gen = rs.getString("Sex");
              txt_sex.setSelectedItem(gen);
              String age = rs.getString("Age");
              txt_age.setText(age);
              String cont = rs.getString("Contact");
            txt_contact.setText(cont);
            String add = rs.getString("Address");
            txt_address.setText(add);
            String ptype = rs.getString("Patient_type");
            txt_patientType.setSelectedItem(ptype);
            String doc = rs.getString("Doctor");
            txt_doctor.setText(doc);
             String mod = rs.getString("Modified_date");
             bl_image.setIcon(ResizeImage(null,rs.getBytes("image")));
            txt_modifiedDate.setText(mod);
             String mot = rs.getString("Modified_time");
            txt_modifiedTime.setText(mot);
       

            }
        } catch (SQLException ex) {
            Logger.getLogger(Patients_Data_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CloseMe();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patients_Data_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patients_Data_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patients_Data_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patients_Data_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patients_Data_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bl_image;
    private javax.swing.JButton btn_First;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_image;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePatient;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_contact;
    private javax.swing.JTextField txt_doctor;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_modifiedDate;
    private javax.swing.JTextField txt_modifiedTime;
    private javax.swing.JTextField txt_name;
    private javax.swing.JComboBox<String> txt_patientType;
    private javax.swing.JComboBox<String> txt_sex;
    private javax.swing.JLabel txt_user;
    private javax.swing.JLabel txt_user1;
    // End of variables declaration//GEN-END:variables
}
