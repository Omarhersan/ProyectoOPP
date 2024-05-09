package backend;

public class PPendiente {
    protected String nombre;
    protected double deuda;

  public PPendiente(String nombre, double deuda) {
		this.nombre = nombre;
    this.deuda = deuda;		
	}

  public void setMasDeuda(double total) {
		this.deuda = this.deuda + total;
	}

  public void setMenosDeuda(double deuda) {
		this.deuda = this.deuda - deuda;
	}

  public String getNombre(){
    return this.nombre;
  }

  public double getDeuda(){
    return this.deuda;
  }
    
}
