public abstract class Liquidador {

    public String liquidarSueldo(Empleado empleado){
        String respuesta = "la liquidación no pudo ser calculada";
        //paso 1 - calcular sueldo
        Double sueldo = calcularSueldo(empleado);
        //paso 2 - emitir recibido si se pudo realizar el saldo uno
        if(sueldo>0.0){
            String recibo = emitirRecibo(empleado);
            //paso 3 - depositar sueldo a la cuenta
            String deposito = depositarSueldo(empleado);
            respuesta = recibo + "saldo a liquidar: " + sueldo;
        }

        //paso 4 - devolver el String final (return)
        return respuesta;
    }

    protected abstract Double calcularSueldo(Empleado empleado);
    protected abstract String emitirRecibo(Empleado empleado);
    private String depositarSueldo(Empleado empleado){
        return "Orden de deposito en la cuenta N: " + empleado.getNumCuenta();
    }
}
