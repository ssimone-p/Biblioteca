package org.Bibliotech.View;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchView extends GeneralView{
    private JPanel rootPanel;
    private JPanel imagePanel;
    private JPanel searchPanel;
    private JLabel imageLabel;
    private JTextField searchField;
    private JButton filtriButton;
    private JButton searchButton;
    private JPanel filtriPanel;
    private JCheckBox autoreCheckBox;
    private JCheckBox genereCheckBox;
    private JCheckBox dataDiPubblicazioneCheckBox;
    private JCheckBox formatoCheckBox;
    private JCheckBox prezzoCheckBox;
    private JTextField autoreField;
    private JTextField genereField; //potrebbe diventare JComboBox, serve una query che va a prendere distinct generi da db
    private JComboBox formatoBox;
    private JTextField minprezzoBox;
    private JTextField maxprezzoBox;
    private JTextField maxDataP;
    private JTextField minDataP;

    public SearchView(){
        ImageIcon glassIconImage = new ImageIcon("src/main/Immagini/glassIcon.png");
        imageLabel.setIcon(logoIcon);
        searchButton.setIcon(glassIconImage);
        imagePanel.setSize(720,240);
        filtriPanel.setVisible(false);
        JFrame frame = newView("Search", rootPanel);

        filtriButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                filtriPanel.setVisible(!filtriPanel.isShowing()); //ogni volta che clicchi apre o chiude filtriPanel
            }
        });
        minprezzoBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if(!minprezzoBox.getText().toString().chars().allMatch(Character::isDigit)){
                    minprezzoBox.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(minprezzoBox.getText().isBlank()){
                    minprezzoBox.setText("Minimo");
                }
            }
        });
        maxprezzoBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if(!maxprezzoBox.getText().toString().chars().allMatch(Character::isDigit)){
                    maxprezzoBox.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(maxprezzoBox.getText().isBlank()){
                    maxprezzoBox.setText("Massimo");
                }
            }
        });
    }
}
