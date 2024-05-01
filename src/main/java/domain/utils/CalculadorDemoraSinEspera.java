package domain.utils;

import domain.viajes.Ubicacion;

import java.util.List;

public class CalculadorDemoraSinEspera implements TipoCalculadoraDemora{

  private double demora;

  @Override
  public double calcularDemora(List<Ubicacion> ubicaciones) {
    if (ubicaciones.size() < 2) {
      throw new IllegalStateException("El viaje debe tener al menos dos ubicaciones");
    }

    // Iteramos sobre las ubicaciones para calcular la demora entre cada par de destinos
    for (int i = 0; i < ubicaciones.size() - 1; i++) {
      Ubicacion origen = ubicaciones.get(i);
      Ubicacion destino = ubicaciones.get(i + 1);
      demora += CalculadorDemora.demoraEntre(origen, destino);
    }
    return demora;
  }
}
