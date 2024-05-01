package domain.utils;

import domain.viajes.Ubicacion;

public class CalculadorDemora{


    
    private AdapterCalculadorDistancia calculadorDistancia;
    private AdapterCalculadorDemora calculadorDemora;

    // SE PUEDE MOCKEAR GRACIAS A QUE TENEMOS EL CALCULADOR DE DISTANCIA Y EL CALCULADOR DE DEMORA COMO INTERFACES
    public double demoraEntre(Ubicacion origen, Ubicacion destino) {
        double distancia = calculadorDistancia.distanciaEntre(origen, destino);
        return calculadorDemora.calcularDemora(distancia);
    }

}