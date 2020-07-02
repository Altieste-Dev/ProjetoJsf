package test;

public class FornecedoresTEST {

/*	
//Teste Salvar
public static void main(String[] args) {
	
	FornecedoresDOMAIN f1 = new FornecedoresDOMAIN();
	f1.setDescricao("Exemplo 1");
	
	FornecedoresDOMAIN f2 = new FornecedoresDOMAIN();
	f2.setDescricao("Exemplo");
	
	FornecedoresDAO dao = new FornecedoresDAO();
	try {
		dao.salvar(f1);
		dao.salvar(f2);
		System.out.println("Salvo com sucesso!");
	} catch (SQLException e) {
		System.out.println("Erro" + e);
		e.printStackTrace();
	}

}

*/

/*
//Testa BuscarPorDescricao
public static void main(String[] args) {
	
	FornecedoresDOMAIN f1 = new FornecedoresDOMAIN();
	f1.setDescricao("Exemplo");

	FornecedoresDAO dao = new FornecedoresDAO();
	try {
		
		ArrayList<FornecedoresDOMAIN>lista = dao.buscarPorDescricao(f1);
		for(FornecedoresDOMAIN f : lista) {
			System.out.println("Resultado: " + f);

		}

	} catch (SQLException e) {
		System.out.println("Erro" + e);
		e.printStackTrace();
	}
	
	
}

*/

/*
//Testa listar
public static void main(String[] args) {

	FornecedoresDAO dao = new FornecedoresDAO();
	try {
		
		ArrayList<FornecedoresDOMAIN>lista = dao.listar();
		for(FornecedoresDOMAIN f : lista) {
			System.out.println("Resultado: " + f);

		}

	} catch (SQLException e) {
		System.out.println("Erro" + e);
		e.printStackTrace();
	}
	
	
}

*/


/*	
//Testa buscarPorCodigo
public static void main(String[] args) {
	
	FornecedoresDOMAIN f1 = new FornecedoresDOMAIN();
	f1.setCodigo(20);
	
	FornecedoresDAO dao = new FornecedoresDAO();
	try {
		
		FornecedoresDOMAIN resultado = dao.buscaporcodigo(f1);
		System.out.println("Resultado: " + resultado);
		
	} catch (SQLException e) {
		System.out.println("Erro" + e);
		e.printStackTrace();
	}
	
	
}

*/

/*
//Testar Editar
public static void main(String[] args) {
	
	FornecedoresDOMAIN f1 = new FornecedoresDOMAIN();
	f1.setCodigo(2);
	f1.setDescricao("Testa Editar");
	
	FornecedoresDAO dao = new FornecedoresDAO();
	try {
		dao.editar(f1);
		System.out.println("Editado com sucesso!");
	} catch (SQLException e) {
		System.out.println("Erro" + e);
		e.printStackTrace();
	}

	
}

*/

/*
//Testar Excluir
public static void main(String[] args) {
	
	FornecedoresDOMAIN f1 = new FornecedoresDOMAIN();
	f1.setCodigo(1);
	
	FornecedoresDAO dao = new FornecedoresDAO();
	try {
		dao.excluir(f1);
		System.out.println("Deletado com sucesso!");
	} catch (SQLException e) {
		System.out.println("Erro" + e);
		e.printStackTrace();
	}

	
}

*/

}