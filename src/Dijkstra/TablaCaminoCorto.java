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
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import static ayed2obligatorio2016.Sistema.getMetro;
import clases.CHashSolucionNodo;
import clases.Hash;

public class TablaCaminoCorto {
    
    private NodoTablaCaminoCorto[] Tabla;
    private Hash ch;
    public Grafo m = getMetro();

    private char linea;
    
    public TablaCaminoCorto()
    {
        Tabla = new NodoTablaCaminoCorto[100];
        ch = getMetro().getTablaEstaciones();
    }
    
    public TablaCaminoCorto(CHashSolucionNodo pch,char nombrelinea)
    {
        linea = nombrelinea;
        Tabla = new NodoTablaCaminoCorto[100];
        ch = pch;
    }
    
    public void AgregarNodoInicio(NodoGrafo pN)
    {
        int i = ch.ObtenerIndice(pN.getNombre());
        NodoTablaCaminoCorto a;
        a = new NodoTablaCaminoCorto();
        a.setConocido(false);
        a.setDistancia(0);
        a.setEstacion(pN.getNombre());
        a.setEstacionA(null);
     
        Tabla[i]=a;
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

    public void Dijktra(NodoGrafo pN)
    {
        CargarTabla(pN);
        ImplementandoDijktra();
    }
    
    public void DijktraLineas(NodoGrafo pN)
    {
        CargarTabla(pN);
        ImplementandoDijktraLineas();
    }
    
    private void ImplementandoDijktra()//A partir del incio toma los demas precios
    {
        int IndiceActual;
        NodoGrafo v, w;
        for(int i=0; i<Tabla.length;i++){
            
            if(Tabla[i]!=null){
            v = NodoTablaConDistanciaMasCortaDesconocido();//funcion clave
            IndiceActual = ch.ObtenerIndice(v.getNombre());
            Tabla[IndiceActual].setConocido(true);
            MarcarAdyacentes(Tabla[IndiceActual],IndiceActual);//funcion clave
            NodoLista nls = v.getAristas().getInicio();//Capturamos La Primera Arista
            // <editor-fold desc="Guardamos Todas Las Aristas Adyacentes al Nodo Inicio">
            
            NodoLista Lista = nls;
            
            // </editor-fold>
            while(nls!=null){   

                Arista a = (Arista)nls.getDato();//Arista  
                NodoGrafo aux = a.getDestino();//siquiente Estacion
                if(aux.getNombre().equals(v.getNombre()))//Aux Siguiente estacion
                {
                    aux = a.getOrigen();
                }
                
                while(aux!=null){
                    int indi = ch.ObtenerIndice(aux.getNombre());
                    if(!Tabla[indi].getConocido()&&((Tabla[IndiceActual].getDistancia()+a.getDistancia())<Tabla[indi].getDistancia()))
                    {
                        float floataux = Tabla[IndiceActual].getDistancia()+a.getDistancia();
                        Tabla[indi].setDistancia(floataux);
                        Tabla[indi].setEstacionA(v);
                    }
                    if(Tabla[indi].getConocido())
                    {
                        break;
                    }
                    nls = nls.getSiguiente();
                    if(nls!=null)
                    {
                        v = aux;
                        if(aux.getNombre().equals(a.getDestino().getNombre()))
                            aux = a.getOrigen();
                        else{
                            aux = a.getDestino();}
                    }
                    else
                    {
                        break;
                    }
                }
            Lista = Lista.getSiguiente();    
            nls = Lista;
            }
        
            }
        }
    }
    
    private void ImplementandoDijktraLineas()//A partir del incio toma los demas precios
    {
        int IndiceActual;
        NodoGrafo v, w;
        for(int i=0; i<Tabla.length;i++){
            
            if(Tabla[i]!=null){
            v = NodoTablaConDistanciaMasCortaDesconocido();//funcion clave
            IndiceActual = ch.ObtenerIndice(v.getNombre());
            Tabla[IndiceActual].setConocido(true);
            MarcarAdyacentes(Tabla[IndiceActual],IndiceActual);//funcion clave

            NodoLista nls = v.getAristas().getInicio();//Capturamos La Primera Arista
            
            // <editor-fold desc="Guardamos Todas Las Aristas Adyacentes al Nodo Inicio">
            NodoLista Lista = nls;            
            // </editor-fold>
            
            while(nls!=null){   

                Arista a = (Arista)nls.getDato();//Arista  
                
                while(a.getNombre()!=linea)// RRRRRRRRRRRRRREVISAR
                {nls = nls.getSiguiente();
                if(nls!=null){
                a = (Arista)nls.getDato();}
                else
                    break;}
                
                if(nls!=null){
                    NodoGrafo aux = a.getDestino();//siquiente Estacion
                    if(aux.getNombre().equals(v.getNombre()))//Aux Siguiente estacion
                    {
                        aux = a.getOrigen();
                    }
                
                    while(aux!=null){
                        int indi = ch.ObtenerIndice(aux.getNombre());
                        if(indi>0){
                        if(!Tabla[indi].getConocido()&&((Tabla[IndiceActual].getDistancia()+a.getDistancia())<Tabla[indi].getDistancia()))
                        {
                            float floataux = Tabla[IndiceActual].getDistancia()+a.getDistancia();
                            Tabla[indi].setDistancia(floataux);
                            Tabla[indi].setEstacionA(v);
                        }
                        if(Tabla[indi].getConocido())
                        {
                            break;
                        }
                        nls = nls.getSiguiente();
                        if(nls!=null)
                        {
                            while(a.getNombre()!=linea)
                            {
                                if(nls.getSiguiente()!=null){
                                    a = (Arista)nls.getSiguiente().getDato();
                                }
                                else
                                {
                                    aux = null;
                                    break;
                                }

                            }                        
                            v = aux;
                            if(aux.getNombre().equals(a.getDestino().getNombre()))
                                aux = a.getOrigen();
                            else{
                                aux = a.getDestino();}
                        }
                        else
                        {
                            break;
                        }
                            } 
                    }
                }
                Lista = Lista.getSiguiente();    
                nls = Lista;
                }
            }
        }
    }
    
    private void MarcarAdyacentes(NodoTablaCaminoCorto pNodo,int pIndice)
    {
        NodoGrafo f = ch.BuscarHash(pNodo.getEstacion());
        NodoLista nls = f.getAristas().getInicio();
        
        while(nls!=null){
            Arista a = (Arista)nls.getDato();//Arista  
            NodoGrafo aux = a.getDestino();//siquiente Estacion
            if(aux.getNombre().equals(f.getNombre()))//Aux Siguiente estacion
            {aux = a.getOrigen();}
            int IndiceAdy = ch.ObtenerIndice(aux.getNombre());
            if(IndiceAdy>0){
                if(!Tabla[IndiceAdy].getConocido()&&((Tabla[pIndice].getDistancia()+a.getDistancia())<Tabla[IndiceAdy].getDistancia()))
                {
                     Tabla[IndiceAdy].setDistancia(a.getDistancia());
                     Tabla[IndiceAdy].setEstacionA(f);
                }
            }
            nls = nls.getSiguiente();
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
    
    public void imprimir_Camino(NodoGrafo pNinicio, NodoGrafo pNfin)
    {
        float distanciaTotal = 0;
        // <editor-fold desc=" CapturarDistancia ">
        int indice = ch.ObtenerIndice(pNinicio.getNombre());
        
        while(!Tabla[indice].equals(pNfin))
        {
            distanciaTotal += Tabla[indice].getDistancia();
            if(Tabla[indice].getEstacionA()!=null){
            indice = ch.ObtenerIndice(Tabla[indice].getEstacionA().getNombre());}
            else break;
        }
        
        // </editor-fold>
        System.out.println("Viaje más corto entre "+ pNfin.getNombre() + " y "+ pNinicio.getNombre() + " : "+ distanciaTotal + " Km");
        imprimir_Caminos(pNinicio,pNfin);
    }
    
    private void imprimir_Caminos(NodoGrafo pNinicio, NodoGrafo pNfin)
    {
        int indice = ch.ObtenerIndice(pNinicio.getNombre());
        if(Tabla[indice].getEstacionA()!=null&&Tabla[indice].getEstacionA().equals(pNfin))
        { 
            System.out.print(Tabla[indice].getEstacionA().getNombre()+"\n");
            System.out.print(Tabla[indice].getEstacion()+"\n");
        }
        else{
            if(Tabla[indice].getEstacionA()!=null)
            {
                imprimir_Caminos(Tabla[indice].getEstacionA(),pNfin);
                System.out.print(pNinicio.getNombre()+"\n");
            }
        }
    }

    public void imprimir_Camino(NodoGrafo pNinicio)
    {
        int indice = ch.ObtenerIndice(pNinicio.getNombre());
        if(Tabla[indice].getEstacionA()!=null)
        {
            imprimir_Camino(Tabla[indice].getEstacionA());
            System.out.print(pNinicio.getNombre()+" - "+Tabla[indice].getDistancia()+" Km\n");
        }
    }
}
