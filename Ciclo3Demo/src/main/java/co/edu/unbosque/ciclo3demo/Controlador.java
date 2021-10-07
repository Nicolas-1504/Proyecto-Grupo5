package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     
	public Controlador() {
		super();
	}
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  				
	  String menu = request.getParameter("menu");
	  String accion = request.getParameter("accion");
          
	   switch (menu) {
	   
       		case "Principal":
	   			request.getRequestDispatcher("/Principal.jsp").forward(request, response);
				break;
       		
       		case "Usuarios":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Usuario> lista = UsuarioJson.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
	  	  	}else if(accion.equals("Agregar")) {
	  	  		Usuario usuario = new Usuario();
	  	  		usuario.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
	  	  		usuario.setNombre_usuario(request.getParameter("nombre"));
	  	  		usuario.setEmail_usuario(request.getParameter("email"));
	  	  		usuario.setUsuario(request.getParameter("usuario"));
	  	  		usuario.setPassword(request.getParameter("password"));
	  					
	  	  		int respuesta=0;
  	  			try {
  	  				respuesta = UsuarioJson.postJSON(usuario);
  	  				PrintWriter write = response.getWriter();
	  	  			if (respuesta==200) {
	  	  				request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,response);
  	  				} else {
  	  					write.println("Error: " +  respuesta);
  	  				}
	  	  				write.close();
  	  			} catch (Exception e) {
  	  				e.printStackTrace();
  	  			}
	  					
  	  		}else if(accion.equals("Actualizar")) {
  	  			Usuario usuario = new Usuario();
  	  			usuario.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
  	  			usuario.setNombre_usuario(request.getParameter("nombre"));
  	  			usuario.setEmail_usuario(request.getParameter("email"));
		 		usuario.setUsuario(request.getParameter("usuario"));
		 		usuario.setPassword(request.getParameter("password"));
 		
		 		int respuesta=0;
		 		try {
		 		   respuesta = UsuarioJson.putJSON(usuario,usuario.getCedula_usuario());
		 		   PrintWriter write = response.getWriter();
 						
	 		   		if (respuesta==200) {
		   				request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
	 		   		}else {
	 		   			write.println("Error: " +  respuesta);
	 		   		}
	 		   			write.close();
		 		} catch (Exception e) {
		 			e.printStackTrace();
		 		}
  	  		}else if(accion.equals("Cargar")) {
  	  			Long id= Long.parseLong(request.getParameter("id"));
  	  			try {
  	                ArrayList<Usuario> lista1 = UsuarioJson.getJSON();
  	                System.out.println("Parametro: " + id);						
  	                for (Usuario usuarios:lista1){
  	                	if (usuarios.getCedula_usuario().equals(id)) {
  	                		request.setAttribute("usuarioSeleccionado", usuarios);
  	                		request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);	
  	                	}
  	                }
  			 } catch (Exception e) {
  		       	e.printStackTrace();
  			 }
  	  		}else if(accion.equals("Eliminar")) {
  	        	Long id= Long.parseLong(request.getParameter("id"));			
  	        	int respuesta=0;
  	        	try {
  	        		respuesta = UsuarioJson.deleteJSON(id);
  	        		PrintWriter write = response.getWriter();
  	        		if (respuesta==200) {
  	        			request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
  			   } else {
  				   write.println("Error: " +  respuesta);
  			   }
				write.close();
  			   } catch (Exception e) {
  				   e.printStackTrace();
  			   }	
  			}

	  	  	request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
	  	  	break;
	  	  	
       		case "Clientes":
       			if (accion.equals("Listar")) {
    				try {
    					ArrayList<Cliente> lista = ClienteJson.getJSON();
    					request.setAttribute("lista", lista);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    	  	  	}else if(accion.equals("Agregar")) {
    	  	  		Cliente cliente = new Cliente();
    	  	  		cliente.setCedula_cliente(Long.parseLong(request.getParameter("cedula")));
	    	  	  	cliente.setDireccion_cliente(request.getParameter("direccion"));
	    	  	  	cliente.setEmail_cliente(request.getParameter("email"));
		    	  	cliente.setNombre_cliente(request.getParameter("nombre"));
		    	  	cliente.setTelefono_cliente(request.getParameter("telefono"));
    	  					
    	  	  		int respuesta=0;
      	  			try {
      	  				respuesta = ClienteJson.postJSON(cliente);
      	  				PrintWriter write = response.getWriter();
    	  	  			if (respuesta==200) {
    	  	  				request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,response);
      	  				} else {
      	  					write.println("Error: " +  respuesta);
      	  				}
    	  	  				write.close();
      	  			} catch (Exception e) {
      	  				e.printStackTrace();
      	  			}
    	  					
      	  		}else if(accion.equals("Actualizar")) {
      	  			Cliente cliente = new Cliente();
      	  			cliente.setCedula_cliente(Long.parseLong(request.getParameter("cedula")));
      	  			cliente.setDireccion_cliente(request.getParameter("direccion"));
      	  			cliente.setEmail_cliente(request.getParameter("email"));
    		 		cliente.setNombre_cliente(request.getParameter("nombre"));
    		 		cliente.setTelefono_cliente(request.getParameter("telefono"));
     		
    		 		int respuesta=0;
    		 		try {
    		 		   respuesta = ClienteJson.putJSON(cliente,cliente.getCedula_cliente());
    		 		   PrintWriter write = response.getWriter();
     						
    	 		   		if (respuesta==200) {
    		   				request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
    	 		   		}else {
    	 		   			write.println("Error: " +  respuesta);
    	 		   		}
    	 		   			write.close();
    		 		} catch (Exception e) {
    		 			e.printStackTrace();
    		 		}
      	  		}else if(accion.equals("Cargar")) {
      	  			Long id= Long.parseLong(request.getParameter("id"));
      	  			try {
      	                ArrayList<Cliente> lista1 = ClienteJson.getJSON();
      	                System.out.println("Parametro: " + id);						
      	                for (Cliente clientes:lista1){
      	                	if (clientes.getCedula_cliente().equals(id)) {
      	                		request.setAttribute("usuarioSeleccionado", clientes);
      	                		request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);	
      	                	}
      	                }
      			 } catch (Exception e) {
      		       	e.printStackTrace();
      			 }
      	  		}else if(accion.equals("Eliminar")) {
      	        	Long id= Long.parseLong(request.getParameter("id"));			
      	        	int respuesta=0;
      	        	try {
      	        		respuesta = ClienteJson.deleteJSON(id);
      	        		PrintWriter write = response.getWriter();
      	        		if (respuesta==200) {
      	        			request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
      			   } else {
      				   write.println("Error: " +  respuesta);
      			   }
    				write.close();
      			   } catch (Exception e) {
      				   e.printStackTrace();
      			   }	
      			}

    	  	  	request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
	  		break;
	  		
       		case "Proveedores":
    			if (accion.equals("Listar")) {
    				try {
    					ArrayList<Proveedor> lista = ProveedorJson.getJSON();
    					request.setAttribute("lista", lista);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    	  	  	}else if(accion.equals("Agregar")) {
    	  	  		Proveedor proveedor = new Proveedor();
	    	  	  	proveedor.setNitproveedor(Long.parseLong(request.getParameter("nit")));
	    	  	  	proveedor.setCiudad_proveedor(request.getParameter("ciudad"));
		    	  	proveedor.setDireccion_proveedor(request.getParameter("direccion"));
		    	  	proveedor.setNombre_proveedor(request.getParameter("nombre"));
		    	  	proveedor.setTelefono_proveedor(request.getParameter("telefono"));
    	  					
    	  	  		int respuesta=0;
      	  			try {
      	  				respuesta = ProveedorJson.postJSON(proveedor);
      	  				PrintWriter write = response.getWriter();
    	  	  			if (respuesta==200) {
    	  	  				request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,response);
      	  				} else {
      	  					write.println("Error: " +  respuesta);
      	  				}
    	  	  				write.close();
      	  			} catch (Exception e) {
      	  				e.printStackTrace();
      	  			}
    	  					
      	  		}else if(accion.equals("Actualizar")) {
      	  			Proveedor proveedor = new Proveedor();
	      	  		proveedor.setNitproveedor(Long.parseLong(request.getParameter("nit")));
		      	  	proveedor.setCiudad_proveedor(request.getParameter("ciudad"));
			      	proveedor.setDireccion_proveedor(request.getParameter("direccion"));
			      	proveedor.setNombre_proveedor(request.getParameter("nombre"));
			      	proveedor.setTelefono_proveedor(request.getParameter("telefono"));
     		
    		 		int respuesta=0;
    		 		try {
    		 		   respuesta = ProveedorJson.putJSON(proveedor,proveedor.getNitproveedor());
    		 		   PrintWriter write = response.getWriter();
     						
    	 		   		if (respuesta==200) {
    		   				request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
    	 		   		}else {
    	 		   			write.println("Error: " +  respuesta);
    	 		   		}
    	 		   			write.close();
    		 		} catch (Exception e) {
    		 			e.printStackTrace();
    		 		}
      	  		}else if(accion.equals("Cargar")) {
      	  			Long id= Long.parseLong(request.getParameter("id"));
      	  			try {
      	                ArrayList<Proveedor> lista1 = ProveedorJson.getJSON();
      	                System.out.println("Parametro: " + id);						
      	                for (Proveedor proveedores:lista1){
      	                	if (proveedores.getNitproveedor().equals(id)) {
      	                		request.setAttribute("usuarioSeleccionado", proveedores);
      	                		request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);	
      	                	}
      	                }
      			 } catch (Exception e) {
      		       	e.printStackTrace();
      			 }
      	  		}else if(accion.equals("Eliminar")) {
      	        	Long id= Long.parseLong(request.getParameter("id"));			
      	        	int respuesta=0;
      	        	try {
      	        		respuesta = ProveedorJson.deleteJSON(id);
      	        		PrintWriter write = response.getWriter();
      	        		if (respuesta==200) {
      	        			request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
      			   } else {
      				   write.println("Error: " +  respuesta);
      			   }
    				write.close();
      			   } catch (Exception e) {
      				   e.printStackTrace();
      			   }	
      			}

    	  	  	request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
    	  	  	break;
       		case "Productos":
       			if (accion.equals("Listar")) {
    				try {
    					ArrayList<Producto> lista = ProductoJson.getJSON();
    					request.setAttribute("lista", lista);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    	  	  	}else if(accion.equals("Agregar")) {
    	  	  		Producto producto = new Producto();
    	  	  		producto.setCodigo_producto(Long.parseLong(request.getParameter("codigo")));
    	  	  		producto.setIvacompra(Double.parseDouble(request.getParameter("iva")));
    	  	  		producto.setNitproveedor(Long.parseLong(request.getParameter("nit")));
    	  	  		producto.setNombre_producto(request.getParameter("nombre"));
    	  	  		producto.setPrecio_compra(Double.parseDouble(request.getParameter("compra")));
    	  	  		producto.setPrecio_venta(Double.parseDouble(request.getParameter("venta")));
    	  					
    	  	  		int respuesta=0;
      	  			try {
      	  				respuesta = ProductoJson.postJSON(producto);
      	  				PrintWriter write = response.getWriter();
    	  	  			if (respuesta==200) {
    	  	  				request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,response);
      	  				} else {
      	  					write.println("Error: " +  respuesta);
      	  				}
    	  	  				write.close();
      	  			} catch (Exception e) {
      	  				e.printStackTrace();
      	  			}
    	  					
      	  		}else if(accion.equals("Actualizar")) {
    	  	  		Producto producto = new Producto();
    	  	  		producto.setCodigo_producto(Long.parseLong(request.getParameter("codigo")));
    	  	  		producto.setIvacompra(Double.parseDouble(request.getParameter("iva")));
    	  	  		producto.setNitproveedor(Long.parseLong(request.getParameter("nit")));
    	  	  		producto.setNombre_producto(request.getParameter("nombre"));
    	  	  		producto.setPrecio_compra(Double.parseDouble(request.getParameter("compra")));
    	  	  		producto.setPrecio_venta(Double.parseDouble(request.getParameter("venta")));
     		
    		 		int respuesta=0;
    		 		try {
    		 		   respuesta = ProductoJson.putJSON(producto,producto.getCodigo_producto());
    		 		   PrintWriter write = response.getWriter();
     						
    	 		   		if (respuesta==200) {
    		   				request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
    	 		   		}else {
    	 		   			write.println("Error: " +  respuesta);
    	 		   		}
    	 		   			write.close();
    		 		} catch (Exception e) {
    		 			e.printStackTrace();
    		 		}
      	  		}else if(accion.equals("Cargar")) {
      	  			Long id= Long.parseLong(request.getParameter("id"));
      	  			try {
      	                ArrayList<Producto> lista1 = ProductoJson.getJSON();
      	                System.out.println("Parametro: " + id);						
      	                for (Producto productos:lista1){
      	                	if (productos.getCodigo_producto().equals(id)) {
      	                		request.setAttribute("usuarioSeleccionado", productos);
      	                		request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);	
      	                	}
      	                }
      			 } catch (Exception e) {
      		       	e.printStackTrace();
      			 }
      	  		}else if(accion.equals("Eliminar")) {
      	        	Long id= Long.parseLong(request.getParameter("id"));			
      	        	int respuesta=0;
      	        	try {
      	        		respuesta = ProductoJson.deleteJSON(id);
      	        		PrintWriter write = response.getWriter();
      	        		if (respuesta==200) {
      	        			request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
      			   } else {
      				   write.println("Error: " +  respuesta);
      			   }
    				write.close();
      			   } catch (Exception e) {
      				   e.printStackTrace();
      			   }	
      			}

    	  	  	request.getRequestDispatcher("/Productos.jsp").forward(request, response);
	  		break;
       		case "Ventas":	
       			request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
	  		break;
  		}
	        
     }
}
