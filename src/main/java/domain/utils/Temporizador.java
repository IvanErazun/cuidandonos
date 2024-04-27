package domain.utils;
import domain.viajes.Viaje;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Temporizador {
	private Timer timer;
	private LocalTime tiempoInicial;
	private long tiempoEstimado;  // en milisegundos
	private Viaje viaje;

	public Temporizador(LocalTime tiempoInicial, long tiempoEstimado, Viaje viaje) {
		this.tiempoInicial = tiempoInicial;
		this.tiempoEstimado = tiempoEstimado;
		this.timer = new Timer();
		this.viaje = viaje;
	}

	public void iniciar() {
		timer.schedule(
			new TimerTask() {
				@Override
				public void run() {
					Duration tiempoTranscurrido = Duration.between(LocalTime.now(), tiempoInicial);
					if (tiempoTranscurrido.toMinutes() >= tiempoEstimado) {
						viaje.alertarPeligro();
						timer.cancel();
					}
				}
			},
			0,
			60000);  // Ejecuta la tarea cada minuto
	}
}