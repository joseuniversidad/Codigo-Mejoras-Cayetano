abstract class Persona {
    private String nombre;
    private double promedio;
    private String id;

    public Persona(String nombre,String id) {
        this.nombre = nombre;
        this.promedio = promedio;
        this.id = id;
    }

    public Persona(String nombreAlumno, double promedioAlumno) {
    }

    public double getPromedio() {
        return promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public abstract void mostrarDetalles();
}