/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ayed2obligatorio2016;

import ayed2obligatorio2016.ArbolBinario.ArbolBinario;
import ayed2obligatorio2016.Grafo.Arista;
import ayed2obligatorio2016.Grafo.CHash;
import ayed2obligatorio2016.Grafo.Grafo;
import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaDoble.ListaDobleEnc;
import ayed2obligatorio2016.ListaDoble.NodoLista;
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;

import clases.Servicio;
import clases.Cliente;
import clases.Servicio;
import clases.Viaje;

import java.time.LocalDateTime;

/**
 *
 * @author Daniel
 */
public class Sistema implements IMetro {
    
    private static ListaSimpleGeneric<Viaje> ListaViaje;
    private static ListaDobleEnc<Cliente> ListaCliente;
    private static ArbolBinario<Arista> ListaAristaOrdenadasNombre;
    private static Grafo Metro;

    // <editor-fold defaultstate="collapsed" desc=" GetSet ">
    public static Grafo getMetro() {
        return Metro;
    }

    public static void setMetro(Grafo aMetro) {
        Metro = aMetro;
    }

    /**
     * @return the ListaArista
     */
    public static ArbolBinario<Arista> getListaAristaOrdenadasNombre() {
        return ListaAristaOrdenadasNombre;
    }

    /**
     * @param aListaArista the ListaArista to set
     */
    public static void setListaAristaOrdenadasNombre(ArbolBinario<Arista> aListaArista) {
        ListaAristaOrdenadasNombre = aListaArista;
    }

    public ListaSimpleGeneric<Viaje> getListaViaje() {
        return ListaViaje;
    }

    public void setListaViaje(ListaSimpleGeneric<Viaje> aListaViaje) {
        ListaViaje = aListaViaje;
    }

    public ListaDobleEnc<Cliente> getListaCliente() {
        return ListaCliente;
    }
    
    public void setListaCliente(ListaDobleEnc<Cliente> aListaCliente) {
        ListaCliente = aListaCliente;
    }
     // </editor-fold>

    public enum TipoRet {
        OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, NO_IMPLEMENTADA
    };


