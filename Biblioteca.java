class Biblioteca{
	//Atributos
	private String nombre;
	private Libro []arreglo;
	private int indice;
	private int cantidad_libros;
	private int total_libros;
	
	//Constructor
	public Biblioteca(String nom, int libros){
		nombre = nom;
		cantidad_libros=0;
		total_libros=0;
		arreglo = new Libro [libros];
		indice=-1;
	}
	
	//Metodos
	public boolean ValidaEspacio(){
		return (indice < arreglo.length-1);
	}
	
	public void Insertar (Libro dato){
		indice++;
		cantidad_libros++;
		arreglo[indice] = dato;
	}
	
	public void Listar(){	//general
		int i;
		for(i=0;i<=indice;i++)
			arreglo[i].Listar();
		//System.out.println();
	}
	
	public void Listar(int pos){	//Especifico/Actualizar
		arreglo[pos].Listar();
	}
	
	public int BuscarClave(int dato){
		int i,aux=0;
		for(i=0;i<=indice;i++){
			if(arreglo[i].getClave()==dato)
				aux=i;
		}
		if(aux==0){
			System.out.println("No existe el libro con clave: "+dato+" en la Biblioteca.");
			aux=-1;
		}
		return aux;
	}
	public int BuscarString(String dato, int tipo){
		int i,aux=0, x = arreglo.length;
		int []listara; int []listarg;	//listar autor, listar generos
		boolean equal=false;
		String nombre="";
		switch(tipo)
		{
			case 1:	//Nombre
				for(i=0;i<=indice;i++){
					 nombre = arreglo[i].getNombre();
					 equal = nombre.equals(dato);
					 if(equal){
						 aux=i;
						 break;
					 }
				}
				if(equal==false)
					System.out.println("No existe el libro con nombre: <<"+dato+">> en la Biblioteca.");
				break;
				
			case 2:	//Autor
				int num=0;
				aux=0;
				listara = new int [x];
				for(i=0;i<=indice;i++){
					 nombre = arreglo[i].getAutor();
					 equal = nombre.equals(dato);
					 if(equal){
						 num++;
						 listara[aux]=i;
						 aux++;
					 }
				}
				if(aux==0){
					System.out.println("No existen libros del autor <<"+dato+">> en la Biblioteca.");
				}
				else{
					System.out.println("Se encontraron "+num+" libros del autor <<"+nombre+">>:");
					for(i=0;i<=aux-1;i++)			//Lista, uno a uno, los libros de un autor igual.
						Listar(listara[i]);
				}
				break;
				
			case 3:	//Generos
				int numg=0;
				aux=0;
				listarg = new int [x];
				for(i=0;i<=indice;i++){
					 nombre = arreglo[i].getGenero();
					 equal = nombre.equals(dato);
					 if(equal){
						 numg++;
						 listarg[aux]=i;
						 aux++;
					 }
				}
				if(aux==0)
					System.out.println("No existen libros del genero <<"+dato+">> en la Biblioteca.");
				else{
					System.out.println("Se encontraron "+numg+" libros del genero <<"+nombre+">>:");
					for(i=0;i<=aux-1;i++)			//Lista, uno a uno, los libros de un autor igual.
						Listar(listarg[i]);
				}
				aux=0;
				break;
		}
		return aux;		// Para este punto, si aux es 0 se busco genero o autor y se listaron automaticamente, si aux es otra cosa es que se buscó por nombre.
	}
	
	public Libro Borrar (int pos){
		Libro aux=new Libro();
		aux=arreglo[pos];
		arreglo[pos] = arreglo[indice];
		indice--;
		return aux;
	}
	public void Menu(int opc){		//1) A�adir libros 2)Listar libros 3)Prestar libros 4) Actualizar libros 5) Buscar libros 6) Eliminar libros 7) Estadisticas 8) Salir del menu
		Libro lib;
		int aux, prest;
		String dato;
		switch(opc){
			case 1:
				 lib = new Libro();
				 lib.Capturar();
				 Insertar(lib);
				break;
			case 2:
				if(indice!=-1)
					Listar();
				else
					System.out.println("No hay libros anadidos a la Biblioteca.\n\n");
				break;
			case 3:
				aux=BuscarClave(Teclado.entero("Clave del libro a prestar: "));
				if(aux!=-1){
					do{
						prest = Teclado.entero ("¿Cuantos libros prestara?: ");
						if(prest>arreglo[aux].getCantidad())
							System.out.println("No hay suficientes libros para prestamo.");
					}while(prest>arreglo[aux].getCantidad());
					System.out.println("Se han prestado "+prest+" libros de <"+arreglo[aux].getNombre()+">.");
					arreglo[aux].setPrestado(prest);
				}
				break;
			case 4:
				aux = BuscarClave(Teclado.entero("Clave del libro a actualizar: "));
				if(aux!=-1)
					arreglo[aux].Actualizar();
				else
					System.out.println("Clave no encontrada.");
				break;
			case 5:
				aux=Buscar();
				if(aux!=-1){
					System.out.println("Se encontro el libro: ");
					Listar(aux);
				}
				break;
			case 6:
				aux = BuscarClave(Teclado.entero("Clave del libro a borrar: "));
				if(aux!=-1){
					lib=Borrar(aux);
					System.out.println("Se ha borrado el siguiente libro y todos sus datos: ");
					lib.Listar();
				}
				break;
			case 7:
			/*
				Falta saber que estadisticas usar
			*/
				System.out.println("Proximamente");
				break;
		}
		return;
	}
	public int Buscar(){
		int opc,datoInt,pos=-1;
		String datoSt;
		opc=Menu.ImprimeMenu("Tipo de busqueda:\n1)Por Clave\n2)Por Nombre\n3)Por Autor\n4)Por Genero\n5)Regresar\nOpcion:",5);
		switch(opc){
			case 1:
				datoInt=Teclado.entero("Clave: ");
				pos=BuscarClave(datoInt);
				break;
			case 2:
				datoSt=Teclado.cadena("Nombre: ");
				Listar(BuscarString(datoSt,1));
				//pos=-1;
				break;
			case 3:
				datoSt=Teclado.cadena("Autor: ");
				BuscarString(datoSt,2);
				//pos=-1;
				break;
			case 4:
				datoSt=Teclado.cadena("Genero: ");
				BuscarString(datoSt,3);
				//pos=-1;
				break;
		}
		return pos;
	}
}