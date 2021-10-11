package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     
	Double subtotal=0.0, totalapagar=0.0, precio=0.0, valor_iva=0.0, iva=0.0, subtotaliva=0.0 ,acusubtotal=0.0;
	long codProducto=0, numfac=0, item=0, cantidad=0;
	
	String descripcion, cedulaCliente;
	
	List<DetalleVenta> listaVentas = new ArrayList<>();
	Usuario usuarios = new Usuario();
	DetalleVenta detalleVenta = new DetalleVenta();
	
	public Controlador() {
		super();
	}
     
	public void buscarCliente(Long id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Cliente> listac = ClienteJson.getJSON();
			for(Cliente cliente:listac) {
				if(cliente.getCedula_cliente().equals(id)) {
					request.setAttribute("clienteSeleccionado", cliente);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void buscarProducto(Long id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Producto> listap = ProductoJson.getJSON();
			for(Producto producto:listap) {
				if(producto.getCodigo_producto().equals(id)) {
					request.setAttribute("productoSeleccionado", producto);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void mostrarFactura(String numFact, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(numFact == null) {
			numfac = Long.parseLong(numFact)+1;
		}else {
			numfac = Long.parseLong(numFact)+1;
		}
		request.setAttribute("numerofactura", numfac);
	}
	
	public void grabarDetalleVenta(Long numFact,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		for(int i=0; i<listaVentas.size() ; i++) {
			detalleVenta = new DetalleVenta();
			detalleVenta.setCodigo_detalle_venta(Long.valueOf(i+1));
			detalleVenta.setCodigo_venta(numFact);
			detalleVenta.setCodigo_producto(listaVentas.get(i).getCodigo_producto());
			detalleVenta.setCantidad_producto(listaVentas.get(i).getCantidad_producto());
			detalleVenta.setValor_venta(listaVentas.get(i).getValor_venta());
			detalleVenta.setValor_total(listaVentas.get(i).getValor_total());
			detalleVenta.setIvacompra(listaVentas.get(i).getIvacompra());
			
			int respuesta = 0;
			try {
				respuesta = DetalleVentaJson.postJSON(detalleVenta);
				PrintWriter writer = response.getWriter();
				if(respuesta==200) {
					request.getRequestDispatcher("Controlador?menu=Ventas&accion=default").forward(request, response);
					System.out.println("Registros Grabados en detalle ventas: " + respuesta);
				}else {
					writer.println("Error detalle ventas: " + respuesta);
				}
				writer.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
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
       			Long cedula_usuario_activo = Long.parseLong(request.getParameter("UsuarioActivo"));
       			usuarios.setCedula_usuario(cedula_usuario_activo);  
       			request.setAttribute("usuarioSeleccionado", usuarios);
       			request.setAttribute("numerofactura", numfac);
       			
       			if(accion.equals("Buscar Cliente")) {
       				String id = request.getParameter("cedulacliente");
       				this.buscarCliente(Long.parseLong(id), request, response);
       			}else if(accion.equals("Buscar Producto")) {
       				String id = request.getParameter("cedulacliente");
       				this.buscarCliente(Long.parseLong(id), request, response);
       				String cod = request.getParameter("codigoproducto");
       				this.buscarProducto(Long.parseLong(cod), request, response);
       			}else if(accion.equals("Agregar Producto")) {
       				String id = request.getParameter("cedulacliente");
       				this.buscarCliente(Long.parseLong(id), request, response);
       				
       				detalleVenta = new DetalleVenta();
       				item++;
       				totalapagar = 0.0;
       				acusubtotal = 0.0;
       				subtotaliva = 0.0;
       				
       				codProducto = Long.parseLong(request.getParameter("codigoproducto"));
       				descripcion = request.getParameter("nombreproducto");
       				precio = Double.parseDouble(request.getParameter("precioproducto"));
       				cantidad = Long.parseLong(request.getParameter("cantidadproducto"));
       				iva = Double.parseDouble(request.getParameter("ivaproducto"));
       				
       				subtotal = precio*cantidad;
       				valor_iva = subtotal*iva/100;
       				
       				detalleVenta.setCodigo_detalle_venta(item);
       				detalleVenta.setCodigo_producto(codProducto);
       				detalleVenta.setDescripcion_producto(descripcion);
       				detalleVenta.setPrecio_producto(precio);
       				detalleVenta.setCantidad_producto(cantidad);
       				detalleVenta.setCodigo_venta(numfac);
       				detalleVenta.setIvacompra(valor_iva);
       				detalleVenta.setValor_venta(subtotal);
       				listaVentas.add(detalleVenta);
       				
       				for(int i=0; i<listaVentas.size();i++) {
       					acusubtotal += listaVentas.get(i).getValor_venta();
       					subtotaliva += listaVentas.get(i).getIvacompra();
       				}
       				totalapagar = acusubtotal + subtotaliva;
       				detalleVenta.setValor_total(totalapagar);
       				
       				request.setAttribute("listaventas", listaVentas);
       				request.setAttribute("totalsubtotal", acusubtotal);
       				request.setAttribute("totaliva", subtotaliva);
       				request.setAttribute("totalapagar", totalapagar);
       			}else if (accion.equals("GenerarVenta")){
       			  
       				cedulaCliente = request.getParameter("cedulacliente");
       				String numFact = request.getParameter("numerofactura");
       				
       				Venta venta = new Venta();
       				venta.setCodigo_venta(Long.parseLong(numFact));
       				venta.setCedula_cliente(Long.parseLong(cedulaCliente));
       				venta.setCedula_usuario(usuarios.getCedula_usuario());
       				venta.setIvaventa(subtotaliva);
       				venta.setValor_venta(acusubtotal);
       				venta.setTotal_venta(totalapagar);
       				
       				int respuesta = 0;
       				
       				try {
       					respuesta = VentaJson.postJSON(venta);
       					PrintWriter write = response.getWriter();
       					if(respuesta==200) {
       						System.out.println("Grabacion  exitosa: " + respuesta);
       						this.grabarDetalleVenta(venta.getCodigo_venta(), request, response);
       					}else {
       						write.println("Error Ventas: " + respuesta);
       					}
       					write.close();
       				}catch(Exception e) {
       					e.printStackTrace();
       				}
           			listaVentas.clear();
           			item = 0;
           			totalapagar = 0.0;
           			subtotal = 0.0;
           			valor_iva = 0.0;
           			acusubtotal = 0.0;
           			subtotaliva = 0.0;
           			totalapagar = 0.0;
       			}else {
       				String factura = "0"; //request.getParameter("numerofactura");
       				this.mostrarFactura(factura, request, response);
       			}       			
       			request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
	  		break;
       		case"Reportes":
   			
       			int opcion = 0;
       			
       			if(accion.equals("ReporteUsuarios")) {
       				opcion = 1;
       				try {
    					ArrayList<Usuario> lista = UsuarioJson.getJSON();
    					request.setAttribute("listaUsuarios", lista);
    					request.setAttribute("opcion", opcion);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
       			}else if(accion.equals("ReporteClientes")) {
       				opcion = 2;
       				try {
    					ArrayList<Cliente> lista = ClienteJson.getJSON();
    					request.setAttribute("listaClientes", lista);
    					request.setAttribute("opcion", opcion);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
       			}else if(accion.equals("ReporteVentas")) {
       				opcion = 3;
       				try {
    					ArrayList<Venta> lista = VentaJson.getJSON();
    					request.setAttribute("listaVentas", lista);
    					request.setAttribute("opcion", opcion);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
       			}
       			request.getRequestDispatcher("/Reportes.jsp").forward(request, response);
   			break;
	   		}
     }
}
