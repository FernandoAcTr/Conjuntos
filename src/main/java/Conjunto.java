import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Clase que representa un conjunto
 * @param <T> Tipo de dato del cual seran los conjuntos
 */
public class Conjunto<T> {

    ArrayList<T> elements;

    public Conjunto(){
        elements = new ArrayList<T>();
    }

    /**
     * Regresa si existe o no el elemento como parametro
     * @param element El elemento a buscar
     * @return True si existe, False si no existe
     */
    public boolean existsElement(T element){
        for(T e : elements){
            if(e.equals(element))
                return true;
        }
        return false;
    }

    /**
     * Agrega un elemento en la ultima posicion del Conjunto
     * @param element El elemento que se desea agregar
     */
    public void addElement(T element){
       elements.add(element);
    }

    /**
     * Retorna el elemento del indice como parametro
     * @param index el indice del elemento que se requiere
     * @return Elemento que se encuentra en index
     */
    public T getElement(int index){
        return elements.get(index);
    }

    public int getSize(){
        return elements.size();
    }

    @Override
    public String toString() {
        String elmts = "{ ";
        for (int i = 0; i < elements.size(); i++) {
            elmts += elements.get(i) +" ";
        }
        elmts+= "}";

        return elmts;
    }
}
