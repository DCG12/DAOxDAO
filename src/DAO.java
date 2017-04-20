import org.basex.api.client.ClientQuery;
import org.basex.api.client.ClientSession;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;

import java.io.File;
import java.io.IOException;

/**
 * Created by 20464654j on 05/04/17.
 */
public class DAO {

    private static String host = "localhost";
    private static int port = 1984;
    private static String user = "admin";
    private static String pass = "admin";

    /** Constructor
     *
     * @param host
     * @param port
     * @param user
     * @param password
     */

    /** Crea una coleccion con el nombre que le insertas como parametro
     *
     * @param name String con el nombre de la coleccion
     * @throws IOException
     */
    public void createCollection(String name) throws IOException {

        try (ClientSession session = new ClientSession(host, port, user, pass)) {

            //creem base de dades i indiquem el fitxer xml
            session.execute( new CreateDB( name ) );

            // tanquem sessio
            session.close();

        }
    }

    /** Crea un recurso del fichero introducido en la coleccion indicada
     *
     * @param collection String con el nombre de la coleccion
     * @param resource File con el fichero a guardar
     * @throws IOException
     */
    public void createResource(String collection, File resource) throws IOException {

        try (ClientSession session = new ClientSession(host, port, user, pass)) {

            //creem base de dades i indiquem el fitxer xml
            session.execute( new CreateDB( collection, resource.getAbsolutePath() ) );

            session.close();
        }
    }

    /** Ejecuta una consulta a la base de datos
     *
     * @param collection String con la coleccion a la que consultar
     * @param query String con la query a ejecutar
     * @return
     * @throws IOException
     */
    public String executeQuery(String collection, File resource, String query) throws IOException {

        try (ClientSession session = new ClientSession(host, port, user, pass)) {

            //creem base de dades i indiquem el fitxer xml
            session.execute( new CreateDB( collection, resource.getAbsolutePath() ) );

            String str;
            //fem la consulta que ens donara la informacio desitjada
            try (ClientQuery clientQuery = session.query(query)) {
                str = clientQuery.execute();
                System.out.println(clientQuery.execute());
            }
            session.close();
            return str;
        }
    }

    /** Elimina la coleccion con el nombre que insertas como parametro
     *
     * @param collection String con la nombre de la coleccion a borrar
     * @throws IOException
     */
    public void dropCollection( String collection ) throws IOException {
        try (ClientSession session = new ClientSession(host, port, user, pass)) {

            //borrem base de dades
            session.execute( new DropDB( collection ) );

            session.close();
        }
    }
}
