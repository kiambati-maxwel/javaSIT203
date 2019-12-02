import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.text.DecimalFormat;

public class OutOfTheNetwork extends CallTimer{

     protected static  LocalTime callstartTime;
    protected static  LocalTime callendTime;
    protected double VAT=0.16;

    protected  static  DecimalFormat frt = new DecimalFormat("0.00");


    public static LocalTime checkLocalTime(){
        callstartTime = LocalTime.now();
        return callstartTime;
    }
    public static LocalTime checkEndTime(){
        callendTime = LocalTime.now();
        return  callendTime;
    }
    public  void billOutOfNet(){

        long bill = getElapsedTime().toMillis();
        double billt;
        if (bill>120000) {
            billt = bill;
            billt = ((billt * 5) / 60000);
            billt = billt + (billt * VAT);
        }
        else {
            billt = bill;
            billt = ((billt * 5) / 60000);

        }

        JOptionPane.showMessageDialog(null, "charges = "+frt.format(billt)+" /=Ksh"+
                " \n from -->  " + callstartTime
                + " \n to --> "+ callendTime);


    }

    public void checkReceiver() {

            checkLocalTime();
            start();
            final JFrame frame = new JFrame();

            //

            JButton btncancel = new JButton("press to hung up");

            btncancel.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                  stop();
                  checkEndTime();
                  billOutOfNet();
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