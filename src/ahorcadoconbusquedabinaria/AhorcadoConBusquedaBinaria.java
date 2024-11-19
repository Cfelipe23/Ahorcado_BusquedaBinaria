package ahorcadoconbusquedabinaria;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AhorcadoConBusquedaBinaria {

    public static void main(String[] args) {
        System.out.println("-------------------------------");
        System.out.println("{ Ahorcado con busqueda Binaria }");
        System.out.println("-------------------------------");
        ahorcadoPersonaje(7);
    }

    public static void ahorcadoPersonaje(int intentos) {
        Scanner scanner = new Scanner(System.in);

        // Generar nombre aleatorio
        String[] nombre = separarNombre(nombreAleatoreo());
        
        // Inicializar el arreglo completandoNombre con guiones bajos
        String[] completandoNombre = new String[nombre.length];
        for (int i = 0; i < completandoNombre.length; i++) {
            completandoNombre[i]="_";
        }

        System.out.println("Tienes 6 intentos: ");
        mostrarMuñeco(intentos);  // Mostrar muñeco con los intentos iniciales

        // Bucle principal
        while (intentos > 0) {
            System.out.print("Ingrese letra: ");
            String caracter = scanner.next();

            // Llamar a la busqueda binaria en una copia ordenada del nombre
            if (BusquedaBinariaCaracter(nombre, caracter)) {
                // Si el caracter esta en el nombre, actualizar completandoNombre
                for (int i = 0; i < nombre.length; i++) {
                    if (nombre[i].equals(caracter)) {
                        completandoNombre[i] = caracter; 
                    }
                }

                // Muestra el progreso del jugador
                mostrarProgreso(completandoNombre);

                // Verificar si el jugador ha ganado
                if (Arrays.equals(nombre, completandoNombre)) {
                    System.out.println("¡Felicidades, has ganado!");
                    break;
                }
            } else {
                // Si la letra no esta en el nombre, restar intentos
                intentos--;
                System.out.println("¡Letra incorrecta! Te quedan " + intentos + " intentos.");
                mostrarMuñeco(intentos);
            }
        }

        // Mensaje final si se quedan sin intentos
        if (intentos == 0) {
            System.out.println("¡Te has quedado sin intentos! Has perdido.");
        }
    }

    // Funcion para mostrar el progreso del nombre adivinado
    public static void mostrarProgreso(String[] completandoNombre) {
        for (String letra : completandoNombre) {
            System.out.print(letra + " ");  // Mostrar letra o "_" si no fue adivinada
        }
        System.out.println();
    }

   
    // Funcion para separar el nombre en un arreglo de letras
    public static String[] separarNombre(String nombre) {
        return nombre.split("");
    }

    // Funcion que retorna un nombre aleatorio de una lista
    public static String nombreAleatoreo() {
        Random random = new Random();

        String[] listaNombres = {"mateo", "felipe", "karen", "Arturo","fernando"};
        int tamanoLista = listaNombres.length;
        return listaNombres[random.nextInt(tamanoLista)];
    }

    // Funcion de busqueda binaria para encontrar el caracter en el nombre
    public static boolean BusquedaBinariaCaracter(String[] nombre, String caracter) {
        // Hacer una copia del arreglo para ordenarlo 
        //{se hace copia para mostrar el original mientras se va llenando}
        String[] nombreOrdenado = Arrays.copyOf(nombre, nombre.length);
        Arrays.sort(nombreOrdenado);  // Ordenamos la copia para usar la busqueda binaria

        int inicio = 0;
        int fin = nombreOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (nombreOrdenado[medio].equals(caracter)) {
                return true;  // Se encontro el caracter
            }
            if (nombreOrdenado[medio].compareTo(caracter) < 0) {
                inicio = medio + 1;  // buscar en la mitad derecha
            } else {
                fin = medio - 1;  // buscar en la mitad izquierda
            }
        }
        return false;  // No se encontro el caracter
    }
    
     // Funcion para mostrar el muñeco en base a los intentos restantes
    public static void mostrarMuñeco(int intentos) {
        switch (intentos) {
            case 7:
                System.out.println("_______");
                System.out.println("|     ");
                System.out.println("|     ");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|    ");
                break;
            case 6:
                System.out.println("_______");
                System.out.println("|     |");
                System.out.println("|     ");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|    ");
                break;
            case 5:
                System.out.println("_______");
                System.out.println("|     |");
                System.out.println("|     O");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|    ");
                break;
            case 4:
                System.out.println("_______");
                System.out.println("|     |");
                System.out.println("|     O");
                System.out.println("|     |");
                System.out.println("|    ");
                System.out.println("|    ");
                break;
            case 3:
                System.out.println("_______");
                System.out.println("|     |");
                System.out.println("|     O");
                System.out.println("|    /|");
                System.out.println("|     ");
                System.out.println("|    ");
                break;
            case 2:
                System.out.println("_______");
                System.out.println("|     |");
                System.out.println("|     O");
                System.out.println("|    /|\\");
                System.out.println("|     ");
                System.out.println("|    ");
                break;
            case 1:
                System.out.println("_______");
                System.out.println("|     |");
                System.out.println("|     O");
                System.out.println("|    /|\\");
                System.out.println("|    /");
                System.out.println("|    ");
                break;
            case 0:
                System.out.println("_______");
                System.out.println("|     |");
                System.out.println("|     O");
                System.out.println("|    /|\\");
                System.out.println("|    / \\");
                System.out.println("|    ");
                System.out.println("¡Has perdido!");
                break;
            default:
                break;
        }
    }

    
}
