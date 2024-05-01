package domain.utils;

import domain.viajes.Ubicacion;

import java.util.List;

public interface TipoCalculadoraDemora {

  double calcularDemora(List<Ubicacion> ubicaciones);
}
