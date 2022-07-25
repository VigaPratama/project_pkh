/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package pkh;

import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Me
 */
public class LaporanKegiatan extends javax.swing.JInternalFrame {
    public static Connection con;
   public static Statement stm;
   public static ResultSet res;
    /**
     * Creates new form DataPesertaPKH
     */
    public LaporanKegiatan() {
        initComponents();
        koneksimysql();
        tampiltabel();
        jTable_Display_Users.getTableHeader().setOpaque(true);
        jTable_Display_Users.setRowHeight(25);
        jTable_Display_Users.getTableHeader().setBackground(Color.blue);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
    }

    public void koneksimysql(){
       try{
           String url = "jdbc:mysql://localhost:3306/pkh";
           String user = "root";
           String pass = "";
           Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection(url, user, pass);
           stm =(Statement) con.createStatement();
           
       }catch(Exception e){
           System.out.println("koneksi gagal" +e.getMessage());
       }
    }
    
    public void tampiltabel(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("ID Pendamping");
        tb.addColumn("Nama Pendamping");
        tb.addColumn("No. Telepon");
        tb.addColumn("Waktu Kegiatan");
        tb.addColumn("Nama Kegiatan");
        tb.addColumn("ID Peserta");
        tb.addColumn("Nama Peserta");
        jTable_Display_Users.setModel(tb);
        
        try{
        res=stm.executeQuery("select * from laporankegiatan");
        while(res.next()){
           tb.addRow(new Object[]{
               res.getString("id"),
               res.getString("Nama_Pendamping"),
               res.getString("Telepon"),
               res.getString("Waktu_Kegiatan"),
               res.getString("Nama_Kegiatan"),
               res.getString("Id_peserta"),
               res.getString("Nama_Peserta"),
               
           });
        }
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, "data gagal ditampilkan" +e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Users = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        print = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_Display_Users);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 969, 335));

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("+ Tambahkan Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 150, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Data Laporan Kegiatan");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 250, 40));

        print.setBackground(new java.awt.Color(0, 0, 255));
        print.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FormLaporanKegiatan backpage = new FormLaporanKegiatan();
        backpage.show();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        try {
              File namafile = new File("src/report/report_data_laporan_kegiatan.jasper");
        JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, koneksiprint.getConnection());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_printActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Users;
    private javax.swing.JButton print;
    // End of variables declaration//GEN-END:variables
}
