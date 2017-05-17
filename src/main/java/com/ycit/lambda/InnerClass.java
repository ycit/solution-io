package com.ycit.lambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by xlch on 2017/3/1.
 */
public class InnerClass {

    public static void main(String[] args) {
        JButton button = new JButton("Test Button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click detected by anon class");
            }
        });

        button.addActionListener(e -> System.out.println("Click detected by lambda expression"));

        // Swing stuff
        JFrame frame = new JFrame("Listener Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

}
