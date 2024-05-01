package domain.alertas;

import domain.alertas.TipoAlerta;
import domain.viajes.Viaje;

public class LlamadaUsuario implements TipoAlerta {
  public void alertar(Viaje unViaje) {
    //Realizar una llamada al celular del usuario
  }
}
