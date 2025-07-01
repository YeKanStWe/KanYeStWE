package tarefa_calculomedia;

public class calculomedia {
	
	public static void main(String args[]) {
		somarNotas();
	}

	private static void somarNotas() {
		 	System.out.println("iniciando metodologia de calculo...");
			double aluno1 = 6.8;
		 	double aluno2 = 9.3;
		 	double aluno3 = 10.0;
		 	double aluno4 = 9.2;
		 	double notaTurma = aluno1 + aluno2 + aluno3 + aluno4;
		 	System.out.println("a nota da turma somada foi " + notaTurma);
		 	double mediaTurma = notaTurma / 4;
		 	System.out.println("tornando a media geral da turma " + mediaTurma);
		 	boolean isMediaTurma = mediaTurma >= 6;
		    if (!isMediaTurma) {
		    	System.out.print("nao foi um bom trimestre da turma");
		    }
		    else { 
		    		System.out.print("parabens turma, boas ferias!!!");
		    }
	}
}