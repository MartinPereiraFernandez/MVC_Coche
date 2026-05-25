/**
 * Clase que representa un coche con sus atributos básicos.
 */
public class Coche {
    /** Matrícula identificadora del coche. */
    String matricula;
    /** Modelo del coche. */
    String modelo;
    /** Velocidad actual del coche en km/hr. */
    Integer velocidad;
    /** Kilómetros totales recorridos por el coche. */
    double kilometrosRecorridos;

    /**
     * Constructor que crea un coche con modelo y matrícula.
     * La velocidad inicial es 0 y los kilómetros recorridos 0.
     * @param modelo modelo del coche
     * @param matricula matrícula identificadora única
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.kilometrosRecorridos = 0;
    }
}
