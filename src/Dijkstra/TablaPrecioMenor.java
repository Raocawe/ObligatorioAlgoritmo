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
        Tabla[i]=a;
    }
    
    private NodoTablaPrecioMenor AgregarInicio(String pN)
    {
        a = new NodoTablaPrecioMenor();
        a.setConocido(false);
        a.setPrecio(0);
        a.setEstacion(pN);
        a.setEstacionA(null);
        return a;
    }
    
    public void Agregar(NodoGrafo pN,int pIndice)
    {
        a = new NodoTablaPrecioMenor();
        a.setConocido(false);
        a.setPrecio(Integer.MAX_VALUE);
        a.setEstacion(pN.getNombre());
        a.setEstacionA(null);
        Tabla[pIndice]=a;
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
        for (int i = 0;i<Tabla.length;i++) {
            if(Tabla[i]!=null)
                {
                    v = NodoTablaConMenorPrecioDesconocido();
                    if(v!=null){
                    IndiceActual = ch.ObtenerIndice(v.getNombre());
                    Tabla[IndiceActual].setConocido(true);

                    NodoLista nls = v.getAristas().getInicio();//Capturamos La Primera Arista
                    Arista a = (Arista)nls.getDato();//Arista                    
                    NodoGrafo aux = a.getDestino();//siquiente Estacion
                    if(aux.getNombre().equals(v.getNombre()))//Aux Siguiente estacion
                    {
                        aux = a.getOrigen();
                    }
                    
                   
                    while(aux!=null){
                        int indi = ch.ObtenerIndice(aux.getNombre());
                        if(!Tabla[indi].isConocido()&&((Tabla[IndiceActual].getPrecio()+a.getTarifa())<Tabla[indi].getPrecio()))
                        {
                            float floataux = Tabla[IndiceActual].getPrecio()+a.getTarifa();
                            Tabla[indi].setPrecio(floataux);
                            Tabla[indi].setEstacionA(v);
                        }
                        if(Tabla[indi].isConocido())
                        {
                            break;
                        }
                        nls = aux.getAristas().getInicio();
                        if(nls!=null)
                        {
                            Arista au = (Arista)nls.getDato();

                            while(au==a){
                                
                                nls = nls.getSiguiente();
                                if(nls==null){
                                aux = null;
                                break;}
                                else
                                    au = (Arista)nls.getDato();
                            }
                            if(aux !=null){
                                a = au;
                                v = aux;
                                    if(aux.getNombre().equals(a.getDestino().getNombre()))
                                        aux = a.getOrigen();
                                    else{
                                        aux = a.getDestino();}
                            } 
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
    
    private NodoGrafo NodoTablaConMenorPrecioDesconocido()
    {
        float MenorPrecio = Integer.MAX_VALUE;
        NodoTablaPrecioMenor aux = null;
        
        for (NodoTablaPrecioMenor Tabla1 : Tabla) {
            if (Tabla1 != null) {
                if(!Tabla1.isConocido()&&Tabla1.getPrecio()<MenorPrecio)
                {
                    MenorPrecio = Tabla1.getPrecio();
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
    
    public void imprimir_Precio_Menor(NodoGrafo pNinicio, NodoGrafo pNfin)
    {
        float PrecioTotal = 0;
        // <editor-fold desc=" CapturarDistancia ">
        int indice = ch.ObtenerIndice(pNinicio.getNombre());
        
        while(!Tabla[indice].equals(pNfin))
        {
            PrecioTotal += Tabla[indice].getPrecio();
            if(Tabla[indice].getEstacionA()!=null){
            indice = ch.ObtenerIndice(Tabla[indice].getEstacionA().getNombre());}
            else break;
        }
        
        // </editor-fold>
        System.out.println("Precio del boleto de "+ pNfin.getNombre() + " y "+ pNinicio.getNombre() + " : $ "+ PrecioTotal);
    }
    
    

    public NodoTablaPrecioMenor[] getTabla() {
        return Tabla;
    }

    public void setTabla(NodoTablaPrecioMenor[] Tabla) {
        this.Tabla = Tabla;
    }

    public NodoTablaPrecioMenor getA() {
        return a;
    }

    public void setA(NodoTablaPrecioMenor a) {
        this.a = a;
    }

    public Hash getCh() {
        return ch;
    }

    public void setCh(CHash ch) {
        this.ch = ch;
    }

    public Grafo getM() {
        return m;
    }

    public void setM(Grafo m) {
        this.m = m;
    }
}
