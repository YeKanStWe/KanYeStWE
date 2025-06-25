package pacote1;
/** 
 *  @author edu.bottini
 *  
 *  
 */ 
public class CaixaDeSucos {
	private int unidades;
	
	private String sabor;
	
	private String marca;
	
	public int getUnidades() {
		return unidades;
	}
	
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	public String getSabor() {
		return sabor;
	}
	
	public void setSabor(String sabor) {
		this.sabor = sabor; 
	}
	
	public String getMarca() { 
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void cadastrarSabor(String sabor) {
		setSabor(sabor);
	}
	
	public void imprimirSabor() {
	System.out.println(this.sabor);
	}
	
	public void cadastrarMarca(String marca) {
		setMarca(marca);
	}
	
	public void imprimirMarca() {
		System.out.println(this.marca); 
	}
	
}	
