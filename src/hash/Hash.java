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
public class Hash {

    /**
     * @param args the command line arguments
     */
    public static CHash h;
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del array: ");
        h = new CHash(in.nextInt());
        funciones();
    }
    public static void funciones(){
        Scanner in = new Scanner(System.in);
       
        System.out.println("Que desea hacer? \n 1: Insertar \n 2:Buscar \n 3:Eliminar \n 4:Imprimir \n 5:Salir");
        int num = in.nextInt();
        if(num==1)
        {
            h.insertarNum();
            funciones();
        }
        else if(num==2)   
        {
            System.out.println("Ingrese el numero que quiere buscar");
            int num2 = in.nextInt();
            if (h.buscarNum(num2)){
                System.out.println("El elemento fue encontrado en la posicion: "+h.hash(num2));
            }
            funciones();
        }
        else if(num==3)
        {
            h.eliminarNum();
            funciones();
        }
        else if(num==4)
        {
            h.imprimir();
            funciones();
        }
        else if(num==5)
        {
           //System.exit(1);
           System.runFinalization();
        }
        else if(num<1 || num >5)
        {
            System.out.println("No seas nabo!!, del 1 al 3!!");
            funciones();
        }
      
    }
    }
    
    

