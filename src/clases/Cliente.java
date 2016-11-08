/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import ayed1obligatorio2016.ListaDoble.ListaDobleEnc;
import ayed1obligatorio2016.ListaDoble.NodoLista;
import ayed1obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed1obligatorio2016.ListaSimple.NodoListaSimple;
import ayed2obligatorio2016.Sistema;

/**
 *
 * @author Martin
 */
public class Cliente {
    
    private int cedula;
    private String nombre;
    
    

    /**
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean CorrobarCanDigitos(Integer pCedula)
    {
        if(pCedula.toString().toCharArray().length == 8)
        {
            return true;
        }
        else
        {
        return false;
        }
    }
    
    
    
    public boolean BuscarCliente(int pCedula)
    {
        Sistema Sis = new Sistema();
        ListaDobleEnc<Cliente> ListCli = Sis.getListaCliente();
        
         if(ListCli.esVacia())
                    {
                    return false;
                     }
            
            else
            {
                NodoLista Nl = ListCli.getInicio();
                while(Nl != null)
                {
                    Cliente elCliente = new Cliente();
                    elCliente = (Cliente) Nl.getDato();
                
                if(elCliente.getCedula() == pCedula)
                    {
                        return true;
                    }
                else
                    {
                        Nl = Nl.getSiguiente();
                    }
                }
            return false;
        }
        }
              
    }


