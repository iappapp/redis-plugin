package com.treefintech.redis.plugin;

import javax.swing.*;
import java.awt.event.*;

public class MessageDialog extends JDialog {
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField hostTextField;
    private JTextField passwordTextField;
    private JTextField portTextField;
    private JButton cancelButton;
    private JButton confirmButton;
    private JButton testConnectionButton;

    public MessageDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(testConnectionButton);
        getRootPane().add(nameTextField);
        getRootPane().add(hostTextField);
        getRootPane().add(passwordTextField);
        getRootPane().add(portTextField);
        getRootPane().add(cancelButton);
        getRootPane().add(confirmButton);
        getRootPane().updateUI();

        testConnectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        testConnectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        MessageDialog dialog = new MessageDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
