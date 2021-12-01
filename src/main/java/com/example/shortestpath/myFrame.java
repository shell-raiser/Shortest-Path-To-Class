package com.example.shortestpath;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame implements ActionListener{
    JComboBox combox;
    JComboBox combox2;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
       // this.setSize(500,500);

        //dropdown box 1
        String[] Locations = {"A","B","C","D","E","F","G","H"};
        combox = new JComboBox(Locations);
        combox.addActionListener(this);

        //dropdown box 2
        combox2 = new JComboBox(Locations);
        combox2.addActionListener(this);

        //submit button
        JButton button = new JButton();
        button.setBounds(500,250,200,150);
        button.setText("Submit");
        button.setFocusable(false);

        button.addActionListener(e -> System.out.println("Hey Shailesh"));/*here submit should work on two inputs instead of "Hey Shailesh"*/


        this.add(combox);
        this.add(combox2);
        this.add(button);

        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==combox && e.getSource()==combox2) {
            //take the result from gui her you should run the algo
        }
    }
}
public class myFrame {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MyFrame();

    }
}