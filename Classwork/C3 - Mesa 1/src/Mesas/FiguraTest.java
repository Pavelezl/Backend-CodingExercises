package Mesas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FiguraTest {

    @Test
    public void calcularAreaCuadrado(){
        //DADO
        Figura figuraPrueba = new Cuadrado(5.0);
        String respuestaEsperada = "El area del cuadrado es de 25.0 Unidades";
        //CUANDO
        String area = figuraPrueba.calcularArea();
        //ENTONCES
        Assertions.assertEquals(respuestaEsperada, area);

    }

    @Test
    public void calcularAreaCirculo(){
        //DADO
        Figura figuraPrueba = new Circulo(10.0);
        String respuestaEsperada = "El area del circulo es de 314.1592653589793 Unidades";
        //CUANDO
        String area = figuraPrueba.calcularArea();
        //ENTONCES
        Assertions.assertEquals(respuestaEsperada, area);

    }
}



