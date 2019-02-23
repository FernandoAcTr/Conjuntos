/**
 * Esta clase implementa las operaciones disponibles para los conjuntos
 */
public class Operaciones {
    private Conjunto conjuntoA, conjuntoB;
    private Conjunto universe;

    public Operaciones(){
    }

    public void setConjuntoA(Conjunto conjuntoA) {
        this.conjuntoA = conjuntoA;
    }

    public void setConjuntoB(Conjunto conjuntoB) {
        this.conjuntoB = conjuntoB;
    }

    public void setUniverse(Conjunto universe) {
        this.universe = universe;
    }

    public Conjunto getConjuntoA() {
        return conjuntoA;
    }

    public Conjunto getConjuntoB() {
        return conjuntoB;
    }

    public Conjunto getUniverse() {
        return universe;
    }

    /**
     * Revisa si el conjunto como parametro tiene algun elemento distinto del universo.
     * @param conjunto El conjunto que se desea revisar
     * @return true si esta dentro del universp, false si tiene elementos distintos del universo
     */
    public boolean verifyUniverse(Conjunto conjunto){
        for (int i = 0; i < conjunto.getSize(); i++) {
            if(!universe.existsElement(conjunto.getElement(i)))
                return false;
        }
        return true;
    }

    /**
     * Une los conjuntos A y B
     * @return conjunto union en forma de instancia de Conjunto
     */
    public Conjunto union(){
        Conjunto union = new Conjunto();
        for (int i = 0; i < conjuntoA.getSize(); i++)
            union.addElement(conjuntoA.getElement(i));

        for (int i = 0; i <conjuntoB.getSize(); i++) {
            if(!union.existsElement(conjuntoB.getElement(i))){
                union.addElement(conjuntoB.getElement(i));
            }
        }
        return union;
    }

    /**
     * Intersecciona los conjuntos A y B
     * @return interseccion como instancia de Conjunto
     */
    public Conjunto intersection(){
        Conjunto intersection = new Conjunto();
        for (int i = 0; i < conjuntoA.getSize(); i++) {
            if(conjuntoB.existsElement(conjuntoA.getElement(i)))
                intersection.addElement(conjuntoA.getElement(i));
        }

        return intersection;
    }

}
