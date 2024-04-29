package domain.viajes;

import domain.personas.Transeunte;

public class MensajeAlerta implements TipoAlerta {

    @Override
    public void alertar() {
        //transeunte.cuidadoresPendientes().forEach(cuidador -> cuidador.notificarLlegadaBien()) // NOTIFICACION INFO
    }

}
