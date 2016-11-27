/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;

public class TablaCaminoCorto {
    
    private ListaSimpleGeneric<NodoTablaCaminoCorto> Tabla;
    private NodoTablaCaminoCorto a;
    
    public TablaCaminoCorto()
    {
        Tabla = new ListaSimpleGeneric<NodoTablaCaminoCorto>();
    }
    
    public void AgregarNodoInicio(String pN)
    {
        a = AgregarInicio(pN);
        getTabla().insertarInicio(a);
    }
    
    private NodoTablaCaminoCorto AgregarInicio(String pN)
    {
        a = new NodoTablaCaminoCorto();
        a.setConocido((byte)0);
        a.setDistancia(0);
        a.setEstacion(pN);
        a.setEstacionA("0");
        return a;
    }
    
    public void Agregar(NodoGrafo pN)
    {
        a.setConocido((byte)0);
        a.setDistancia(0);
        a.setEstacion(pN.getNombre());
        a.setEstacionA("0");
        Tabla.insertarInicio(a);
    }

    public ListaSimpleGeneric<NodoTablaCaminoCorto> getTabla() {
        return Tabla;
    }
    
}
