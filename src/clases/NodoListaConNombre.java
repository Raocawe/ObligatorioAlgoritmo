/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import ayed2obligatorio2016.ArbolBinario.ArbolBinario;
import ayed2obligatorio2016.ArbolBinario.NodoBinario;
import ayed2obligatorio2016.Grafo.Arista;
import ayed2obligatorio2016.Grafo.CHash;
import ayed2obligatorio2016.ListaSimple.ListaSimpleGeneric;
import static ayed2obligatorio2016.Sistema.getListaAristaOrdenadasNombre;

/**
 *
 * @author cristian castro
 */
public class NodoListaConNombre implements Comparable<NodoListaConNombre>{
    
    private char nombre;
    private CHashSolucionNodo HashEstacionLinea;
    private int CantidadEnLista;

    public NodoListaConNombre()
    {   
        HashEstacionLinea = new CHashSolucionNodo();
        CantidadEnLista = 0;
    }
    
    public int compareTo(NodoListaConNombre o) {
        
        int a = CharAint(this.getNombre());
        int b = CharAint(o.getNombre());
        
        if(a>b)
            return 1;
        else if(a < b)
            return -1;
        else
            return 0;
        
    }
    
    public int CharAint(char pC)
    {
        return (int)pC;
    }
    
    public char getNombre() {
        return nombre;
    }
    public void setNombre(char nombre) {
        this.nombre = nombre;
    }
    public CHashSolucionNodo getHashEstacionLinea() {
        return HashEstacionLinea;
    }
    public void setHashEstacionLinea(CHashSolucionNodo HashEstacionLinea) {
        this.HashEstacionLinea = HashEstacionLinea;
    }
    public int getCantidadEnLista() {
        return CantidadEnLista;
    }
    public void setCantidadEnLista(int CantidadEnLista) {
        this.CantidadEnLista = CantidadEnLista;
    }
    
}
