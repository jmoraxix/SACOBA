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

    ENTRA_USUARIO(1), NOTIFICA_SECUENCIA(2), ACTUALIZA_PLATAFORMA(3), ACTUALIZA_TRAMITES(4),
    ACTUALIZA_CUENTAS(5), AVANZA_CLIENTE(6), LIBERAR_CAJA(7), NOTIFICAR_CAJERO(8);

    private final int valor;

    private Notificacion(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

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
                resultado = Notificacion.NOTIFICAR_CAJERO;
                break;
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
//        case NOTIFICAR_CAJERO:
//            break;
//        default:
//            throw new AssertionError(Notificacion.convertirValor(Integer.parseInt(datos[0])).name());
//    }
}
