class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica("teste");
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);
			System.out.println(codigo);
			ResultGen resultGen = new ResultGen();
			Integer result = resultGen.geraResultado(arv);
			System.out.println("Resultado ResultGen: " + result);
			PileComputer pileComputer = new PileComputer(codigo);
			System.out.println("Resultado PileComputer: "+ pileComputer.execute());

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
