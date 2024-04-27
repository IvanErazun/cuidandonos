package domain.personas;
import domain.utils.CalculadorDemora;
import domain.utils.CalculadorDistancia;
import domain.utils.Repositorio;
import domain.viajes.Ubicacion;
import domain.viajes.Viaje;
import java.util.List;

public class Transeunte {
    private Persona persona;
    private Viaje viaje;
    private List<Cuidador> cuidadoresPendientes;
    private List<Cuidador> cuidadoresConfirmados;

    public Transeunte(List<Cuidador> cuidadoresPendientes) {
        this.cuidadoresPendientes = cuidadoresPendientes;
    }

    Repositorio<Cuidador> repositorioDeCuidadores = new Repositorio<>();
    void armarViaje() {
        //TODO obtengo la info del viaje desde consola
        Ubicacion ubicacionActual = new Ubicacion();
        Ubicacion destino = new Ubicacion();
        this.viaje = new Viaje(ubicacionActual, destino);
        mostrarCuidadores(repositorioDeCuidadores.obtenerTodos());
    }

    private void mostrarCuidadores(List<Cuidador> cuidadores) {
        //capa interfaz
    }

    public void elegirCuidadores(Cuidador cuidador) {
        //TODO agregar cuidador a cuidadoresPendiente para luego notificarlos
        cuidadoresPendientes.add(cuidador);
    }
    public void removerCuidadores(Cuidador cuidador) {
        //TODO eliminar cuidador de cuidadoresPendientes porque no se lo necesita
        cuidadoresPendientes.remove(cuidador);
    }

    public void confirmarCuidadores(){
        //notifica al cuidador
        cuidadoresPendientes.forEach(cuidador -> cuidador.aceptoViaje(this.viaje));
    }

    CalculadorDistancia calculadorDistancia;
    CalculadorDemora calculadorDemora;
    public void comenzarViaje() {
        //Apagar notificaciones
        persona.apagarNotificaciones();
        //Iniciar cronometro del viaje para alertar
        viaje.iniciarCronometro();
        //Calcular la distancia y demora
        viaje.calcularDistanciaYDemora(calculadorDistancia, calculadorDemora);
        //Notificar cuidadores
        notificarArranqueViaje();
    }
    public void llegueBien() {
        //Encender notificaciones
        persona.prenderNotificaciones();
        //Notificar cuidadores
        cuidadoresConfirmados.forEach(cuidador -> cuidador.notificarLlegadaBien());  // NOTIFICACION INFO

    }
    public void notificarArranqueViaje(){
        cuidadoresConfirmados.forEach(cuidador -> cuidador.notificarArranque());  // NOTIFICACION INFO
    }

}