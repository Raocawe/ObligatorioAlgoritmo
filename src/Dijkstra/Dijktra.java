/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import ayed2obligatorio2016.Grafo.Grafo;
import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import static ayed2obligatorio2016.Sistema.getMetro;

/**
 *
 * @author cristian castro
 */
public class Dijktra {
    
    public static Grafo m = getMetro();
    
    public static String Dijktra(NodoGrafo pN)
    {
        CargarTabla(pN);
        
    }
    
    private static TablaCaminoCorto CargarTabla(NodoGrafo pN)
    {
        TablaCaminoCorto t = new TablaCaminoCorto();
        t.AgregarNodoInicio(pN.getNombre());
        NodoListaSimple i = m.getListaEstaciones().getInicio();
        while(i != null)
        {
            NodoGrafo g = (NodoGrafo)i.getDato();
            t.Agregar(g);
            i = i.getSiguiente();
        }
        return t;
    }
}
