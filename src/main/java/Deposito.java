import java.util.ArrayList;
public class Deposito<T> {
    private ArrayList<T> lista;
    public Deposito(){
        lista=new ArrayList<>();
    }
    public void add(T item){
        lista.add(item);
    }
    public T get(){
        if(lista.isEmpty()){
            return null;
        }
        return lista.remove(0);
    }
}
