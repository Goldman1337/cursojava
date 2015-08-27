package com.comics.app.Controller;

import java.util.List;

import com.comics.app.Dao.UsuarioDao;
import com.comics.app.Model.Usuario;

public class UsuarioController {
	
	UsuarioDao usuariodao = new UsuarioDao();
	
	public boolean login(String username, String password) {
		if (username.equals("Sheldon") && password.equals("Bazzinga")) {
			return true;
		}
		return false;
	}
	
	public boolean addUsuario (Usuario l) {
		boolean rta = usuariodao.add(l);
		
		return rta;
	}
	
	public List<Usuario> getAll() {
		List<Usuario> list = usuariodao.getAll();
		return list;
	}
	
	public boolean delete(int key) {
		boolean rta = usuariodao.delete(key);		
		return rta;
	}
	
	public Usuario get (int key) {
		Usuario l = new Usuario();
		l = usuariodao.get(key);
		return l;
	}
	
	public boolean update(Usuario l) {
		boolean rta = usuariodao.update(l);
		return rta;
	}
}
