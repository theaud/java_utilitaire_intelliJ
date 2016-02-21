package graphique;

import util3.ComplexeInt;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {

    private ComplexeInt pos=new ComplexeInt(-50,-50);
    private ComplexeInt dimention=new ComplexeInt(50,50);

    public Panneau()
    {



    }



    public void paintComponent(Graphics g){g.setColor(Color.lightGray);


        objet obj= new objet(Color.blue);
        objet obj1= new objet(new ComplexeInt(100,100));


     //   Ovale( g, Color.green, pos, dimention);
        Ovale(g, obj);
        Ovale(g, obj1);
    }

    public void drawLine(Graphics g,ComplexeInt origine,ComplexeInt destination)
    {g.drawLine(origine.getRe(),origine.getIm(),destination.getRe(),destination.getIm());}


    public static void Ovale(Graphics g,Color color,ComplexeInt pos,ComplexeInt Dimension)
    {
        g.setColor(color);
      g.fillOval(pos.getRe(), pos.getIm(), Dimension.getRe(), Dimension.getIm());
    }

    public static void Ovale(Graphics g,objet obj)
    { g.setColor(obj.getColor());
        g.fillOval(obj.getPos().getRe(), obj.getPos().getIm(),obj.getDim().getRe(), obj.getDim().getIm());
    }

    public void drawStar(Graphics g,ComplexeInt origine,int taille)
    {
        //a faire en pompan
    }
public int getPosX() {return pos.getRe();}
    public void setPosX(int posX) {this.pos.setRe(posX);}

    public int getPosY() {return pos.getIm();}
    public void setPosY(int posY) {this.pos.setIm(posY);}


}
