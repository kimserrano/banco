/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *Clase que representa una excepción de Persistencia utilizada en metodos varios
 * @author Kim y Elmer
 */
public class PersistenciaException extends Exception {
/**
 * Constructor por defecto...
 */
    public PersistenciaException() {
    }
/**
 * Constructor que manda un mensaje
 * @param message  mensaje
 */
    public PersistenciaException(String message) {
        super(message);
    }
/**
 * Constructor que manda un mensaje y causa
 * @param message mensaje
 * @param cause  cuasa
 */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
/**
 * Constructor que solo manda una causa
 * @param cause  causa
 */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }
/**
 * Constructor que manda un mensaje, una causa, y puede habilitar supression además de el writable StackTrace
 * @param message Mensaje
 * @param cause Causa
 * @param enableSuppression Supresión
 * @param writableStackTrace  WritableStackTrace
 */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
