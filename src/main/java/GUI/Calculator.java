package GUI;

import actions.ActionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator extends JFrame implements ActionListener{

    private static final String[] calcKeys = {"%","CE","C","<-","1/x","x^2","2√x","/","7","8","9","x","4","5","6","-",
    "1","2","3","+","+\\-","0",".","="};

    static JTextField field;
    static JTextField bufferField;
    public Calculator(){
        setupGUI();
    }

    private void setupGUI(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field = new JTextField();
        field.setHorizontalAlignment(SwingConstants.RIGHT);
        field.setEditable(false);

        bufferField = new JTextField();
        bufferField.setHorizontalAlignment(SwingConstants.RIGHT);
        bufferField.setEditable(false);

        JPanel bottom = new JPanel();
        JPanel center = new JPanel();

        bottom.setLayout(new GridLayout(6,4));
        center.setLayout(new GridLayout(2,1));

        for (String calcKey : calcKeys) {
            CalcButton button = new CalcButton(calcKey);
            button.addActionListener(this);
            bottom.add(button);

        }


        center.add(bufferField);
        center.add(field);

        add(bottom,BorderLayout.SOUTH);
        add(center, BorderLayout.CENTER);
        pack();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        ActionManager.pressEvent(command,field,bufferField);


    }

}
