package Calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Main extends JFrame {
    JButton[][] A = new JButton[4][5];

    public static void main(String[] args) {
        Main objM = new Main();
    }
    Main() {
        Buttons();
        Labels();
    }

    private void Buttons() {
        this.setLayout(null);
        this.setBounds(555, 200, 500, 720);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("New window.");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                A[i][j] = new JButton(String.valueOf((i + 7) - ((j - 1) * (j + 1)) - ((j - 1) * (j - 2) * (j - 4))));
                this.add(A[i][j]);
                A[i][j].setBounds(50 + i * 100, 150 + j * 100, 70, 70);
            }
        }
        A[0][4].setText("+\\-");
        A[1][4].setText("0");
        A[2][4].setText(".");
        A[3][4].setText("=");
        A[3][3].setText("+");
        A[3][2].setText("-");
        A[3][1].setText("*");
        A[3][0].setText("/");
        A[2][0].setText("⌫");
        A[1][0].setText("CE");
        A[0][0].setText("%");
    }

    private void Labels() {
        JLabel jlRes;
        jlRes = new JLabel();
        jlRes.setBackground(Color.blue);
        this.add(jlRes);
        jlRes.setBounds(30, 30, 300, 35);

        System.out.println(jlRes.getText());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int finalI = i;
                int finalJ = j;
                A[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if ((finalI!=0 || finalJ!= 4)&&(finalI!=0 || finalJ!= 0)&&(finalI != 1 || finalJ != 0)&&(finalI != 2 || finalJ != 0)) {
                            jlRes.setText(jlRes.getText() + A[finalI][finalJ].getText());
                        }
                    }
                });
            }
        }
        A[1][0].addActionListener(new ActionListener() /* CE */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlRes.setText("");
            }
        });

        A[3][0].addActionListener(new ActionListener() /* / */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand1 = Double.parseDouble(jlRes.getText());
                jlRes.setText("");
                operacia = Oper.DIV;
            }
        });

        A[3][1].addActionListener(new ActionListener() /* * */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand1 = Double.parseDouble(jlRes.getText());
                jlRes.setText("");
                operacia = Oper.MUL;
            }
        });

        A[3][2].addActionListener(new ActionListener() /* - */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand1 = Double.parseDouble(jlRes.getText());
                jlRes.setText("");
                operacia = Oper.SUB;
            }
        });
        A[3][3].addActionListener(new ActionListener() /* + */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand1 = Double.parseDouble(jlRes.getText());
                jlRes.setText("");
                operacia = Oper.SUM;
            }
        });
        A[0][0].addActionListener(new ActionListener() /* % */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand1 = Double.parseDouble(jlRes.getText());
                jlRes.setText("");
                operacia = Oper.OST;
            }
        });
        A[0][4].addActionListener(new ActionListener() /* +/- */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(Double.parseDouble(jlRes.getText())%1,(double) 0)){
                    jlRes.setText(String.valueOf(-Integer.parseInt(jlRes.getText())));
                    operand1 = Integer.parseInt(jlRes.getText());
                }
                else{
                    jlRes.setText(String.valueOf(0 - Double.parseDouble(jlRes.getText())));
                    operand1 = Double.parseDouble(jlRes.getText());
                }
            }
        });

        A[3][4].addActionListener(new ActionListener() /* = */ {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (Objects.equals(operacia.operMeth(operand1, Double.parseDouble(jlRes.getText()))%1,(double) 0)) {
                    jlRes.setText("" + ((int) operacia.operMeth(operand1, Double.parseDouble(jlRes.getText()))));
                }
                else{
                    jlRes.setText("" + operacia.operMeth(operand1, Double.parseDouble(jlRes.getText())));
                }
                operand1 = 0;
            }
        });
    }
    JLabel jlRes;
    private double operand1 = 0;
    private Oper operacia = Oper.NONE;

}