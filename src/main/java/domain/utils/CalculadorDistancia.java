package domain.utils;
import domain.viajes.Ubicacion;

public interface CalculadorDistancia{
    double distanciaEntre(Ubicacion origen, Ubicacion destino);
}