/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonModel;
import javax.swing.JButton;

/**
 *
 * @author umbara
 */
public class buttonGW extends JButton {

    private Paint paint;
    private Shape shape;
    private Paint glass;
    private Paint glass2;
    private boolean over;
    private boolean tekan;

    public buttonGW() {
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

        //Menambahkan mouse listener
        addMouseListener(new MouseAdapter() {

            //saat mouse di atas button
            @Override
            public void mouseEntered(MouseEvent e) {
                setOver(true);
            }

            //saat mouse di luar button
            @Override
            public void mouseExited(MouseEvent e) {
                setOver(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setTekan(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setTekan(false);
            }
        });

    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    public boolean isTekan() {
        return tekan;
    }

    public void setTekan(boolean tekan) {
        this.tekan = tekan;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        ButtonModel buttonModel = getModel();
        Graphics2D gd = (Graphics2D) g.create();
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setPaint(new GradientPaint(0, 0, Color.black, 0, getHeight(), new Color(0, 0, 0, 0)));
        if (buttonModel.isRollover()) {
            gd.setPaint(new GradientPaint(0, 0, new Color(0, 0, 0, 0), 0, getHeight(), Color.white));
            if (buttonModel.isPressed()) {
                gd.setPaint(new GradientPaint(0, 0, Color.BLACK, 0, getHeight(), Color.WHITE));
                setForeground(Color.ORANGE);
            }else {
                setForeground(Color.BLUE);
            }
        }
        gd.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        gd.dispose();
        super.paintComponent(g);
    }
}
