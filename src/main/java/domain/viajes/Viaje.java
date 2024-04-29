package domain.viajes;

import domain.personas.Cuidador;
import domain.utils.CalculadorDemora;
import domain.utils.CalculadorDistancia;
import domain.utils.TareaTerminada;
import domain.utils.Temporizador;
import java.time.LocalTime;
import jdk.vm.ci.meta.Local;

public class Viaje implements TareaTerminada{

    private Ubicacion ubicacionInicial;
    private Ubicacion ubicacionFinal;
    private TipoAlerta tipoDeAlerta;
    private double demoraAprox;
    private double distancia;
    //private double cronometro = 0;
    private Temporizador cronometro;

    public double getDemoraAprox() {
        return demoraAprox;
    }

    public Viaje(Ubicacion ubicacionInicial, Ubicacion ubicacionFinal) {
        this.ubicacionInicial = ubicacionInicial;
        this.ubicacionFinal = ubicacionFinal;
    }

    public void calcularDistanciaYDemora(CalculadorDistancia calculadorDistancia, CalculadorDemora calculadorDemora) {
        this.distancia = calculadorDistancia.distanciaEntre(this.ubicacionInicial, this.ubicacionFinal);
        this.demoraAprox = calculadorDemora.demoraAproximadaEnMinsParaRecorrer(this.distancia);
    }

    public void iniciarCronometro() {

        this.cronometro = new Temporizador(
            LocalTime.now(),
            (long) this.getDemoraAprox()
        );
        cronometro.setListener(this);
    }

    @Override
    public void finTemporizador() {
        tipoDeAlerta.alertar();
    }
}
