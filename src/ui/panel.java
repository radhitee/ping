/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Radhitee
 */
public class panel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image gambar = new ImageIcon(getClass().getResource("/ui/gambar.png")).getImage();

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0, 0, Color.RED, 0, gambar.getHeight(null), Color.BLACK));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.drawImage(kaca.getEfekKaca(gambar), 10, 10, null);
    }
}
