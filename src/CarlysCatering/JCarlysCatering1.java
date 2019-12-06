package CarlysCatering;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
public class JCarlysCatering1 extends JFrame implements ItemListener, ActionListener {

    int guests;
    int totalCost;
    String[] entree = {"Stuffedbread", "Rice", "lentil", "Pizza"};
    String[] sidedish = {"bakedbeans", "salad", "soup", "fries"};
    String[] dessert = {"cake", "pie", "muffins", "custard"};
    Container con= getContentPane();
   
    JPanel guestpanel = new JPanel();
    JLabel guestLabel = new JLabel("Guests");
    JTextField guestTextBox = new JTextField(4);
    JPanel entreepanel = new JPanel();
    JLabel entreeLabel = new JLabel("Entree");
    JComboBox entreeCombo = new JComboBox(entree);
    //Side dish check box
    JPanel sidedish1panel = new JPanel();
    JLabel sides1Label = new JLabel("Side dish 1");
    JCheckBox bakedbeansCbox = new JCheckBox("bakedbeans");
    JCheckBox saladCbox = new JCheckBox("salad");
    JCheckBox soupCbox = new JCheckBox("soup");
    JCheckBox friesCbox = new JCheckBox("fries");
    //desser combo box
    JPanel dessertpanel = new JPanel();
    JLabel dessertLabel = new JLabel("Dessert");
    JComboBox dessertCombo = new JComboBox(dessert);
    JPanel costpanel = new JPanel();
    JLabel costLabel = new JLabel("Cost of event $35/person.");
    JLabel itemLabel = new JLabel("Item selected: ");
    
    List<String> sidedishes = new ArrayList<String>();
    JPanel totalcostpanel = new JPanel();
    JLabel totalCostLabel = new JLabel("Cost is :");
    JPanel itemlabelpanel = new JPanel();

    public JCarlysCatering1() {
        super("Carly's Catering");
        FlowLayout flow = new FlowLayout(FlowLayout.LEADING);
         sidedish1panel.setLayout(new GridLayout(2,2,1,1) );
         itemlabelpanel.setLayout(new BorderLayout());
         
         con.setBackground(Color.PINK); 
        setLayout(flow);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding to JFrame
        add(guestpanel);
        guestpanel.add(guestLabel);
        guestpanel.add(guestTextBox);
        guestTextBox.addActionListener(this);
        guestpanel.setBackground(Color.yellow);

        entreepanel.add(entreeLabel);
        entreepanel.add(entreeCombo);
        entreeCombo.setSelectedIndex(-1);
        add(entreepanel);
        entreeCombo.addItemListener(this);

        sidedish1panel.add(sides1Label);
        sidedish1panel.add(bakedbeansCbox);
        sidedish1panel.add(saladCbox);
        sidedish1panel.add(soupCbox);
        sidedish1panel.add(friesCbox);
        add(sidedish1panel);
        bakedbeansCbox.addItemListener(this);
        saladCbox.addItemListener(this);
        soupCbox.addItemListener(this);
        friesCbox.addItemListener(this);

        dessertpanel.add(dessertLabel);
        dessertpanel.add(dessertCombo);
        dessertCombo.setSelectedIndex(-1);
        add(dessertpanel);
        dessertCombo.addItemListener(this);
        add(costpanel);
        costpanel.add(costLabel);

        this.setVisible(true);
        this.setSize(700, 500);
        add(totalcostpanel);
        add(itemlabelpanel);
        itemlabelpanel.add(itemLabel);
        
         itemlabelpanel.setBackground(Color.yellow);
        totalcostpanel.add(totalCostLabel);
        totalCostLabel.setText("The total cost is:" + totalCost);
        totalcostpanel.setBackground(Color.yellow);
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        StringBuffer displayString = new StringBuffer();
        System.out.println("source - " + event.getSource() + ", event : " + event.getStateChange());
        sidedishes.clear();
        Object source = event.getSource();
        int select = event.getStateChange();

        if (entreeCombo.getSelectedItem() != null) {
            displayString.append("Entree : " + entreeCombo.getSelectedItem() + "\n");
        }

        // populating sidedish array
        if (bakedbeansCbox.isSelected()) {
            sidedishes.add(bakedbeansCbox.getText());
        }
        if (saladCbox.isSelected()) {
            sidedishes.add(saladCbox.getText());
        }
        if (soupCbox.isSelected()) {
            sidedishes.add(soupCbox.getText());
        }

        if (friesCbox.isSelected()) {
            sidedishes.add(friesCbox.getText());
        }

        if (sidedishes.isEmpty()) {
            // do nothing
        } else if (sidedishes.size() <= 2) {
            displayString.append("Side Dishes : " + sidedishes.toString());
        } else { // more than 2

            bakedbeansCbox.setSelected(false);
            saladCbox.setSelected(false);
            soupCbox.setSelected(false);
            friesCbox.setSelected(false);

        }

        if (dessertCombo.getSelectedItem() != null) {
            displayString.append("Dessert : " + dessertCombo.getSelectedItem() + "\n");
        }

        itemLabel.setText(displayString.toString());
    }

    public static void main(String[] args) {
        JCarlysCatering1 frame = new JCarlysCatering1();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        String select = event.getActionCommand();

        if (source == guestTextBox) {
            String text = guestTextBox.getText();
            try {
                guests = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                guests = 0;
            }
            totalCost = guests * 35;
            totalCostLabel.setText("The total cost is:" + totalCost);

        }
//if the user enters nonnumeric input

    }
}
