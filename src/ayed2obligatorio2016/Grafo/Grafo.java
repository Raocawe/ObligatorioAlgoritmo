package ayed2obligatorio2016.Grafo;

import ayed2obligatorio2016.ListaDoble.ListaDobleEnc;
import ayed2obligatorio2016.ListaDoble.NodoLista;
import ayed2obligatorio2016.Sistema;


public class Grafo {
    
    private ListaDobleEnc<Arista> ListaLineas = new ListaDobleEnc<Arista>();
    private CHash TablaEstaciones = new CHash(); 

    public ListaDobleEnc<Arista> getListaLineas() {
        return ListaLineas;
    }

    public void setListaLineas(ListaDobleEnc<Arista> ListaLineas) {
        this.ListaLineas = ListaLineas;
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
    
    }
