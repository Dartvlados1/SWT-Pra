package guis;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenGui extends JDialog {

    private ApplicationGui source;
    JTextField pathTextField;

    public OpenGui(ApplicationGui source) throws IOException {
        this.source = source;
        setTitle("Open .csv file");
        setSize(300, 150);
        setLocationRelativeTo(source);
        setModal(true);
        setLayout(null);
        addOpenGuiComponents();

    }

    private void addOpenGuiComponents() throws IOException {
       addFilePathTextField();
       addOpenButton();
    }

    private void addFilePathTextField() {
        JLabel pathLabel = new JLabel("Path:");
        pathLabel.setBounds(10, 45, 100, 20);
        add(pathLabel);
        pathTextField = new JTextField();
        pathTextField.setBounds(45, 45, 230, 20);
        add(pathTextField);
    }

    private void addOpenButton()  throws IOException {
        JButton openButton = new JButton("Open");
        openButton.setBounds(200, 90, 80, 20);

        openButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String path = pathTextField.getText();
                try {
                    JTable table = readCSVToJTable(path);
                    source.addTableWithScrollPane(table); // Передайте таблицу в метод ApplicationGui для создания JScrollPane
                    setVisible(false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(openButton);
    }

    public JTable readCSVToJTable(String filePath)  throws IOException {
        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Читаем заголовки столбцов
            if ((line = br.readLine()) != null) {
                String[] headers = line.split(",");
                for (String header : headers) {
                    model.addColumn(header);
                }
            }

            // Читаем данные строк построчно
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // В случае ошибки в чтении файла, возвращаем пустую таблицу
            return new JTable();
        }

        return table;
    }
}
