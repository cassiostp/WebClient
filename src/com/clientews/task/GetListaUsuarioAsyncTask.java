package com.clientews.task;

import java.util.List;

import android.os.AsyncTask;

import com.clientews.Interface.GetListaUsuarioInterface;
import com.clientews.acessows.UsuarioREST;
import com.clientews.entidade.Usuario;

public class GetListaUsuarioAsyncTask extends AsyncTask<Void, Void, List<Usuario>> {
	
	private GetListaUsuarioInterface glui;
	

	public GetListaUsuarioAsyncTask(GetListaUsuarioInterface glui) {
		super();
		this.glui = glui;
	}

	@Override
	protected List<Usuario> doInBackground(Void... params) {
		UsuarioREST ur = new UsuarioREST();
		List<Usuario> usuarios;
		try {
			usuarios = ur.getUsuario();
			return usuarios;
		} catch (Exception e) {
			
			return null;
		}
		
	}
	
	@Override
	protected void onPostExecute(List<Usuario> result) {
		glui.listaUsuarioHandler(result);
		super.onPostExecute(result);
	}

}
