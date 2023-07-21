package view;

import javax.swing.*;
import java.awt.*;


public class TextFieldWindow extends JDialog {
    private final JTextField ex1, ex2, ex3, ex4, ex5;
    private final String[] res = new String[5];
    public TextFieldWindow(Object[] exercise){
        super((Frame) null, "Enter results of that day in next format:'sets'/'reps' 'weight'", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(1200,400));
        setLayout(new GridLayout(4, 1));
        setLocation(450,200);

        ex1 = new JTextField(exercise[0].toString(), 25);
        ex2 = new JTextField(exercise[1].toString(), 25);
        ex3 = new JTextField(exercise[2].toString(), 25);
        ex4 = new JTextField(exercise[3].toString(), 25);
        ex5 = new JTextField(exercise[4].toString(), 25);

        JButton setButton = new JButton("Set results");
        setButton.setPreferredSize(new Dimension(100,100));

        setButton.addActionListener(e -> {
            setResults();
            dispose();
        });

        JPanel p1 = new JPanel(new BorderLayout());
        p1.setLayout(new GridLayout(5, 2));

        JPanel p2 = new JPanel(new BorderLayout());

        this.add(p1, BorderLayout.NORTH);
        this.add(p2,BorderLayout.WEST);

        p1.add(ex1);
        p1.add(ex2);
        p1.add(ex3);
        p1.add(ex4);
        p1.add(ex5);

        p2.add(setButton);
        setVisible(true);
    }


    public String[] getResults(){return res;}
    private void setResults(){
        res[0] = ex1.getText();
        res[1] = ex2.getText();
        res[2] = ex3.getText();
        res[3] = ex4.getText();
        res[4] = ex5.getText();
    }


}
