import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CostoCoaccionamiento implements Lista<Votantes>{

    private int seleccion;
    private int candidatos;
    private int votantes;
    public static int lista = 1;
    public static int j =1;
    
    
  
    public CostoCoaccionamiento(String candidatoNum, int eleccion, int candidatos, int votantes) {

        this.seleccion = eleccion;
        this.candidatos = candidatos;
        this.votantes = votantes;
      
  }
    
    public List<Votantes> coaccionamiento(List<Votantes> listaVotantes) {
    	
	    if (j==1) {
		  
		  System.out.println("------------------------------------------------");
		  for (int i = 0; i < candidatos; i++) {
			  
			  if(i == seleccion) {
				  i = i+1;
			  } 
			  
			  int probabilidad =(int) (Math.random() * 10);
			  int costo =(int) (Math.random() * 10);
			  System.out.println("Candidato "+i);
			  System.out.println("Probabilidad: "+probabilidad+" Coste de coaccionamiento: "+costo);
		}
		  
		  
	 }
	  
	  System.out.println("------------------------------------------------");
	  if (lista == 1) {
		  System.out.println("Lista de votantes para el candidato "+seleccion);
		  
		  for (int i = 0; i < listaVotantes.size(); i++) {
			System.out.println(listaVotantes.get(i));
		}
	  	}else{
		
		System.out.println("Votantes descartados");
		 for (int i = 0; i < listaVotantes.size(); i++) {
				System.out.println(listaVotantes.get(i));
			}
	}
	 
	  lista = 2;
	  j=2;
	 
	Collections.sort(listaVotantes);
	
	System.out.println("-------------------------");
	 for (int i = 0; i < listaVotantes.size(); i++) {
			System.out.println(listaVotantes.get(i));
		}
    
    List<Votantes> listaVotantesFinal = new ArrayList<Votantes>();
    
    int tamañoLista = listaVotantes.size();
    float coaccionTotal = 0; 
    int porcentaje = 70;
    
    while (!solucion(listaVotantesFinal.size(), tamañoLista, porcentaje)) {
        
        Votantes votante = primeroLista(listaVotantes);
      
        coaccionTotal = coaccionTotal + votante.getCostoFinal();
        listaVotantesFinal.add(votante);
        listaVotantes.remove(votante);
    }
    
    return listaVotantesFinal;
    
  }

    private Votantes primeroLista(List<Votantes> listaDeVotantes) {
	  
        return listaDeVotantes.get(0);
    
  }

    private boolean solucion(int tamañoListaFinal, int tamañoLista, int porcentaje) {
        
    	return (tamañoListaFinal * 100) / tamañoLista > porcentaje;
    
  }


    public void print(List<Votantes> solucion) {
		
	    float costoCoaccion=0;
	    System.out.println("------------------------------------------------");
	    System.out.println("Votantes elegidos para coaccionar y monto pagado");
	    
	    for (Votantes votanteFinal : solucion) {
	        System.out.println(votanteFinal.toString());
	        costoCoaccion = costoCoaccion + votanteFinal.getCostoFinal();
	    }
	    
	    System.out.println("------------------------------------------------");
	    System.out.println("El costo total de coaccionamiento es de : " + costoCoaccion);
	
  }

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
	  	
	  	System.out.println("Digite el número de candidatos");
	  	
	  	int candidatos = sc.nextInt();
	  	
	  	System.out.println("Digite la cantidad de votantes");
	  	
	  	int votantes = sc.nextInt();
	  	
	  	System.out.println("Digite el numero del candidato a ganar");
	  	
	  	int eleccion = sc.nextInt();
	  	
	  	int costo[] = new int [votantes];
	  	
	  	int incremento2 = 1;
	  	for (int i = 0; i < votantes; i++) {
	  		
	  		System.out.println("Digite el valor de coacción para el votante "+incremento2);
	  		costo[i] = sc.nextInt();
	  		incremento2 = incremento2+1;
		}
	  	
	  	List<Votantes> listaDeVotantes=new ArrayList<Votantes>();
	  	
	  	int incremento =1;
	  	for (int i = 0; i < votantes; i++) {
	  			  		
	  		float probabilidad1 =(float) (Math.random() * 10);
		  	float probabilidad = probabilidad1/10;

	  		listaDeVotantes.add(new Votantes("Votante "+incremento,probabilidad,costo[i]));
	  		incremento = incremento+1;
		}
	  	
	  	CostoCoaccionamiento objCosto =new CostoCoaccionamiento("Candidato "+eleccion,eleccion,candidatos, votantes);
	  	List<Votantes>solucion=objCosto.coaccionamiento(listaDeVotantes);
	  	objCosto.print(solucion);
	
		}
}