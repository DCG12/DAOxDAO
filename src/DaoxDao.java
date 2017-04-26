

import org.xmldb.api.base.XMLDBException;

import java.io.File;
import java.io.IOException;

public class DaoxDao {

   DAO dao = new DAO();

    String collectionName;
    File resourceName;
    String query;

    public void collection(){
        try {
            dao.createCollection(collectionName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resource(){
        try {
            dao.createResource(collectionName, resourceName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Xquery(){
        try {
            dao.executeQuery(collectionName, resourceName, query);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Delete(){
        try {
            dao.dropCollection(collectionName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
