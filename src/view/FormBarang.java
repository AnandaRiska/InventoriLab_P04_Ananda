package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;

public class FormBarang extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private final List<Barang> daftarBarang = new ArrayList<Barang>();
    private DefaultTableModel modelTabel;
    
    public FormBarang() {
        initComponents();
        siapkanTabel();
        isiDataContoh();
        setLocationRelativeTo(null);
    }
    
    private void siapkanTabel(){
        modelTabel = new DefaultTableModel(
                new Object[] {"Kode", "Nama Barang", "Tersedia"}, 0) {
            private static final long serialVersionUID = 1L;
                
                @Override
                public boolean isCellEdittable(int row, int column) {
                    return false;
                }
                
            };
            tblBarang.setModel(modelTabel);
            tblBarang.setRowHeight(26);
            tblBarang.getTableHeader().setReorderingAllowed(false);
    }
    
    private void isiDataContoh(){
        daftarBarang.add(new Barang("BRG-001", "Keyboard USB", 10));
        daftarBarang.add(new Barang("BRG-002", "Mouse USB", 8));
        perbaruiTabel();
        lblStatus.setText("Siap. Dua data contoh dimuat di memori.");
    }
    
    private void perbaruiTabel(){
        modelTabel.setRowCount(0);
            for (Barang barang : daftarBarang){
            modelTabel.addRow(new Object[]{
                barang.getKode(),
                barang.getNama(),
                barang.getJumlahTersedia()
            });
        }
    }
    
    private void bersihkanInput() {
        txtKode.setText("");
        txtNama.setText("");
        txtJumlah.setText("");
        txtKode.requestFocusInWindow();
    }
    
    private void tambahDemo(){
        String kode = txtKode.getText().trim();
        String nama = txtNama.getText().trim();
        String teksJumlah = txtJumlah.getText().trim();
        
        try {
            if (kode.isEmpty() || nama.isEmpty() || teksJumlah.isEmpty()){
                throw new IllegalArgumentException(
                "Kode, nama, dan jumlah wajib diisi.");
            }
            
            int jumlah = Integer.parseInt(teksJumlah);
            Barang barang = new Barang(kode, nama, jumlah);
            daftarBarang.add(barang);
            perbaruiTabel();
            bersihkanInput();
            lblStatus.setText("Barang " + barang.getNama()
                + " ditambahkan ke daftar sementara.");
        } catch (NumberFormatException e) {
            lblStatus.setText("Jumlah belum valid. Data tidak ditambahkan.");
            JOptionPane.showMessageDialog(this, 
                    "Jumlah harus bilangan bulat antara 0 dan 2147483647.",
                    "Input jumlah", JOptionPane.WARNING_MESSAGE);
            txtJumlah.requestFocusInWindow();
            txtJumlah.selectAll();
        } catch (IllegalArgumentException e) {
            lblStatus.setText("Data tidak ditambahkan: " + e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Periksa data barang", JOptionPane.WARNING_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        lblKode = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventori Laboratorium - Data Barang");
        setMinimumSize(new java.awt.Dimension(520, 760));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJudul.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblJudul.setText("INVENTORI LABORATORIUM");
        getContentPane().add(lblJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 25, -1, -1));

        lblInfo.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblInfo.setText("Latihan antarmuka - data tersimpan sementara");
        getContentPane().add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Barang"));
        pnlInput.setPreferredSize(new java.awt.Dimension(400, 300));
        pnlInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblKode.setText("Kode Barang");
        pnlInput.add(lblKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 49, -1, -1));

        lblNama.setText("Nama Barang");
        pnlInput.add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 92, -1, -1));

        lblJumlah.setText("Jumlah Tersedia");
        pnlInput.add(lblJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 133, -1, -1));
        pnlInput.add(txtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 490, -1));

        txtNama.setToolTipText("");
        pnlInput.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 490, -1));
        pnlInput.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 490, -1));

        btnTambah.setText("Tambah Demo");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        pnlInput.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 198, -1, -1));

        btnBersihkan.setText("Bersihkan Input");
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });
        pnlInput.add(btnBersihkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 198, -1, -1));

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });
        pnlInput.add(btnTutup, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 198, -1, -1));

        getContentPane().add(pnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 760, 250));

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tblBarang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 750, 220));

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblStatus.setText("Barang Kabel HDMI ditambahkan ke daftar sementara.");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        tambahDemo();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed
        bersihkanInput();
        lblStatus.setText("Input dibersihkan. Daftar barang tetap.");
    }//GEN-LAST:event_btnBersihkanActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable(){
           @Override
           public void run(){
               new FormBarang().setVisible(true);
           }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKode;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
