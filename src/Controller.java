/**
 * Clase controladora que coordina la View y el Model.
 * Gestiona el flujo principal de la aplicación.
 */
public class Controller {

    /** Instancia de la vista para interacción con el usuario. */
    static View miView = new View();
    /** Instancia del modelo para gestión de datos. */
    static Model miModel = new Model();

    /**
     * Método principal que inicia la aplicación.
     */
    public static void main(String[] args) {
        // Crear tres coches de ejemplo
        miModel.crearCoche("LaFerrari", "SBC 1234");
        miModel.crearCoche("Alpine", "HYU 4567");
        miModel.crearCoche("Aston Martin", "FGH 3333");

        // Modifica la velocidad del ferrari
        miModel.cambiarVelocidad("SBC 1234", 30);

        // Muestra la velocidad inicial
        boolean hecho = miView.muestraVelocidad("SBC 1234", miModel.getVelocidad("SBC 1234"));
        if (hecho) {
            System.out.println("[LOG] Correcto");
        } else {
            System.out.println("[LOG] Error");
        }

        // Menú principal
        int opcion = miView.mostrarMenu();

        switch (opcion) {
            case 1:
                String[] datos = miView.crearCoche();
                miModel.crearCoche(datos[0], datos[1]);
                main(args);
                break;

            case 2:
                String matricula = miView.mostrarVelocidad();
                Coche coche = miModel.getCoche(matricula);
                if (coche != null) {
                    miView.muestraVelocidad(matricula, miModel.getVelocidad(matricula));
                } else {
                    miView.mostrarErrorCocheNoEncontrado(matricula);
                }
                main(args);
                break;

            case 3:
                String[] datosAvanzar = miView.pedirDatosAvanzar();
                String matriculaAvanzar = datosAvanzar[0];
                Coche cocheAvanzar = miModel.getCoche(matriculaAvanzar);
                if (cocheAvanzar != null) {
                    double metros = Double.parseDouble(datosAvanzar[1]);
                    double kmTotales = miModel.avanzar(matriculaAvanzar, metros);
                    miView.mostrarKilometros(matriculaAvanzar, kmTotales);
                } else {
                    miView.mostrarErrorCocheNoEncontrado(matriculaAvanzar);
                }
                main(args);
                break;

            case 0:
                System.out.println("Saliendo... ¡Hasta luego!");
                break;

            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                main(args);
                break;
        }
    }
}