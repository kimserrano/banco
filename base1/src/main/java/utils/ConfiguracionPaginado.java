/*
 * Paquete utilizado para clases de utilidad
 */
package utils;

/**
 * Clase que muestra los atributos y métodos de acceso para el paginado del
 * historial de transacciones de una cuenta
 *
 * @author Elmer y Kim
 */
public class ConfiguracionPaginado {

    /**
     * El numero de pagina indica la página actual en la que se encuentra el
     * paginado
     */
    private int numeroPagina;
    /**
     * El conteo por pagina indica el número de elementos que se mostrarán en la
     * página
     */
    private int conteoPorPagina;

    /**
     * Constructor por defecto que setea el numeroPagina=0 y conteoPorPagina=5
     */
    public ConfiguracionPaginado() {
        this.numeroPagina = 0;
        this.conteoPorPagina = 5;
    }

    /**
     * Constructor que recibe un numeroPagina y un conteoPorPagina
     *
     * @param numeroPagina El numero de pagina indica la página actual en la que
     * se encuentra el paginado
     * @param conteoPorPagina El conteo por pagina indica el número de elementos
     * que se mostrarán en la página
     */
    public ConfiguracionPaginado(int numeroPagina, int conteoPorPagina) {
        this.numeroPagina = numeroPagina;
        this.conteoPorPagina = conteoPorPagina;
    }

    /**
     * Regresa el numero de pagina actual
     *
     * @return int con valor del numero de pagina actual
     */
    public int getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * Setter para cambiar el numero de pagina
     *
     * @param numeroPagina El numero de pagina indica la página actual en la que
     * se encuentra el paginado
     */
    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }
    /**
     * Getter que regresa el conteo por pagina actual
     * @return int con valor del conteo por pagina
     */
    public int getConteoPorPagina() {
        return conteoPorPagina;
    }
    /**
     * Setter para cambiar el conteo por pagina
     * @param conteoPorPagina  El conteo por pagina indica el número de elementos
     * que se mostrarán en la página
     */
    public void setConteoPorPagina(int conteoPorPagina) {
        this.conteoPorPagina = conteoPorPagina;
    }
    /**
     * Getter que regresa los elementos a saltar 
     * @return regresa los elementos a saltar resultado de la multiplicación del numeroPagina * conteoPorPagina
     */
    public int getElementosASaltar() {
        return this.numeroPagina * this.conteoPorPagina;
    }
/** 
 * Aumenta en 1 el numeroPagina para avanzar a la siguiente
 */
    public void avanzarPagina() {
        this.numeroPagina++;
    }
    /**
     * Retrocede la página actual en 1, si la página actual es igual o menor a 0 no lo hace.
     */
    public void retrocederPagina() {
        if (this.numeroPagina > 0) {
            this.numeroPagina--;
        }
    }

}
