package com.miapp.bibloteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.bibloteca.Libro;

public class LibroServicio {
	
	private ArrayList<Libro> bibloteca;
	
	public LibroServicio(ArrayList<Libro> bibloteca) {
		this.bibloteca = bibloteca;
	}
	
	public void crearLibro(String titulo, String autor, String ISBN, String genero) {
		Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
		bibloteca.add(nuevoLibro);
	}
	
	public ArrayList<Libro> obtenerTodosLosLibros(){
		return bibloteca;
	}
	
	public void actualizarLibro(String ISBN, String nuevoTitulo, String nuevoAutor, String nuevoGenero) {
		boolean bandera = false;
		for(Libro libro : bibloteca) {
			if(libro.getISBN().equals(ISBN)) {
				libro.setTitulo(nuevoTitulo);
				libro.setAutor(nuevoAutor);
				libro.setGenero(nuevoGenero);
				bandera = true;
			}
		}
		if(bandera) {
			System.out.println("Cambios Guardados con Exito!!!");
		}
		else {
			System.out.println("El libro no se encontro, cambios no realizados!!!");
		}
	}
	
	public void eliminarLibro(String ISBN) {
		boolean bandera = false;
		Iterator<Libro> it=bibloteca.iterator();
		while(it.hasNext()) {
			if(it.next().getISBN().equals(ISBN)) {
				it.remove();
				bandera = true;
			}
		}
		if(bandera) {
			System.out.println("Libro Eliminado con Exito!!!");
		}
		else {
			System.out.println("El libro no se encontro no se pudo Eliminar!!!");
		}
	}
	
	public void mostrarTodosLosLibros(){
		System.out.println("LIBROS");
		for (int i = 0; i < bibloteca.size(); i++) {
			System.out.println("==========================================");
	        Libro libro = bibloteca.get(i);
	        String disponible = libro.isDisponible()?"SI":"NO";
	        System.out.println((i+1)+". Libro: "+libro.getTitulo()+"\n"
	        		+ "Autor: "+libro.getAutor()+"\n"
	        		+ "ISBN: "+libro.getISBN()+"\n"
	        		+ "Genero: "+libro.getGenero()+"\n"
	        		+ "Disponible: "+disponible);
	    }
	}
	
	public void mostrarTodosLosLibrosDisponibles(){
		System.out.println("LIBROS DISPONIBLES");
		for (int i = 0; i < bibloteca.size(); i++) {
			System.out.println("==========================================");
	        Libro libro = bibloteca.get(i);
	        if(libro.isDisponible()) {
	        	String disponible = libro.isDisponible()?"SI":"NO";
		        System.out.println((i+1)+". Libro: "+libro.getTitulo()+"\n"
		        		+ "Autor: "+libro.getAutor()+"\n"
		        		+ "ISBN: "+libro.getISBN()+"\n"
		        		+ "Genero: "+libro.getGenero()+"\n"
		        		+ "Disponible: "+disponible);
	        }
	    }
	}
	
	public Libro buscarLibroPorISBN(String ISBN) {
		for(Libro libro: bibloteca) {
			if(libro.getISBN().equals(ISBN)) {
				return libro;
			}
		}
		return null;
	}
	
	public ArrayList<Libro> buscarLibrosPortitulo(String titulo){
		boolean bandera = false;
		ArrayList<Libro> librosEncontrados = new ArrayList<>();
		for(Libro libro : bibloteca) {
			if(libro.getTitulo().equalsIgnoreCase(titulo)) {
				librosEncontrados.add(libro);
				bandera = true;
			}
		}
		if(bandera) {
			return librosEncontrados;
		}
		else {
			return null;
		}
	}
	
	public boolean verificarDisponibilidad(Libro libro) {
		return libro.isDisponible();
	}
	
	public void generarLibros() {
		Libro libro1 = new Libro("El principito", "Antoine de Saint-Exupéry", "9781539939193", "Fábula");
		bibloteca.add(libro1);
        Libro libro2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "9788424117525", "Novela");
        bibloteca.add(libro2);
        Libro libro3 = new Libro("Cien años de soledad", "Gabriel García Márquez", "9788466331177", "Realismo mágico");
        bibloteca.add(libro3);
        Libro libro4 = new Libro("1984", "George Orwell", "9788408174219", "Ciencia ficción");
        bibloteca.add(libro4);
        Libro libro5 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "9788478884457", "Fantasía");
        bibloteca.add(libro5);
        Libro libro6 = new Libro("Orgullo y prejuicio", "Jane Austen", "9788497940104", "Novela romántica");
        bibloteca.add(libro6);
        Libro libro7 = new Libro("La sombra del viento", "Carlos Ruiz Zafón", "9788408182818", "Misterio");
        bibloteca.add(libro7);
        Libro libro8 = new Libro("Rayuela", "Julio Cortázar", "9788437602055", "Narrativa experimental");
        bibloteca.add(libro8);
        Libro libro9 = new Libro("El hobbit", "J.R.R. Tolkien", "9788499082476", "Fantasía épica");
        bibloteca.add(libro9);
        Libro libro10 = new Libro("El código Da Vinci", "Dan Brown", "9788408089825", "Suspenso");
        bibloteca.add(libro10);
	}
}
