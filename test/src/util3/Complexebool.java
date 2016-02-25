
package util3;

/**
 *
 * @author mathieu
 */
public class Complexebool {


    private boolean _im;
    private boolean _re;

    //***************************************************************************************

    public  Complexebool()
    {_im=true;
     _re=true;
    }
    public  Complexebool(boolean im,boolean re)
    {_im=im;
        _re=re;
    }
    //***************************************************************************************
    //***************************************************************************************
    //***************************************************************************************

    /**
     *
     * @param size
     * @return
     */
    public static Complexebool[] newTableComplexeBoolean(int size)
    {
        if(size>0)
        {Complexebool[] table=new Complexebool[size];
            for(int i=0;i<size;i++)
            { table[i]=new Complexebool(); }

            return table;
        }
        Complexebool[] table=new Complexebool[1];
        return table;

    }

    public boolean getIm()            {return _im;}
    public void   setIm(boolean im)   {_im=im;}

    public boolean getRe()            {return _re;}
    public void   setRe(boolean re)   {_re=re;}

    public void set(boolean re,boolean im){_re=re;_im=im;}












}
