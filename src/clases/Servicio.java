/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Martin
 */
public class Servicio implements Comparable<Servicio>{
    
    private String Nombre;


    /**
     * @return the servicio
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the servicio to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int StringAint(String pC)
    {
        int retorno = 0;
        char[] a = pC.toCharArray();
        for(int i=0 ; i<a.length ; i++)
        {
            retorno+=(int)a[i];
        }
        return retorno;
    }
    
    public int compareTo(Servicio o) {
        
        int a = StringAint(this.Nombre);
        int b = StringAint(o.Nombre);
        
        if(a>b)
            return 1;
        else if(a < b)
            return -1;
        else
            return 0; 
    }
    
}
