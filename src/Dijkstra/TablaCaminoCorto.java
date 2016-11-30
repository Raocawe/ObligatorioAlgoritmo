/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import ayed2obligatorio2016.Grafo.Arista;
import ayed2obligatorio2016.Grafo.CHash;
import ayed2obligatorio2016.Grafo.Grafo;
import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import static ayed2obligatorio2016.Sistema.getMetro;

public class TablaCaminoCorto {
    
    private NodoTablaCaminoCorto[] Tabla;
    private NodoTablaCaminoCorto a;
    private CHash ch;
    
    public TablaCaminoCorto()
    {
        Tabla = new NodoTablaCaminoCorto[100];
        ch = getMetro().getTablaEstaciones();
        a = new NodoTablaCaminoCorto();
    }
    
    public void AgregarNodoInicio(NodoGrafo pN)
    {
        int i = ch.ObtenerIndice(pN.getNombre());
        a = AgregarInicio(pN.getNombre());
        getTabla()[i]=a;
    }
    
    private NodoTablaCaminoCorto AgregarInicio(String pN)
    {
        a = new NodoTablaCaminoCorto();
        a.setConocido(false);
        a.setDistancia(0);
        a.setEstacion(pN);
        a.setEstacionA(null);
        return a;
    }
    
    public void Agregar(NodoGrafo pN,int pIndice)
    {
        a.setConocido(false);
        a.setDistancia(Integer.MAX_VALUE);
        a.setEstacion(pN.getNombre());
        a.setEstacionA(null);
        Tabla[pIndice]=a;
    }

    public NodoTablaCaminoCorto[] getTabla() {
        return Tabla;
    }
    
    public Grafo m = getMetro();
    
    public void Dijktra(NodoGrafo pN)
    {
        CargarTabla(pN);
        ImplementandoDijktra(Tabla);
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
    
    private NodoGrafo NodoTablaConDistanciaMasCortaDesconocido()
    {
        float MenorDistancia = Integer.MAX_VALUE;
        NodoTablaCaminoCorto aux = null;
        
        for (NodoTablaCaminoCorto Tabla1 : Tabla) {
            if (Tabla1 != null) {
                if(!Tabla1.getConocido()&&Tabla1.getDistancia()<MenorDistancia)
                {
                    MenorDistancia = Tabla1.getDistancia();
                    aux = Tabla1;
                }
            }       
        }
        if(aux!=null)
        {
            return ch.BuscarHash(aux.getEstacion());
        }
        return null;
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
    
    public void imprimir_Camino(NodoGrafo pN)
    {
        int indice = ch.ObtenerIndice(pN.getNombre());
        if(Tabla[indice].getEstacionA()!=null)
        {
            imprimir_Camino(Tabla[indice].getEstacionA());
            System.out.print(pN.getNombre());
        }
    }
}
