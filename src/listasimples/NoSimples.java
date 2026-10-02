package listasimples;

public class NoSimples<T> {

    private T valor;
    private NoSimples<T> proximo;

    public NoSimples(T valor){
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoSimples<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoSimples<T> proximo) {
        this.proximo = proximo;
    }
}

