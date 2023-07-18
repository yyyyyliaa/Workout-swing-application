package data;

import javax.swing.*;


public class TextFieldWindow extends JDialog {
    JTextField ex1, ex2, ex3, ex4, ex5;
    public TextFieldWindow(String[] res, Object[] exercise, JFrame f){
        super(f, "Enter results of that day in next format: Number of sets/reps, weight", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ex1 = new JTextField(exercise[0].toString(), 25);
        ex2 = new JTextField(exercise[1].toString(), 25);
        ex3 = new JTextField(exercise[2].toString(), 25);
        ex4 = new JTextField(exercise[3].toString(), 25);
        ex5 = new JTextField(exercise[4].toString(), 25);


        JButton set = new JButton("Set results");
        set.addActionListener(e -> {
            res[0] = ex1.getText();
            res[1] = ex2.getText();
            res[2] = ex3.getText();
            res[3] = ex4.getText();
            res[4] = ex5.getText();
            dispose();
        });

        add(ex1);
        add(ex2);
        add(ex3);
        add(ex4);
        add(ex5);
        add(set);

    }
}
