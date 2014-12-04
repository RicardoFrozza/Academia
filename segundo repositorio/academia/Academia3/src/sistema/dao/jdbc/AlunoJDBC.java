package sistema.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema.dao.AlunoDAO;
import sistema.model.aluno;

public class AlunoJDBC implements AlunoDAO {

	public void salvar(aluno aluno) {
		String sql = "insert into aluno values(null,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = ConexaoUtil.getConexao().prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getSexo());
			ps.setLong(3, aluno.getCpf());
			ps.setLong(4, aluno.getRg());
			ps.setLong(5, aluno.getTelefone());
			ps.setLong(6, aluno.getCelular());
			ps.setString(7, aluno.getEndereco());
			ps.setString(8, aluno.getEmail());
			ps.setString(9, aluno.getCidade());
			ps.setString(10, aluno.getCep());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(aluno aluno) {
		String sql = "update aluno set nome=?,sexo=?,cpf=?,rg=?,telefone=?,celular=?,endereco=?,email=?,cidade=?,cep=?, where idAluno=?";
		try {
			PreparedStatement ps = ConexaoUtil.getConexao().prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getSexo());
			ps.setLong(3, aluno.getCpf());
			ps.setLong(4, aluno.getRg());
			ps.setLong(5, aluno.getTelefone());
			ps.setLong(6, aluno.getCelular());
			ps.setString(7, aluno.getEndereco());
			ps.setString(8, aluno.getEmail());
			ps.setString(9, aluno.getCidade());
			ps.setString(10, aluno.getCep());
			ps.setInt(11, aluno.getCodigo());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(aluno aluno) {
		String sql = "delete from aluno where idAluno=?";
		try {
			PreparedStatement ps = ConexaoUtil.getConexao().prepareStatement(sql);
			ps.setInt(1, aluno.getCodigo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public aluno get(Integer codigo) {
		aluno aluno = new aluno();
		String sql = "select*from aluno where idAluno=?";
		try {
			PreparedStatement ps = ConexaoUtil.getConexao().prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			rs.next();
			aluno.setCodigo(rs.getInt("idProfessor"));
			aluno.setNome(rs.getString("nome"));
			aluno.setSexo(rs.getString("sexo"));
			aluno.setCpf(rs.getLong("cpf"));
			aluno.setRg(rs.getLong("rg"));
			aluno.setTelefone(rs.getLong("telefone"));
			aluno.setCelular(rs.getLong("celular"));
			aluno.setEndereco(rs.getString("endereco"));
			aluno.setEmail(rs.getString("email"));
			aluno.setCidade(rs.getString("cidade"));
			aluno.setCep(rs.getString("cep"));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aluno;
	}

	public List<aluno> listarTodos() {
		List<aluno> alunos = new ArrayList<>();
		String sql = "select*from aluno";
		try {
			PreparedStatement ps = ConexaoUtil.getConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				aluno aluno = new aluno();
				aluno.setCodigo(rs.getInt("idAluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setCpf(rs.getLong("cpf"));
				aluno.setRg(rs.getLong("rg"));
				aluno.setTelefone(rs.getLong("telefone"));
				aluno.setCelular(rs.getLong("celular"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setEmail(rs.getString("email"));
				aluno.setCidade(rs.getString("cidade"));
				aluno.setCep(rs.getString("cep"));
				
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}

	@Override
	public void remover(int idContato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(aluno aluno) {
		// TODO Auto-generated method stub
		
	}
}