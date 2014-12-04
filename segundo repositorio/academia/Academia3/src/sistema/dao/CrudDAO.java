package sistema.dao;

import java.util.List;

import sistema.model.Entidade;

public interface CrudDAO<T extends Entidade> {
	void salvar(T entidade);

	void alterar(T entidade);

	void excluir(T entidade);

	T get(Integer codigo);

	List<T> listarTodos();

}
