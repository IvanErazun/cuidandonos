package domain.personas;
import domain.utils.CalculadorDemora;
import domain.utils.CalculadorDistancia;
import domain.utils.Repositorio;
import domain.viajes.Ubicacion;
import domain.viajes.Viaje;
import java.util.ArrayList;
import java.util.List;

public class Transeunte {
    private Persona persona;
    private List<Cuidador> cuidadoresPendientes;
    private Viaje viaje;

    public Transeunte() {
        this.cuidadoresPendientes = new ArrayList<>();
    }

    //CREO MOMENTANEAMENTE EL REPOSITORIO ACÁ
    Repositorio<Cuidador> repositorioDeCuidadores = new Repositorio<>();

    public void armarViaje(Ubicacion ubicacionActual, Ubicacion destino) {
        //TODO obtengo la info del viaje desde consola
        this.viaje = new Viaje(ubicacionActual, destino);
        mostrarCuidadores(repositorioDeCuidadores.obtenerTodos());
    }

    private void mostrarCuidadores(List<Cuidador> cuidadores) {
        //capa interfaz
    }

    public void elegirCuidador(Cuidador cuidador) {
        //TODO agregar cuidador a cuidadoresPendiente para luego notificarlos
        cuidadoresPendientes.add(cuidador);
    }
    public void removerCuidador(Cuidador cuidador) {
        //TODO eliminar cuidador de cuidadoresPendientes porque no se lo necesita
        cuidadoresPendientes.remove(cuidador);
    }

    public void consultaAceptanViaje(){
        //Pregunta a todos los cuidadores si aceptan el viaje
        cuidadoresPendientes.forEach(cuidador -> cuidador.aceptasViaje(this.viaje));
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
        this.viaje.getCuidadoresConfirmados().forEach(cuidador -> cuidador.notificarLlegadaBien());  // NOTIFICACION INFO

    }
    private void notificarArranqueViaje(){
        this.viaje.getCuidadoresConfirmados().forEach(cuidador -> cuidador.notificarArranque());  // NOTIFICACION INFO
    }

}