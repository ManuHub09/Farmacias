package es.cifpcm.controlador;

import es.cifpcm.models.Farmacia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//debemos organizar las carpetas, models, data, views ...
@WebServlet("/rodriguez_farm")
public class RodriguezManuelServlet extends HttpServlet {
    public static Persistence pst = new ImplementsPersistence();
    public static imRodriguezManuel area = new imRodriguezManuel();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      pst.open();
      PrintWriter wrt;
      response.setContentType("text/html");
      List <Farmacia> list = pst.list();
      wrt = response.getWriter();
      wrt.println("<h1> Listas de Farmacias </h1>");
      ListarFarmacia(wrt, list);
      //pst.closeJSON();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        pst.open();
        String nombreFarmacia = request.getParameter("Nombrefarmacia").toLowerCase();
        response.setContentType("text/html");
        PrintWriter wrt;
        wrt = response.getWriter();
        List <Farmacia> list = pst.list();
        //Farmacia FarmiEncontrada = list.stream().filter(farmacia -> farmacia.getNOMBRE().toLowerCase().equals(nombreFarmacia)).findFirst().orElse(null);
        Farmacia FarmiEncontrada = list.stream().filter(farmacia -> farmacia.getNOMBRE().toLowerCase().equals(nombreFarmacia)).findFirst().orElse(null);
        if(FarmiEncontrada != null){
            List <Farmacia> FarmaciasCer = area.buscaArea2(list , FarmiEncontrada);
            if( FarmaciasCer.size() != 0){

                wrt.println("<h1> Las Farmacias encontradas cercanas a la farmacia: "+ FarmiEncontrada.getNOMBRE()+ "</h1>");
                ListarFarmacia(wrt, FarmaciasCer);
            }
            else
            {

                wrt.println("<h1> No hay farmacias cercanas de:  "+ FarmiEncontrada.getNOMBRE()+ "</h1>");
            }

        }
        else {
            wrt.println("<span style: color:red> Farmacia no encontrada </span>");
        }

    }


    private void ListarFarmacia(PrintWriter wrt, List<Farmacia> farmaciaMostrar)
    {
        wrt.println("<table border>");
        wrt.println("<tr>");
            wrt.println("<td> Web </td>");
            wrt.println("<td> Lunes </td>");
            wrt.println("<td> Martes </td>");
            wrt.println("<td> Miercoles </td>");
            wrt.println("<td> Jueves </td>");
            wrt.println("<td> Viernes </td>");
            wrt.println("<td> Sabado </td>");
            wrt.println("<td> Domingo </td>");
            wrt.println("<td> Telefono </td>");
            wrt.println("<td> Nombre </td>");
            wrt.println("<td> UX </td>");
            wrt.println("<td> UY </td>");

        wrt.println("</tr>");
        for ( Farmacia farmacia : farmaciaMostrar) {
            wrt.println("<tr>");
            wrt.println("<td> "+ farmacia.getWEB() +"</td>");
            wrt.println("<td> "+ farmacia.getLUNES() +"</td>");
            wrt.println("<td> "+ farmacia.getMARTES() +"</td>");
            wrt.println("<td> "+ farmacia.getMIERCOLES() +"</td>");
            wrt.println("<td> "+ farmacia.getJUEVES() +"</td>");
            wrt.println("<td> "+ farmacia.getVIERNES() +"</td>");
            wrt.println("<td> "+ farmacia.getSABADO() +"</td>");
            wrt.println("<td> "+ farmacia.getDOMINGO() +"</td>");
            wrt.println("<td> "+ farmacia.getTELEFONO()+"</td>");
            wrt.println("<td> "+ farmacia.getNOMBRE() +"</td>");
            wrt.println("<td> "+ farmacia.getUTM_X() +"</td>");
            wrt.println("<td> "+ farmacia.getUTM_Y() +"</td>");
            wrt.println("</tr>");
        }
        wrt.println("</table>");
        wrt.println(" <a href='index.jsp'> Volver al inicio </a>");
    }
}
