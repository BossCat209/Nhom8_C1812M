/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author huanh
 */
public class Test extends JFrame{
    public Test() {
      setTitle("JEditableComboBox Test");
      setLayout(new BorderLayout());
      final JComboBox combobox = new JComboBox();
      final JList list = new JList(new DefaultListModel());
      add(BorderLayout.NORTH, combobox);
      add(BorderLayout.CENTER, list);
      combobox.setEditable(true);
      combobox.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
               ((DefaultListModel) list.getModel()).addElement(combobox.getSelectedItem());
               combobox.insertItemAt(combobox.getSelectedItem(), 0);
            }
         }
      });
      setSize(new Dimension(375, 250));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
    
    
    public static void main(String[] args) {
        new Test();
    }
}
