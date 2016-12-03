package ayed2obligatorio2016.Grafo;

import ayed2obligatorio2016.ListaDoble.ListaDobleEnc;
import ayed2obligatorio2016.ListaDoble.NodoLista;
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import ayed2obligatorio2016.Sistema;


public class Grafo {
    
    private ListaDobleEnc<Arista> ListaAristas;
    private ListaSimpleGeneric<NodoGrafo> ListaEstaciones;
    private CHash TablaEstaciones; 

    
    public Grafo()
    {
    TablaEstaciones = new CHash(); 
    ListaAristas = new ListaDobleEnc<Arista>();
    ListaEstaciones = new ListaSimpleGeneric<NodoGrafo>();
    }
        
    
    public ListaDobleEnc<Arista> getListaAristas() {
        return ListaAristas;
    }

    public void setListaAristas(ListaDobleEnc<Arista> ListaAristas) {
        this.ListaAristas = ListaAristas;
    }

    /**
     * @return the TablaEstaciones
     */
    public CHash getTablaEstaciones() {
        return TablaEstaciones;
    }

    /**
     * @param TablaEstaciones the TablaEstaciones to set
     */
    public void setTablaEstaciones(CHash TablaEstaciones) {
        this.TablaEstaciones = TablaEstaciones;
    }
    
     public Arista BuscarAristaOrigenDestino(Arista pArista) {
       
        NodoLista nl = ListaAristas.getInicio();
        if(nl!=null){
        Arista a = (Arista)nl.getDato();
        if(a.getOrigen().equals(pArista.getOrigen())&&a.getDestino().equals(pArista.getDestino()))
        {
            return a;
        }
        else
        {
            if(a.getOrigen().equals(pArista.getDestino())&&a.getDestino().equals(pArista.getOrigen()))
            {
            return a;      
            }
        }
        
        while(nl.getSiguiente()!=null)
        {
            a = (Arista)nl.getSiguiente().getDato();
                    if(a.getOrigen().equals(pArista.getOrigen())&&a.getDestino().equals(pArista.getDestino()))
                    {
                        return a;
                    }
                    else
                    {
                        if(a.getOrigen().equals(pArista.getDestino())&&a.getDestino().equals(pArista.getOrigen()))
                        {
                        return a;      
                        }
                    }
            nl = nl.getSiguiente();
        }
        return null;
     }
     else
        {     
            return null;
        }
    }

    /**
     * @return the ListaEstaciones
     */
    public ListaSimpleGeneric<NodoGrafo> getListaEstaciones() {
        return ListaEstaciones;
    }
        
    }
