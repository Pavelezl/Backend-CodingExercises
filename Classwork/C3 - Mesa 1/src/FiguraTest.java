import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FiguraTest {

    @Test
    public void calcularAreaCuadrado(){
        //DADO
        Figura figura1 = new Cuadrado(5.0);
        String respuestaEsperada = "El area del cuadrado es de 25.0 unidades";
        //Cuando
        String area = figura1.calcularArea();
        //Entonces
        Assertions.assertEquals(respuestaEsperada,area);
    }

    @Test
    public void calcularAreaCirculo(){
        //DADO
        Figura figura2 = new Circulo(10.0);
        String respuestaEsperada1 = "El area del circulo es de 314.1592653589793 unidades";
        //Cuando
        String area = figura2.calcularArea();
        //Entonces
        Assertions.assertEquals(respuestaEsperada1,area);
    }
}
