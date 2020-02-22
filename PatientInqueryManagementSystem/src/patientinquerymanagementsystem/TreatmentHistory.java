

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
public class TreatmentHistory extends javax.swing.JFrame {

    /** Creates new form TreatmentHistory */
    public TreatmentHistory() {
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
                txt_medicineNameDose.getText() == null 
                   ||
                txt_admissionDate.getText() == null 
                    ||
                txt_releaseDate.getText() == null 
                    ||
                txt_cabinNo.getText() == null 
                    ||
                txt_chargedAmount.getText() == null 
                    ||
                txt_billPaid.getText() == null 
                         
                
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
    
       public ArrayList<Treatment> getTreatmentList()
    {
         ArrayList<Treatment> treatmentList  =   new ArrayList<Treatment>();
            Connection con = getConnection();
            String query = "SELECT * FROM treatment_history";
            
            java.sql.Statement st;
            ResultSet rs;
        try {
           
            st = con.createStatement();
            rs = st.executeQuery(query);
            Treatment treatment;
            
            while(rs.next())
            {
                treatment = new Treatment(rs.getInt("id"),rs.getString("name"),rs.getString("medicine_name"),rs.getString("admission_Date"),rs.getString("release_Date"),
               rs.getString("cabin_no"),Float.parseFloat(rs.getString("Charged_bill")),Float.parseFloat(rs.getString("Bill_payed")),Float.parseFloat(rs.getString("Due_bill")),rs.getBytes("Prescription"));
               treatmentList.add(treatment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patients_Data_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return treatmentList;
    }  
       
       
                                        
      //2- Populate The jTable
    
   public void Show_Products_in_jTable()
    {
        ArrayList<Treatment> list = getTreatmentList();
        DefaultTableModel model = (DefaultTableModel) jTableTreatment.getModel();
        //Clear jTable;
        model.setRowCount(0);
        Object[] row = new Object[2];
        for(int i=0;i<list.size();i++)
        {
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getCabin();
            model.addRow(row);
        }
    }    
    
     public void ShowItem(int index){
        txt_id.setText(Integer.toString(getTreatmentList().get(index).getID()));
        txt_name.setText(getTreatmentList().get(index).getName());
      

        txt_medicineNameDose.setText(getTreatmentList().get(index).getMedicine());
        txt_admissionDate.setText(getTreatmentList().get(index).getAdmissionDate());
        txt_releaseDate.setText(getTreatmentList().get(index).getReleaseDate());
       
        txt_cabinNo.setText(getTreatmentList().get(index).getCabin());
         txt_chargedAmount.setText(Float.toString(getTreatmentList().get(index).getChargedAmount()));
         txt_billPaid.setText(Float.toString(getTreatmentList().get(index).getBillPaid()));
         
         float a = getTreatmentList().get(index).getChargedAmount();
         float b =  getTreatmentList().get(index).getBillPaid(); 
         txt_dueBill.setText(Float.toString(getTreatmentList().get(index).getDueBill(a, b)));
     
          bl_image.setIcon(ResizeImage(null,getTreatmentList().get(index).getPicture()));
    
        
        
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txt_dueBill = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_admissionDate = new javax.swing.JTextField();
        txt_releaseDate = new javax.swing.JTextField();
        txt_cabinNo = new javax.swing.JTextField();
        txt_chargedAmount = new javax.swing.JTextField();
        txt_billPaid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTreatment = new javax.swing.JTable();
        bl_image = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_medicineNameDose = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel1.setText("Patient ID :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 20));

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel2.setText("Patient Name :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        jLabel4.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel4.setText("Medicine Name and Dose  :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, 30));

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel5.setText("Admission Date : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel6.setText("Release Date : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel7.setText("Cabin /Ward_bed Number : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel8.setText("Charged Amount :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel9.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel9.setText("Bill Paid :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel10.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel10.setText("Due Bill : ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 552, -1, -1));

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, -1, -1));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, -1, -1));

        jButton4.setText("First");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, -1, -1));

