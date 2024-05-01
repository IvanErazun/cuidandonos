package domain.viajes;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class Viaje {
  private Ubicacion ubicacionInicial;
  private Ubicacion ubicacionFinal;
  private List<Persona> cuidadoresConfirmados;
  private List<Persona> cuidadoresPendientes;
  private Persona transeunte;
  private double demoraAprox;
  private LocalDateTime horaInicio;

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

