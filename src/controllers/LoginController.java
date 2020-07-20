/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import models.components.database.User;
import services.HandlingLoginService;
import services.LoginService;
import views.MainJForm;

/**
 *
 * @author huanh
 */
public class LoginController {

    private final Dialog dialog;
    private final JButton jbtSubmit;
    private final JTextField jtfUserName;
    private final JTextField jtfPassWord;
    private final JLabel jlbMessage;

    private LoginService loginSer = null;

    public LoginController(Dialog dialog, JButton jbtSubmit, JTextField jtfUserName, JTextField jtfPassWord, JLabel jlbMessage) {
        this.dialog = dialog;
        this.jbtSubmit = jbtSubmit;
        this.jtfUserName = jtfUserName;
        this.jtfPassWord = jtfPassWord;
        this.jlbMessage = jlbMessage;
        loginSer = new HandlingLoginService();
    }

    public void setEvent() {
        jbtSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (jtfUserName.getText().length() == 0 || jtfPassWord.getText().length() == 0) {
                        jlbMessage.setText("Vui lòng nhập dữ liệu.");
                    } else {
                        User user = loginSer.login(jtfUserName.getText(), jtfPassWord.getText());
                        if (user == null) {
                            jlbMessage.setText("Tài khoản hoặc mật khẩu không đúng.");
                        } else {
                            dialog.dispose();
                            MainJForm form = new MainJForm();
                            form.setVisible(true);
                        }
                    }
                } catch (Exception ex) {
                    jlbMessage.setText(ex.toString());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtSubmit.setBackground(new Color(200, 150, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbtSubmit.setBackground(new Color(140, 200, 100));
            }
        });
    }

}
