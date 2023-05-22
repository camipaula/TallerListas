import java.util.ArrayList;

public class Libro {
    private int id;
    private int paginas;
    private String nombre;
    private static int contador=0;


    public int getId() {
        return id;
    }

    public int getPaginas() {
        return paginas;
    }


    public String getNombre() {
        return nombre;
    }


    public Libro(int paginas, String nombre) {
        this.id = crearCodigo();
        this.paginas = paginas;
        this.nombre = nombre;
    }

    private int crearCodigo(){
        contador=contador+1;
        return contador;
    }


    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", paginas=" + paginas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
