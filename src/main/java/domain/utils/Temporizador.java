package domain.utils;
import domain.viajes.Viaje;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Temporizador {
	private Timer timer;
	private LocalTime tiempoInicial;
	private long tiempoTemporizador;  // en milisegundos
	//private Viaje viaje;

	private TareaTerminada listener;

	public Temporizador(LocalTime tiempoInicial, long tiempoTemporizador) {
		this.tiempoInicial = tiempoInicial;
		this.tiempoTemporizador = tiempoTemporizador;
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
					if (tiempoTranscurrido.toMinutes() >= tiempoTemporizador) {
						listener.finTemporizador();
						timer.cancel();
					}
				}
			},
			0,
			60000);  // Ejecuta la tarea cada minuto
	}
}