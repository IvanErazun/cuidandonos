package domain.viajes;

import domain.utils.CalculadorDemora;
import domain.utils.TipoCalculadoraDemora;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
  @Getter @Setter
  private List<Ubicacion> ubicaciones;
  @Getter @Setter
  private List<Persona> cuidadoresConfirmados;
  @Getter @Setter
  private List<Persona> cuidadoresPendientes;
  @Getter @Setter
  private Persona transeunte;
  @Getter @Setter
  private double minPorParada;
  @Getter @Setter
  private LocalDateTime horaInicio;
  @Getter @Setter
  private int parada;
  @Getter @Setter
  private TipoCalculadoraDemora tipoCalculadoraDemora;
  private double demoraAprox;

  public Viaje(Persona transeunte) {
    this.ubicaciones = new ArrayList<>();
    this.cuidadoresConfirmados = new ArrayList<>();
    this.cuidadoresPendientes = new ArrayList<>();
    this.transeunte = transeunte;
    this.parada = 0;
    this.demoraAprox = 0;
  }

  public void setDemoraAprox() {
    demoraAprox = tipoCalculadoraDemora.calcularDemora(ubicaciones);
  }

  public void notificarCuidadores(List<Persona> cuidadores, String mensaje) {
    cuidadores.forEach(cuidador -> cuidador.notificar(mensaje));
  }

  public void agregarCuidador(Persona cuidador){
    cuidadoresPendientes.add(cuidador);
  }

  public void agregarCuidadorConfirmado(Persona cuidador){
    cuidadoresConfirmados.add(cuidador);
  }

}

