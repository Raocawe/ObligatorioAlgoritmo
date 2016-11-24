package ayed2obligatorio2016.ArbolBinario;

/**
 * Creado por hadexexplade el 21/01/16.9:47
 */
public class NodoBinario<E> implements Elemento<E>
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