        jButton5.setText("Next");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, -1, -1));

        jButton6.setText("Previous");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, -1, -1));

        jButton7.setText("Last");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));

        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, -1, -1));

        txt_dueBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dueBillActionPerformed(evt);
            }
        });
        txt_dueBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dueBillKeyReleased(evt);
            }
        });
        getContentPane().add(txt_dueBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 240, 30));

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 200, 30));
        getContentPane().add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 200, 30));

        txt_admissionDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_admissionDateActionPerformed(evt);
            }
        });
        getContentPane().add(txt_admissionDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 200, 30));

        txt_releaseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_releaseDateActionPerformed(evt);
            }
        });
        getContentPane().add(txt_releaseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 200, 30));
        getContentPane().add(txt_cabinNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 140, 30));

        txt_chargedAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chargedAmountActionPerformed(evt);
            }
        });
        getContentPane().add(txt_chargedAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 180, 30));
        getContentPane().add(txt_billPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 240, 30));

        jTableTreatment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "Cabin/Room"
            }
        ));
        jTableTreatment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTreatmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTreatment);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 230, 340));

        bl_image.setBackground(new java.awt.Color(204, 204, 255));
        bl_image.setOpaque(true);
        getContentPane().add(bl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 230, 140));

        jButton9.setText("Add Prescription");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 230, -1));

        txt_medicineNameDose.setColumns(20);
        txt_medicineNameDose.setRows(5);
        jScrollPane2.setViewportView(txt_medicineNameDose);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 310, 90));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Patient Medical History");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 320, 50));

        jButton10.setText("Back");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 600, 70, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  //insert
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(checkInputs() && ImgPath != null)
        {
            
            try {
                Connection con  =  getConnection() ;
                PreparedStatement ps = con.prepareStatement("INSERT INTO treatment_history(ID,Name,Medicine_name,Charged_bill,Bill_payed,Due_bill,Admission_Date,Release_Date,Cabin_no,Prescription)" + "Values(?,?,?,?,?,?,?,?,?,?) ");
                ps.setString(1, txt_id.getText());
                ps.setString(2, txt_name.getText());
                
              
                ps.setString(3, txt_medicineNameDose.getText());
                ps.setString(4, txt_chargedAmount.getText()); 
                ps.setString(5, txt_billPaid.getText());
                 float a = Float.parseFloat(txt_chargedAmount.getText());
                 float b =  Float.parseFloat(txt_billPaid.getText()); 
                float c = a - b;
                String s  = Float.toString(c);
                ps.setString(6,s );
                ps.setString(7, txt_admissionDate.getText());
               
                ps.setString(8, txt_releaseDate.getText());
                ps.setString(9, txt_cabinNo.getText());
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(10,img);
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
    }//GEN-LAST:event_jButton1ActionPerformed
    private void CloseMe()
    {
        WindowEvent meClose = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(meClose);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         if(checkInputs() && txt_id.getText() !=null)
        {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
            
            //update without image;
            if(ImgPath == null)
            {
                 try {
                UpdateQuery = "UPDATE treatment_history SET Name = ?,Medicine_name = ?, Charged_bill = ?,Bill_payed = ?,Due_bill = ?,Admission_Date = ? ,Release_Date = ?,Cabin_no = ? where ID = ?";
               
                    ps = con.prepareStatement(UpdateQuery);
          
                ps.setString(1, txt_name.getText());
                
              
                ps.setString(2, txt_medicineNameDose.getText());
                ps.setString(3, txt_chargedAmount.getText()); 
                ps.setString(4, txt_billPaid.getText());
                 ps.setString(5, txt_dueBill.getText());
                ps.setString(6, txt_admissionDate.getText());
               
                ps.setString(7, txt_releaseDate.getText());
                ps.setString(8, txt_cabinNo.getText());
                     
                ps.setInt(9, Integer.parseInt(txt_id.getText()));
                     
                     
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
                     UpdateQuery = "UPDATE treatment_history SET Name = ?,Medicine_name = ?, Charged_bill = ?,Bill_payed = ?,Due_bill = ?,Admission_Date = ? ,Release_Date = ?,Cabin_no = ?,Prescription = ? where ID = ?";
                    
                     ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, txt_name.getText());
                
              
                ps.setString(2, txt_medicineNameDose.getText());
                ps.setString(3, txt_chargedAmount.getText()); 
                ps.setString(4, txt_billPaid.getText());
                ps.setString(5, txt_dueBill.getText());
                ps.setString(6, txt_admissionDate.getText());
               
                ps.setString(7, txt_releaseDate.getText());
                ps.setString(8, txt_cabinNo.getText());
                     
                ps.setBlob(9,img);
                     
                     ps.setInt(10, Integer.parseInt(txt_id.getText()));
                     
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
              pos = 0;
        ShowItem(pos);        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
           pos++;
        if(pos>=getTreatmentList().size())
        {
             pos = getTreatmentList().size()-1;
        }
         ShowItem(pos);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
              pos--;
        if(pos<0)
        {
            pos = 0;
        }
        ShowItem(pos);        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        pos = getTreatmentList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txt_releaseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_releaseDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_releaseDateActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_chargedAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chargedAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chargedAmountActionPerformed

    private void txt_admissionDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_admissionDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_admissionDateActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
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
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTableTreatmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTreatmentMouseClicked
        int index = jTableTreatment.getSelectedRow();
          ShowItem(index);
    }//GEN-LAST:event_jTableTreatmentMouseClicked

    private void txt_dueBillKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dueBillKeyReleased
       
    }//GEN-LAST:event_txt_dueBillKeyReleased

    private void txt_dueBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dueBillActionPerformed
        try {
            String  query ;
            PreparedStatement ps = null;
            Connection con = getConnection();
            query = " Update Treatment_history set Due_bill = Charged_bill - Bill_payed";
            ps = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(TreatmentHistory.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_txt_dueBillActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!txt_id.getText().equals(""))
        {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM treatment_history  WHERE ID = ?");
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
            JOptionPane.showMessageDialog(null, "Selected data is not deleted ,no proper ID to delete");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM treatment_history where ID = ?");
            int ID = Integer.parseInt(txt_id.getText());
             ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String name = rs.getString("Name");
                txt_name.setText(name);
                String gen = rs.getString("Medicine_name");
              txt_medicineNameDose.setText(gen);
              String adate = rs.getString("Admission_Date");
              txt_admissionDate.setText(adate);
              String rdate = rs.getString("Release_Date");
              txt_releaseDate.setText(rdate);
            String cno = rs.getString("Cabin_no");
            txt_cabinNo.setText(cno);
            String cbill = rs.getString("Charged_bill");
            txt_chargedAmount.setText(cbill);
            String bpaid = rs.getString("Bill_payed");
            txt_billPaid.setText(bpaid);
            String dbill = rs.getString("Due_bill");
            txt_dueBill.setText(dbill);
           
             bl_image.setIcon(ResizeImage(null,rs.getBytes("Prescription")));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patients_Data_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        CloseMe();
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(TreatmentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TreatmentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TreatmentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TreatmentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TreatmentHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bl_image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTreatment;
    private javax.swing.JTextField txt_admissionDate;
    private javax.swing.JTextField txt_billPaid;
    private javax.swing.JTextField txt_cabinNo;
    private javax.swing.JTextField txt_chargedAmount;
    private javax.swing.JTextField txt_dueBill;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextArea txt_medicineNameDose;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_releaseDate;
    // End of variables declaration//GEN-END:variables

}
