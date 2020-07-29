/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmmain;

import Pikachu.MyFrame;
import Pikachu.MyMain;
import Snake.Snake;
import Snake2.GamePanel;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MocMel
 */
public class Game extends javax.swing.JFrame {

    MyFrame frame;
    String name;

    public Game() {
        initComponents();

        name = JOptionPane.showInputDialog("Player Name : ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bPikachu = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPikachu = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbTtt = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSnake = new javax.swing.JTable();
        bSnake = new javax.swing.JButton();
        bTictactoe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bPikachu.setIcon(new javax.swing.ImageIcon("C:\\Users\\MocMel\\Downloads\\pokemon.png")); // NOI18N
        bPikachu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPikachuActionPerformed(evt);
            }
        });

        tbPikachu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Player Name", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbPikachu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(tbPikachu);

        jTabbedPane4.addTab("Pikachu", jScrollPane3);

        tbTtt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Player Name", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbTtt);

        jTabbedPane4.addTab("Tictactoe", jScrollPane4);

        tbSnake.setAutoCreateRowSorter(true);
        tbSnake.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"duy", "123"},
                {"van", "231"},
                {null, null},
                {null, null}
            },
            new String [] {
                "Player Name", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbSnake);

        jTabbedPane4.addTab("Snake", jScrollPane2);

        bSnake.setIcon(new javax.swing.ImageIcon("C:\\Users\\MocMel\\Downloads\\snake.png")); // NOI18N
        bSnake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSnakeActionPerformed(evt);
            }
        });

        bTictactoe.setIcon(new javax.swing.ImageIcon("C:\\Users\\MocMel\\Downloads\\tictactoe.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(bPikachu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(bSnake, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bTictactoe, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bPikachu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSnake, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bTictactoe, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bPikachuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPikachuActionPerformed
        // TODO add your handling code here:
        frame = new MyFrame();
        MyTimeCount timeCount = new MyTimeCount();
        timeCount.start();
        new Thread(frame).start();
        setVisible(false);
    }//GEN-LAST:event_bPikachuActionPerformed

    private void bSnakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSnakeActionPerformed
        // TODO add your handling code here:
//        Snake S = new Snake() {
//        };        
//        S.setVisible(true);
//        setVisible(false);
        JFrame frm = new JFrame("SNAKE");
        frm.setContentPane(new GamePanel());
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);
        frm.pack();
        int x = GamePanel.score;//getScore
        frm.setPreferredSize(new Dimension(GamePanel.WIDTH, GamePanel.HEIGHT));
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        JOptionPane.showMessageDialog(null, x);
    }//GEN-LAST:event_bSnakeActionPerformed

    class MyTimeCount extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                frame.setTime(frame.getTime() - 1);
                if (frame.getTime() == 0) {
                    frame.showDialogNewGame(
                            "Full time\nDo you want play again?", "Lose");
                }
            }
        }
    }

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bPikachu;
    private javax.swing.JButton bSnake;
    private javax.swing.JButton bTictactoe;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable tbPikachu;
    private javax.swing.JTable tbSnake;
    private javax.swing.JTable tbTtt;
    // End of variables declaration//GEN-END:variables
}
