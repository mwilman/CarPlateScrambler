/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carplatescrambler;

import carplatescrambler.Models.PlateSequence;
import carplatescrambler.PlateBuilder.PlateBuilder;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mwilman
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
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

        jLabel1 = new javax.swing.JLabel();
        label_Title = new javax.swing.JLabel();
        label_searchword = new javax.swing.JLabel();
        tf_searchword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_output = new javax.swing.JTextArea();
        b_search = new javax.swing.JButton();
        b_help = new javax.swing.JButton();
        b_generate = new javax.swing.JButton();
        p_draw = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        label_Title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_Title.setText("Auto-Kennzeichen-Scrabble");

        label_searchword.setText("Suchwort");

        tf_searchword.setText("biber");
        tf_searchword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchwordActionPerformed(evt);
            }
        });

        ta_output.setColumns(20);
        ta_output.setRows(5);
        jScrollPane1.setViewportView(ta_output);

        b_search.setText("Suchen");
        b_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_searchActionPerformed(evt);
            }
        });

        b_help.setText("Hilfe");
        b_help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_helpActionPerformed(evt);
            }
        });

        b_generate.setText("Generate");
        b_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_generateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_drawLayout = new javax.swing.GroupLayout(p_draw);
        p_draw.setLayout(p_drawLayout);
        p_drawLayout.setHorizontalGroup(
            p_drawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        p_drawLayout.setVerticalGroup(
            p_drawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(b_help)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_generate)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p_draw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_searchword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tf_searchword)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b_search))
                                    .addComponent(label_Title, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_Title)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_searchword)
                    .addComponent(tf_searchword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_search))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_help)
                    .addComponent(b_generate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p_draw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_searchwordActionPerformed

    private void b_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_searchActionPerformed
       String searchword = tf_searchword.getText().toUpperCase();
       String output = "";
       
       output+="Wortlänge: " + searchword.length() + "\n";

        PlateBuilder plateBuilder = new PlateBuilder(searchword);
        List<PlateSequence> scrabble = plateBuilder.scrabble();
        output+="Anzahl Kombinationsmöglichkeiten: "+scrabble.size();

        for (PlateSequence plateSequence : scrabble) {
            output+="\n"+plateSequence.getPlateSequence()+"\n";
        }
        
        ta_output.setText(output);
    }//GEN-LAST:event_b_searchActionPerformed

    private void b_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_helpActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Gib einfach dein Wort oben in die Zeile ein und klicke auf Suchen","Hilfe",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showConfirmDialog(rootPane, "Hast du kapiert?", "Bestätigung", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_b_helpActionPerformed

    private void b_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_generateActionPerformed
        DrawPlates.paint(tf_searchword.getText().toUpperCase());
    }//GEN-LAST:event_b_generateActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_generate;
    private javax.swing.JButton b_help;
    private javax.swing.JButton b_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Title;
    private javax.swing.JLabel label_searchword;
    private javax.swing.JPanel p_draw;
    private javax.swing.JTextArea ta_output;
    private javax.swing.JTextField tf_searchword;
    // End of variables declaration//GEN-END:variables
}
