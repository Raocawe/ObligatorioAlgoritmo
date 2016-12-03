/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016.Grafo;

import ayed2obligatorio2016.ArbolBinario.ArbolBinario;
import ayed2obligatorio2016.ArbolBinario.NodoBinario;
import ayed2obligatorio2016.ListaDoble.ListaDobleEnc;
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed2obligatorio2016.Sistema;
import static ayed2obligatorio2016.Sistema.getListaClienteOrdenadosNombre;
import clases.Cliente;
import clases.Servicio;

/**
 *
 * @author cristian castro
 */
public class NodoGrafo <E extends Comparable<E>>{

    private ArbolBinario<Servicio> Servicios;
    private String nombre;
    private ListaDobleEnc<Arista> Aristas;
    private Enumerado estado;
    

    public NodoGrafo()
    {
        Servicios = new ArbolBinario<Servicio>();
        nombre = "";
        Aristas = new ListaDobleEnc<Arista>();
        estado = Enumerado.V;
    }
    /**
     * @return the Servicios
     */
    public ArbolBinario<Servicio> getServicios() {
        return Servicios;
    }

    /**
     * @param Servicios the Servicios to set
     */
    public void setServicios(ArbolBinario<Servicio> Servicios) {
        this.Servicios = Servicios;
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

    /**
     * @return the Aristas
     */
    public ListaDobleEnc<Arista> getAristas() {
        return Aristas;
    }

    /**
     * @param Aristas the Aristas to set
     */
    public void setAristas(ListaDobleEnc<Arista> Aristas) {
        this.Aristas = Aristas;
    }

    /**
     * @return the estado
     */
    public Enumerado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Enumerado estado) {
        this.estado = estado;
    }

    private void Recorrido_En_Orden(NodoBinario raiz)
    {
        if(raiz != null)
        {
            Servicio c = (Servicio)raiz.getElemento();
            
            Recorrido_En_Orden(raiz.getHijoIzquierdo());
            System.out.println(c.getNombre());
            Recorrido_En_Orden(raiz.getHijoDerecho());
            
        }
    }
    
       public void ListadoServicioDeEstacion(NodoGrafo ng)
    {
        System.out.println("");
        ArbolBinario<Servicio> s = ng.getServicios();
        NodoBinario s1 = (NodoBinario)s.getRaiz();
        System.out.println("Estacion: "+ng.getNombre());
        
        if(s1==null)
        {
            System.out.println("Sin Servicios Registrados");
            return;
        }
        Recorrido_En_Orden(s1);
        System.out.println("");
    }   
    }
    