package domain;

public class Viaje {
    private double distancia;
    private double  demoraAprox;

    public void calcularDistanciaYDemora(CalculadorDeDistancia calculadorDeDistancia, CalculadorDeDemora calculadorDeDemora) {
        this.distancia = calculadorDeDistancia.distanciaEnMetrosEntre(this.puntoDePartida, this.destino);
        this.demoraAprox = calculadorDeDemora.demoraAproximadaEnMinsParaRecorrer(distanciaEnMetros);
    }


}
