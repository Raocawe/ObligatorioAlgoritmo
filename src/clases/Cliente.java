/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import ayed2obligatorio2016.ArbolBinario.ArbolBinario;
import ayed2obligatorio2016.ArbolBinario.NodoBinario;
import ayed2obligatorio2016.ListaDoble.ListaDobleEnc;
import ayed2obligatorio2016.ListaDoble.NodoLista;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import ayed2obligatorio2016.Pila.NodoPila;
import ayed2obligatorio2016.Pila.Pila;
import ayed2obligatorio2016.Sistema;
import static ayed2obligatorio2016.Sistema.getListaClienteOrdenadosNombre;

/**
 *
 * @author Martin
 */
public class Cliente implements Comparable<Cliente>{
    
    private int cedula;
    private String nombre;
    private Pila<Viaje> Viajes;
    
    
    public Cliente(){
    Viajes = new Pila<Viaje>();
    
    }
            
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
        
    public Cliente BuscarCliente(int pCedula)
    {
        Sistema Sis = new Sistema();
        ListaDobleEnc<Cliente> ListCli = Sis.getListaCliente();
        
         if(ListCli.esVacia())
         {
            return null;
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
                        return elCliente;
                    }
                else
                    {
                        Nl = Nl.getSiguiente();
                    }
                }
            return null;
        }
    }
    
    public void ImprimirTodos()
    {
        Viaje v;
        
        System.out.println("Cliente: "+ this.cedula +" - "+ this.nombre);
        if(Viajes.IsEmpty())
        {
            System.out.println("\n Sin Viajes Registrados");
        }
        else
        {
            NodoPila top = Viajes.getTop();
            while(top!=null)
            {
                v = (Viaje)top.getElem();
                
                System.out.println(v.getFecha().toString()+" - "+v.getOrigen()+" - "+v.getDestino());
                
                top = top.getSiguiente();
            }
        }
    }       

    public Pila<Viaje> getViajes() {
        return Viajes;
    }

    public void setViajes(Pila<Viaje> Viajes) {
        this.Viajes = Viajes;
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
    public int compareTo(Cliente o) {
        
        int a = StringAint(this.nombre);
        int b = StringAint(o.nombre);
        
        if(a>b)
            return 1;
        else if(a < b)
            return -1;
        else
            return 0; 
    }
    
    private void ListadoCliente(Cliente pC)
    {
        
        if(!pC.getViajes().IsEmpty())
        System.out.println(pC.getNombre()+" - "+pC.getViajes().Top().getOrigen()+" - "+pC.getViajes().Top().getDestino());
        else{
        System.out.println(pC.getNombre()+" Sin Viajes Registrados");    
        
    }
    System.out.println("");
    }
    
    public void ListadoClientes()
    {
        ArbolBinario<Cliente> s = getListaClienteOrdenadosNombre();
        NodoBinario s1 = (NodoBinario)s.getRaiz();
        Recorrido_En_Orden(s1); 
    }
    
    private void Recorrido_En_Orden(NodoBinario raiz)
    {
        if(raiz != null)
        {
            Cliente c = (Cliente)raiz.getElemento();
            
            Recorrido_En_Orden(raiz.getHijoIzquierdo());
            ListadoCliente(c);
            Recorrido_En_Orden(raiz.getHijoDerecho());
        }
    }
    
    
    }


