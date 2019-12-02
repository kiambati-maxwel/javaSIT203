import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public class HomeNetWork extends OutOfTheNetwork {


    private static int currenthour;


    public static int getHour() {
        GregorianCalendar calender = new GregorianCalendar();

        currenthour = calender.get(calender.HOUR_OF_DAY);
        return currenthour;

    }


    public void getCharges() {
        long billHome = getElapsedTime().toMillis();
        double charges = billHome;

        if (currenthour < 18 && currenthour > 6 ) {

               if (billHome>120000) {
                   charges = ((charges * 3) / 60000);
                   charges = charges + (charges * VAT);

                   JOptionPane.showMessageDialog(null, "charges = " + frt.format(charges) +
                           " /=Ksh" + " \n from " + callstartTime
                           + " \n to" + callendTime);
               }else{
                   charges = ((charges * 3) / 60000);
                   JOptionPane.showMessageDialog(null, "charges = " + frt.format(charges) +
                           " /=Ksh" + " \n from " + callstartTime
                           + " \n to" + callendTime);
               }

        }
        else {
            if (billHome>120000) {
                charges = ((charges * 4) / 60000);
                charges = charges + (charges * VAT);
                JOptionPane.showMessageDialog(null, "charges = " + frt.format(charges) + " /=Ksh" +
                        " \n from --> " + callstartTime +
                        " \n to --> " + callendTime);
            }else{
                charges = ((charges * 4) / 60000);
                JOptionPane.showMessageDialog(null, "charges = " + frt.format(charges) + " /=Ksh" +
                        " \n from --> " + callstartTime+
                        " \n to --> " + callendTime);
            }
        }

    }


    public void homeReceiver() {

        getHour();
        checkLocalTime();
        start();
        final JFrame frame = new JFrame();

        //

        JButton btncancel = new JButton("press to hung up call");

        btncancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
                checkEndTime();
                getCharges();

                btncancel.setVisible(false);
                btncancel.invalidate();
                frame.setVisible(false);
                System.exit(0);

            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btncancel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}

