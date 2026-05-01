package expendedor;

import productos.*;
import monedas.*;
import excepciones.*;


public class Expendedor {
    private Deposito<Bebida> cocacolaD;
    private Deposito<Bebida> spriteD;
    private Deposito<Bebida> fantaD;
    private Deposito<Dulce> snickersD;
    private Deposito<Dulce> super8D;
    private Deposito<Moneda> monVU;

    public Expendedor(int cantidad){
        this.cocacolaD= new Deposito<Bebida>();
        this.spriteD= new Deposito<Bebida>();
        this.fantaD= new Deposito<Bebida>();
        this.snickersD= new Deposito<Dulce>();
        this.super8D= new Deposito<Dulce>();
        this.monVU= new Deposito<Moneda>();

        for (int i= 0; i < cantidad; i++)
        {
            cocacolaD.add(new CocaCola(1000 + i));
            spriteD.add(new Sprite(2000 + i));
            fantaD.add(new Fanta(3000 + i));
            snickersD.add(new Snickers(4000 + i));
            super8D.add(new Super8(5000 + i));
        }
    }

    public Producto comprarProducto(Moneda m, int eleccion) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Producto p= null;
        int precioProducto= 0;

        if(m == null) //No existe moneda
        {
            throw new PagoIncorrectoException("Error: No hay moneda para pagar.");
        }

        Inventario seleccion= null;
        for(Inventario i: Inventario.values()){
            if(i.getSeleccion() == eleccion){
                seleccion= i;
                break;
            }
        }
        if (seleccion == null){
            monVU.add(m);
            throw new NoHayProductoException("No existe el producto!");
        }

        precioProducto = seleccion.getPrecio();
        switch (seleccion){
            case COCA_COLA:
                if(m.getValor() >= precioProducto) p = cocacolaD.get();
                break;

            case SPRITE:
                if(m.getValor() >= precioProducto) p = spriteD.get();
                break;

            case FANTA:
                if(m.getValor() >= precioProducto) p = fantaD.get();
                break;

            case SNICKERS:
                if(m.getValor() >= precioProducto) p = snickersD.get();
                break;

            case SUPER8:
                if(m.getValor() >= precioProducto) p = super8D.get();
                break;
        }


        if(m.getValor() < precioProducto){ //El valor de la moneda es menor al del producto

            monVU.add(m);
            throw new PagoInsuficienteException("Cantidad insuficiente de dinero.");
        }

        if (p == null){ //No hay producto

            monVU.add(m);
            throw new NoHayProductoException("No hay existencias del producto seleccionado");
        }

        int vuelto= m.getValor() - precioProducto;
        while(vuelto >= 100){
            monVU.add(new Moneda100());
            vuelto -= 100;
        }

        return p;
    }

    public Moneda getVuelto() {
        return monVU.get();
    }
}

