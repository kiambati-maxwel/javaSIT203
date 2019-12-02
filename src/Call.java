import javax.swing.*;

public class Call extends HomeNetWork {
    private static   int phoneNO;
    public Call(){

        String receiver = JOptionPane.showInputDialog("enter receivers network\n (700) for other network \n (100) for my network");
        phoneNO = Integer.parseInt(receiver);

    }
    public static void main(String [] args){
        Call a = new Call();


        if ( phoneNO==700){
            a.checkReceiver();
        }
        else if (phoneNO == 100){
            a.homeReceiver();
        }
        else{
            JOptionPane.showMessageDialog(null,"invalid no");
        }
    }
}
