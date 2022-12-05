public class EmpleadoContratado extends Empleado{

    private Integer cantidadHoras;
    private Double valorPorHora;

    public EmpleadoContratado(String nombre, String apellido, String numCuenta, Integer cantidadHoras, Double valorPorHora) {
        super(nombre, apellido, numCuenta);
        this.cantidadHoras = cantidadHoras;
        this.valorPorHora = valorPorHora;
    }

    public Integer getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(Integer cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }
}
