package es.cifpcm.controlador;

import es.cifpcm.models.Farmacia;

import java.util.List;
import java.util.ArrayList;

public class  imRodriguezManuel implements RodriguezInterfazUtil {
    /*
    @Override
    public List<Farmacia> buscaArea1(List<Farmacia> listaFarmacia) {
        return getFarmacias(listaFarmacia,Float.parseFloat("377174.54"), Float.parseFloat("3149714.57"));
    }
    */

    @Override
    public List<Farmacia> buscaArea2(List<Farmacia> listaFarmacia, Farmacia farmacia) {
        return getFarmacias(listaFarmacia, farmacia.getUTM_X(), farmacia.getUTM_Y(), farmacia.getNOMBRE());
    }

    private static List<Farmacia> getFarmacias(List<Farmacia> listaFarmacia, Float UX, Float UY, String NombreFarmacia) {
        List<Farmacia> farmaciasCercanas = new ArrayList<Farmacia>();

        for (Farmacia farmaciaLista : listaFarmacia)
        {
            if(!farmaciaLista.getNOMBRE().equals(NombreFarmacia)){
                if ( Math.abs(farmaciaLista.getUTM_X() - UX ) <= 1600 && Math.abs(farmaciaLista.getUTM_Y() - UY) <= 16000)
                {
                    farmaciasCercanas.add(farmaciaLista);
                }
            }
        }
        return farmaciasCercanas;
    }




}
