package es.cifpcm.controlador;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import  java.io.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import es.cifpcm.models.Farmacia;

public class ImplementsPersistence implements Persistence {
    private List<Farmacia> memStore = new ArrayList<>();
    Gson gson = new Gson();
   // private final String FileStore_Path = System.getProperty("java.io.tmpdir")+"RodriguezManuel_Farmacias.json";
    private final String Filename = "RodriguezManuel_Farmacias.json";
    /*
        el JSON se guarda aquí, que esto es no mandarlo en el temp, sino en la carpeta de resources del es dodne tiene que estar el json
        URL res = getClass().getCLassLoader().getResource(filename);
        File file = Paths.get(res.toURL()).toFile();
     */
    @Override
    public void open() {
        try {
            URL res = getClass().getClassLoader().getResource(Filename);
            File file = Paths.get(res.toURI()).toFile();
            if(file.exists()){
                openJSON(file);
                System.out.println("Se ha cargado correctamente");

            }
            else
            {
                System.out.println("No se pudieron cargar los datos bien");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void openJSON(File file) { //lo que tenemos en el JSON pasarlo a la lista de farmacias
        try {
            //FileReader filereader = new Filereader(FicheroJSON);
            /*Type tipo = new TypeToker<ArrayList<farmacia>>(){}.getType();
                memstore = gson.fromJson(filereader,tipo );
             */
            String JSON ="";
            BufferedReader br = new BufferedReader(new FileReader((file)));
            String linea;
            while ((linea = br.readLine()) !=null){

                JSON += linea;
            }
            br.close();
            // es el codigo de convertir una matriz JSON en una lista del
            // tipo que yo quiero, en este caso de Farmacia
            // puse el TypeToken, luego getType, ya que si no lo pongo no me guarda los objetos JSON
            // como objetos Farmacia
            memStore = gson.fromJson(JSON, new TypeToken<List<Farmacia>>(){}.getType());

        }catch (Exception e){
            System.out.println(e);
        }

    }
    /*
    @Override
    public void close() { //cuando cierro el programa y se guarda
        closeJSON();
        System.out.println("Programa cerrado");
    }
     */
    @Override
    public void closeJSON() { //Actualizar el archivo JSON
        File FicheroJSON = new File(Filename);
        try {
            String MemJson = gson.toJson(memStore);
            PrintWriter escribir = new PrintWriter(FicheroJSON);
            escribir.write(""); //vaciamos el archivo
            escribir.write(MemJson); //lo volvemos a cargar con las modificaciones
            escribir.close();

        }catch (Exception e){
            System.out.println(e);
        }


    }

    @Override
    public void add(Farmacia farmacia) {

        memStore.add(farmacia);

    }

    @Override
    public void delete(Farmacia farmacia) {
        int pos =0;
        pos = memStore.indexOf(farmacia);
        memStore.remove(pos);
    }

    @Override
    public List<Farmacia> list() {
        return memStore;
    }
}




