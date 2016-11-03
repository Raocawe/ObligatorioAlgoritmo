/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;

/**
 *
 * @author Kingdel
 */
public class ClaseGrafo {
    
    private ArrayList<NodoGrafo> Vertices;
    private ArrayList<Arista> Aristas;

    /**
     * @return the Vertices
     */
    public ArrayList<NodoGrafo> getVertices() {
        return Vertices;
    }

    /**
     * @param Vertices the Vertices to set
     */
    public void setVertices(ArrayList<NodoGrafo> Vertices) {
        this.Vertices = Vertices;
    }

    /**
     * @return the Aristas
     */
    public ArrayList<Arista> getAristas() {
        return Aristas;
    }

    /**
     * @param Aristas the Aristas to set
     */
    public void setAristas(ArrayList<Arista> Aristas) {
        this.Aristas = Aristas;
    }
    
    public ClaseGrafo()
    {
        Vertices = new ArrayList<>();
        Aristas = new ArrayList<>();
    }
    
    public boolean isEmply()
    {
        return Vertices.size() == 0;
    }
    
    
}
