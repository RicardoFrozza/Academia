package sistema.dao.factory;

import sistema.dao.AlunoDAO;
import sistema.dao.ProfessorDAO;

public interface AbstractDaoFactory {
	AlunoDAO alunoDao();
	ProfessorDAO professorDao();
}
