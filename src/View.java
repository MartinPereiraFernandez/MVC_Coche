import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario.
 */
public class View {

    /** Scanner para leer la entrada del usuario. */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Muestra el menú principal y devuelve la opción elegida por el usuario.
     * @return opción seleccionada por el usuario
     */
    public int mostrarMenu() {
        System.out.println("\n========== MENÚ PRINCIPAL ==========");
        System.out.println("1. Crear un coche");
        System.out.println("2. Mostrar velocidad de un coche");
        System.out.println("3. Avanzar");
        System.out.println("4. Poner gasolina");
        System.out.println("0. Salir");
        System.out.println("=====================================");
        System.out.print("Selecciona una opción: ");

        int opcion = -1;
        try {
            opcion = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Opción no válida. Introduce un número.");
        }
        return opcion;
    }

    /**
     * Solicita al usuario los datos para crear un coche.
     * @return array con {modelo, matricula}
     */
    public String[] crearCoche() {
        System.out.println("\n--- Crear nuevo coche ---");
        System.out.print("Introduce el modelo: ");
        String modelo = scanner.nextLine().trim();
        System.out.print("Introduce la matrícula: ");
        String matricula = scanner.nextLine().trim();
        System.out.println("Coche '" + modelo + "' creado correctamente.");
        return new String[]{modelo, matricula};
    }

    /**
     * Solicita la matrícula del coche para consultar su velocidad.
     * @return matrícula introducida por el usuario
     */
    public String mostrarVelocidad() {
        System.out.println("\n--- Mostrar velocidad ---");
        System.out.print("Introduce la matrícula del coche: ");
        return scanner.nextLine().trim();
    }

    /**
     * Solicita los datos necesarios para avanzar: matrícula y metros.
     * @return array con {matricula, metros}
     */
    public String[] pedirDatosAvanzar() {
        System.out.println("\n--- Avanzar ---");
        System.out.print("Introduce la matrícula del coche: ");
        String matricula = scanner.nextLine().trim();
        System.out.print("Introduce los metros a avanzar: ");
        String metros = scanner.nextLine().trim();
        return new String[]{matricula, metros};
    }

    /**
     * Solicita los datos necesarios para poner gasolina: matrícula y litros.
     * @return array con {matricula, litros}
     */
    public String[] pedirDatosGasolina() {
        System.out.println("\n--- Poner gasolina ---");
        System.out.print("Introduce la matrícula del coche: ");
        String matricula = scanner.nextLine().trim();
        System.out.print("Introduce los litros a añadir: ");
        String litros = scanner.nextLine().trim();
        return new String[]{matricula, litros};
    }

    /**
     * Muestra la velocidad actual de un coche por pantalla.
     * @param matricula matrícula del coche
     * @param v velocidad actual en km/hr
     * @return true si se mostró correctamente, false si no se encontró el coche
     */
    public boolean muestraVelocidad(String matricula, Integer v) {
        if (v == null) {
            System.out.println("No se encontró ningún coche con la matrícula: " + matricula);
            return false;
        }
        System.out.println(matricula + ": " + v + " km/hr");
        return true;
    }

    /**
     * Muestra los kilómetros recorridos acumulados de un coche.
     * @param matricula matrícula del coche
     * @param kilometros kilómetros totales recorridos
     */
    public void mostrarKilometros(String matricula, double kilometros) {
        System.out.printf("%s ha recorrido %.3f km en total.%n", matricula, kilometros);
    }

    /**
     * Muestra los litros de gasolina actuales de un coche.
     * @param matricula matrícula del coche
     * @param litros litros de gasolina actuales
     */
    public void mostrarGasolina(String matricula, double litros) {
        System.out.printf("%s tiene %.2f litros de gasolina.%n", matricula, litros);
    }

    /**
     * Muestra un mensaje de error cuando no se encuentra un coche.
     * @param matricula matrícula no encontrada
     */
    public void mostrarErrorCocheNoEncontrado(String matricula) {
        System.out.println("No se encontró ningún coche con la matrícula: " + matricula);
    }
}