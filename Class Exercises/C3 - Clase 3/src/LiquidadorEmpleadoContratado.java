public class LiquidadorEmpleadoContratado extends Liquidador{


    @Override
    protected Double calcularSueldo(Empleado empleado) {
        //el sueldo es la operacion canthoras*valorhora
        Double respuesta = 0.0;
        //proceso
        if (empleado instanceof EmpleadoContratado) {
            // (ClaseADondeQuieroIr) ObjetoDeInicio
            EmpleadoContratado emp = (EmpleadoContratado) empleado;
            respuesta=emp.getCantidadHoras()*emp.getValorPorHora();
        }
        return respuesta;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidacion generada es un documento digital";
    }
}
