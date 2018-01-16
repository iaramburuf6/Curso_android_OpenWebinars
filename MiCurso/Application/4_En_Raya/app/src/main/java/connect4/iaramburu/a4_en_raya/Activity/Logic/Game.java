package connect4.iaramburu.a4_en_raya.Activity.Logic;

import java.util.Random;

public class Game {
	public static final int NFILAS = 6;
	public static final int NCOLUMNAS = 7;
	public static final int VACIO = 0;
	public static final int MAQUINA = 1;
	private final String MAQUINASTR = "1111";
	public static final int JUGADOR = 2;
	private final String JUGADORSTR = "2222";
	private int tablero[][];
	private boolean juego_activo = true;

	public Game() {
		tablero = new int[NFILAS][NCOLUMNAS];
		for (int i = 0; i < NFILAS; i++)
			for (int j = 0; j < NCOLUMNAS; j++)
				tablero[i][j] = VACIO;
	}

	public void setVacio(int i, int j){
		tablero[i][j]=VACIO;
	}
	public void setJugador(int i, int j) {
		tablero[i][j] = JUGADOR;
	}

	public int getTablero(int i, int j) {
		return tablero[i][j];
	}

    /*************************************************************************
    Parametros: indices i y j del tablero.
    Retorno: cierto si la posicion tablero[i][j] esta vacia (su valor
    es VACIO) y falso en caso contrario
    *************************************************************************/
	/* Retorno: cierto si la posicion tablero[i][j] esta vacia (su valor
    es VACIO) y falso en caso contrario */
   public boolean estaVacio(int i, int j) 
   {
   	if(tablero[i][j]!=VACIO)
   	{
   		return false;
   	}
   	
   	return true;
   }

	public boolean estaMaquina(int i, int j) {
		return tablero[i][j] == MAQUINA;
	}

	/* Retorno: cierto si la posicion tablero[i][j] esta ocupada por el
    jugador (su valor es JUGADOR) y falso en caso contrario */
   public boolean estaJugador(int i, int j) 
   {
   	if(tablero[i][j]==JUGADOR)
   	{
   		return true;
   	}
   	
       return false;
   }

	public boolean tableroLleno() {

		for (int i = 0; i < NFILAS; i++)
			for (int j = 0; j < NCOLUMNAS; j++)
				if (tablero[i][j] == VACIO)
					return false;

		return true;
	}

	public boolean finalJuego() {
		if (tableroLleno() || !juego_activo)
			return true;

		return false;
	}

	 /* Retorno: cierto si se puede colocar ficha en la posicion (i,j) del
    tablero. Debes comprobar que esa posicion del tablero esta vacia
    (su valor es VACIO) y que es la posicion vacia mas baja del tablero.
    En caso contrario, la funcion debe devolver false. */
   public int sePuedeColocarFicha(int i, int j, int jugador)
   {
		// Si la posicion del tablero esta ocupada
		if(tablero[i][j]!=VACIO)
		{
			return 0;
		}
		else
		{
			// Si la posicion del tablero no es la más baja libre
			for(int k=NFILAS-1;k>i;k--)
			{
				if(tablero[k][j]==VACIO)
				{
					tablero[k][j]=jugador;
					return 2;
				}
			}
		}

		return 1;
   }

	public void juegaMaquina() {
		int i;
	       int fila = -1, columna;
	       Random r = new Random();
	
	       do {
	           columna = r.nextInt(NCOLUMNAS);
	
	           for (i = NFILAS-1; i >=0; i--)
	               if (tablero[i][columna] == VACIO) {
	                   fila = i;
	                   break;
	               }
	       } while (fila < 0);
	
	       tablero[fila][columna] = MAQUINA;
	}

	public boolean comprobarCuatro(int turno) {
		if (comprobarFilas(turno) || comprobarColumnas(turno) || comprobarDiagonales(turno)) {
			juego_activo = false;
			return true;
		}
		return false;
	}

	public boolean comprobarFilas(int turno) {
		String cadena = turno == MAQUINA ? MAQUINASTR : JUGADORSTR;

		for (int i = 0; i < NFILAS; i++) {
			String str = "";
			for (int j = 0; j < NCOLUMNAS; j++)
				str += Integer.toString(tablero[i][j]);
			if (str.contains(cadena))
				return true;
		}

		return false;
	}

	/*Parametro: turno que puede ser MAQUINA o JUGADOR.
    Retorno: true si se el jugador correspondiente al turno tiene cuatro fichas
    contiguas verticalmente, o false en caso contrario.*/
	
	boolean comprobarColumnas(int turno)
	{
		// Coloca aqui tu codigo
		String cadena = turno == MAQUINA ? MAQUINASTR : JUGADORSTR;

		for (int i =0; i < NCOLUMNAS; i++) {
			String str = "";
			for (int j = 0; j < NFILAS; j++)
			{
				str += Integer.toString(tablero[j][i]);
			}
			if (str.contains(cadena))
			{
				return true;
			}
		}
		
		return false;
	}

	boolean comprobarDiagonales(int turno) {
		String cadena = turno == MAQUINA ? MAQUINASTR : JUGADORSTR;

		// Diagonal de izquierda a derecha
		for (int i = 0; i < 3; i++) {
			String str = "";
			for (int k = 0; k < NFILAS - i; k++)
				str += Integer.toString(tablero[i + k][k]);
			if (str.contains(cadena))
				return true;
		}

		for (int j = 1; j < 4; j++) {
			String str = "";
			for (int k = 0; k < NCOLUMNAS - j; k++)
				str += Integer.toString(tablero[k][j + k]);
			if (str.contains(cadena))
				return true;
		}

		// Diagonal de derecha a izquierda (Diagonal superior)
		for (int i = 0; i < 3; i++) {
			String str = "";
			int add=0;
			for (int k = NFILAS-i-1; k>=0 ; k--) {
				str += Integer.toString(tablero[k][add]);
				add++;
			}
			if (str.contains(cadena))
				return true;
		}

		// Diagonal de derecha a izquierda (Diagonal inferior)
		for (int j = 1; j < 4; j++) {
			String str = "";
			int add=0;
			for (int k = 0; k < NCOLUMNAS - j; k++) {
				str += Integer.toString(tablero[NFILAS - add - 1][j + k]);
				add++;
			}
			if (str.contains(cadena))
				return true;
		}

		return false;
	}
	
    /*************************************************************************
    Completa este metodo.
    El metodo debe eliminar las fichas de todas las posiciones del tablero y
    ajustar el estado del juego como activo.
    *************************************************************************/
	public void restart() 
	{
		// Coloca aqui tu codigo
		for (int i = 0; i < NFILAS; i++) 
		{
			for (int j = 0; j < NCOLUMNAS; j++)
			{
				tablero[i][j]=VACIO;
			}
		}
		juego_activo=true;
	}
}
