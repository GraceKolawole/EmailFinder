package view;

import controller.FileContentCheckerOGK;

import javax.swing.*;
import java.awt.*;

public class FileContentCheckerGUIOGK {

    public FileContentCheckerGUIOGK(FileContentCheckerOGK fileContentCheckerOGK) {

        JFrame frame = new JFrame("File Content Checker - GUI");
        frame.setSize(315, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea textField = new JTextArea();
        textField.setEditable(false);
        JScrollPane scroll = new JScrollPane(textField);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setViewportView(textField);
        scroll.setPreferredSize(new Dimension(300, 260));

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            startButton.setEnabled(false);
            String result = fileContentCheckerOGK.fileWithEmailOGK();
            textField.setText(result);
            startButton.setEnabled(true);
        });
        frame.add(scroll, BorderLayout.NORTH);
        frame.add(startButton, BorderLayout.SOUTH);

        frame.setVisible(true);

    }
}
