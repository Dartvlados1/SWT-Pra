package guis;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Optional;
import java.util.Stack;

import static java.util.Arrays.stream;

public class ApplicationGui extends JFrame {

    private JTable table;

    public ApplicationGui() {
        super("Spinfood Application");

        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addGuiComponents();
    }

    private void addGuiComponents() {
        addToolBar();
        Optional<Component> table = stream(getComponents()).findFirst().filter(c -> c instanceof JTable);
    }

    private void addToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        JMenuBar menu = new JMenuBar();
        toolBar.add(menu);

        menu.add(addFileMenu());
        menu.add(addSettingsMenu());
        menu.add(addEditMenu());

        toolBar.add(addUnDoButton());
        toolBar.add(addReDoButton());
        toolBar.add(addApplyButton());


        add(toolBar, BorderLayout.NORTH);
    }

    private JMenu addFileMenu() {
        ImageIcon fileIcon = new ImageIcon
                ("C:/Users/markg/IdeaProjects/Food/src/main/resources/MenuIcons/files-and-folders.png");
        JMenu fileWindow = new JMenu();
        fileWindow.setIcon(fileIcon);

        JMenuItem openFile = new JMenuItem("Open");
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new OpenGui(ApplicationGui.this).setVisible(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        fileWindow.add(openFile);

        JMenuItem saveAs = new JMenuItem("Save As");
        fileWindow.add(saveAs);

        return  fileWindow;
    }

    private JMenu addSettingsMenu() {
        ImageIcon settingsIcon = new ImageIcon
                ("C:/Users/markg/IdeaProjects/Food/src/main/resources/MenuIcons/settings.png");
        JMenu settingsWindow = new JMenu();
        settingsWindow.setIcon(settingsIcon);

        JMenuItem account = new JMenuItem("Account");
        settingsWindow.add(account);

        JMenuItem path = new JMenuItem("Path");
        settingsWindow.add(path);

        JMenuItem logOut = new JMenuItem("Log Out");
        settingsWindow.add(logOut);

        return  settingsWindow;
    }

    private JMenu addEditMenu() {
        ImageIcon editIcon = new ImageIcon
                ("C:/Users/markg/IdeaProjects/Food/src/main/resources/MenuIcons/edit-tools.png");
        JMenu editMenu = new JMenu();
        editMenu.setIcon(editIcon);

        JMenuItem configure = new JMenuItem("Configure");
        editMenu.add(configure);

        JMenuItem addRow = new JMenuItem("Add Row");
        addRow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[model.getColumnCount()]);
                repaint();
            }
        });
        editMenu.add(addRow);

        JMenuItem removeRow = new JMenuItem("Remove Row");
        removeRow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(model.getRowCount() - 1);
            }
        });

        editMenu.add(removeRow);

        return  editMenu;
    }

    private JButton addUnDoButton() {
        JButton undoButton = new JButton();
        ImageIcon unDoIcon =  new ImageIcon
                ("C:/Users/markg/IdeaProjects/Food/src/main/resources/MenuIcons/undo.png");

        undoButton.setIcon(unDoIcon);

        undoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return undoButton;
    }

    private JButton addReDoButton() {
        JButton undoButton = new JButton();
        ImageIcon unDoIcon =  new ImageIcon
                ("C:/Users/markg/IdeaProjects/Food/src/main/resources/MenuIcons/redo.png");

        undoButton.setIcon(unDoIcon);
        return undoButton;
    }

    private JButton addApplyButton() {
        ImageIcon applyIcon = new ImageIcon(
                "C:/Users/markg/IdeaProjects/Food/src/main/resources/MenuIcons/submit.png");

        JButton applyButton = new JButton();
        applyButton.setIcon(applyIcon);
        return applyButton;
    }

    public void addTableWithScrollPane(JTable t) {
        table = t;
        add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

}

