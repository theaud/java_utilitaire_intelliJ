package graphique;

import util3.Complexe;
import util3.ComplexeInt;
import util3.Complexebool;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {

    private ComplexeInt pos=new ComplexeInt(-50,-50);
    private ComplexeInt dimention=new ComplexeInt(50,50);
    private objet[] obj=new objet[5];


    public Panneau()
    {
        obj[0]= new objet(Color.red,new ComplexeInt(50,150),1,1);
        obj[1]= new objet(Color.blue,new ComplexeInt(100,250),2,2);
        obj[2]= new objet(Color.green,new ComplexeInt(200,355),3,3);
        obj[3]= new objet(Color.yellow,new ComplexeInt(250,455),1,3);
        obj[4]= new objet(Color.gray,new ComplexeInt(300,55),4,4);
    }

    public void collision_classic(int i)
    {   if (getObj(i).getPosX() < 1)
             {getObj(i).setBackX(false);}
        if (getObj(i).getPosX() > getWidth() - getObj(i).getDim().getRe())
            { getObj(i).setBackX(true);}

        if (getObj(i).getPosY() < 1)
            {getObj(i).setBackY(false);}
        if (getObj(i).getPosY() > getHeight() - getObj(i).getDim().getIm())
             {getObj(i).setBackY(true);}
    }

    public void inversion_colision(Complexebool inversion,int i)
    {
    if(inversion.getRe())
        {if(getObj(i).getBackX())
            {getObj(i).setBackX(false);}
         else
            {getObj(i).setBackX(true);}
         }
    if(inversion.getIm())
        {if(getObj(i).getBackY())
            {getObj(i).setBackY(false);}
        else
            {getObj(i).setBackY(true);}
        }
    }



    public void paintComponent(Graphics g){g.setColor(Color.lightGray);

        //clear du fond
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

         //on redessine tous les objets
        for(int i=0;i<5;i++)
            {draw(g,obj[i]);}

    }


    public void draw(Graphics g,objet obj)
    {switch (obj.getForm())
        {   case 1:Ovale( g, obj);
                break;
            case 2:rectangle(g,obj);
                break;
            case 3:triangle(g,obj);
              break;
            case 4:etoile(g,obj);
                break;
            default:Ovale(g,obj);
                break;
        }
    }



// ---------------------   creation figure  -------------------------------------------------------
    public static void Ovale(Graphics g,objet obj)
    { g.setColor(obj.getColor());
        g.fillOval(obj.getPos().getRe(), obj.getPos().getIm(),obj.getDim().getRe(), obj.getDim().getIm());
    }

    public static void rectangle(Graphics g,objet obj)
    { g.setColor(obj.getColor());
        g.fillRect(obj.getPos().getRe(), obj.getPos().getIm(),obj.getDim().getRe(), obj.getDim().getIm());
    }

    public static void triangle(Graphics g,objet obj)
    { g.setColor(obj.getColor());
        int s1X = obj.getPosX() + obj.getDim().getRe()/2;
        int s1Y = obj.getPosY();
        //Le sommet 2 se situe en bas à droite
        int s2X = obj.getPosX() + obj.getDim().getRe();
        int s2Y = obj.getPosY() + obj.getDim().getIm();
        //Le sommet 3 se situe en bas à gauche
        int s3X = obj.getPosX();
        int s3Y = obj.getPosY() + obj.getDim().getIm();
        //Nous créons deux tableaux de coordonnées
        int[] ptsX = {s1X, s2X, s3X};
        int[] ptsY = {s1Y, s2Y, s3Y};
        //Nous utilisons la méthode fillPolygon()
        g.fillPolygon(ptsX, ptsY, 3);
    }

    public static void etoile(Graphics g,objet obj)
    { g.setColor(obj.getColor());
        int s1X = obj.getPosX() + obj.getDim().getRe()/2;
        int s1Y = obj.getPosY();
        int s2X = obj.getPosX() + obj.getDim().getRe();
        int s2Y = obj.getPosY() + obj.getDim().getIm();
        g.drawLine(s1X, s1Y, s2X, s2Y);
        int s3X = obj.getPosX();
        int s3Y = obj.getPosY() + obj.getDim().getIm()/3+1;
        g.drawLine(s2X, s2Y, s3X, s3Y);
        int s4X = obj.getPosX() + obj.getDim().getRe();
        int s4Y = obj.getPosY() + obj.getDim().getIm()/3+1;
        g.drawLine(s3X, s3Y, s4X, s4Y);
        int s5X = obj.getPosX();
        int s5Y = obj.getPosY() + obj.getDim().getIm();
        g.drawLine(s4X, s4Y, s5X, s5Y);
        g.drawLine(s5X, s5Y, s1X, s1Y);
    }

// ---------------------   Getter setter  -------------------------------------------------------
    public int getPosX() {return pos.getRe();}
    public void setPosX(int posX) {this.pos.setRe(posX);}

    public int getPosY() {return pos.getIm();}
    public void setPosY(int posY) {this.pos.setIm(posY);}

    public void setPos(ComplexeInt pos) {this.pos = pos;  }

    public void setDimention(ComplexeInt dimention) {   this.dimention = dimention; }

    public void setObj(objet objet,int i) {this.obj[i] = objet;    }
    public objet getObj(int i) {return obj[i]; }


}
