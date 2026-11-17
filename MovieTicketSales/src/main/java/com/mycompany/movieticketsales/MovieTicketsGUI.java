/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kirta
 */
package com.mycompany.movieticketsales;

import com.mycompany.movieticketsales.MovieTicketData;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class MovieTicketsGUI extends JFrame {

    private JComboBox<String> movieComboBox;
    private JTextField numberOfTicketsField;
    private JTextField ticketPriceField;
    private JTextArea ticketReportArea;

    private MovieTickets movieTickets;

    public MovieTicketsGUI() {

        movieTickets = new MovieTickets();

        setTitle("MOVIE TICKETS");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenu();
        createForm();
    }

    // Creates the menu system.
    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        // Closes the application.
        exitItem.addActionListener(e -> System.exit(0));

        // Processes the movie tickets.
        processItem.addActionListener(e -> processTickets());

        // Clears the form.
        clearItem.addActionListener(e -> clearForm());

        fileMenu.add(exitItem);

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);
    }

    // Creates the form components.
    private void createForm() {

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        movieComboBox = new JComboBox<>(new String[]{
            "Napoleon", "Oppenheimer", "Damsel"
        });

        numberOfTicketsField = new JTextField();
        ticketPriceField = new JTextField();

        inputPanel.add(new JLabel("MOVIE:"));
        inputPanel.add(movieComboBox);

        inputPanel.add(new JLabel("NUMBER OF TICKETS:"));
        inputPanel.add(numberOfTicketsField);

        inputPanel.add(new JLabel("TICKET PRICE:"));
        inputPanel.add(ticketPriceField);

        ticketReportArea = new JTextArea(8, 30);
        ticketReportArea.setEditable(false);

        JPanel reportPanel = new JPanel(new BorderLayout());

        reportPanel.add(new JLabel("TICKET REPORT:"), BorderLayout.NORTH);
        reportPanel.add(new JScrollPane(ticketReportArea), BorderLayout.CENTER);

        setLayout(new BorderLayout(10, 10));

        add(inputPanel, BorderLayout.NORTH);
        add(reportPanel, BorderLayout.CENTER);
    }

    // Processes the ticket information.
    private void processTickets() {

        try {

            String movieName = movieComboBox.getSelectedItem().toString();

            int numberOfTickets = Integer.parseInt(
                    numberOfTicketsField.getText().trim());

            double ticketPrice = Double.parseDouble(
                    ticketPriceField.getText().trim());

            MovieTicketData ticketData = new MovieTicketData(
                    movieName, numberOfTickets, ticketPrice);

            if (movieTickets.ValidateData(ticketData)) {

                double totalPrice = movieTickets.CalculateTotalTicketPrice(
                        numberOfTickets, ticketPrice);

                String report = "MOVIE TICKET REPORT\n"
                        + "************************************\n"
                        + "MOVIE NAME: " + movieName + "\n"
                        + "MOVIE TICKET PRICE: R " + ticketPrice + "\n"
                        + "NUMBER OF TICKETS: " + numberOfTickets + "\n"
                        + "TOTAL TICKET PRICE: R " + totalPrice + "\n"
                        + "************************************";

                ticketReportArea.setText(report);

                saveReport(report);

            } else {

                JOptionPane.showMessageDialog(this,
                        "Movie name, ticket price and number of tickets must be valid.");
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Please enter a valid number of tickets and ticket price.");
        }
    }

    // Saves the report to report.txt.
    private void saveReport(String report) {

        try (PrintWriter writer = new PrintWriter(new FileWriter("report.txt"))) {

            writer.println(report);

            JOptionPane.showMessageDialog(this,
                    "The report was saved to report.txt");

        } catch (IOException e) {

            JOptionPane.showMessageDialog(this,
                    "The report could not be saved.");
        }
    }

    // Resets the form to its default state.
    private void clearForm() {

        movieComboBox.setSelectedIndex(0);

        numberOfTicketsField.setText("");

        ticketPriceField.setText("");

        ticketReportArea.setText("");
    }

    public static void main(String[] args) {

        MovieTicketsGUI gui = new MovieTicketsGUI();

        gui.setVisible(true);
    }
}
