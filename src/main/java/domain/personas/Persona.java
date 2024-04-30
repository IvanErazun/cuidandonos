package domain.personas;

import domain.utils.Repositorio;
import domain.viajes.Ubicacion;
import domain.viajes.Viaje;

public class Persona {
  private String nombre;
  private String apellido;
  private String direccion;
  private String edad;
  private String sexo;
  private Boolean estado;
  private Boolean notificaciones;

  void prenderNotificaciones() {
    this.notificaciones = Boolean.TRUE;
  }
  void apagarNotificaciones() {
    this.notificaciones = Boolean.FALSE;
  }

}


