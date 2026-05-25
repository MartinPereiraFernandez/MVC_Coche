import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario.
 * Gestiona las entradas y salidas por consola.
 */
public class View {

    /** Scanner para leer la entrada del usuario. */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Muestra el menú principal y devuelve la opción elegida por el usuario.
     */
    public int mostrarMenu() {
        System.out.println("\n========== MENÚ PRINCIPAL ==========");
        System.out.println("1. Crear un coche");
        System.out.println("2. Mostrar velocidad de un coche");
        System.out.println("3. Avanzar");
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
     */
    public String mostrarVelocidad() {
        System.out.println("\n--- Mostrar velocidad ---");
        System.out.print("Introduce la matrícula del coche: ");
        return scanner.nextLine().trim();
    }

    /**
     * Solicita los datos necesarios para avanzar: matrícula y metros.
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
     * Muestra la velocidad actual de un coche por pantalla.
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
     */
    public void mostrarKilometros(String matricula, double kilometros) {
        System.out.printf("%s ha recorrido %.3f km en total.%n", matricula, kilometros);
    }

    /**
     * Muestra un mensaje de error cuando no se encuentra un coche.
     */
    public void mostrarErrorCocheNoEncontrado(String matricula) {
        System.out.println("No se encontró ningún coche con la matrícula: " + matricula);
    }
}

