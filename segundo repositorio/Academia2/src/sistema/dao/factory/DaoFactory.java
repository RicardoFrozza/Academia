package sistema.dao.factory;

import sistema.dao.AlunoDAO;
import sistema.dao.ProfessorDAO;


public class DaoFactory {
	private static DaoFactory factory;
	private static AbstractDaoFactory daoFactory;

	public static DaoFactory get() {
		if (factory == null) {
			factory = new DaoFactory();
		}
		daoFactory = new JDBCDaoFactory();
		return factory;
	}
	
	public AlunoDAO alunoDao(){
		return daoFactory.alunoDao();
	}
	
	public ProfessorDAO professorDao(){
		return daoFactory.professorDao();
	}
}