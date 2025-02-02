package com.miapp.bibloteca.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.miapp.bibloteca.Libro;
import com.miapp.bibloteca.Usuario;
import com.miapp.bibloteca.service.LibroServicio;
import com.miapp.bibloteca.service.UsuarioServicio;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Libro> bibloteca = new ArrayList<>();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		LibroServicio libroServicio = new LibroServicio(bibloteca);
		libroServicio.generarLibros();
		
		UsuarioServicio usuarioServicio = new UsuarioServicio(usuarios);
		usuarioServicio.generarUsuarios();
		
		Scanner scanner = new Scanner(System.in);
		
		int opcion;
		
		do {
			System.out.println("=========BIBLOTECA VIRTUAL=========");
	        System.out.println(("1. Crear Libro.\n"
	        		+ "2. Actualizar Libro.\n"
	        		+ "3. Buscar Libro por ISBN.\n"
	        		+ "4. Buscar Libros por Titulo.\n"
	        		+ "5. Listar todos los Libros.\n"
	        		+ "6. Listar todos los Libros disponibles a prestar.\n"
	        		+ "7. Eliminar Libro.\n"
	        		+ "8. Prestamos.\n"
	        		+ "9. Devulociones.\n"
	        		+ "10. Crear Usuario.\n"
	        		+ "11. Actualizar Usuario.\n"
	        		+ "12. Listar todos los Usuarios.\n"
	        		+ "13. Eliminar Usuario.\n"
	        		+ "0. Salir."
	        		));
	        System.out.println("Seleccione una opcion: ");
	        opcion = scanner.nextInt();
	        scanner.nextLine();
	        switch(opcion) {
	        case 0:
	        	System.out.println("Gracias por usar Bibloteca Virtual. ¡Hasta luego!");
	        	break;
	        case 1:
	        	pedirDatosParaCrearLibro(scanner, libroServicio);
	        	break;
	        case 2:
	        	pedirDatosParaActualizarLibro(scanner, libroServicio);
	        	break;
	        case 3:
	        	pedirIsbnParaBuscar(scanner, libroServicio);
	        	break;
	        case 4:
	        	pedirTituloParaBuscar(scanner, libroServicio);
	        	break;
	        case 5:
	        	libroServicio.mostrarTodosLosLibros();
	        	break;
	        case 6:
	        	libroServicio.mostrarTodosLosLibrosDisponibles();
	        	break;
	        case 7:
	        	pedirIsbParaEliminar(scanner, libroServicio);
	        	break;
	        case 8:
	        	pedirDatosParaElPrestamo(scanner, usuarioServicio, libroServicio);
	        	break;
	        case 9:
	        	pedirDatosParaLaDevolucion(scanner, usuarioServicio, libroServicio);
	        	break;
	        case 10:
	        	pedirDatosParaCrearUsuario(scanner, usuarioServicio);
	        	break;
	        case 11:
	        	pedirDatosParaActualizarUsuario(scanner, usuarioServicio);
	        	break;
	        case 12:
	        	usuarioServicio.mostrarTodosLosUsuarios();
	        	break;
	        case 13:
	        	pedirIdParaEliminarUsuario(scanner, usuarioServicio);
	        	break;
	        default:
	        	System.out.println("Opción no válida. Intente de nuevo.");
	        	break;
	        }
	        	
		}while(opcion != 0);
	}
	
	public static void pedirDatosParaCrearLibro(Scanner scanner, LibroServicio libroServicio) {
		System.out.println("Ingrese el titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el autor: ");
        String autor = scanner.nextLine();
        System.out.println("Ingrese el ISBN: ");
        String isbn = scanner.nextLine();
        System.out.println("Ingrese el genero: ");
        String genero = scanner.nextLine();
        libroServicio.crearLibro(titulo, autor, isbn, genero);
    }
	
	public static void pedirDatosParaActualizarLibro(Scanner scanner, LibroServicio libroServicio) {
        System.out.println("Ingrese el ISBN del libro a actualizar: ");
        String isbnActualizar = scanner.nextLine();
        System.out.println("Ingrese el nuevo titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el nuevo autor: ");
        String autor = scanner.nextLine();
        System.out.println("Ingrese el nuevo genero: ");
        String genero = scanner.nextLine();
        libroServicio.actualizarLibro(isbnActualizar, titulo, autor, genero);
    }
	
	public static void pedirIsbnParaBuscar(Scanner scanner, LibroServicio libroServicio) {
		System.out.println("Ingrese el ISBN del libro a buscar: ");
        String isbnBuscar = scanner.nextLine();
        Libro libroISBN = libroServicio.buscarLibroPorISBN(isbnBuscar);
        if(libroISBN != null) {
        	System.out.println("Libro encontrado: "+libroISBN.getTitulo()+"\n"
        			+ "ISBN: "+libroISBN.getISBN()+"\n"
        			+ "Autor: "+libroISBN.getAutor()+"\n"
        			+ "Genero: "+libroISBN.getGenero());
        }
        else {
        	System.out.println("Libro no encontado!!!");
        }
	}
	
	public static void pedirTituloParaBuscar(Scanner scanner, LibroServicio libroServicio) {
		System.out.println("Ingrese el titulo del libro a buscar: ");
        String tituloBuscar = scanner.nextLine();
        ArrayList<Libro> librosPortitulo = libroServicio.buscarLibrosPortitulo(tituloBuscar);
        if(librosPortitulo != null) {
        	System.out.println("Libros encontrados: ");
        	for (int i = 0; i < librosPortitulo.size(); i++) {
    			System.out.println("==========================================");
    	        Libro libro = librosPortitulo.get(i);
    	        String disponible = libro.isDisponible()?"SI":"NO";
    	        System.out.println((i+1)+". Libro: "+libro.getTitulo()+"\n"
    	        		+ "Autor: "+libro.getAutor()+"\n"
    	        		+ "ISBN: "+libro.getISBN()+"\n"
    	        		+ "Genero: "+libro.getGenero()+"\n"
    	        		+ "Disponible: "+disponible);
    	    }
        }
        else {
        	System.out.println("Libro no encontado con el titulo: "+tituloBuscar+".");
        }
	}
	
	public static void pedirIsbParaEliminar(Scanner scanner, LibroServicio libroServicio) {
		System.out.println("Ingrese el ISBN del libro a eliminar: ");
        String isbnEliminar = scanner.nextLine();
        libroServicio.eliminarLibro(isbnEliminar);
	}
	
	public static void pedirDatosParaElPrestamo(Scanner scanner, UsuarioServicio usuarioServicio, LibroServicio libroServicio) {
		System.out.println("Ingrese el número de identificación del usuario: ");
		String idUsuario = scanner.nextLine();
		Usuario usuarioPrestamo = usuarioServicio.buscarUsuarioPorId(idUsuario);
		if(usuarioPrestamo != null) {
			System.out.println("Ingrese el ISBN del libro a prestar: ");
			String isbnPrestamo = scanner.nextLine();
			Libro libroPrestamo = libroServicio.buscarLibroPorISBN(isbnPrestamo);
			if(libroPrestamo != null) {
				if(libroServicio.verificarDisponibilidad(libroPrestamo)) {
					usuarioServicio.prestarLibro(usuarioPrestamo, libroPrestamo);
					System.out.println("Préstamo exitoso:\n"
							+ "Libro: "+libroPrestamo.getTitulo()+"\n"
							+ "Prestado a: "+usuarioPrestamo.getNombre());
				}
				else {
					System.out.println("El libro no está disponible para el préstamo.");
				}
			}
			else {
				System.out.println("Libro no encontrado.");
			}
		}
		else {
			System.out.println("Usuario no encontrado!!!");
		}
	}
	
	public static void pedirDatosParaLaDevolucion(Scanner scanner, UsuarioServicio usuarioServicio, LibroServicio libroServicio) {
		System.out.println("Ingrese el número de identificación del usuario: ");
		String idUsuario = scanner.nextLine();
		Usuario usuarioDevolucion = usuarioServicio.buscarUsuarioPorId(idUsuario);
		if(usuarioDevolucion != null) {
			System.out.println("Ingrese el ISBN del libro a devolver: ");
			String isbnDevolucion = scanner.nextLine();
			Libro libroDevolucion = libroServicio.buscarLibroPorISBN(isbnDevolucion);
			if(libroDevolucion != null) {
				usuarioServicio.devolverLibro(usuarioDevolucion, libroDevolucion);
				System.out.println("Devolucion exitosa:\n"
						+ "Libro: "+libroDevolucion.getTitulo()+"\n"
						+ "Prestado a: "+usuarioDevolucion.getNombre());
			}
			else {
				System.out.println("Libro no encontrado!!!");
			}
		}
		else {
			System.out.println("Usuario no encontrado!!!");
		}
	}
	
	public static void pedirDatosParaCrearUsuario(Scanner scanner, UsuarioServicio usuarioServicio) {
		System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el id: ");
        String id = scanner.nextLine();
        usuarioServicio.crearUsuario(nombre, id);
    }
	
	public static void pedirDatosParaActualizarUsuario(Scanner scanner, UsuarioServicio usuarioServicio) {
		System.out.println("Ingrese el id del usuario para actualizar el nombre: ");
        String id = scanner.nextLine();
		System.out.println("Ingrese el nuevo nombre: ");
        String nombre = scanner.nextLine();
        usuarioServicio.actualizarUsuario(id, nombre);
    }
	
	public static void pedirIdParaEliminarUsuario(Scanner scanner, UsuarioServicio usuarioServicio) {
		System.out.println("Ingrese el id del usuario a eliminar: ");
        String idEliminar = scanner.nextLine();
        usuarioServicio.eliminarUsuario(idEliminar);
	}
}
