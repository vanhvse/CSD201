/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake2;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author MocMel
 */
public class MainClass {

    public static void main(String[] args) {
        JFrame frm = new JFrame("SNAKE");
        frm.setContentPane(new GamePanel());
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);
        frm.pack();
        int x =GamePanel.score;//getScore
        frm.setPreferredSize(new Dimension(GamePanel.WIDTH, GamePanel.HEIGHT));
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}
