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
    /** Litros de gasolina actuales del coche. */
    double gasolina;

    /**
     * Constructor que crea un coche con modelo y matrícula.
     * La velocidad, kilómetros y gasolina son 0 inicialmente.
     * @param modelo modelo del coche
     * @param matricula matrícula identificadora única
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.kilometrosRecorridos = 0;
        this.gasolina = 0;
    }
}