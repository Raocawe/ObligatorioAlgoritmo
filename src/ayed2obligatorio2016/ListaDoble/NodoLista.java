/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016.ListaDoble;

/**
 *
 * @param <T>
 */
public class NodoLista <T> {
    private T dato;
    private NodoLista <T> siguiente;
    private NodoLista <T> anterior;
    
    public NodoLista(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }
    public NodoLista getAnterior() {
        return anterior;
    }

    public void setSiguiente(NodoLista <T> siguiente) {
        this.siguiente = siguiente;
    }
    public void setAnterior(NodoLista <T> anterior) {
        this.anterior = anterior;
    }
    
}
