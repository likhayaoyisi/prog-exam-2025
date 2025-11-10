import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProductSalesApp {
    private JFrame frame;
    private JTextArea textArea;
    private JLabel yearsLabel;
    private final int SALES_LIMIT = 500;

    public ProductSalesApp() {
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Product Sales Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadMenuItem = new JMenuItem("Load Product Data");
        JMenuItem saveMenuItem = new JMenuItem("Save Product Data");
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        toolsMenu.add(loadMenuItem);
        toolsMenu.add(saveMenuItem);
        toolsMenu.add(clearMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        frame.setJMenuBar(menuBar);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel buttonsPanel = new JPanel();
        JButton loadButton = new JButton("Load Product Data");
        JButton saveButton = new JButton("Save Product Data");
        buttonsPanel.add(loadButton);
        buttonsPanel.add(saveButton);

        yearsLabel = new JLabel("Years Processed: ");
        yearsLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        bottomPanel.add(buttonsPanel, BorderLayout.WEST);
        bottomPanel.add(yearsLabel, BorderLayout.EAST);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);


        loadButton.addActionListener(e -> doLoad());
        saveButton.addActionListener(e -> doSave());

        loadMenuItem.addActionListener(e -> doLoad());
        saveMenuItem.addActionListener(e -> doSave());
        clearMenuItem.addActionListener(e -> doClear());
        exitItem.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    private void doLoad() {
        ProductSales ps = new ProductSales();
        int[][] data = ps.GetProductSales();
        StringBuilder sb = new StringBuilder();
        sb.append("Product Sales Data (Sales Limit = ").append(ps.GetSalesLimit()).append(")\n\n");
        for (int i = 0; i < data.length; i++) {
            sb.append("Year ").append(i + 1).append(": ");
            for (int j = 0; j < data[i].length; j++) {
                sb.append(data[i][j]);
                if (j < data[i].length - 1) sb.append(", ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("Total Sales: ").append(ps.GetTotalSales()).append("\n");
        sb.append(String.format("Average Sales: %.2f\n", ps.GetAverageSales()));
        sb.append("Sales Over Limit: ").append(ps.GetSalesOverLimit()).append("\n");
        sb.append("Sales Under Limit: ").append(ps.GetSalesUnderLimit()).append("\n");
        sb.append("Years Processed: ").append(ps.GetProductsProcessed()).append("\n");

        textArea.setText(sb.toString());
        yearsLabel.setText("Years Processed: " + ps.GetProductsProcessed());
    }

    private void doSave() {
        String content = textArea.getText();
        if (content == null || content.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Text area is empty, nothing to save.", "Save", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write(content);
            JOptionPane.showMessageDialog(frame, "Saved to data.txt", "Save", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Failed to save data.txt: " + ex.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doClear() {
        textArea.setText("");
        yearsLabel.setText("Years Processed: ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesApp());
    }
}
