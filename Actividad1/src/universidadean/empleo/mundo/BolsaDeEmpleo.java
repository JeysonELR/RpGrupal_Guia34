/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnología de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en un Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Bolsa de Empleo
 * Fecha: 11 de marzo de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.empleo.mundo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Es la clase que se encarga de manejar y organizar los aspirantes <br>
 * <b>inv: </b> <br>
 * aspirantes != null <br>
 * En el vector de aspirantes no hay dos o más con el mismo nombre
 */
public class BolsaDeEmpleo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los aspirantes
     */
    private ArrayList<Aspirante> aspirantes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva bolsa de emplea sin aspirantes.
     */
    public BolsaDeEmpleo() {
        aspirantes = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de aspirantes. La lista retornada no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     *
     * @return lista de aspirantes
     */
    public ArrayList<Aspirante> darAspirantes() {
        ArrayList<Aspirante> copia = new ArrayList<>(aspirantes);
        return copia;
    }

    /**
     * Agrega un nuevo aspirante a la bolsa
     *
     * @param nombreA           El nombre del aspirante - nombreA != null
     * @param profesionA        La profesión del aspirante - profesionA es uno de estos { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA Años de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA             La edad del aspirante - edadA > 0
     * @param telefonoA         El teléfono del aspirante - telefonoA != null
     * @param imagenA           La ruta a la imagen del aspirante - imagenA != null
     * @return Se retornó true si el aspirante fue adicionado o false de lo contrario
     */

    public boolean agregarAspirante(String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA) {
        int aspiranteBuscado = buscarAspirante(nombreA);
        boolean agregado = false;
        if (aspiranteBuscado == -1) {
            Aspirante nuevoAspirante = new Aspirante(nombreA, profesionA, aniosExperienciaA, edadA, telefonoA, imagenA);
            aspirantes.add(nuevoAspirante);
            agregado = true;
        }
        return agregado;
    }

    /**
     * Organiza la lista de aspirantes por nombre usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de aspirantes está ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre() {
        // TODO: Realizar el ejercicio correspondiente

        System.out.println("Los nombres de los aspirantes en orden son :");
        String temp;
        int area = aspirantes.size();
        for (int h = 0; h < area; h++) {          // Gestionando el proceso de los elementos hasta los más pesados.
            for (int i = h + 1 ; i < area; i++) {  // Ordena los elementos gestionados.
                if (aspirantes.get(h).darNombre().compareTo(aspirantes.get(i).darNombre())> 0) {
                    Aspirante aux = aspirantes.get(i);
                    aspirantes.set(i, aspirantes.get(h));
                    aspirantes.set(h, aux);
                }
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por edad usando el algoritmo de selección <br>
     * <b>post: </b>La lista de aspirantes está ordenada por edad
     */
    public void ordenarPorEdad() {
        // TODO: Realizar el ejercicio correspondiente
        int area = aspirantes.size();
        for (int i = 0; i < area - 1; ++i) {
            int menor = Integer.MAX_VALUE;
            int posMenor = -1;
            for (int j = i ; j < area; ++j) {
                if (aspirantes.get(j).darEdad() < menor){
                    menor = aspirantes.get(j).darEdad();
                    posMenor = j;
                }
            }
            Aspirante aux = aspirantes.get(i);
            aspirantes.set(i, aspirantes.get(posMenor));
            aspirantes.set(posMenor, aux);
        }
    }

    /**
     * Organiza la lista de aspirantes por profesión usando el algoritmo de burbuja <br>
     * <b>post: </b>El conjunto de aspirantes esta ordenado por profesión
     */
    public void ordenarPorProfesion() {
        // TODO: Realizar el ejercicio correspondiente
    
        int area = aspirantes.size();
        for (int h = 0; h < area; h++) {          // Gestionando el proceso de los elementos hasta los más pesados.
            for (int i = h + 1; i < area; i++) {  // Ordena los elementos gestionados.
                if (aspirantes.get(h).darProfesion().compareTo(aspirantes.get(i).darProfesion()) > 0) {
                    Aspirante aux = aspirantes.get(i);
                    aspirantes.set(i, aspirantes.get(h));
                    aspirantes.set(h, aux);
                }
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por años de experiencia usando el algoritmo de inserción <br>
     * <b>post: </b>La lista de aspirantes está ordenada por años de experiencia
     */
    public void ordenarPorAniosDeExperiencia() {
        // TODO: Realizar el ejercicio correspondiente

        for ( int i = 0; i < aspirantes.size(); i++) {
                int posicion = i;
                Aspirante aux = aspirantes.get(i);
               while ((posicion > 0) && (aspirantes.get(posicion-1).darAniosExperiencia()) >
                       aux.darAniosExperiencia()){

                   aspirantes.set(posicion, aspirantes.get(posicion-1)).darAniosExperiencia();
                   posicion--;
                }
                aspirantes.set(posicion, aux);
        }
    }


    /**
     * Busca un Aspirante según su nombre y retorna la posición en la que se encuentra. <br>
     *
     * @param nombre El nombre del aspirante buscado - nombre!=null
     * @return Se retornó la posición donde se encuentra un aspirante con el nombre dado. Si no se encuentra ningún aspirante con ese nombre se retornó -1.
     */
    public int buscarAspirante(String nombre) {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente

        for ( int i = 0; i < aspirantes.size(); i++) {
            int pos = i;
            Aspirante aux = aspirantes.get(i);
            if (Objects.equals(nombre, aux.darNombre())){
               posicion = pos+1;
            }

        }

        return posicion;
    }

    /**
     * Busca un aspirante utilizando una búsqueda binaria. <br>
     * <b>pre: </b> La lista de aspirantes se encuentra ordenada por nombre. <br>
     *
     * @param nombre es el nombre del aspirante que se va a buscar - nombre!=null
     * @return Se retornó la posición del aspirante con el nombre dado. Si el aspirante no existe se retornó -1.
     */
    public int buscarBinarioPorNombre(String nombre) {
        int posicion = -1;
        int ini = 0;
        int fin = aspirantes.size() - 1;
        // TODO: Realizar el ejercicio correspondiente
       while (ini<=fin){
           posicion=(ini+fin)/2;
           if(Objects.equals(aspirantes.get(posicion).darNombre(), nombre)){
               return posicion+1;
           }else if (!Objects.equals(aspirantes.get(posicion).darNombre(), nombre)){
                ini = posicion+1;
           }else{
               fin =  posicion-1;
           }
       }
        return posicion;
    }

    /**
     * Busca el aspirante que tenga la menor edad en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante más joven. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMasJoven() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente


        for (int i = 0; i < aspirantes.size(); i++) {
            posicion = i;
            Aspirante aux = aspirantes.get(i);
            while ((posicion > 0) && (aspirantes.get(posicion - 1).darEdad()) >
                    aux.darEdad()) {
                aspirantes.set(posicion, aspirantes.get(posicion - 1)).darEdad();
                posicion--;
            }
            aspirantes.set(posicion, aux);
        }
        return posicion;
    }

    /**
     * Busca el aspirante que tenga la mayor edad en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante con más edad. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMayorEdad() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente

        for (int i = 0; i < aspirantes.size(); i++) {
            posicion = i;
            Aspirante aux = aspirantes.get(i);
            while ((posicion > 0) && (aspirantes.get(posicion - 1).darEdad()) <
                    aux.darEdad()) {
                aspirantes.set(posicion, aspirantes.get(posicion - 1)).darEdad();
                posicion--;
            }
            aspirantes.set(posicion, aux);
        }
        return posicion;
    }

    /**
     * Busca el aspirante con más años de experiencia en la bolsa.
     *
     * @return Se retornó la posición donde se encuentra el aspirante con mayor experiencia. Si no hay aspirantes en la bolsa se retornó -1
     */
    public int buscarAspiranteMayorExperiencia() {
        int posicion = -1;
        // TODO: Realizar el ejercicio correspondiente
        for (int i = 0; i < aspirantes.size(); i++) {
            posicion = i;
            Aspirante aux = aspirantes.get(i);
            while ((posicion > 0) && (aspirantes.get(posicion - 1).darAniosExperiencia()) <
                    aux.darAniosExperiencia()) {
                aspirantes.set(posicion, aspirantes.get(posicion - 1)).darAniosExperiencia();
                posicion--;
            }
            aspirantes.set(posicion, aux);
        }
        return posicion;
    }

    /**
     * Contrata a un aspirante.<br>
     * <b>post: </b>Se eliminó el aspirante de la lista de aspirantes.
     *
     * @param nombre El nombre del aspirante a contratar - nombre!=null
     * @return Se retornó true si el aspirante estaba registrado en la bolsa o false de lo contrario
     */
    public boolean contratarAspirante(String nombre) {
        boolean contratado = false;

        // TODO: Realizar el ejercicio correspondiente

        for ( int i = 0; i < aspirantes.size(); i++) {
            int posicion = i;
            Aspirante aux = aspirantes.get(i);
            if (Objects.equals(nombre, aux.darNombre())){
                contratado= true;
            }
        }
        return contratado;
    }

    /**
     * Elimina todos los aspirantes de la bolsa cuyos años de experiencia <br>
     * son menores a la cantidad de años especificada <br>
     *
     * @param aniosExperiencia La cantidad de años con relación a la cual se van a eliminar los aspirantes. aniosExperiencia>=0
     * @return La cantidad de aspirantes que fueron eliminados
     */
    public int eliminarAspirantesPorExperiencia(int aniosExperiencia) {
        int eliminados = 0;
        int cont = 0;
        // TODO: Realizar el ejercicio correspondiente
        for ( int i = 0; i < aspirantes.size(); i++) {
            int posicion = i;
            Aspirante aux = aspirantes.get(i);
            if (aniosExperiencia == aux.darAniosExperiencia()){
                aspirantes.remove(posicion);
                cont++;
            }
            eliminados=cont;
        }
        return eliminados;
    }
}
