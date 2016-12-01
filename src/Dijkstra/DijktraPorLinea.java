/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import ayed2obligatorio2016.Grafo.Arista;
import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;

/**
 *
 * @author cristian castro
 */
public class DijktraPorLinea {
    
    private NodoGrafo[] Nodos;
    
    public DijktraPorLinea(){}
    
    public void DijktraPorLineas(NodoGrafo[] pN)
    {
        Nodos = pN;
        CargarTabla(pN);
        ImplementandoDijktra(Tabla);
        int i = 0;
    }
    
    private  void CargarTabla(NodoGrafo pN)
    {
        NodoGrafo[] nga = ch.getArray();
        for(int i=0; i<Tabla.length ;i++)
        {
            if(nga[i]!=null)
            {
                Agregar(nga[i],i);
            }
            else
            {
                Tabla[i]=null;
            }
        }
        this.AgregarNodoInicio(pN);
    }
    
    private void ImplementandoDijktra(NodoTablaCaminoCorto[] r)
    {
        int IndiceActual;
        NodoGrafo v, w;
        for (NodoTablaCaminoCorto Nodo : Tabla) {
            if(Nodo!=null)
                {
                    v = NodoTablaConDistanciaMasCortaDesconocido();
                    if(v!=null){
                    IndiceActual = ch.ObtenerIndice(v.getNombre());
                    Nodo.setConocido(true);

                    NodoListaSimple nls = v.getAristas().getInicio();//Capturamos La Primera Arista
                    Arista a = (Arista)nls.getDato();
                    NodoGrafo aux = a.getDestino();//siquiente Estacion

                    while(aux!=null){
                        int indi = ch.ObtenerIndice(aux.getNombre());
                        if(!Tabla[indi].getConocido()&&((Tabla[IndiceActual].getDistancia()+a.getDistancia())<Tabla[indi].getDistancia()))
                        {
                            float floataux = Tabla[IndiceActual].getDistancia()+a.getDistancia();
                            Tabla[indi].setDistancia(floataux);
                            Tabla[indi].setEstacionA(v);
                        }
                        nls = nls.getSiguiente();
                        if(nls!=null)
                        {
                            a = (Arista)nls.getDato();
                            aux = a.getDestino();
                        }
                        else
                        {
                            aux = null;
                        }
                    }
                }
            }
        }
    }
}
