class Libro{
	//Atributos
	private int edicion;
	private int año;
	private int cantidad;
	private int prestados;

	private String nombre;
	private String autor;
	private String editorial;
	private String genero;
	
	private int clave;

	//Constructores
		public Libro(){
			
		}
	
	//Metodos

	public void Capturar() {
		nombre= Teclado.cadena("Nombre del Libro:");
		autor= Teclado.cadena("Nombre del autor:");
		editorial= Teclado.cadena("Editorial:");
		edicion= Teclado.entero("Edicion:");
		genero= Teclado.cadena("Genero:");
		clave= Teclado.entero("Clave:");
		cantidad= Teclado.entero("Cantidad: ");
		prestados = 0;	//Uriel//
	}

	public void Listar() {	//General
        System.out.println("-------------------------------------------------");
		  System.out.println("<"+nombre+">\t"+autor+"\tEd. "+editorial+"\t\nEdicion: "+edicion+"\t\nGenero: "+genero+"\t\nClave: "+clave+"\t\nCantidad/Prestados: "+cantidad+"/"+prestados);
	}

	public void Actualizar(){
		int opcion;
		do {
			opcion= Menu.ImprimeMenu("Actualizar Libro.\n1)Nombre\n2)Autor\n3)Editorial\n4)Edicion\n5)Genero\n6)Clave\n7)Cantidad\n8)Salir\nOpcion:",8);
			switch (opcion){
				case 1:
					nombre= Teclado.cadena("Nombre del Libro:");
					break;
				case 2:
					autor= Teclado.cadena("Nombre del autor:"); 
					break;
				case 3:
					editorial= Teclado.cadena("Editorial:");
					break;
				case 4:
					edicion= Teclado.entero("Edicion:");
					break;
				case 5:
					genero= Teclado.cadena("Genero:");
					break;
				case 6:
					clave= Teclado.entero("Clave:");
					break;
				case 7:		//uriel//
					System.out.println("La cantidad total (actual) de libros de <<"+nombre+">> son: "+cantidad);
					cantidad= Teclado.entero("Introduzca una nueva cantidad: ");
					break;	//uriel//
			   }
		}while(opcion != 8);
	}
	
//Uriel//
	//Estos get se usan en Biblioteca al buscar.
	public int getClave(){
		return clave;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getAutor(){
		return autor;
	}
	
	public String getGenero(){
		return genero;
	}
	
	public int getCantidad(){
		return cantidad;
	}
	
	public void setPrestado(int prestamo){
		prestados=prestamo;
		return;
	}
//Uriel//
}