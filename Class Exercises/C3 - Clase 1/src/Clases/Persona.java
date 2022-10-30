package Clases;

public class Persona {

    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
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

    public Boolean esMyorDeEdad(){
        return edad >= 18;
    }

    public Boolean checkNombre4Letas(){
        return nombre.length()>4;
    }

    public Boolean checkEdad(){
        boolean respuesta = false;
        //proceso
        if(edad>= 0 && edad<= 120){
            respuesta = true;
        }
        //salida
        return respuesta;
    }

    public Boolean checkLetrasAZ(){
        boolean respuesta = false;
        //proceso
        //Chequeo cada caracter sea una letra
        char[] nombresAchar = nombre.toCharArray();
        for (char letra: nombresAchar) {
            if(!Character.isLetter(letra)){
                return respuesta;
            }
        }
        respuesta = true;
        //salida
        return respuesta;

    }
}
