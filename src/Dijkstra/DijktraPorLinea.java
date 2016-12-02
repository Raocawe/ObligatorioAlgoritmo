/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import ayed2obligatorio2016.Grafo.Arista;
import ayed2obligatorio2016.Grafo.CHash;
import ayed2obligatorio2016.Grafo.NodoGrafo;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;

/**
 *
 * @author cristian castro
 */
public class DijktraPorLinea {
    
    private NodoGrafo[] Nodos;
    private NodoTablaCaminoCorto[] Tabla;
    private CHash ch;
    
    public DijktraPorLinea(){
    ch = new CHash();
    }
    
    public void DijktraPorLineas(NodoGrafo[] pN)
    {
        Nodos = pN;
        Tabla = new NodoTablaCaminoCorto[pN.length];
        CargarTabla(pN[0]);
        ImplementandoDijktra(getTabla());
    }
    
    private  void CargarTabla(NodoGrafo pN)
    {
        AgregarNodoInicio(pN);
        for(int i=1; i<getTabla().length ;i++)
        {
            Agregar(Nodos[i],i);
        }
    }
    
    private int ObtenerIndice(String pN)
    {
        for(int i = 0; i< Tabla.length ;i++)
        {
            if(Tabla[i].getEstacion().equals(pN)){
                return i;
            }
        }
        return 0;
    }
    
    private void ImplementandoDijktra(NodoTablaCaminoCorto[] r)
    {
        int IndiceActual;
        NodoGrafo v, w;
        for (NodoTablaCaminoCorto Nodo : getTabla()) {
            if(Nodo!=null)
                {
                    v = NodoTablaConDistanciaMasCortaDesconocido();
                    if(v!=null){
                    IndiceActual = ObtenerIndice(v.getNombre());
                    Nodo.setConocido(true);

                    NodoListaSimple nls = v.getAristas().getInicio();//Capturamos La Primera Arista
                    Arista a = (Arista)nls.getDato();
                    NodoGrafo aux = a.getDestino();//siquiente Estacion

                    while(aux!=null){
                        int indi = ObtenerIndice(aux.getNombre());
                        if(!Tabla[indi].getConocido()&&((getTabla()[IndiceActual].getDistancia()+a.getDistancia())<getTabla()[indi].getDistancia()))
                        {
                            float floataux = getTabla()[IndiceActual].getDistancia()+a.getDistancia();
                            getTabla()[indi].setDistancia(floataux);
                            getTabla()[indi].setEstacionA(v);
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
        
        for (NodoTablaCaminoCorto Tabla1 : getTabla()) {
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
    
    public void AgregarNodoInicio(NodoGrafo pN)
    {
        NodoTablaCaminoCorto a = new NodoTablaCaminoCorto();
        a.setConocido(false);
        a.setDistancia(0);
        a.setEstacion(pN.getNombre());
        a.setEstacionA(null);
        Tabla[0]=a;
    }
        
    public void Agregar(NodoGrafo pN,int pIndice)
    {
        NodoTablaCaminoCorto a = new NodoTablaCaminoCorto();
        a.setConocido(false);
        a.setDistancia(Integer.MAX_VALUE);
        a.setEstacion(pN.getNombre());
        a.setEstacionA(null);
        Tabla[pIndice]=a;
    }

    public NodoTablaCaminoCorto[] getTabla() {
        return Tabla;
    }
    
    public void imprimir_Camino()
    {
        NodoGrafo i = ch.BuscarHash(Tabla[0].getEstacion());
        System.out.println(i.getNombre());
        System.out.println("");
        imprimir_Camino(i,0);
    }
    
    private void imprimir_Camino(NodoGrafo pNinicio,int indice)
    {
        if(Tabla[indice].getEstacionA()==null)
        {
        }
        else{
            if(Tabla[indice].getEstacionA()!=null)
            {
                imprimir_Camino(Tabla[indice].getEstacionA(),indice++);
                System.out.print(pNinicio.getNombre());
            }
        }
    }
}
