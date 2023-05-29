package es.cifpcm.controlador;

import es.cifpcm.models.Farmacia;

import java.io.File;
import java.util.List;

public interface Persistence {
    public void open();
    public void openJSON(File file);
   // public void close();
    public void closeJSON();
    public void add(Farmacia farmacia);
    public void delete(Farmacia farmacia);
    List<Farmacia>list();

}
