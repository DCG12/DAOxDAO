

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by 46406163y on 19/04/17.
 */
public class Main {
    //port 1984
    //user admin
    //password admin
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        DaoxDao dxd = new DaoxDao();


        System.out.println("Menu del DAO x DAO");
        System.out.println("------------------");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Para salir del Programa pulse --------------------------    0");
        System.out.println("Para crear una colección pulse ---------------------------- 1");
        System.out.println("Para crear una conexión pulse -------------------------- 2");
        System.out.println("Seleccione la opción deseada");
        int aux = 9;

        while (aux != 0) {
            aux = sc.nextInt();
            switch (aux) {
                case 1:
                    System.out.println("Escriva el nombre de la colección que desea crear");
                    dxd.collectionName = sc.next();
                    dxd.collection();
                    break;
                case 2:
                    System.out.println("Escriva la ruta del archivo que quiere subir");
                    String ruta = sc.next();
                    File f = new File(ruta);
                    dxd.resourceName = f;
                    System.out.println("Escrive el nombre de la colección que desea crear");
                    dxd.collectionName = sc.next();
                    dxd.resource();
                    break;
                case 3:
                    System.out.println("Escriva la consulta que quiere realizar");
                    dxd.query = sc.next();
                    System.out.println("Escriva la collecion en la que quiere hacer la consulta");
                    dxd.collectionName = sc.next();
                    System.out.println("Escriva la ruta del archivo que quiere subir");
                    ruta = sc.next();
                    f = new File(ruta);
                    dxd.resourceName = f;
                    dxd.Xquery();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;

            }
        }
    }
}
