package sistema.dao;

import sistema.model.aluno;

public interface AlunoDAO extends CrudDAO<aluno> {

	void remover(int idContato);

	void delete(aluno aluno);

	
}
