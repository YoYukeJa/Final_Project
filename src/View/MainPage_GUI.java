package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage_GUI implements ActionListener {
    private int count = 0;
    private JFrame frame;
    private JLabel label;
    private JButton button;


    public MainPage_GUI(){
        frame = new JFrame();

        button = new JButton("Click me");
        button.addActionListener(this);
        button.setSize(300, 100);

        label = new JLabel("Number of clicks: 0");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(600, 600, 200, 600));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Page");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new MainPage_GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    }
}
