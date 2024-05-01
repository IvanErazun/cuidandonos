package domain.utils;

import domain.viajes.Ubicacion;

import java.util.List;

public class CalculadorDemoraConEspera implements TipoCalculadoraDemora{
  private int parada = 0;

  public double calcularDemora(List<Ubicacion> ubicaciones) {
    double demora = CalculadorDemora.demoraEntre(ubicaciones.get(parada), ubicaciones.get(parada+1));
    parada++;
    return demora;
  }
}
