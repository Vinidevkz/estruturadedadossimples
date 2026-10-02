package listasimples;

public class ListaSimples<T> {

    private NoSimples<T> head;
    private NoSimples<T> tail;
    private int size = 0;

    //a lista deve começar vazia, por isso sem parâmetros no construtor.
    public ListaSimples(){}

    public NoSimples<T> getHead() {
        return head;
    }

    public void setHead(NoSimples<T> head) {
        this.head = head;
    }

    public NoSimples<T> getTail() {
        return tail;
    }

    public void setTail(NoSimples<T> tail) {
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
        //passo 1: criar o novo nó:
        NoSimples<T> novoNo = new NoSimples<T>(valor);

        //passo 2: verificar se o head está vazio = lista vazia.
        if(this.head == null){
            //fazer tanto o head quanto o tail apontarem para ele:
            this.head = novoNo;
            this.tail = novoNo;
        //o else só entra aqui se o head já estiver com um elemento
        }else{
            //passo 3: se head já estiver com algum elemento, seguiremos pegando o ultimo
            //elemento/tail (o primeiro caso só tenha um) e faremos ele apontar para o novo nó,
            // depois só faremos tail apontar para ele.

            //tail -aponta para-> NoSimples -que aponta-> objeto. lembram? tail é só
            //um "sinalizador" que nos ajuda a pegar o último nó mais facilmente.
            //Através dos "." navegamos até ele e setamos o "proximo" dele como o nó que
            //acabamos de criar.
            this.tail.setProximo(novoNo);
            //após isso, fazemos o tail apontar para o novo nó, já que ele será o ultim
            //da lista.
            this.tail = novoNo;
        }
        //incrementamos o tamanho da lista em 1.
        size++;
    }

    public void insertInIndex(T valor, int index) throws Exception{

        //se a lista estiver vazia, ele
        //colocará o valor na primeira posição.
        if(size == 0) {
            append(valor);
        //se o index for igual a 0, isso significa que ele será o primeiro
        //da lista, certo? então é só fazer ele apontar para o head,
        //depois o proprio head apontar para ele:
        }else if(index == 0){
            NoSimples<T> novoNo = new NoSimples<>(valor);
            novoNo.setProximo(this.head);
            this.head = novoNo;
        //Se o (index - 1) for maior do que o tamanho da lista ou menor do que zero,
        //ele retornar deve uma exceção.
        //por que (index - 1)? Se o tamanho da lista for de 10, então os index
        //dela só vão de 0 a 9, se o usuário digitar um index de 11, aqui ele será
        //10 e 10 é igual ao tamanho da lista e porem não existe um index 10 para ele
        //na lista:
        }else if((index - 1) > this.size || index < 0){
            throw new Exception("O index está fora dos limites.");
        //caso nenhum dos dois casos sejam verdadeiros, percorremos a lista
        //até chegar no index que queremos, começando pelo head:
        }else{
            NoSimples<T> buffer = this.head;

            for(int i = 0; i < index; i++){
                //a cada entrada do laço for, significa que ainda não
                //chegamos no nó que queremos, então continuamos a
                //avançar:
                buffer = buffer.getProximo();
            }

            NoSimples<T> novoNo = new NoSimples<T>(valor);
            novoNo.setProximo(buffer.getProximo());
            buffer.setProximo(novoNo);
        }
        size++;
    }

    public void deleteInIndex(int index) throws Exception{
        if(size == 0 || index < 0 || (index - 1) > size){
            throw new Exception("Index inválido.");
        }else if(size == 1 && index == 0) {
            //se tiver apenas 1 elemento, basta tornar head e tail nulos.
            this.head = null;
            this.tail = null;
        }else if(index == 0){
            this.head = this.head.getProximo();
        }else{
            NoSimples buffer = this.head;

            for(int i = 0; i < (index - 1); i++){
                buffer = buffer.getProximo();
            }

            buffer.setProximo(buffer.getProximo().getProximo());
        }
        size--;
    }

    @Override
    public String toString(){

        if(this.size == 0){
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");

        NoSimples<T> buffer = this.head;
        stringBuilder.append(buffer.getValor());

        while(buffer.getProximo() != null){
            stringBuilder.append(", ");
            buffer = buffer.getProximo();
            stringBuilder.append(buffer.getValor());
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}