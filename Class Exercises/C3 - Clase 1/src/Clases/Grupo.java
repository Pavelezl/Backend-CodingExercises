package Clases;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

    private List<Persona> personaList;

    public Grupo() {
        personaList = new ArrayList<>();
    }

    public void agregarPersona(Persona persona) {
        boolean checkMayoria = persona.esMyorDeEdad();
        boolean cantidadLetras = persona.checkNombre4Letas();
        boolean soloLetras = persona.checkLetrasAZ();
        boolean checkEdad = persona.checkEdad();

        if (checkMayoria && cantidadLetras && soloLetras && checkEdad) {
            personaList.add(persona);
            System.out.println("Se agrego la persona " + persona.getNombre());
        } else {
            System.err.println("No se puede agregar a la persona" + persona.getNombre());
            if (!checkMayoria) {
                System.err.println("La persona tiene que ser mayor de edad de 18 años");
            }
            if (!cantidadLetras) {
                System.err.println("El nombre de la persona tiene que ser de 5 letra o más");
            }
            if (!soloLetras) {
                System.err.println("El nombre de la prsona debe ser solo letras");
            }
            if (!checkEdad) {
                System.err.println("La edad tiene que ser de 0 a 120");
            }
            System.err.println("*******************************************");

        }
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }
}

