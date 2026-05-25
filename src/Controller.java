/**
 * Clase controladora que coordina la View y el Model.
 */
public class Controller {

    /** Instancia de la vista para interacción con el usuario. */
    static View miView = new View();
    /** Instancia del modelo para gestión de datos. */
    static Model miModel = new Model();

    /**
     * Método principal que inicia la aplicación.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        miModel.crearCoche("LaFerrari", "SBC 1234");
        miModel.crearCoche("Alpine", "HYU 4567");
        miModel.crearCoche("Aston Martin", "FGH 3333");

        miModel.cambiarVelocidad("SBC 1234", 30);

        boolean hecho = miView.muestraVelocidad("SBC 1234", miModel.getVelocidad("SBC 1234"));
        if (hecho) {
            System.out.println("[LOG] Correcto");
        } else {
            System.out.println("[LOG] Error");
        }

        int opcion = miView.mostrarMenu();

        switch (opcion) {
            case 1:
                String[] datos = miView.crearCoche();
                miModel.crearCoche(datos[0], datos[1]);
                main(args);
                break;

            case 2:
                String matricula2 = miView.mostrarVelocidad();
                if (miModel.getCoche(matricula2) != null) {
                    miView.muestraVelocidad(matricula2, miModel.getVelocidad(matricula2));
                } else {
                    miView.mostrarErrorCocheNoEncontrado(matricula2);
                }
                main(args);
                break;

            case 3:
                String[] datosAvanzar = miView.pedirDatosAvanzar();
                String matricula3 = datosAvanzar[0];
                if (miModel.getCoche(matricula3) != null) {
                    double metros = Double.parseDouble(datosAvanzar[1]);
                    double kmTotales = miModel.avanzar(matricula3, metros);
                    miView.mostrarKilometros(matricula3, kmTotales);
                } else {
                    miView.mostrarErrorCocheNoEncontrado(matricula3);
                }
                main(args);
                break;

            case 4:
                String[] datosGasolina = miView.pedirDatosGasolina();
                String matricula4 = datosGasolina[0];
                if (miModel.getCoche(matricula4) != null) {
                    double litros = Double.parseDouble(datosGasolina[1]);
                    double litrosTotales = miModel.ponerGasolina(matricula4, litros);
                    miView.mostrarGasolina(matricula4, litrosTotales);
                } else {
                    miView.mostrarErrorCocheNoEncontrado(matricula4);
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