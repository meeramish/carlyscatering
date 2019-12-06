package CarlysCatering;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author meera mishra
 */
public class JCarlysLogoPanel extends JPanel {
    
    int xPoints[] = {00, 20, 30, 40, 60, 40, 30, 20, 00};
    int yPoints[] = {30, 20, 00, 20, 30, 40, 60, 40, 30};

    // int xPoints[] = {42, 52, 72, 52, 40, 40, 15, 28, 9, 32, 42};
    // int yPoints[] = {178, 172, 188, 200,    245, 225, 242, 180, 168, 172, 178};
    public Dimension getPreferredSize() {
        return new Dimension(600, 60);
    }
    
    public void paint(Graphics star) {
        super.paint(star);
        star.setColor(Color.BLUE);
        Polygon aStar = new Polygon(xPoints, yPoints, xPoints.length);        
        star.drawPolygon(aStar);
        star.fillPolygon(aStar);
        star.drawString("Carly's", 60, 30);        
        setBackground(Color.PINK);
    }
}
