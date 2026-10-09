package listadupla;

public class Main {

    public static void main(String[] args) throws Exception {

        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.append(10);
        lista.append(20);
        lista.append(30);
        lista.append(40);
        lista.append(50);

        System.out.println(lista);

        lista.insertInIndex(9, 1);

        System.out.println(lista);

        lista.insertInIndex(67, 0);

        System.out.println(lista);

        lista.insertInIndex(100, 6);

        System.out.println(lista);

        lista.deleteInIndex(0);

        System.out.println(lista);

        lista.deleteInIndex(4);

        System.out.println(lista);

        //erro com exceção:
        //lista.deleteInIndex(-45);
        //System.out.println(lista);

    }

}
