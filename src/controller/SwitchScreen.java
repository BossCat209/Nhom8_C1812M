/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Category;
import view.AddBillJPanel;
import view.BrandJPanel;
import view.ColorJPanel;
import view.OutBillJPanel;
import view.ProductJPanel;
import view.SizeJPanel;
import view.UserJPanel;

/**
 *
 * @author huanh
 */
public class SwitchScreen {
    private final JPanel index;                                                                                                            
    private String kindSelected = "";
    List<Category> listCate = null;

    public SwitchScreen(JPanel jbnIndex) {
        this.index = jbnIndex;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "Product";
        jpnItem.setBackground(new Color(255, 153, 153));
        jlbItem.setBackground(new Color(255, 153, 153));
        
        index.removeAll();
        index.setLayout(new BorderLayout());
        index.add(new ProductJPanel());
        index.validate();
        index.repaint();    
    }
    
    /**
     *
     * @param listCate
     */
    public void setEvent(List<Category> listCate){
        this.listCate = listCate;
        for (Category cate : listCate) {
            cate.getJlabel().addMouseListener(new LabelEvent(cate.getKind(), cate.getJpanel(), cate.getJlabel()));
        }
    }
    
    class LabelEvent implements MouseListener {
        
        private JPanel node;
        private final String kind;
        private final JPanel jpnItem;
        private final JLabel jlbItem;
        
        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem){
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            switch (kind) {
                case "Product":
                    node = new ProductJPanel();
                    break;
                    
                case "User":
                    node = new UserJPanel();
                    break;
                    
                case "Add Bill":
                    node = new AddBillJPanel();
                    break;
                    
                case "Out Bill":
                    node = new OutBillJPanel();
                    break;
                    
                case "Brand":
                    node = new BrandJPanel();
                    break;
                
                case "Size":
                    node = new SizeJPanel();
                    break;
                    
                case "Color":
                    node = new ColorJPanel();
                    break;
                    
                default:
                    node = new ProductJPanel();
                    break;
            }
            index.removeAll();
            index.setLayout(new BorderLayout());
            index.add(node);
            index.validate();
            index.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            kindSelected = kind;
            jpnItem.setBackground(new Color(255, 153, 153));
            jlbItem.setBackground(new Color(255, 153, 153));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            jpnItem.setBackground(new Color(0, 153, 153));
            jlbItem.setBackground(new Color(0, 153, 153));
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(0, 255, 255));
                jlbItem.setBackground(new Color(0, 255, 255));
            }
        }
        
    }
    
    private void setChangeBackground(String kind){
        for (Category cate : listCate) {
            if (cate.getKind().equalsIgnoreCase(kind)) {
                cate.getJpanel().setBackground(new Color(255, 153, 153));
                cate.getJlabel().setBackground(new Color(255, 153, 153));
            }else {
                cate.getJpanel().setBackground(new Color(0, 255, 255));
                cate.getJlabel().setBackground(new Color(0, 255, 255));
            }    
        }
    }
}
