/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author huanh
 */
public class Category {
    private String kind;
    private JPanel jpanel;
    private JLabel jlabel;
    
    public Category(){}

    public Category(String kind, JPanel jpanel, JLabel jlabel) {
        this.kind = kind;
        this.jpanel = jpanel;
        this.jlabel = jlabel;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }

    public JLabel getJlabel() {
        return jlabel;
    }

    public void setJlabel(JLabel jlabel) {
        this.jlabel = jlabel;
    }
    
    
}
