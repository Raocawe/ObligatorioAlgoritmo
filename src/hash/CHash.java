/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

import java.util.Scanner;

/**
 *
 * @author Ezequiel
 */
public class CHash implements IHash{
    private static nodoHash[] array;
    @Override
    public void insertarNum() {
        System.out.println("Ingrese un numero a ingresar");
         Scanner in = new Scanner(System.in);
         int num = in.nextInt();
         nodoHash n = new nodoHash();
         n.setValor(num);
         n.setEstado(EstadoNodo.O);
         n.setNextNodo(null);
         if(array[hash(num)]==null || array[hash(num)].getEstado()==EstadoNodo.O ){
             n.setNextNodo(array[hash(num)]); 
         }
         array[hash(num)]=n;
    }

    @Override
    public boolean buscarNum(int num) {
       
        if(array[hash(num)].getEstado()==EstadoNodo.O)
         {
         if(array[hash(num)].getValor()==num)
         return true;
         else{
             nodoHash n = array[hash(num)].getNextNodo();
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
             System.out.println("No se encuentra el Elemento");
             return false;
         }
    }
    

    @Override
    public void eliminarNum() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el numero que desea eliminar");
       
        int num = in.nextInt();
        if(buscarNum(num)){
            if(array[hash(num)].getValor()==num){
                array[hash(num)]=array[hash(num)].getNextNodo();
            }
         else{
             nodoHash n = array[hash(num)];
             nodoHash n2 = array[hash(num)].getNextNodo();
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
        array = new nodoHash[i];
    }
    @Override
    public void imprimir(){
        for(nodoHash n : array)
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
    
}
