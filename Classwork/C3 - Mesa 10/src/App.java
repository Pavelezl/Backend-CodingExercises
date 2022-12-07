import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static final Logger logger = Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App() {
        this.listaEnteros = new ArrayList<>();
    }

    public void agregarEntero(Integer entero) {
        listaEnteros.add(entero);
        if (listaEnteros.size() > 5) {
            logger.info("La longitud de la lista es mayor a 5, en total tiene " + listaEnteros.size() + ".");
        }
        if (listaEnteros.size() > 10) {
            logger.info("La longitud de la lista es mayor a 10, en total tiene " + listaEnteros.size() + ".");
        }
        if (listaEnteros.size() == 0) {
            logger.error("La lista es igual a cero");
        }
    }

    public void calcularPromedio() {
        Double suma = 0.0;
        for (Integer listaEntero : listaEnteros) {
            suma += listaEntero;
        }
        Double promedio = suma / listaEnteros.size();
        logger.info("El promedio es " + promedio + ".");
    }

    public void calcularMinimo() {
        Integer minimo = listaEnteros.get(0);
        for (int i = 0; i < listaEnteros.size() ; i++) {
            if (listaEnteros.get(i) < minimo) {
                minimo = listaEnteros.get(i);
            }
        }
        logger.info("El mínimo es " + minimo + ".");
    }

    public void calcularMaximo() {
        Integer maximo = listaEnteros.get(0);
        for (int i = 0; i < listaEnteros.size() ; i++) {
            if (listaEnteros.get(i) > maximo) {
                maximo = listaEnteros.get(i);
            }
        }
        logger.info("El maximo es " + maximo + ".");
    }

}