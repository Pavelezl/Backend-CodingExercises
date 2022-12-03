import java.util.ArrayList;
import java.util.List;

public class Grupo {

    private List<Persona> personaList;

    public Grupo() {
        personaList = new ArrayList<>();
    }

    public void agregarPersonas(Persona persona){
        Boolean checkMayoria = persona.esMayorDeEdad();
        Boolean contidadLetras = persona.checkNombre4Letas();
        Boolean alfabeto = persona.checkLetrasAZ();
        Boolean checkEdad = persona.checkEdad();

        if(checkMayoria && contidadLetras && alfabeto && checkEdad){
            personaList.add(persona);
            System.out.println("Se agrego a la persona: " + persona.getNombre());
        }
        else{
            System.err.println("No se puede agregar a la persona " + persona.getNombre());
            if(!checkMayoria){
                System.err.println("La persona tiene que tener más de 18 años");
            }
            if(!contidadLetras){
                System.err.println("El nombre de la persona tiene que tener más de 5 letras");
            }
            if(!alfabeto){
                System.err.println("El nombre de la persona tiene que contener letras de la A a la Z");
            }
            if(!checkEdad){
                System.err.println("La edad de la persona tiene que ser de 0 a 120 años");
            }
            System.err.println("**********************************************");
        }



    }
}
