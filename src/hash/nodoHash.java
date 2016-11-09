/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author Ezequiel
 */
public class nodoHash {
    private int Valor ;
    private nodoHash nextNodo;
    private EstadoNodo estado;

    /**
     * @return the Valor
     */
    public int getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    /**
     * @return the nextNodo
     */
    public nodoHash getNextNodo() {
        return nextNodo;
    }

    /**
     * @param nextNodo the nextNodo to set
     */
    public void setNextNodo(nodoHash nextNodo) {
        this.nextNodo = nextNodo;
    }

    /**
     * @return the estado
     */
    public EstadoNodo getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoNodo estado) {
        this.estado = estado;
    }
    
    
}

 enum EstadoNodo{
    O,
    V,
    E,
}
