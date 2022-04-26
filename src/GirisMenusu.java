import javax.swing.*;

public class GirisMenusu {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AnaMenu frame=new AnaMenu();

                frame.setVisible(true);

            }
        });



   /*     JFrame frame=new JFrame("Ana Menü");


        JButton urunTanimlama= new JButton("Urun Tanımlama");
        urunTanimlama.setBounds(10,10,140,20);
        frame.add(urunTanimlama);
        urunTanimlama.setLayout(null);//Bunu da kurcaladım ama sonuç alamadım.










        frame.setSize(300,300);
        frame.setLayout(null); //Sorun muhtemelen bu ama basit bir çözüm bulmadım.
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    */



    }
}
