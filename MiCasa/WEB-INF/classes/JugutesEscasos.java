import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import juguetes.Juguete;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;


@WebServlet("/JugutesEscasos")
public class JugutesEscasos extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			String base = getServletContext().getInitParameter("base");
			String contraseña=getServletContext().getInitParameter("contraseña");
			String usuarioBase=getServletContext().getInitParameter("usuario");

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
			
			
			//System.out.println(url);

			//Parametros son direccion de la base, usuario y constraseña de mysql
			Connection con = DriverManager.getConnection(url,usuarioBase,contraseña);
			

			Statement stat = con.createStatement();
			String sql = "SELECT * FROM Juguete, Proveedor WHERE Juguete.cantidad < 10 and Juguete.id_proveedor = Proveedor.id";

			ResultSet res = stat.executeQuery(sql);


			Vector<Juguete> juguetes = new Vector<Juguete>();

			while(res.next()){
				
				Juguete jug = new Juguete();
				
					jug.setNombreProveedor(res.getString("Proveedor.nombre"));
					jug.setNombre(res.getString("Juguete.nombre"));
					jug.setPrecio(res.getDouble("Juguete.precio"));
					jug.setPrecioProv(res.getDouble("Juguete.precio_proveedor"));
					jug.setCategoria(res.getString("Juguete.categoria"));
					jug.setDescripcion(res.getString("Juguete.descripcion"));
					jug.setCantidad(res.getInt("Juguete.cantidad"));
					jug.setID(res.getInt("Juguete.id"));

					juguetes.add(jug);
			}
			
			stat.close();
			con.close();

			//preguntare
			request.setAttribute("juguetes",juguetes);

			RequestDispatcher disp =  getServletContext().getRequestDispatcher("/inventario.jsp");

			if(disp!=null){
				disp.forward(request,response);
			}


		}
		catch(Exception e){
			e.printStackTrace();
		}



	}

}
