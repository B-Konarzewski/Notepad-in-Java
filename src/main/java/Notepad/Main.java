/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Notepad;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sterr
 */
public class Main extends javax.swing.JFrame {

    private File plikOdczyt;
    private ArrayList<String> odczyt;
    private File plikZapis;
    private String name;


    public Main() {
        initComponents();
        odczyt = new ArrayList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPlik = new javax.swing.JMenu();
        jMenuOtworz = new javax.swing.JMenuItem();
        jMenuNowy = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuZapisz = new javax.swing.JMenuItem();
        jMenuZapiszJako = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuZamknij = new javax.swing.JMenuItem();
        jMenuO = new javax.swing.JMenu();
        jMenuOprogramie = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notatnik ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenuPlik.setText("Plik");

        jMenuOtworz.setText("Otw�rz");
        jMenuOtworz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOtworzActionPerformed(evt);
            }
        });
        jMenuPlik.add(jMenuOtworz);

        jMenuNowy.setText("Nowy");
        jMenuNowy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNowyActionPerformed(evt);
            }
        });
        jMenuPlik.add(jMenuNowy);
        jMenuPlik.add(jSeparator1);

        jMenuZapisz.setText("Zapisz");
        jMenuZapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuZapiszActionPerformed(evt);
            }
        });
        jMenuPlik.add(jMenuZapisz);

        jMenuZapiszJako.setText("Zapisz jako..");
        jMenuZapiszJako.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuZapiszJakoActionPerformed(evt);
            }
        });
        jMenuPlik.add(jMenuZapiszJako);
        jMenuPlik.add(jSeparator2);

        jMenuZamknij.setText("Zamknij");
        jMenuZamknij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuZamknijActionPerformed(evt);
            }
        });
        jMenuPlik.add(jMenuZamknij);

        jMenuBar1.add(jMenuPlik);

        jMenuO.setText("O");

        jMenuOprogramie.setText("O programie");
        jMenuOprogramie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOprogramieActionPerformed(evt);
            }
        });
        jMenuO.add(jMenuOprogramie);

        jMenuBar1.add(jMenuO);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuOtworzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOtworzActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filtr1 = new FileNameExtensionFilter("Plik tekstowy (*.txt)", "txt");
        fileChooser.setFileFilter(filtr1);

        int rezultat = fileChooser.showOpenDialog(this);
        if (rezultat == JFileChooser.APPROVE_OPTION) {
            plikOdczyt = fileChooser.getSelectedFile();
            name= fileChooser.getSelectedFile().getName();
            jTextArea1.setText("");
            try ( FileReader fr = new FileReader(plikOdczyt); 
                      Scanner fIn = new Scanner(fr)) {
                while (fIn.hasNextLine()) {
                    String linia = fIn.nextLine();
                    odczyt.add(linia);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "B��d otwarcia pliku",
                        "B��d", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchElementException e) {
                JOptionPane.showMessageDialog(null, "B��d odczytu pliku",
                        "B��d", JOptionPane.ERROR_MESSAGE);
            }
            for (String linia : odczyt) {
                jTextArea1.append(linia +"\n");

            }
        }
        name= fileChooser.getSelectedFile().getName();
        setTitle("Notatnik - edytujesz plik: "+ name);
    }//GEN-LAST:event_jMenuOtworzActionPerformed

    private void jMenuNowyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNowyActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
                // TODO add your handling code here:
         try (FileWriter writer = new FileWriter(name, false); PrintWriter pw = new PrintWriter(writer)) {
                pw.print(jTextArea1.getText());
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "B��d zapisu pliku: " + e.getMessage(),
                    "B��d", JOptionPane.ERROR_MESSAGE);
        }
        setTitle("Notatnik");
    }//GEN-LAST:event_jMenuNowyActionPerformed

    private void jMenuZamknijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuZamknijActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuZamknijActionPerformed

    private void jMenuOprogramieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOprogramieActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Prosty edytor tekstu pozwalaj�cy na zapis i otwieranie plik�w", "O programie", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuOprogramieActionPerformed

    private void jMenuZapiszJakoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuZapiszJakoActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setSelectedFile(new File("we.txt")); 
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir"))); 
    int result = fileChooser.showSaveDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        plikZapis = fileChooser.getSelectedFile(); 

        try (FileWriter writer = new FileWriter(plikZapis); PrintWriter pw = new PrintWriter(writer)) {
                pw.print(jTextArea1.getText());
               JOptionPane.showMessageDialog(null, "Plik zosta� zapisany poprawnie",
                "Informacja", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "B��d zapisu pliku: " + e.getMessage(),
                    "B��d", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Zapis anulowany przez u�ytkownika",
                "Informacja", JOptionPane.INFORMATION_MESSAGE);
    }
       name= fileChooser.getSelectedFile().getName();
        setTitle("Notatnik - edytujesz plik: "+ name);
        
    }//GEN-LAST:event_jMenuZapiszJakoActionPerformed

    private void jMenuZapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuZapiszActionPerformed
        // TODO add your handling code here:
        if (name == null){
           JFileChooser fileChooser = new JFileChooser();
    fileChooser.setSelectedFile(new File("we.txt")); 
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir"))); 
    int result = fileChooser.showSaveDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        plikZapis = fileChooser.getSelectedFile(); 

        try (FileWriter writer = new FileWriter(plikZapis); PrintWriter pw = new PrintWriter(writer)) {
                pw.print(jTextArea1.getText());
               JOptionPane.showMessageDialog(null, "Plik zosta� zapisany poprawnie",
                "Informacja", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "B��d zapisu pliku: " + e.getMessage(),
                    "B��d", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Zapis anulowany przez u�ytkownika",
                "Informacja", JOptionPane.INFORMATION_MESSAGE);
    }
       name= fileChooser.getSelectedFile().getName();
        setTitle("Notatnik - edytujesz plik: "+ name);
        }else {
         try (FileWriter writer = new FileWriter(name, false); PrintWriter pw = new PrintWriter(writer)) {
                pw.print(jTextArea1.getText());
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "B��d zapisu pliku: " + e.getMessage(),
                    "B��d", JOptionPane.ERROR_MESSAGE);
        }

        }
    }//GEN-LAST:event_jMenuZapiszActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuNowy;
    private javax.swing.JMenu jMenuO;
    private javax.swing.JMenuItem jMenuOprogramie;
    private javax.swing.JMenuItem jMenuOtworz;
    private javax.swing.JMenu jMenuPlik;
    private javax.swing.JMenuItem jMenuZamknij;
    private javax.swing.JMenuItem jMenuZapisz;
    private javax.swing.JMenuItem jMenuZapiszJako;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
