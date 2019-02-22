import java.util.ArrayList;

public class Conjunto {

    private ArrayList<String> elementos;
    private final String nombre;

    public Conjunto(String nombre) {
        elementos = new ArrayList<String>();
        this.nombre = nombre;
    }

    public void agregarElemto(String elemento) {
        elementos.add(elemento);
    }

    public void sustituirElemento(int index, String elemento) {
        elementos.set(index, elemento);
    }

    public void eliminarElemento(int index) {
        elementos.remove(index);
    }

    public String getElemento(int index) {
        return elementos.get(index);
    }

    public boolean existeElemento(String elemento) {
        /*for (String e : elementos) {
            if (e.equals(elemento)) {
                return true;
            }
        }*/
        return elementos.lastIndexOf(elemento) != -1;       
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getElementos() {
        return elementos;
    }
    
    

    @Override
    public String toString() {
        String cadena = nombre + ": {}";
        if (!elementos.isEmpty()) {
            cadena = nombre + ":{ ";
            for (String e : elementos) {
                cadena += e + ",";
            }
            cadena += "}";
        }
        return cadena;
    }
}
