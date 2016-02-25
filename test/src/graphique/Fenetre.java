package graphique;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util3.ComplexeInt;

public class Fenetre extends JFrame {

    public static final int dimentionX = 500;
    public static final int dimentionY = 500;
    //-------------------------------------------------------------
    private Panneau pan = new Panneau();

    private JPanel container = new JPanel();


    private boolean animated = true;


    private Thread t;
    // private Thread t2;

    private objet obj;
    //private objet obj1;

    public Fenetre() {

        //----------------------------Creation de la fenetre global ---------------------------------------------------------
        this.setTitle("Animation");
        this.setSize(dimentionX, dimentionY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//-----------------------Definir pan comme fond et l'afficher--------------------------------------
        this.setContentPane(pan);
        this.setVisible(true);

//---------------------------------------------------------------------------------------------

       go();

/*
        t = new Thread(new PlayAnimation());

        t.start();

        this.setContentPane(container);

*/
     //   this.setVisible(true);
    }

    private void go(){
    int vitesse=1;

        while (true)
            {

             for(int i=0;i<5;i++)
             {
                 vitesse=pan.getObj(i).getVitesse();

                 pan.collision_objet();
                 pan.collision_classic(i);
                 if (!pan.getObj(i).getBackX()) pan.getObj(i).moveX(vitesse);
                 else pan.getObj(i).moveX(-vitesse);

                 if (!pan.getObj(i).getBackY())  pan.getObj(i).moveY(vitesse);
                 else pan.getObj(i).moveY(-vitesse);

             }

                pan.repaint();
                try {Thread.sleep(5);}
                catch (InterruptedException e) {e.printStackTrace();}
            }


        }



/*
    class PlayAnimation implements Runnable {

        public  void run() {


            ComplexeInt size = new ComplexeInt(50, 50);

            boolean backX=false, backY=false;
            int x = obj.getPosX();
            int y = obj.getPosY();

           // while (obj.getAnimeted())
            while (true)
            {System.out.println("running");
                if (x < 1) backX = false;
                if (x > pan.getWidth() - size.getRe()) backX = true;
                if (y < 1) backY = false;
                if (y > pan.getHeight() - size.getIm()) backY = true;
                if (!backX) obj.setPosX(++x);
                else obj.setPosX(--x);
                if (!backY) obj.setPosY(++y);
                else obj.setPosY(--y);

                pan.repaint();

                try {Thread.sleep(3);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
        }
    }

*/
}
