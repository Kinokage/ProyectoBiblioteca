class ProyectoBiblioteca{
	public static void main (String []args){
		int num_lib, opc;
		String nom_bib;
		//Libro lib;
		
		nom_bib=Teclado.cadena("ï¿½Como se llama la Biblioteca?: ");
		num_lib=Teclado.entero("ï¿½Cuantos libros diferentes tiene capacidad la biblioteca?: ");
		
		Biblioteca biblos = new Biblioteca(nom_bib,num_lib);
		
		do{
			System.out.println("Bienvenido a la Biblioteca "+nom_bib);
			System.out.println("Que desea hacer?");
			opc=Menu.ImprimeMenu("1) Añadir libros\n2)Listar libros\n3)Prestar libros\n4) Actualizar libros\n5) Buscar libros\n6) Eliminar libros\n7) Estadisticas\n8) Salir del menu\nOpcion: ",8);
			biblos.Menu(opc);
		}while(opc!=8);
		return;
	}
}