package domain.viajes;

import domain.personas.Cuidador;
import domain.utils.AccionTemporizada;
import domain.utils.CalculadorDemora;
import domain.utils.CalculadorDistancia;
import domain.utils.TareaTerminada;
import domain.utils.Temporizador;
import java.time.LocalTime;
import java.util.List;
import jdk.vm.ci.meta.Local;
import lombok.Getter;

public class Viaje {

    private Ubicacion ubicacionInicial;
    private Ubicacion ubicacionFinal;
    private TipoAlerta tipoDeAlerta; // USA STRATEGY
    @Getter
    private double demoraAprox;
    private double distancia;
    //private double cronometro = 0;
    private Temporizador cronometro;
    @Getter
    private List<Cuidador> cuidadoresConfirmados;

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
        AccionTemporizada accionTermorizada = new AccionTemporizada();
        cronometro.setListener(accionTermorizada);
    }

    @Override
    public void finTemporizador() {
        tipoDeAlerta.alertar();
    }

    public void aceptoViaje(Cuidador cuidador) {
        cuidadoresConfirmados.add(cuidador);
    }
}
