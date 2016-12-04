/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016.ListaDoble;


/**
 *
 */
public class ListaDobleEnc <T> implements IListaDobleEnc <T> {
    private NodoLista<T> inicio;
    public int length;
    public NodoLista getInicio(){
        return this.inicio;
    }
    public ListaDobleEnc() {
        this.inicio = null;
    }

    @Override
    public void insertarInicio(T n) {
        NodoLista nuevo = new NodoLista(n);
        NodoLista aux = this.getInicio();
        nuevo.setSiguiente(inicio);
        this.inicio = nuevo;
        if(aux != null)
            aux.setAnterior(nuevo);
        nuevo.setAnterior(null);
    }
    @Override
    public void RemoveNodo(T n){
        NodoLista NodoBorrar = new NodoLista(n);
        NodoLista ElAnt = new NodoLista(NodoBorrar.getAnterior());
        NodoLista ElPost = new NodoLista(NodoBorrar.getSiguiente());
        if(ElAnt.getDato() == null && ElPost.getDato() == null)
        {
            this.inicio = null;
        }else{
            ElAnt.setSiguiente(ElPost);
            ElPost.setAnterior(ElAnt);
        }
        
    }
    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    @Override
    public void imprimir(T n) {
        int cont = 1;
        if(this.esVacia())
            System.out.println("LISTA VACIA");
        else{
            NodoLista aux = this.inicio;
            while(aux != null){
                System.out.println(cont + ". " + aux.getDato());
                cont++;
                aux = aux.getSiguiente();
            }
        }
    }
   /* @Override
    public void imprimirVuelos(T n) { // recibo un Nodo con un Vuelo
        ListaDobleEnc LosVuelos = (ListaDobleEnc)n;
        NodoLista Nodo = (NodoLista)(LosVuelos.getInicio());
        int cont = 1;
        
        while(Nodo != null){
            Vuelo unVuelo = null;
            unVuelo = (Vuelo)Nodo.getDato();
            Reservas lasReservas = new Reservas(); // instancio para poder acceder a la funcion de calcular ranking
            int Ranking = lasReservas.CalcRankPorVue(unVuelo.getComentarios());
            System.out.println(cont + ". N°" + unVuelo.getNumero() + ", Origen: " + unVuelo.getCiudadOrigen() + ", Destino: " + unVuelo.getCiudadDestino()+ ", Valoracion: " + unVuelo.getEstrellas()+ ", Ranking: " + Ranking );
            cont++;
            Nodo = Nodo.getSiguiente();
        }
    }*/

    @Override
    public void borrarInicio() {
        if(!this.esVacia())
            this.inicio = this.inicio.getSiguiente();
            
    }

    @Override
    public void vaciarLista() {
        while(this.inicio != null)
            this.borrarInicio();
    }
    
    
}
