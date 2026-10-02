package listasimples;

public class Main {

    public static void main(String[] args) throws Exception {

        ListaSimples<Integer> lista = new ListaSimples<Integer>();

        lista.append(1);

        System.out.println(lista + " - " + lista.getSize());

        lista.deleteInIndex(0);

        System.out.println(lista + " - " + lista.getSize());

        lista.append(5);
        lista.append(1);
        lista.append(3);
        lista.append(10);

        System.out.println(lista + " - " + lista.getSize());

        lista.insertInIndex(20, 0);

        System.out.println(lista + " - " + lista.getSize());

        lista.insertInIndex(15, 1);

        System.out.println(lista + " - " + lista.getSize());

        lista.deleteInIndex(1);

        System.out.println(lista + " - " + lista.getSize());

        lista.deleteInIndex(0);

        System.out.println(lista + " - " + lista.getSize());
    }
}
