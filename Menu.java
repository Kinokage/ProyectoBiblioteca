class Menu {
	public static int ImprimeMenu(String texto, int max) {
			int opcion;
			do {
				 opcion =Teclado.entero(texto);
				 if (opcion <1 || opcion > max)
					System.out.println("Error: opcion no valida");
			}while (opcion <1 || opcion > max);
			return opcion;	
	}
}	
