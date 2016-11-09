/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ayed2obligatorio2016.Grafo.IHash;
import ayed2obligatorio2016.Grafo.NodoGrafo;

/**
 *
 * @author Ezequiel
 */
public class CHash{
    private static NodoGrafo[] array = new NodoGrafo[100];
    
    public void insertarEstacion(NodoGrafo pEstacion) {
         
        
         NodoGrafo n = new NodoGrafo();
         if(array[hash(num)]==null || array[hash(num)].getEstado()==EstadoNodo.O ){
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
       
        if(array[hash(num)].getEstado()==EstadoNodo.O)
         {
         if(array[hash(num)].getValor()==num)
         return true;
         else{
             NodoGrafo n = array[hash(num)].getNextNodo();
             while(n!=null)
             {
                 if(n.getValor()== num)
                     return true;
                 else 
                 {
                     n=n.getNextNodo();
                 }
             }
             return false;
         }
         }
         else{
             return false;
         }
    }
    

    @Override
    public void eliminarNum(int pEntero) {
       
        int num = pEntero;
        if(buscarNum(num)){
            if(array[hash(num)].getValor()==num){
                array[hash(num)]=array[hash(num)].getNextNodo();
            }
         else{
             NodoGrafo n = array[hash(num)];
             NodoGrafo n2 = array[hash(num)].getNextNodo();
             while(n2!=null)
             {
                 if(n2.getValor()== num){
                     n.setNextNodo(n2.getNextNodo());
                    
                     
                 }
                     
                
                     n2=n2.getNextNodo();
                     n=n.getNextNodo();
                 
             }
            
         }
           
            System.out.println("Se elimino correctamente");
        }
        }

    @Override
    public int hash(int i){
        return i%array.length;
    }
    public CHash(int i)
    {
        array = new NodoGrafo[i];
    }
    @Override
    public void imprimir(){
        for(NodoGrafo n : array)
        {
            if(n!=null && n.getEstado()==EstadoNodo.O)
            {
                while(n!=null)
                {
                System.out.print("--> "+n.getValor());
                n=n.getNextNodo();
                }
             System.out.println();
            }
            else{
                System.out.println("__");
            }
                
        }
    }

    public void insertarNum(int pEntero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
