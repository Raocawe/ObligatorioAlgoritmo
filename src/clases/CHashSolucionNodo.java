/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import ayed2obligatorio2016.Grafo.Enumerado;
import ayed2obligatorio2016.Grafo.NodoGrafo;

/**
 *
 * @author cristian castro
 */
public class CHashSolucionNodo implements Hash{

    private NodoGrafo[] array;

    /**
     * @return the array
     */
    public NodoGrafo[] getArray() {
        return array;
    }
    
    public CHashSolucionNodo()
    {
        array = new NodoGrafo[100];
    }
    
    public void insertarEstacion(NodoGrafo pEstacion) {
         NodoGrafo n = new NodoGrafo();
         int Indice = hash(StringAInt(pEstacion.getNombre()));
         if(getArray()[Indice] ==null)
         {
             pEstacion.setEstado(Enumerado.O);
             array[Indice] = pEstacion;    
         }
         else
         {
             if(getArray()[Indice].getEstado().equals(Enumerado.O) || !pEstacion.getNombre().equals(array[Indice].getNombre()))
             {
                 boolean ver = false;
                int contador = 1;
                while(!ver)
                {
                    if(getArray()[Indice+contador]==null)
                    {
                        pEstacion.setEstado(Enumerado.O);
                        array[Indice+contador] = pEstacion;
                        ver = true;
                    }
                    contador++;
                }
             }
         }
                  
    }

    public NodoGrafo BuscarPrimerNoNUll()
    {
        for(NodoGrafo n : getArray())
        {
            if(n!=null)
            {
                return n;
            }
        }
        return null;
    }
    
    public int StringAInt(String pChar)
    {
            char[] Charr = pChar.toCharArray();
            int retorno=0;
            for(int i=0; i<Charr.length;i++)
            {
                retorno = retorno + (int)Charr[i];
            }
            return retorno;
    }
    
    public NodoGrafo BuscarHash(String pNombre) {
       
        int num = hash(StringAInt(pNombre));
        if(getArray()[num]!=null)
        {
            if(getArray()[num].getEstado().equals(Enumerado.O))
            {
        if(     getArray()[num].getNombre().equals(pNombre))
        return  getArray()[num];
           else
           {
               int i = num+1;
               NodoGrafo n = getArray()[i];
               while(n!=null)
               {
                   if(n.getNombre().equals(pNombre))
                       return n;
                   else 
                   {
                       i++;
                       n =  getArray()[i];
                   }
               }
               return null;
           }
        }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    
    public int hash(int i){
        return i%97;
    }
    
    public void imprimir(){
        for(NodoGrafo n : getArray())
        {
            if(n!=null && n.getEstado()==Enumerado.O)
            {
                while(n!=null)
                {
                System.out.print("--> "+n.getNombre());
                }
             System.out.println();
            }
            else{
                System.out.println("__");
            }
                
        }
    }
    
    public int ObtenerIndice(String pNombre)
    {
        int num = hash(StringAInt(pNombre));
        if(getArray()[num]!=null)
        {
            if(getArray()[num].getEstado().equals(Enumerado.O))
            {
                if(getArray()[num].getNombre().equals(pNombre))
                return  num;
                   else
                   {
                       int i = num+1;
                       NodoGrafo n = getArray()[i];
                       while(n!=null)
                       {
                           if(n.getNombre().equals(pNombre))
                               return i;
                           else 
                           {
                               i++;
                               n =  getArray()[i];
                           }
                       }
                       return -1;
                   }
            }
            else
            {
                return -1;
            }
        }
        else
        {
            return -1;
        }
    }


}
