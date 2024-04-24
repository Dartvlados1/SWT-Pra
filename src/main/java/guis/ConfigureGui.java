package guis;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConfigureGui extends JDialog {

    private ApplicationGui source;

    public ConfigureGui(ApplicationGui source) {

        this.source = source;
        setTitle("Define priorities");
        setSize(500, 300);
        setLocationRelativeTo(source);
        setModal(true);
        setLayout(null);

    }

}
