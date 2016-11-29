package ayed2obligatorio2016.Grafo;

import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import ayed2obligatorio2016.ListaSimple.NodoListaSimple;
import ayed2obligatorio2016.Sistema;


public class Grafo {
    
    private ListaSimpleGeneric<Arista> ListaAristas;
    private ListaSimpleGeneric<NodoGrafo> ListaEstaciones;
    private CHash TablaEstaciones; 

    
    public Grafo()
    {
    TablaEstaciones = new CHash(); 
    ListaAristas = new ListaSimpleGeneric<Arista>();
    ListaEstaciones = new ListaSimpleGeneric<NodoGrafo>();
    }
        
    
    public ListaSimpleGeneric<Arista> getListaAristas() {
        return ListaAristas;
    }

    public void setListaAristas(ListaSimpleGeneric<Arista> ListaAristas) {
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
    
     public boolean BuscarAristaOrigenDestino(Arista pArista) {
       
        NodoListaSimple nl = ListaAristas.getInicio();
        if(nl!=null){
        Arista a = (Arista)nl.getDato();
        if(a.getOrigen().equals(pArista.getOrigen())&&a.getDestino().equals(pArista.getDestino()))
        {
            return true;
        }
        else
        {
            if(a.getOrigen().equals(pArista.getDestino())&&a.getDestino().equals(pArista.getOrigen()))
            {
            return true;      
            }
        }
        
        while(nl.getSiguiente()!=null)
        {
            a = (Arista)nl.getSiguiente().getDato();
                    if(a.getOrigen().equals(pArista.getOrigen())&&a.getDestino().equals(pArista.getDestino()))
                    {
                        return true;
                    }
                    else
                    {
                        if(a.getOrigen().equals(pArista.getDestino())&&a.getDestino().equals(pArista.getOrigen()))
                        {
                        return true;      
                        }
                    }
            nl = nl.getSiguiente();
        }
        return false;
     }
     else
        {     
            return false;
        }
    }

    /**
     * @return the ListaEstaciones
     */
    public ListaSimpleGeneric<NodoGrafo> getListaEstaciones() {
        return ListaEstaciones;
    }
        
    }
