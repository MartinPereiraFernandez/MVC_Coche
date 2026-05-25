import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos de la aplicación.
 */
public class Model {

    /** Lista de coches disponibles en el parking. */
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo añade al parking.
     * @param modelo modelo del coche
     * @param matricula matrícula identificadora única
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula) {
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche por su matrícula.
     * @param matricula matrícula a buscar
     * @return el coche encontrado, o null si no existe
     */
    public Coche getCoche(String matricula) {
        Coche aux = null;
        for (Coche e : parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Cambia la velocidad de un coche.
     * @param matricula matrícula del coche
     * @param v nueva velocidad en km/hr
     * @return la nueva velocidad establecida
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v;
        return getCoche(matricula).velocidad;
    }

    /**
     * Devuelve la velocidad actual de un coche.
     * @param matricula matrícula del coche
     * @return velocidad actual en km/hr
     */
    public int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

    /**
     * Avanza el coche un número de metros y acumula los kilómetros recorridos.
     * @param matricula matrícula del coche que avanza
     * @param metros metros que avanza el coche
     * @return total de kilómetros recorridos acumulados
     */
    public double avanzar(String matricula, double metros) {
        Coche coche = getCoche(matricula);
        coche.kilometrosRecorridos += metros / 1000.0;
        return coche.kilometrosRecorridos;
    }

    /**
     * Devuelve los kilómetros totales recorridos por un coche.
     * @param matricula matrícula del coche
     * @return kilómetros recorridos acumulados
     */
    public double getKilometros(String matricula) {
        return getCoche(matricula).kilometrosRecorridos;
    }

    /**
     * Añade litros de gasolina al depósito de un coche.
     * @param matricula matrícula del coche
     * @param litros litros de gasolina a añadir
     * @return total de litros de gasolina tras repostar
     */
    public double ponerGasolina(String matricula, double litros) {
        Coche coche = getCoche(matricula);
        coche.gasolina += litros;
        return coche.gasolina;
    }

    /**
     * Devuelve los litros de gasolina actuales de un coche.
     * @param matricula matrícula del coche
     * @return litros de gasolina actuales
     */
    public double getGasolina(String matricula) {
        return getCoche(matricula).gasolina;
    }
}