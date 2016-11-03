/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author Kingdel
 */
public class NodoGrafo {
    
    private NodoGrafo siguiente;
    private int dato;
    private int peso;

    /**
     * @return the siguiente
     */
    public NodoGrafo getSiguiente() {
        return siguiente;
    }
    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoGrafo siguiente) {
        this.siguiente = siguiente;
    }
    /**
     * @return the dato
     */
    public int getDato() {
        return dato;
    }
    /**
     * @param dato the dato to set
     */
    public void setDato(int dato) {
        this.dato = dato;
    }
    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }
    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public NodoGrafo()
    {siguiente = new NodoGrafo();}
    
    
}
