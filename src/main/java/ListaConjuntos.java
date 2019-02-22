import java.util.ArrayList;

public class ListaConjuntos {
    private final ArrayList<Conjunto> conjuntos;
    private Conjunto conjuntoU;
    
    public ListaConjuntos(){
        conjuntos = new ArrayList();
    }
    
    public void agregarConjunto(Conjunto conjunto){
        conjuntos.add(conjunto);       
    }
    
    public void eliminarConjunto(int index){
        conjuntos.remove(index);
    }
    
    /**
     * Retorna si el elemento fue eliminado con exito. De no existir el conjunto se retorna un false
     * @param nombre : Nombre del conjunto a eliminar
     * @return true: El conjunto fue eliminado. false: el conjunto no existe
     */
    public boolean eliminarConjunto(String nombre){
        for(Conjunto c: conjuntos)
            if(c.getNombre().equals(nombre)){
                conjuntos.remove(c);
                return true;
            }        
        return false;
    }
    
    public boolean existeConjunto(String nombre){
        for(Conjunto c: conjuntos)
            if(c.getNombre().equals(nombre))
               return true;
                   
        return false;
    }
    
    public Conjunto getConjunto(int index){
        return conjuntos.get(index);
    }
    
    public Conjunto getConjunto(String nombre){       
        for(Conjunto c: conjuntos)
            if(c.getNombre().equals(nombre))
               return c;                   
        return null;
    }

    public Conjunto getConjuntoU() {
        return conjuntoU;
    }
    
    public boolean compararConUniverso(Conjunto conjunto){        
        for(String eleConjuto : conjunto.getElementos())
            if(!conjuntoU.existeElemento(eleConjuto))
                return false;               
        return true;
    }

    public void setConjuntoU(Conjunto conjuntoU) {
        this.conjuntoU = conjuntoU;
    }
    
    public ArrayList<String> getNombres(){
        ArrayList<String> nombres = new ArrayList();
        for(Conjunto c : conjuntos)          
           nombres.add(c.getNombre());
        return nombres;
    }
    
    // ------ metodos de operacion -----
    public Conjunto unionConjuntos(Conjunto c1, Conjunto c2){
        Conjunto nuevo = new Conjunto("U_"+c1.getNombre()+"_"+c2.getNombre());
        for(String ele : c1.getElementos()){
              if(!nuevo.existeElemento(ele))
                 nuevo.agregarElemto(ele);
        }
        for(String ele : c2.getElementos()){
              if(!nuevo.existeElemento(ele))
                 nuevo.agregarElemto(ele);
        }
        return nuevo;
    }
    
    public Conjunto interConjunto(Conjunto c1, Conjunto c2){
        Conjunto nuevo = new Conjunto("I_"+c1.getNombre()+"_"+c2.getNombre());
        for(String ele : c1.getElementos())
              if(c2.existeElemento(ele))
                  nuevo.agregarElemto(ele);
        return nuevo;
    }
    
    public Conjunto restaConjunto(Conjunto c1, Conjunto c2){
        Conjunto nuevo = new Conjunto("R_"+c1.getNombre()+"_"+c2.getNombre());
        for(String ele : c1.getElementos())
              if(!c2.existeElemento(ele))
                  nuevo.agregarElemto(ele);
        
        return nuevo;
    }
    
    public Conjunto compleConjunto(Conjunto c1){
        Conjunto nuevo = new Conjunto("C_"+c1.getNombre());
        for(String ele : conjuntoU.getElementos())
              if(!c1.existeElemento(ele))
                  nuevo.agregarElemto(ele);
        
        return nuevo;
    }
}
