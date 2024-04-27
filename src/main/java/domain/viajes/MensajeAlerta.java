package domain.viajes;

import domain.personas.Transeunte;

public class MensajeAlerta {
    //Enviar un mensaje de alerta a sus cuidadores
    public void alertar(Transeunte transeunte) {
        transeunte.cuidadoresPendientes().forEach(cuidador -> cuidador.notificarLlegadaBien()) // NOTIFICACION INFO
    }
}
