package listadupla;

public class ListaDupla<T> {

    private NoDuplo<T> head;
    private NoDuplo<T> tail;
    private int size = 0;

    public ListaDupla(){}

    public NoDuplo<T> getHead() {
        return head;
    }

    public void setHead(NoDuplo<T> head) {
        this.head = head;
    }

    public NoDuplo<T> getTail() {
        return tail;
    }

    public void setTail(NoDuplo<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //metodos da lista
    public void append(T valor){

        NoDuplo<T> novoNo = new NoDuplo<T>(valor);

        //no primeiro if, a lógica permanece a mesma da lista simples,
        //fazemos os dois ponteiros das extremidades apontarem para o primeiro
        //da lista.
        if(head == null){
            this.head = novoNo;
            this.tail = novoNo;
        }else{
            //aqui o jogo muda, como a lista ja possui pelo menos um elemento,
            //fazemos o ultimo apontar para o novo (até ai ja tinhamos feito, nada
            //de novo) e setamos o anterior desse novo sendo o tail, ou seja, o ultimo
            //da lista. E por ultimo, fazemos esse novo nó ser justamento o ultimo da lista
            //com o this.tail = novoNo;
            /*1° Passo*/ this.tail.setProximo(novoNo);
            /*2° Passo*/ novoNo.setAnterior(this.tail);
            /*3° Passo*/ this.tail = novoNo;
        }

        size++;
    }

    public void insertInIndex(T valor, int index) throws Exception{

        if(this.size == 0){
            append(valor);
        }else if (index == 0) {
            NoDuplo<T> novoNo = new NoDuplo<>(valor);
            this.head.setAnterior(novoNo);
            novoNo.setProximo(this.head);
            this.head = novoNo;
        }else if((index - 1) > this.size || index < 0) {
            throw new Exception("O index está fora dos limites.");
        } else{
            NoDuplo<T> buffer = this.head;

            for(int i = 0; i < (index - 1); i++){
                buffer = buffer.getProximo();
            }

            //1° Passo: instanciando um novoNo
            NoDuplo<T> novoNo = new NoDuplo<>(valor);
            //2° Passo: faremos o proximo dele ser o proximo do buffer
            //atual
            novoNo.setProximo(buffer.getProximo());
            //3° Passo: pegaremos o proximo do buffer e setaremos o anterior
            //dele ser o novo nó que instanciamos
            buffer.getProximo().setAnterior(novoNo);
            //4° Passo: agora, faremos o buffer apontar para o novoNo
            buffer.setProximo(novoNo);
            //5° Passo: por fim, faremos o novoNo t er como seu antecessor o buffer
            novoNo.setAnterior(buffer);
        }
        size++;
    }

    public void deleteInIndex(int index) throws Exception{
        if(size == 0) {
            throw new Exception("A lista está vazia.");
        }else if(index == 0){
            //Pega o próximo e faz o head apontar para ele
            //"deletando" o primeiro da lista.
            this.head = this.head.getProximo();
        }else if((index - 1) < size && index >= 0){

            NoDuplo<T> buffer = this.head;

            for(int i = 0; i < (index - 1); i++){
                buffer = buffer.getProximo();
            }

            //Fazendo o proximo do proximo apontar anteriormente
            //para o buffer atual
            buffer.getProximo().getProximo().setAnterior(buffer);

            //Pega o próximo do pŕoximo e faz o atual apontar para ele
            //ignorando o próximo.
            buffer.setProximo(buffer.getProximo().getProximo());
            size--;

        }else{
            throw new Exception("Index inválido.");
        }
    }

    @Override
    public String toString(){

        if(size == 0){
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");
        NoDuplo<T> buffer = this.head;
        stringBuilder.append(buffer.getValor());

        while(buffer.getProximo() != null){
            buffer = buffer.getProximo();
            stringBuilder.append(", " + buffer.getValor());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();

    }


}
