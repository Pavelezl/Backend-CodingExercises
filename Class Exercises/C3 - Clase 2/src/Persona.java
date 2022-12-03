public class Persona {

    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Boolean esMayorDeEdad(){
        return edad >= 18;
    }

    public Boolean checkNombre4Letas(){
        return nombre.length() > 4;
    }

    public Boolean checkEdad(){
        Boolean respuesta = false;
        //proceso
        if(edad>=0&&edad<=120){
            respuesta=true;
        }
        //salida
        return respuesta;
    }

    public Boolean checkLetrasAZ(){
        Boolean respuesta = false;
        //Proceso
        //Chequeo
        char[] nombreAChar = nombre.toCharArray();
        for (char letras: nombreAChar){
            if(!Character.isLetter(letras)){
                return respuesta;
            }
            
        }
        respuesta=true;
        //Salida
        return respuesta;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
