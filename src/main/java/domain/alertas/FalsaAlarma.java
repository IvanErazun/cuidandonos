package domain.alertas;

import domain.alertas.TipoAlerta;
import domain.viajes.Viaje;

public class FalsaAlarma implements TipoAlerta {

    public void alertar(Viaje unViaje) {
        //Esperar N minutos para ver si es una falsa alarma (los minutos deben ser parametrizables)
    }
}


