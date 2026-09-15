package com.mycompany.gradesystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class managergui extends JFrame implements ActionListener {

    Gradesystem gradesystem = new Gradesystem();

    JTextField nameField;
    JTextField rollField;
    JTextField gradeField;

    JButton addButton;
    JButton avgButton;
    JButton highestButton;
    JButton lowestButton;
    JButton summaryButton;

    JTable table;
    DefaultTableModel tableModel;

    JTextField avgField;
    JTextField highestField;
    JTextField lowestField;

    JTextArea outputArea;

    public managergui() {

        setTitle("Student Grade Tracker");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        nameField = new JTextField(10);
        rollField = new JTextField(6);
        gradeField = new JTextField(4);

        addButton = new JButton("Add Student");
        avgButton = new JButton("Average");
        highestButton = new JButton("Highest");
        lowestButton = new JButton("Lowest");
        summaryButton = new JButton("Summary");

        // ---------- Input fields only ----------
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Roll No:"));
        add(rollField);
        add(new JLabel("Grade:"));
        add(gradeField);
         add(addButton);

        // ---------- Table ----------
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Roll No");
        tableModel.addColumn("Grade");
        table = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setPreferredSize(new Dimension(650, 150));
        add(tableScroll);

        // ---------- Buttons after table ----------
       
        
       
        // ---------- Separate result fields ----------
        avgField = new JTextField(15);
        avgField.setEditable(false);
        highestField = new JTextField(20);
        highestField.setEditable(false);
        lowestField = new JTextField(20);
        lowestField.setEditable(false);

       
         add(avgButton);
        add(avgField);
      
         add(highestButton);
        add(highestField);
       
         add(lowestButton);
        add(lowestField);
add(summaryButton);

        // ---------- Output area (summary only) ----------
        outputArea = new JTextArea(10, 50);
        outputArea.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        add(outputScroll);

        addButton.addActionListener(this);
        avgButton.addActionListener(this);
        highestButton.addActionListener(this);
        lowestButton.addActionListener(this);
        summaryButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {

            String name = nameField.getText();
            String roll = rollField.getText();
            String gradeText = gradeField.getText();

            int grade = Integer.parseInt(gradeText);

            gradesystem.addstudent(name, roll, grade);

            tableModel.addRow(new Object[]{name, roll, grade});

            nameField.setText("");
            rollField.setText("");
            gradeField.setText("");
        }

        if (e.getSource() == avgButton) {
            avgField.setText("" + gradesystem.avg());
        }

        if (e.getSource() == highestButton) {
            highestField.setText(gradesystem.highest().info());
        }

        if (e.getSource() == lowestButton) {
            lowestField.setText(gradesystem.lowest().info());
        }

        if (e.getSource() == summaryButton) {
            outputArea.setText(gradesystem.summary());
        }
    }

    public static void main(String[] args) {
        managergui gui = new managergui();
    }
}