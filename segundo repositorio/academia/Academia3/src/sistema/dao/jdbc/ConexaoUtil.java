package sistema.dao.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {
	private static Connection conexao;

	static {
		String url = "jdbc:mysql://127.0.0.1:3306/Academia";
		String user = "root";
		String senha = "";
		try {
			conexao = DriverManager.getConnection(url, user, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConexao() {
		return conexao;
	}
}