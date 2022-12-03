import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class GrupoTest {

    @Test
    public void casoUno(){
        //DADO (Lo que necesito para hacer mis pruebas)
        Persona juan = new Persona("Juan",20);
        Persona pedro = new Persona("Pedro",21);
        Persona ana = new Persona("Ana",22);
        Persona luz = new Persona("Luz",23);
        Persona julian = new Persona("Julian",24);
        Grupo grupo1 = new Grupo();
        
        //Cuando (Lo que se esta ejecutando)
        grupo1.agregarPersonas(juan);
        grupo1.agregarPersonas(pedro);
        grupo1.agregarPersonas(ana);
        grupo1.agregarPersonas(luz);
        grupo1.agregarPersonas(julian);
        
        //Entonces (Las pruebas finales a ver si funciona o no)
        Assertions.assertTrue(grupo1.getPersonaList().size()==2);
    }

    @Test
    public void casoDos(){
        //DADO (Lo que necesito para hacer mis pruebas)
        Persona agustin = new Persona("Agustin",18);
        Persona antonio = new Persona("Antonio",17);
        Persona carlos = new Persona("Carlos",22);
        Persona sebastian = new Persona("Sebastian",14);
        Persona carolina = new Persona("Carolina",32);
        Grupo grupo1 = new Grupo();

        //Cuando (Lo que se esta ejecutando)
        grupo1.agregarPersonas(agustin);
        grupo1.agregarPersonas(antonio);
        grupo1.agregarPersonas(carlos);
        grupo1.agregarPersonas(sebastian);
        grupo1.agregarPersonas(carolina);

        //Entonces (Las pruebas finales a ver si funciona o no)
        Assertions.assertTrue(grupo1.getPersonaList().size()==3);
    }
    @Test
    public void casoTres(){
        //DADO (Lo que necesito para hacer mis pruebas)
        Persona nicolas = new Persona("n1c0las",22);
        Persona tomas = new Persona("Tomas",23);
        Persona carly = new Persona("Carlos/sV",24);
        Persona francisco = new Persona("Francisco/sII",25);
        Grupo grupo1 = new Grupo();

        //Cuando (Lo que se esta ejecutando)
        grupo1.agregarPersonas(nicolas);
        grupo1.agregarPersonas(tomas);
        grupo1.agregarPersonas(carly);
        grupo1.agregarPersonas(francisco);

        //Entonces (Las pruebas finales a ver si funciona o no)
        Assertions.assertEquals(1,grupo1.getPersonaList().size());
    }


}
