package listadupla;

public class NoDuplo<T> {

    private T valor;
    private NoDuplo<T> anterior;
    private NoDuplo<T> proximo;

    public NoDuplo(T valor){
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoDuplo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    public NoDuplo<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "valor=" + valor +
                ", anterior=" + anterior +
                ", proximo=" + proximo +
                '}';
    }
}
