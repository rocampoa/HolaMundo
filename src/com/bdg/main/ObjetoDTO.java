package com.bdg.main;

/**
 * Created by Rafael on 17/06/2017.
 */
public class ObjetoDTO {

  private int edad;
  private boolean mayor;

  public ObjetoDTO(int edad) {
    this.edad = edad;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public boolean isMayor() {
    return mayor;
  }

  public void setMayor(boolean mayor) {
    this.mayor = mayor;
  }
}
