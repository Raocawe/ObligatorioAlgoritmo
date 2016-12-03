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
import ayed2obligatorio2016.ListaDoble.NodoLista;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import static ayed2obligatorio2016.Sistema.getMetro;
import clases.Hash;

/**
 *
 * @author Kingdel
 */
public class TablaPrecioMenor {
        
    private NodoTablaPrecioMenor[] Tabla;
    private NodoTablaPrecioMenor a;
    private Hash ch;
    private Grafo m = getMetro();
    
    public TablaPrecioMenor()
    {
        Tabla = new NodoTablaPrecioMenor[100];
        ch = getMetro().getTablaEstaciones();
        a = new NodoTablaPrecioMenor();
    }
    
    public void AgregarNodoInicio(NodoGrafo pN)
    {
        int i = getCh().ObtenerIndice(pN.getNombre());
        setA(AgregarInicio(pN.getNombre()));
        Tabla[i]=getA();
    }
    
    private NodoTablaPrecioMenor AgregarInicio(String pN)
    {
        setA(new NodoTablaPrecioMenor());
        getA().setConocido(false);
        getA().setPrecio(0);
        getA().setEstacion(pN);
        getA().setEstacionA(null);
        return getA();
    }
    
    public void Agregar(NodoGrafo pN,int pIndice)
    {
        getA().setConocido(false);
        getA().setPrecio(Integer.MAX_VALUE);
        getA().setEstacion(pN.getNombre());
        getA().setEstacionA(null);
        getTabla()[pIndice]=getA();
    }
    
    public void Dijktra(NodoGrafo pN)
    {
        CargarTabla(pN);
        ImplementandoDijktra(Tabla);
    }

    private void ImplementandoDijktra(NodoTablaPrecioMenor[] r)
    {
        int IndiceActual;
        NodoGrafo v, w;
        for (NodoTablaPrecioMenor Nodo : getTabla()) {
            if(Nodo!=null)
                {
                    v = NodoTablaConDistanciaMasCortaDesconocido();
                    if(v!=null){
                    IndiceActual = getCh().ObtenerIndice(v.getNombre());
                    Nodo.setConocido(true);

                    NodoLista nls = v.getAristas().getInicio();//Capturamos La Primera Arista
                    Arista a = (Arista)nls.getDato();
                    NodoGrafo aux = a.getDestino();//siquiente Estacion

                    while(aux!=null){
                        int indi = getCh().ObtenerIndice(aux.getNombre());
                        if(!Tabla[indi].isConocido()&&((getTabla()[IndiceActual].getPrecio()+a.getDistancia())<getTabla()[indi].getPrecio()))
                        {
                            float floataux = getTabla()[IndiceActual].getPrecio()+a.getDistancia();
                            Tabla[indi].setPrecio(floataux);
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
        NodoTablaPrecioMenor aux = null;
        
        for (NodoTablaPrecioMenor Tabla1 : getTabla()) {
            if (Tabla1 != null) {
                if(!Tabla1.isConocido()&&Tabla1.getPrecio()<MenorDistancia)
                {
                    MenorDistancia = Tabla1.getPrecio();
                    aux = Tabla1;
                }
            }       
        }
        if(aux!=null)
        {
            return getCh().BuscarHash(aux.getEstacion());
        }
        return null;
    }
    
    private  void CargarTabla(NodoGrafo pN)
    {
        NodoGrafo[] nga = getCh().getArray();
        for(int i=0; i<getTabla().length ;i++)
        {
            if(nga[i]!=null)
            {
                Agregar(nga[i],i);
            }
            else
            {
                getTabla()[i]=null;
            }
        }
        this.AgregarNodoInicio(pN);
    }
    
    public void imprimir_Camino(NodoGrafo pNinicio,NodoGrafo pNfin)
    {
        int indice = getCh().ObtenerIndice(pNinicio.getNombre());
        if(Tabla[indice].getEstacionA()!=null&&Tabla[indice].getEstacionA().equals(pNfin))
        {
            return;
        }
        else{
            if(Tabla[indice].getEstacionA()!=null)
            {
                imprimir_Camino(Tabla[indice].getEstacionA(),pNfin);
                System.out.print(pNinicio.getNombre());
            }
        }
    }

    /**
     * @return the Tabla
     */
    public NodoTablaPrecioMenor[] getTabla() {
        return Tabla;
    }

    /**
     * @param Tabla the Tabla to set
     */
    public void setTabla(NodoTablaPrecioMenor[] Tabla) {
        this.Tabla = Tabla;
    }

    /**
     * @return the a
     */
    public NodoTablaPrecioMenor getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(NodoTablaPrecioMenor a) {
        this.a = a;
    }

    /**
     * @return the ch
     */
    public Hash getCh() {
        return ch;
    }

    /**
     * @param ch the ch to set
     */
    public void setCh(CHash ch) {
        this.ch = ch;
    }

    /**
     * @return the m
     */
    public Grafo getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(Grafo m) {
        this.m = m;
    }
}
