package org.home;

import javax.swing.*;

public class MoneyCalc {

    private static JFrame jFrame = new JFrame("Money Calc");

    public static void main( String[] args ) {
        MoneyCalc moneyCalc = new MoneyCalc();
        moneyCalc.setupGUI();
    }

    private void setupGUI() {
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(30, 30, 300, 300);
        jFrame.setVisible(true);
    }
}
