package pacote1;

public class CadastroCaixaDeSuco {
	
	public static void main(String args[]) {
		System.out.println("Cadastrando nova caixa...");
		CaixaDeSucos suco = new CaixaDeSucos();
		suco.cadastrarSabor("Pessego");
		suco.cadastrarMarca("Del Valle");
		suco.setUnidades(6);
		System.out.println(suco.getUnidades());
		System.out.println(suco.getSabor());
		System.out.println(suco.getMarca());
		
		
	}

}
