package domain.viajes;

import domain.personas.Transeunte;
import domain.utils.Temporizador;

import java.time.LocalTime;

public class MensajeAlerta implements TipoAlerta {

    private Temporizador cronometro;

    @Override
    public void alertar() {
        //transeunte.cuidadoresPendientes().forEach(cuidador -> cuidador.notificarLlegadaBien()) // NOTIFICACION INFO

        this.cronometro = new Temporizador(
            LocalTime.now(),
            5
        );
        cronometro.setListener(this);
    }

}
