package productsalesgui;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class ProductSalesGUI {

    private static final int SALES_LIMIT = 500;

    // Sales data: Microphone, Speakers and a mixing desk
    private static final int[][] PRODUCT_SALES = {
        {300, 150, 700}, // Year 1
        {250, 200, 600} // Year 2
    };

    //Starts swing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductSalesGUI::createGUI);
    }

    //method with all the swing components
    private static void createGUI() {
        JFrame frame = new JFrame("Product Sales Report");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);
        menuBar.add(toolsMenu);

        frame.setJMenuBar(menuBar);

        // Buttons
        JButton loadButton = new JButton("Load Product Data");
        loadButton.setBounds(20, 20, 180, 30);
        frame.add(loadButton);

        JButton saveButton = new JButton("Save Product Data");
        saveButton.setBounds(220, 20, 180, 30);
        frame.add(saveButton);

        // Text area to display report
        JTextArea reportArea = new JTextArea();
        reportArea.setBounds(20, 70, 500, 250);
        reportArea.setEditable(false);
        frame.add(reportArea);

        // Label to display number of years processed
        JLabel yearsLabel = new JLabel("Number of years: 0");
        yearsLabel.setBounds(20, 330, 200, 25);
        frame.add(yearsLabel);

        //shared actionlistener used by both the menu items and buttons
        ActionListener loadAction = e -> {
            ProductSales sales = new ProductSales(PRODUCT_SALES);

            String report = "Total Sales: "
                    + sales.GetTotalSales()
                    + "\nAverage Sales: "
                    + String.format("%.2f", sales.GetAverageSales())
                    + "\nSales Over Limit (" + SALES_LIMIT + "): "
                    + sales.GetSalesOverLimit()
                    + "\nSales Under Limit ("
                    + SALES_LIMIT + "): "
                    + sales.GetSalesUnderLimit();

            reportArea.setText(report);
            yearsLabel.setText("Number of years: " + sales.GetProductsProcessed());
        };

        ActionListener saveAction = e -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
                writer.write(reportArea.getText());
                JOptionPane.showMessageDialog(frame, "Report saved to data.txt");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving report: " + ex.getMessage());
            }
        };

        ActionListener clearAction = e -> {
            reportArea.setText("");
            yearsLabel.setText("Number of years: 0");
        };
        
        //buttons call action 
        loadButton.addActionListener(loadAction);
        saveButton.addActionListener(saveAction);
        loadItem.addActionListener(loadAction);
        saveItem.addActionListener(saveAction);
        clearItem.addActionListener(clearAction);
        exitItem.addActionListener(e -> frame.dispose());
        frame.setVisible(true);
    }
}
