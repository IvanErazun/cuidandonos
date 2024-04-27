package domain.utils;
import java.util.*;

public class Repositorio<T> {
    
    private List<T> elementos;
    
    public Repositorio() {
        this.elementos = new ArrayList<>();
    }
    
    public void agregar(T elemento) {
        this.elementos.add(elemento);
    }
    
    public T obtener(int indice) {
        return this.elementos.get(indice);
    }
    
    public List<T> obtenerTodos() {
        return this.elementos;
    }
}