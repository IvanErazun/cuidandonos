package domain.utils;
import domain.viajes.Viaje;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Temporizador {
	private Timer timer;
	private LocalTime tiempoInicial;
	private long tiempoEstimado;  // en milisegundos
	//private Viaje viaje;

	private TareaTerminada listener;

	public Temporizador(LocalTime tiempoInicial, long tiempoEstimado, Viaje viaje) {
		this.tiempoInicial = tiempoInicial;
		this.tiempoEstimado = tiempoEstimado;
		this.timer = new Timer();
		//this.viaje = viaje;
	}

	//TODO cambiar nombre se SetListener y de listener
	public void setListener(TareaTerminada toSet) {
		listener = toSet;
	}

	public void iniciar() {
		timer.schedule(
			new TimerTask() {
				@Override
				public void run() {
					Duration tiempoTranscurrido = Duration.between(LocalTime.now(), tiempoInicial);
					if (tiempoTranscurrido.toMinutes() >= tiempoEstimado) {
						listener.finTemporizador();
						timer.cancel();
					}
				}
			},
			0,
			60000);  // Ejecuta la tarea cada minuto
	}
}