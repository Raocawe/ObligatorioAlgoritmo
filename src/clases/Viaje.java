/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import ayed2obligatorio2016.Pila.NodoPila;
import ayed2obligatorio2016.Pila.Pila;
import ayed2obligatorio2016.Sistema;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Martin
 */
public class Viaje {
    
    private String origen;
    private String destino;
    private int ciCliente;
    private LocalDateTime fecha;

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the ciCliente
     */
    public int getCiCliente() {
        return ciCliente;
    }

    /**
     * @param ciCliente the ciCliente to set
     */
    public void setCiCliente(int ciCliente) {
        this.ciCliente = ciCliente;
    }

    /**
     * @return the fechaHora
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fechaHora to set
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    public void ImprimirViajes(int pCliente)
    {
        Cliente Cli = new Cliente();
        Cli = Cli.BuscarCliente(pCliente);
        
        System.out.println("Cliente: "+ Integer.toString(pCliente) + " - " + Cli.getNombre());
        Pila pila = Cli.getViajes();
        
            if(pila.IsEmpty())
            {
                System.out.println("Sin Viajes Registrados");
            }
            else
            {
                NodoPila Np = pila.getTop();
                while(Np != null)
                {
                    Viaje aux = (Viaje) Np.getElem();
                    System.out.println(aux.fecha.toString()+" - "+aux.origen+" - "+aux.destino);
                    Np = Np.getSiguiente();
                }
            }
    }
    
/*   public void ImprimirViajes(int pCliente)
    {
        Cliente Cli = new Cliente();
        Sistema Sis = new Sistema();
        ListaSimpleGeneric<Viaje> ListaViajes = Sis.getListaViaje(); ;
        Cli = Cli.BuscarCliente(pCliente);
                
        ListaSimpleGeneric<Viaje> ListaAux = new ListaSimpleGeneric<Viaje>();
        NodoListaSimple Nls = ListaViajes.getInicio();
        while(Nls != null)
        {
            Viaje aux = (Viaje) Nls.getDato();
            if(aux.ciCliente == pCliente)
            {
                ListaAux.insertarInicio(aux);//Capturamos todos los viajes del Cliente
            }
            Nls = Nls.getSiguiente();
        }
                            System.out.println("Cliente: "+ Integer.toString(pCliente) + " - " + Cli.getNombre());

                            if(ListaAux.esVacia())
                            {
                                System.out.println("Sin Viajes Registrados");
                            }
                            else
                            {
                                ListaAux = OrdenarFechaDecendente(ListaAux);
                                Nls = ListaAux.getInicio();
                                while(Nls != null)
                                {
                                    Viaje aux = (Viaje) Nls.getDato();
                                    System.out.println(aux.fecha.toString()+" - "+aux.origen+" - "+aux.destino);
                                }
                                Nls = Nls.getSiguiente();
                            }
    }
    
    public ListaSimpleGeneric<Viaje> OrdenarFechaDecendente(ListaSimpleGeneric<Viaje> pLista)
    {
        ListaSimpleGeneric<Viaje> retorno = pLista;
        
        NodoListaSimple Nls = pLista.getInicio();
        while(Nls != null)
        {
            Viaje aux = (Viaje) Nls.getDato();
            Viaje auxSig = (Viaje)Nls.getSiguiente().getDato();
            Date Fecha = aux.getFecha();
            Date FechaSig = auxSig.getFecha();
            
            if(!Fecha.before(FechaSig))
            {
                NodoListaSimple Nlsaux = Nls;
                Nls.setSiguiente(Nls.getSiguiente().getSiguiente());
                Nlsaux.getSiguiente().setSiguiente(Nls);
            }
            Nls = Nls.getSiguiente();
        }
        return retorno;
    }
*/
}
