package domain.utils;
import domain.viajes.Viaje;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import lombok.Setter;

public class Temporizador {
	private Timer timer;
	private LocalTime tiempoInicial;
	private long tiempoTemporizador;  // en milisegundos
	//private Viaje viaje;

	//TODO cambiar nombre se SetListener y de listener
	@Setter
	private AccionTemporizada listener;

	public Temporizador(LocalTime tiempoInicial, long tiempoTemporizador) {
		this.tiempoInicial = tiempoInicial;
		this.tiempoTemporizador = tiempoTemporizador;
		this.timer = new Timer();
		//this.viaje = viaje;
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