package ayed2obligatorio2016.Grafo;


import ayed2obligatorio2016.Grafo.Enumerado;
import ayed2obligatorio2016.Grafo.NodoGrafo;

/**
 *
 * @author Ezequiel
 */
public class CHash{
    private static NodoGrafo[] array = new NodoGrafo[100];
    
    public void insertarEstacion(NodoGrafo pEstacion) {
         
         NodoGrafo n = new NodoGrafo();
         
         
         if(array[hash(num)]==null || array[hash(num)].getEstado()==Enumerado.O ){
             n.setNextNodo(array[hash(num)]); 
         }
         array[hash(num)]=n;
    }

    public int StringAInt(String pChar)
    {
        char[] Charr = pChar.toCharArray();
        int retorno=0;
        for(int i=0; i<Charr.length;i++)
        {
            retorno =+  (int)Charr[i];
        }
        return retorno;
    }
    
    public boolean buscarNum(int num) {
       
        if(array[hash(num)].getEstado()==Enumerado.O)
         {
         if(StringAInt(array[hash(num)].getNombre())==num)
         return true;
         else{
             NodoGrafo n = array[hash(num)].getNextGrafo();
             while(n!=null)
             {
                 if(StringAInt(n.getNombre())== num)
                     return true;
                 else 
                 {
                     n=n.getNextGrafo();
                 }
             }
             return false;
         }
         }
         else{
             return false;
         }
    }
    

    public void eliminarNum(int pEntero) {
       
        int num = pEntero;
        if(buscarNum(num)){
            if(StringAInt(array[hash(num)].getNombre())==num){
                array[hash(num)]=array[hash(num)].getNextGrafo();
            }
         else{
             NodoGrafo n = array[hash(num)];
             NodoGrafo n2 = array[hash(num)].getNextGrafo();
             while(n2!=null)
             {
                 if(StringAInt(n2.getNombre())== num){
                     n.setNextGrafo(n2.getNextGrafo());
                 }
                     n2=n2.getNextGrafo();
                     n=n.getNextGrafo();
             }
         }
        }
        }

    public int hash(int i){
        return i%101;
    }
    public CHash(){}
    
    public void imprimir(){
        for(NodoGrafo n : array)
        {
            if(n!=null && n.getEstado()==Enumerado.O)
            {
                while(n!=null)
                {
                System.out.print("--> "+n.getNombre());
                n=n.getNextGrafo();
                }
             System.out.println();
            }
            else{
                System.out.println("__");
            }
                
        }
    }    
}
