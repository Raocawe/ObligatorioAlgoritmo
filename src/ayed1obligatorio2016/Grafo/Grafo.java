package ayed1obligatorio2016.Grafo;

import ayed1obligatorio2016.ListaDoble.ListaDobleEnc;
import ayed1obligatorio2016.ListaDoble.NodoLista;
import ayed2obligatorio2016.Sistema;


public class Grafo {
    
    private ListaDobleEnc<NodoGrafo> ListaEstaciones;
    private ListaDobleEnc<Arista> ListaLineas;

    
    public ListaDobleEnc<NodoGrafo> getListaEstaciones() {
        return ListaEstaciones;
    }

    public void setListaEstaciones(ListaDobleEnc<NodoGrafo> ListaEstaciones) {
        this.ListaEstaciones = ListaEstaciones;
    }

    public ListaDobleEnc<Arista> getListaLineas() {
        return ListaLineas;
    }

    public void setListaLineas(ListaDobleEnc<Arista> ListaLineas) {
        this.ListaLineas = ListaLineas;
    }
    
    public boolean esVacio(){
        return ListaEstaciones.esVacia();
    }
    
    public NodoGrafo Buscar(NodoGrafo pNodo){
        if(esVacio())
        {
            return null;
        }
        else
        {
            NodoLista Nl = this.ListaEstaciones.getInicio();
            while(Nl != null)
            {
                NodoGrafo Ng = new NodoGrafo();
                Ng = (NodoGrafo) Nl.getDato();

            if(Ng.getNombre()== pNodo.getNombre())
                {
                    return Ng;
                }
            else
                {
                    Nl = Nl.getSiguiente();
                }
            }
            return null;
        }
}}
