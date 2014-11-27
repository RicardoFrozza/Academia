package sistema.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import sistema.dao.ProfessorDAO;
import sistema.model.Professor;

public class ProfessorJDBC implements ProfessorDAO {

	public void salvar(Professor professor) {
		String sql = "insert into professor values(null,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = ConexaoUtil.getConexao().prepareStatement(sql);
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getSexo());
			ps.setLong(3, professor.getCpf());
			ps.setLong(4, professor.getRg());
			ps.setLong(5, professor.getTelefone());
			ps.setLong(6, professor.getCelular());
			ps.setString(7, professor.getEndereco());
			ps.setString(8, professor.getEmail());
			ps.setString(9, professor.getCidade());
			ps.setString(10, professor.getCep());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Professor professor) {
		String sql = "update professor set nome=?,sexo=?,cpf=?,rg=?,telefone=?,celular=?,endereco=?,email=?,cidade=?,cep=? where idProfessor=?";
		try {
			PreparedStatement ps = ConexaoUtil.getConexao().prepareStatement(sql);
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getSexo());
			ps.setLong(3, professor.getCpf());
			ps.setLong(4, professor.getRg());
			ps.setLong(5, professor.getTelefone());
			ps.setLong(6, professor.getCelular());
			ps.setString(7, professor.getEndereco());
			ps.setString(8, professor.getEmail());
			ps.setString(9, professor.getCidade());
			ps.setString(10, professor.getCep());
			ps.setInt(11, professor.getCodigo());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Professor professor) {
		String sql = "delete from professor where idProfessor=?";
		try {
			PreparedStatement ps = ConexaoUtil.getConexao().prepareStatement(sql);
			ps.setInt(1, professor.getCodigo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Professor get(Integer codigo) {
		Professor professor = new Professor();
		String slq = "select*from professor where idProfessor=?";
		try {
			PreparedStatement ps = ConexaoUtil.getConexao().prepareStatement(slq);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			rs.next();
			professor.setCodigo(rs.getInt("idProfessor"));
			professor.setNome(rs.getString("nome"));
			professor.setSexo(rs.getString("sexo"));
			professor.setCpf(rs.getLong("cpf"));
			professor.setRg(rs.getLong("rg"));
			professor.setTelefone(rs.getLong("telefone"));
			professor.setCelular(rs.getLong("celular"));
			professor.setEndereco(rs.getString("endereco"));
			professor.setEmail(rs.getString("email"));
			professor.setCidade(rs.getString("cidade"));
			professor.setCep(rs.getString("cep"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return professor;
	}

	public List<Professor> listarTodos() {
		List<Professor> professores = new ArrayList<>();
		String sql = "select*from professor";
		try {
			PreparedStatement ps = ConexaoUtil.getConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setCodigo(rs.getInt("idProfessor"));
				professor.setNome(rs.getString("nome"));
				professor.setSexo(rs.getString("sexo"));
				professor.setCpf(rs.getLong("cpf"));
				professor.setRg(rs.getLong("rg"));
				professor.setTelefone(rs.getLong("telefone"));
				professor.setCelular(rs.getLong("celular"));
				professor.setEndereco(rs.getString("endereco"));
				professor.setEmail(rs.getString("email"));
				professor.setCidade(rs.getString("cidade"));
				professor.setCep(rs.getString("cep"));
				professores.add(professor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professores;
	}
}