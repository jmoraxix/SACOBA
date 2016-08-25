/*
 *  Sistema de Asistencia de Control Bancario
 *  SACOBA
 *  
 *  Marcela Cascante Quiros
 *  Diego Delgado Cerdas
 *  Alejandro Loaiza Arguedas
 *  Jose David Mora Loria
 */
package sacoba.servidor.beans;

/**
 *
 * @author jmora
 */
public enum Notificacion {

    /**
     * Evento utilizado para notificar usuario al ingresar por la puerta.
     */
    ENTRA_USUARIO(1),

    /**
     *Evento utilizado para notificarle a un usuario su número de secuencia.
     */
    NOTIFICA_SECUENCIA(2),

    /**
     *Evento utilizado para actualizar el total de usuarios en la cola de plataforma.
     */
    ACTUALIZA_PLATAFORMA(3),

    /**
     *Evento utilizado para actualizar el total de usuarios en la cola de tramites.
     */
    ACTUALIZA_TRAMITES(4),

    /**
     *Evento utilizado para actualizar el total de usuarios en la cola de cuentas.
     */
    ACTUALIZA_CUENTAS(5),

    /**
     *Evento utilizado para notificar que el cliente procede a alguna caja.
     */
    AVANZA_CLIENTE(6),

    /**
     *Evento utilizado para notificar al servidor que la caja esta vacía.
     */
    LIBERAR_CAJA(7),

    /**
     *Evento utilizado para notificar a la caja el siguiente cliente.
     */
    CLIENTE_A_CAJA(8),
    
    /**
     *Evento utilizado para crear un nuevo usuario.
     */
    CREAR_USUARIO(9);

    private final int valor;

    private Notificacion(int valor) {
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public int getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     * @return
     */
    public static Notificacion convertirValor(int valor) {
        Notificacion resultado = null;

        switch (valor) {
            case 1:
                resultado = Notificacion.ENTRA_USUARIO;
                break;
            case 2:
                resultado = Notificacion.NOTIFICA_SECUENCIA;
                break;
            case 3:
                resultado = Notificacion.ACTUALIZA_PLATAFORMA;
                break;
            case 4:
                resultado = Notificacion.ACTUALIZA_TRAMITES;
                break;
            case 5:
                resultado = Notificacion.ACTUALIZA_CUENTAS;
                break;
            case 6:
                resultado = Notificacion.AVANZA_CLIENTE;
                break;
            case 7:
                resultado = Notificacion.LIBERAR_CAJA;
                break;
            case 8:
                resultado = Notificacion.CLIENTE_A_CAJA;
                break;
            case 9:
                resultado = Notificacion.CREAR_USUARIO;
            default:
                break;
        }

        return resultado;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }

//  Switch para ver que tipo de notificacion se recibio
//    switch (Notificacion.convertirValor(Integer.parseInt(datos[0]))) {
//        case ENTRA_USUARIO:
//            break;
//        case NOTIFICA_SECUENCIA:
//            break;
//        case ACTUALIZA_PLATAFORMA:
//            break;
//        case ACTUALIZA_TRAMITES:
//            break;
//        case ACTUALIZA_CUENTAS:
//            break;
//        case LIBERAR_CAJA:
//            break;
//        case CLIENTE_A_CAJA:
//            break;
//        default:
//            throw new AssertionError(Notificacion.convertirValor(Integer.parseInt(datos[0])).name());
//    }
}
