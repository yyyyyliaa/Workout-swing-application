package view;

import javax.swing.*;


public class TextFieldWindow extends JDialog {
    private JFrame f;
    private final JTextField ex1, ex2, ex3, ex4, ex5;
    public TextFieldWindow(String[] res, Object[] exercise, JFrame f){
        super(f, "Enter results of that day in next format:'sets'/'reps' 'weight'", true);
        this.f = f;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ex1 = new JTextField(exercise[0].toString(), 25);
        ex2 = new JTextField(exercise[1].toString(), 25);
        ex3 = new JTextField(exercise[2].toString(), 25);
        ex4 = new JTextField(exercise[3].toString(), 25);
        ex5 = new JTextField(exercise[4].toString(), 25);


        JButton set = new JButton("Set results");
        set.addActionListener(e -> {
            if(checkCorrectData(ex1.getText())&&checkCorrectData(ex2.getText())&&checkCorrectData(ex3.getText())&&
                    checkCorrectData(ex4.getText())&&checkCorrectData(ex5.getText())){
                res[0] = ex1.getText();
                res[1] = ex2.getText();
                res[2] = ex3.getText();
                res[3] = ex4.getText();
                res[4] = ex5.getText();
                dispose();
            } else{
                JOptionPane.showMessageDialog(f,"Wrong data");
                dispose();
            }

        });

        add(ex1);
        add(ex2);
        add(ex3);
        add(ex4);
        add(ex5);
        add(set);

    }

    private boolean checkCorrectData(String str){
        if((str.charAt(2)=='/'&&str.charAt(5)==' ')||(str.charAt(1)=='/'&&str.charAt(4)==' ')||
                (str.charAt(2)=='/'&&str.charAt(4)==' ')||(str.charAt(1)=='/'&&str.charAt(3)==' ')){
                    String[] tokens = str.split(" ");
                    if(isNumber(tokens[1])){
                        String[] tokens2 = tokens[0].split("/");
                        return isNumber(tokens2[0]) && isNumber(tokens2[1]);
                    } else return false;
        } else return false;
    }

    private boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++)
            if (!Character.isDigit(str.charAt(i))) return false;
        return true;
    }
}
