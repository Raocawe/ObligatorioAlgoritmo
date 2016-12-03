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
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import static ayed2obligatorio2016.Sistema.getMetro;

/**
 *
 * @author cristian castro
 */
public class DijktraPorLinea {
    
    private NodoGrafo[] Nodos;
    private NodoTablaCaminoCorto[] Tabla;
    private CHash ch;
    private Grafo g;
    private String[] ver;
    private NodoGrafo inicio;
    
    public DijktraPorLinea(){
    ch = getMetro().getTablaEstaciones();
    g = getMetro();
    }
    
    public void DijktraPorLineas(NodoGrafo[] pN,NodoGrafo n)
    {
        inicio = n;
        Nodos = pN;
        Tabla = new NodoTablaCaminoCorto[pN.length];
        CargarTabla(n);
        ImplementandoDijktra(getTabla());
    }
    
    private  void CargarTabla(NodoGrafo pN)
    {
        AgregarNodoInicio(pN);
        for(int i=1; i<getTabla().length ;i++)
        {
            if(Nodos[i]!=null&&Nodos[i]!=pN)
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
        
    public void imprimir_Camino_PrimeraParte()
    {
        NodoTablaCaminoCorto n = Tabla[1];
        System.out.println(Tabla[0].getEstacion());
        System.out.println("");
        NodoGrafo i = ch.BuscarHash(n.getEstacion());
        imprimir_Camino(i,1);
    }
    
   /* private void imprimir_Camino(NodoGrafo pNinicio,int indice)
    {
        if(indice<Tabla.length){
            if(Tabla[indice].getEstacionA()!=null)
            {
                int mand = indice+1;
                imprimir_Camino(Tabla[indice].getEstacionA(),mand);
                Arista a = new Arista();
                a.setDestino(pNinicio);
                a.setOrigen(Tabla[indice].getEstacionA());
                a = g.BuscarAristaOrigenDestino(a);
                System.out.print(pNinicio.getNombre()+" - "+a.getDistancia()+"Km");
                System.out.println("");
                Nodos[indice]=null;
            }
        }
    }*/
    
    public void imprimir_Camino(NodoGrafo pNinicio,int indice)
    {
        if(indice<Tabla.length){
            if(Tabla[indice].getEstacionA()!=null)
            {
                imprimir_Camino(ch.BuscarHash(Tabla[indice].getEstacion()),indice+1);
                System.out.print(pNinicio.getNombre());
            }
        }
    }
    
    private NodoGrafo[] DescartarNull(NodoGrafo[] pNG)
    {
        int contErrores = 0;
        int length = pNG.length-1;
        for(int i=0;i<length;i++){
            if(pNG[i]== null)
            {
              NodoGrafo a = pNG[length-contErrores];
              pNG[length-contErrores] = null;
              pNG[i] = a;
              contErrores++;  
            }
        }      
        NodoGrafo[] r = new NodoGrafo[pNG.length-contErrores];
        
        for(int i=0;i<r.length;i++){
            r[i]=pNG[i];
        } 
 
        return r;
    }
    
    
 }

