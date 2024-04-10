package com.miapp.bibloteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.bibloteca.Libro;
import com.miapp.bibloteca.Usuario;


public class UsuarioServicio {
	
	private ArrayList<Usuario> usuarios;
	
	public UsuarioServicio(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void crearUsuario(String nombre, String id) {
		Usuario nuevoUsuario = new Usuario(nombre, id);
		usuarios.add(nuevoUsuario);
	}
	
	public ArrayList<Usuario> obtenerTodosLosUsuarios(){
		return usuarios;
	}
	
	public void actualizarUsuario(String id, String nuevoNombre) {
		boolean bandera = false;
		for(Usuario usuario : usuarios) {
			if(usuario.getId().equals(id)) {
				usuario.setNombre(nuevoNombre);
				bandera = true;
			}
		}
		if(bandera) {
			System.out.println("Cambios Guardados con Exito!!!");
		}
		else {
			System.out.println("El Usuario no se encontro cambios No Realiza");
		}
	}
	
	public void eliminarUsuario(String id) {
		boolean bandera = false;
		Iterator<Usuario> it=usuarios.iterator();
		while(it.hasNext()) {
			if(it.next().getId().equals(id)) {
				it.remove();
				bandera = true;
			}
		}
		if(bandera) {
			System.out.println("Usuario Eliminado con Exito!!!");
		}
		else {
			System.out.println("El suario no se encontro no se pudo Eliminar!!!");
		}
	}
	
	public void mostrarTodosLosUsuarios(){
		System.out.println("USUARIOS");
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println("==========================================");
	        Usuario usuario = usuarios.get(i);
	        System.out.println((i+1)+". ID: "+usuario.getId()+"\n"
	        		+ "Nombre: "+usuario.getNombre());
	    }
	}
	
	public Usuario buscarUsuarioPorId(String id) {
		for(Usuario usuario : usuarios) {
			if(usuario.getId().equals(id)) {
				return usuario;
			}
		}
		return null;
	}
	
	public void prestarLibro(Usuario usuario, Libro libro) {
		if(libro.isDisponible()) {
			usuario.getLibrosPrestados().add(libro);
			libro.setDisponible(false);
		}
		else {
			System.out.println("El libro no está disponible para prestamo..");
		}
	}
	
	public void devolverLibro(Usuario usuario, Libro libro) {
		if(usuario.getLibrosPrestados().contains(libro)) {
			usuario.getLibrosPrestados().remove(libro);
			libro.setDisponible(true);
		}
		else {
			System.out.println("Este libro no fue prestado a este usuario");
		}
	}
	
	public ArrayList<Libro> obtenerLibrosPrestados(Usuario usuario){
		return usuario.getLibrosPrestados();
	}
	
	public void generarUsuarios() {
		Usuario usuario1 = new Usuario("Juan", "0001");
		usuarios.add(usuario1);
        Usuario usuario2 = new Usuario("María", "0002");
        usuarios.add(usuario2);
        Usuario usuario3 = new Usuario("Carlos", "0003");
        usuarios.add(usuario3);
        Usuario usuario4 = new Usuario("Ana", "0004");
        usuarios.add(usuario4);
        Usuario usuario5 = new Usuario("Pedro", "0005");
        usuarios.add(usuario5);
	}
}
