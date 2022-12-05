import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LiquidadorTest {

    @Test
    public void pruebaLiquidacionEmpleadoEfectivo(){
        //dado
        Empleado empleado = new EmpleadoEfectivo("Juan", "Perez", "75894",75000.0,5284.0,5984.0);
        Liquidador liquidador = new LiquidadorEmpleadoEfectivo();
        String respEsperada = "La liquidacion generada es un documento escrito. saldo a liquidar: 74300.0";
        //cuando
        String liquidacionFinal = liquidador.liquidarSueldo(empleado);
        //entonces
        Assertions.assertEquals(respEsperada,liquidacionFinal);
    }
    
}
