package domain.viajes;

import domain.alertas.TipoAlerta;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter @Getter
public class Persona {
  private String nombre;
  private String apellido;
  private Ubicacion direccion;
  private LocalDateTime fechaNacimiento;
  private String sexo;
  private TipoAlerta tipoDeAlerta;
  private Boolean notificaciones;

  public void notificar(String mensaje) {
    if (notificaciones) {
      //TODO hacer algo con la notificacion recibida
    }
    // else { avisar que no está disponible}
  }

  public int edad() {
    return LocalDateTime.now().getYear()-fechaNacimiento.getYear();
  }

}