    public TipoRet listarClientes() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet listarServiciosEstacion(String estacion) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet listarLineas() {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet caminoMasCorto(String origen, String destino) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet precioBoleto(String origen, String destino) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    // <editor-fold defaultstate="collapsed" desc=" Prontas ">
    public TipoRet altaTramo(char linea, String origen, String destino, float distancia, float tarifa) {
        Viaje v = new Viaje();
        Arista a = new Arista();
        
        CHash ha = Metro.getTablaEstaciones();
        NodoGrafo dest = ha.BuscarHash(destino);
        NodoGrafo orig = ha.BuscarHash(origen);
        // <editor-fold defaultstate="collapsed" desc=" Agregar Estaciones">
         if(orig==null)
         {
             orig = new NodoGrafo();
             orig.setNombre(origen);
             ha.insertarEstacion(orig);
         }
         if(dest==null)
         {
            dest = new NodoGrafo();
            dest.setNombre(destino);
            ha.insertarEstacion(dest);
         }
         // </editor-fold>

         if(distancia >0)
         {
             if(tarifa >0)
             {
                 dest.setNombre(destino);
                 orig.setNombre(origen);
                 a.setDestino(dest);
                 a.setOrigen(orig);
                    if(!Metro.BuscarAristaOrigenDestino(a))
                    {
                        a.setDestino(dest);
                        a.setOrigen(orig);
                        a.setDistancia(distancia);
                        a.setNombre(linea);
                        a.setTarifa(tarifa);
                        
                        dest.getAristas().insertarInicio(a);
                        orig.getAristas().insertarInicio(a);
                        Metro.getListaLineas().insertarInicio(a);
                        ListaAristaOrdenadasNombre.insertar(a);
                        return TipoRet.OK;
                    }
                    else
                    {
                        return TipoRet.ERROR_1;
                    }
             }
             else
             {
                 return TipoRet.ERROR_3;
             }
         }
         else
         {
             return TipoRet.ERROR_2;
         }
    }
    
    public TipoRet altaCliente(int cedula, String nombre) {
          
       Cliente unCliente = new Cliente();
       unCliente.setCedula(cedula);
       unCliente.setNombre(nombre);
              
       if(!unCliente.CorrobarCanDigitos(cedula))
       {
           return TipoRet.ERROR_2;
       }
       else
       {
           if(unCliente.BuscarCliente(cedula) == null)
           {
               ListaCliente.insertarInicio(unCliente);
               return TipoRet.OK;
           }
           
           else
           {
               return TipoRet.ERROR_1;
           }
       }
    }

    public TipoRet bajaCliente(int cedula) {
                
        Cliente unCliente = new Cliente();
        unCliente.setCedula(cedula);
        ListaDobleEnc LD = new ListaDobleEnc();
        
        if(unCliente.CorrobarCanDigitos(cedula))
        {
            if(unCliente.BuscarCliente(cedula) != null)
            {
                LD.RemoveNodo(unCliente);
                return TipoRet.OK;
            }
            else
            {
                return TipoRet.ERROR_1;
            }
        }
        else
        {
            return TipoRet.ERROR_2;
        }
    }
    
    public TipoRet agregarServicio(String estacion, String servicio) {
            
        NodoGrafo Es = new NodoGrafo();
        Es = Metro.getTablaEstaciones().BuscarHash(estacion);
        
        if(Es == null)
        {
            return TipoRet.ERROR_1;
        }
        else
        {
            Servicio Ser = new Servicio();
            Ser.setNombre(servicio);
        
            Es.getServicios().insertar((Comparable) Ser);
            return TipoRet.OK;
        }  
    }
    
    public TipoRet listarViajesCliente(int ciCliente) {
        Cliente Cli = new Cliente();
        if(Cli.CorrobarCanDigitos(ciCliente))
        {
            if(Cli.BuscarCliente(ciCliente)!= null)
            {
                Viaje V = new Viaje();
                V.ImprimirViajes(ciCliente);
                return TipoRet.OK;
            }
            else
            {
                return TipoRet.ERROR_1;
            }
        }
        else
        {
            return TipoRet.ERROR_2;
        }
    }
    
    public TipoRet crearMetro() {
        ListaViaje = new ListaSimpleGeneric<Viaje>();
        ListaCliente = new ListaDobleEnc<Cliente>();
        ListaAristaOrdenadasNombre = new ArbolBinario();
        Metro = new Grafo();
        return TipoRet.OK;
    }

    public TipoRet destruirMetro() {
        Metro = new Grafo();
        ListaViaje = new ListaSimpleGeneric<Viaje>();
        ListaCliente = new ListaDobleEnc<Cliente>();
        ListaAristaOrdenadasNombre = new ArbolBinario();
        return TipoRet.OK;
    }
    
    public TipoRet agregarViaje(String origen, String destino, int ciCliente, LocalDateTime fechaHora) {
       Viaje v = new Viaje();
       Cliente c = new Cliente();
       
       if(c.CorrobarCanDigitos(ciCliente)){
       c = c.BuscarCliente(ciCliente);
           if(c!=null)
           {
                Arista a = new Arista();
                CHash ch = new CHash();
                
                NodoGrafo ng = ch.BuscarHash(origen);
                a.setOrigen(ng);
                ng = ch.BuscarHash(destino);
                a.setDestino(ng);
                if(Metro.BuscarAristaOrigenDestino(a))
                {
                    v.setCiCliente(ciCliente);
                    v.setDestino(destino);
                    v.setOrigen(origen);
                    v.setFecha(fechaHora);
                    this.getListaViaje().insertarInicio(v);
                    c.getViajes().push(v);
                    return TipoRet.OK;
                }
                return TipoRet.ERROR_1;
           }
           else
           {
               return TipoRet.ERROR_2;
           }
       }
       else
       {
           return TipoRet.ERROR_3;
       }
    }
    // </editor-fold >
    
}
