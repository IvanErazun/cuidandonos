package domain.utils;

import domain.viajes.Ubicacion;

public interface AdapterCalculadorDistancia {
  double distanciaEntre(Ubicacion origen, Ubicacion destino);
}
