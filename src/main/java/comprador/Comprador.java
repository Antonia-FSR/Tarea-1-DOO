package comprador;

import expendedor.Expendedor;
import monedas.Moneda;
import productos.Producto;
import excepciones.*;

public class Comprador {
    private String sabor;
    private int vuelto;

    public Comprador(Moneda m, int eleccion, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {

        Producto p = exp.comprarProducto(m, eleccion);

        if (p!= null) {
            sabor= p.Consumir();
        } else {
            sabor= null;
        }

        vuelto = 0;
        Moneda monedaVuelto;

        while ((monedaVuelto= exp.getVuelto())!= null) {
            vuelto+= monedaVuelto.getValor();
        }
    }

    public String queSabor() {
        return sabor;
    }

    public int cuantoVuelto() {
        return vuelto;
    }
}