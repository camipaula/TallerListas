import java.util.ArrayList;
import java.util.List;

public class Bibliotecaa {

    private List<Libro> libros;

    public List<Libro> getLibros() {
        return libros;
    }

    public Bibliotecaa() {
        this.libros = new ArrayList<Libro>();
    }

    public boolean agregarLibro(Libro l) {
        if(busquedaLibro(l.getNombre())==null){
            libros.add(l);
            return true;
        }else{
            return false;
        }
    }

    public Libro busquedaLibro(String nombre){
        for (Libro libro1 : libros) {
            if(libro1.getNombre().equals(nombre)){
                return libro1;
            }
        }
        return null;
    }

    public Libro busquedaBinario(int Id){
        int izquierda = 0;
        int derecha = libros.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (libros.get(medio).getId() == Id) {
                return libros.get(medio);
            } else if (libros.get(medio).getId() < Id) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null;
    }

    public Libro removeLibroPorNombre(String nombre){
        Libro libro1;
        for (int i=0;i<libros.size();i++) {
            libro1=libros.get(i);
            if(libro1.getNombre().equals(nombre)){
                libros.remove(i);
                return libro1;
            }
        }
        return null;
    }

    public Libro removeLibroPorId(int id){
        Libro libro1;
        for (int i=0;i<libros.size();i++) {
            libro1=libros.get(i);
            if(libro1.getId()==id){
                libros.remove(i);
                return libro1;
            }
        }
        return null;
    }


    public void datosQuemados(){
        libros.add(new Libro(10,"Cien años de soledad"));
        libros.add(new Libro(20,"El amor en los tiempos del cólera"));
        libros.add(new Libro(30,"Almas muertas"));
        libros.add(new Libro(35,"Don Quijote de la Mancha"));
        libros.add(new Libro(42,"El Señor de los Anillos"));
        libros.add(new Libro(54,"Fausto"));
    }

    public int sumaPaginas(List<Libro> libros, int n){
        if(n==0){
            return libros.get(0).getPaginas();
        }else{
            return libros.get(n).getPaginas()+sumaPaginas(libros,n-1);
        }
    }

    @Override
    public String toString() {
        return "Bibliotecaa{" +
                "libros=" + libros +
                '}';
    }
}
