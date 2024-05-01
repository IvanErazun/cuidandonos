package domain.alertas;

import domain.viajes.Viaje;

public interface TipoAlerta {
    public void alertar(Viaje unViaje);
}
