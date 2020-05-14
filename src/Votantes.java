
public class Votantes implements  Comparable<Votantes>{
	
    private final String votante;
    private final float probabilidad;
    private final int costo;
    private final float costoFinal;
    

    public Votantes(String votante, float probabilidad, int costo) {
    	
        this.votante = votante;
        this.probabilidad=probabilidad;
        this.costo = costo;
        this.costoFinal = (1 - probabilidad) * costo;
    }
  
    public float getProbabilidad() {
        
    	return probabilidad;
    }
  

    public int getCosto() {
        
    	return costo;
    }
  
    public float getCostoFinal() {
        
    	return this.costoFinal;
    }

  @Override
  public String toString() {
	  
    StringBuffer str=new StringBuffer("").append(votante).append("  Probabilidad de voto: ").append(probabilidad).append("  Costo: ").append(costo).append("  Coaccionamiento: ").append(costoFinal);
    
    return str.toString();
  }

  @Override
	public int compareTo(Votantes v) {
	  
	 if(v.getCosto()>costo) {
		 
		 return -1;
	    
	    }else if(v.getCosto()>costo) {
	    	return 0;
	    }
	 	return 1;
  }

}