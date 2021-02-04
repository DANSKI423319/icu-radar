/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.*;
import radar.Chart;

/**
 *
 * @author clair
 */
public class radarFrame extends javax.swing.JFrame {

    public Patient[] patientArr = new Patient[2];
    public DefaultListModel listModel = new DefaultListModel();
    public DefaultTableModel tableModel = new DefaultTableModel(new String[]{"POID", "First Name", "Last Name", "CPAX Total", "MRC Total", "SOFA Total"}, 0);

    /**
     * Creates new form radarFrame
     */
    public radarFrame() {
        this.setLocationRelativeTo(null);
        createData();
        loadList();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radarPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        lblPatientList = new javax.swing.JLabel();
        lblRadarChart = new javax.swing.JLabel();
        btnCpax = new javax.swing.JButton();
        btnSofa = new javax.swing.JButton();
        btnMrc = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        patientVisitList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuOther = new javax.swing.JMenu();
        replaceZeroCB = new javax.swing.JCheckBoxMenuItem();
        drawScoresCB = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medical Chart");
        setResizable(false);

        radarPanel.setBackground(new java.awt.Color(204, 204, 204));

        patientList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        patientList.setModel(listModel);
        patientList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patientList);

        patientTable.setModel(tableModel);
        patientTable.setEnabled(false);
        jScrollPane2.setViewportView(patientTable);

        lblPatientList.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPatientList.setText("Patient List");

        lblRadarChart.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblRadarChart.setText("Radar Chart");

        btnCpax.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCpax.setText("CPAX");

        btnSofa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSofa.setText("SOFA");

        btnMrc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMrc.setText("MRC");

        patientVisitList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(patientVisitList);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Patient Visits");

        jMenuFile.setText("File");
        jMenuBar1.add(jMenuFile);

        jMenuOther.setText("Options");

        replaceZeroCB.setSelected(true);
        replaceZeroCB.setText("Replace zero values");
        replaceZeroCB.setActionCommand("");
        replaceZeroCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                replaceZeroCBItemStateChanged(evt);
            }
        });
        jMenuOther.add(replaceZeroCB);

        drawScoresCB.setSelected(true);
        drawScoresCB.setText("Draw scores");
        drawScoresCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                drawScoresCBItemStateChanged(evt);
            }
        });
        jMenuOther.add(drawScoresCB);

        jMenuBar1.add(jMenuOther);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPatientList)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRadarChart)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCpax, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMrc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSofa, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(radarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientList)
                    .addComponent(lblRadarChart)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMrc, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(btnCpax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSofa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void patientListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientListMouseClicked
        // TODO add your handling code here:
        radarPanel.removeAll();
        String selected = patientList.getSelectedValue();

        for (int i = 0; i < patientArr.length; i++) {

            if (patientArr[i].getPoid().equals(selected)) {

                radarPanel.add(chartBuilder(i));
                this.revalidate();
                this.repaint();

                if (tableModel.getRowCount() == 1) {
                    tableModel.removeRow(0);
                    tableModel.addRow(patientArr[i].getDataRow());
                } else {
                    tableModel.addRow(patientArr[i].getDataRow());
                }

                break;

            }
        }

        /*
        *   Idea:
        *
        *   Search by ID,
        *   Add search count INT
        *   if search count > 1, start adding dates
        *   select data by date...?
        *
         */
    }//GEN-LAST:event_patientListMouseClicked

    private void replaceZeroCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_replaceZeroCBItemStateChanged
        // TODO add your handling code here:
        chartRefresh();
    }//GEN-LAST:event_replaceZeroCBItemStateChanged

    private void drawScoresCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_drawScoresCBItemStateChanged
        // TODO add your handling code here:
        chartRefresh();
    }//GEN-LAST:event_drawScoresCBItemStateChanged

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(radarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(radarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(radarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(radarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new radarFrame().setVisible(true);
            }
        });
    }

    public void createData() {
        Cpax cpax = new Cpax(5, 5, 2, 2, 4, 2, 4, 4, 1, 0, 33);
        Mrc mrc = new Mrc(0, 5, 3, 0, 5, 5, 0, 4, 0, 5, 0, 4, 5, 3, 5, 0, 5, 0, 5, 0, 0, 5, 5, 0, 59);
        Sofa sofa = new Sofa(4, 4, 3, 0, 1, 2, 14);
        Patient John = new Patient("1234", "John", "Smith", "5 Transfers with assistance", cpax, mrc, sofa);
        patientArr[0] = John;

        cpax = new Cpax(5, 5, 2, 2, 4, 2, 2, 2, 1, 0, 25);
        mrc = new Mrc(0, 5, 3, 0, 0, 5, 0, 4, 0, 5, 0, 4, 5, 0, 5, 0, 5, 0, 5, 0, 0, 5, 5, 0, 51);
        sofa = new Sofa(1, 2, 3, 0, 5, 4, 15);
        Patient Jane = new Patient("2345", "Jane", "Doe", "10 Transfers with assistance", cpax, mrc, sofa);
        patientArr[1] = Jane;
    }

    public void loadList() {

        System.out.println(patientArr.length);

        for (int i = 0; i < patientArr.length; i++) {
            listModel.addElement(patientArr[i].getPoid());
        }
    }

    public Chart chartBuilder(int index) {

        int scores[] = patientArr[index].getSofa().getScores();
        int slices = scores.length;
        int size = 428;

        Chart chart = new Chart(slices, scores, size, replaceZeroCB.getState(), drawScoresCB.getState());

        return chart;

    }

    public void chartRefresh() {
        radarPanel.removeAll();
        String selected = patientList.getSelectedValue();

        for (int i = 0; i < patientArr.length; i++) {

            if (patientArr[i].getPoid().equals(selected)) {

                radarPanel.add(chartBuilder(i));
                this.revalidate();
                this.repaint();

                if (tableModel.getRowCount() == 1) {
                    tableModel.removeRow(0);
                    tableModel.addRow(patientArr[i].getDataRow());
                } else {
                    tableModel.addRow(patientArr[i].getDataRow());
                }

                break;

            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCpax;
    private javax.swing.JButton btnMrc;
    private javax.swing.JButton btnSofa;
    private javax.swing.JCheckBoxMenuItem drawScoresCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuOther;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPatientList;
    private javax.swing.JLabel lblRadarChart;
    private javax.swing.JList<String> patientList;
    public javax.swing.JTable patientTable;
    private javax.swing.JList<String> patientVisitList;
    public javax.swing.JPanel radarPanel;
    private javax.swing.JCheckBoxMenuItem replaceZeroCB;
    // End of variables declaration//GEN-END:variables
}
