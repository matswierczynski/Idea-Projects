package com.company;
import javax.swing.*;

import java.util.Scanner;

public class Main {
    /*private long silnia;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Silnię jakiego argumentu wyznaczyć?");
        long tmp=scan.nextLong();
	    System.out.println(silnia(tmp));
        System.out.println(fib(tmp));
    }

    public static long silnia(long value){
        if(value==0)
            return 1;
        return value*silnia(value-1);
    }

    public static long fib(long value){
        if(value==0)
            return 0;
        if(value==1)
            return 1;
        return fib(value-1)+fib(value-2);
    }

*/

    public static void main(String[] args) {
        JFrame frame = new JFrame("Powitanie");                              // 1
        String htmlText = "<html><FONT SIZE=+3>" +                           // 2
                "Witaj<font color=red><b> Javo!</b></font><br>" +
                "<font color=blue>... A witaj!</font></html>";

        Icon icon = new ImageIcon("java_logo.png");                          // 3
        JLabel label = new JLabel(htmlText, icon, JLabel.CENTER);            // 4
        frame.add(label);                                                    // 5
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                // 6
        frame.pack();                                                        // 7
        frame.setLocationRelativeTo(null);                                   // 8
        frame.setVisible(true);                                              // 9

    }
}
