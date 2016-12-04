package ayed2obligatorio2016.ArbolBinario;

import ayed2obligatorio2016.Grafo.Arista;
import clases.Cliente;

/**
 */
public class NodoBinario<E extends Comparable<E>> implements Elemento<E>
{
    E elemento;
    NodoBinario<E>padre;
    NodoBinario<E>hijoIzquierdo;
    NodoBinario<E>hijoDerecho;
    
    public NodoBinario(E elemento, NodoBinario<E> padre, NodoBinario<E> hijoIzquierdo, NodoBinario<E> hijoDerecho)
    {
        this.elemento = elemento;
        this.padre = padre;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }
    
    public NodoBinario(E pDato)
    {
       this.elemento = pDato;
       this.padre = null;
       this.hijoIzquierdo = null;
       this.hijoDerecho = null; 
    }
    
    public NodoBinario(){}

    public E getElemento()
    {
        return elemento;
    }

    public void setElemento(E elemento)
    {
        this.elemento = elemento;
    }

    public NodoBinario<E> getPadre()
    {
        return padre;
    }

    public void setPadre(NodoBinario<E> padre)
    {
        this.padre = padre;
    }

    public NodoBinario<E> getHijoIzquierdo()
    {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoBinario<E> hijoIzquierdo)
    {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoBinario<E> getHijoDerecho()
    {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoBinario<E> hijoDerecho)
    {
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public String toString()
    {
        return getElemento().toString();
    }

}
