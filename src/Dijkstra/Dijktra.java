/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import ayed2obligatorio2016.Grafo.CHash;
import ayed2obligatorio2016.Grafo.Grafo;
import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import static ayed2obligatorio2016.Sistema.getMetro;

/**
 *
 * @author cristian castro
 */
public class Dijktra {
    
    public static Grafo m = getMetro();
    private static int contador = 0;
    
    public static String Dijktra(NodoGrafo pN)
    {
        TablaCaminoCorto s = CargarTabla(pN);
        ListaSimpleGeneric r = s.getTabla();
        return ImplementandoDijktra(r);
    }

    private static String ImplementandoDijktra(ListaSimpleGeneric r)
    {
        NodoListaSimple v, w;
        for(int i=0; i<contador; i++)
        {
            v = NodoTablaConDistanciaMasCortaDesconocido(r);
            v = (NodoTablaCaminoCorto)r.buscar(v);
            v.setConocido((byte)1);
            
            for(w = v.getSiguiente(); w != null; w = w.getSiguiente()){
                
            }
            
        }
    }
    
    private static NodoTablaCaminoCorto NodoTablaConDistanciaMasCortaDesconocido(ListaSimpleGeneric pT)
    {
        NodoListaSimple Nls = pT.getInicio();
        float MenorDistancia = Integer.MAX_VALUE;
        NodoTablaCaminoCorto aux = null;
        
        if(Nls!=null)
        {
            while(Nls != null)
            {
                NodoTablaCaminoCorto Ntcc = (NodoTablaCaminoCorto)Nls.getDato();
                if(Ntcc.getConocido()==(byte)0)
                {
                   if(Ntcc.getDistancia()<MenorDistancia)
                   {
                       MenorDistancia = Ntcc.getDistancia();
                       aux = Ntcc;
                   }
                }
                Nls = Nls.getSiguiente();
            }
            return aux;
        }
        else
            return aux;
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
            contador++;
        }
        return t;
    }
}
