package sistema.dao.factory;

import sistema.dao.AlunoDAO;
import sistema.dao.ProfessorDAO;
import sistema.dao.jdbc.AlunoJDBC;
import sistema.dao.jdbc.ProfessorJDBC;

public class JDBCDaoFactory implements AbstractDaoFactory {

	public AlunoDAO alunoDao() {
		return new AlunoJDBC();
	}

	public ProfessorDAO professorDao() {
		return new ProfessorJDBC();
	}
}