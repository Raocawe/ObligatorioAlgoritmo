/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016.Pila;

/**
 *
 * @author Maxi
 */
public class Pila<T> implements IPila<T> {
    private NodoPila<T> top;
    
    public void push (T elem){ // ingresa un nuevo elemento
        NodoPila<T> nuevo = new NodoPila<T>(elem);
        if(getTop() == null){
            setTop(nuevo);
        }else{
            nuevo.setSiguiente(getTop());
            setTop(nuevo);
        }
        
    }
    @Override
    public boolean IsEmpty() { // retorna si esta vacia
        return this.getTop() == null;
    }
    @Override
    public T Pop(){ // Quita el elemento Superior
        NodoPila<T> aux = getTop();
        if(!IsEmpty()){
            setTop(getTop().siguiente);
            return aux.getElem();
        }else{
            System.out.println("La Lista ya esta Vacia");
            return null;
        }
        

    }
    @Override
    public T Top(){ // Retorna el elemento superior
        return getTop().getElem();
        
    }
    @Override // Vacia la lista
    public void Empty(){
        setTop(null);
        
    }

    public NodoPila<T> getTop() {
        return top;
    }

    public void setTop(NodoPila<T> top) {
        this.top = top;
    }
    
}
