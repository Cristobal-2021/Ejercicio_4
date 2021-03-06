package model;
/**
 * 
 * @author Cuya Cristobal Luis Angel
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import entidad.tipoCliente;
import util.MySqlDBConexion;

public class ClienteModel {

	
	public List<Cliente> consultaCliente(String dni){
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			String sql =  "Select c.* , t.nombre from Cliente c inner join tipo_cliente t on c.idCliente = t.idTpoCliente where c.dni = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1,dni);
			
		
			rs = pstm.executeQuery();
					
			Cliente objCliente = null;
			tipoCliente objtipoCliente = null;
			while(rs.next()){
				objCliente = new Cliente();
				objCliente.setIdCliente(rs.getInt(1));
				objCliente.setNombres(rs.getString(2));
				objCliente.setApellidos(rs.getString(3));
				objCliente.setDni(rs.getString(4));
				objCliente.setFechaNacimiento(rs.getDate(5));
				
				objtipoCliente = new tipoCliente();
				objtipoCliente.setIdtipo(rs.getInt(6));
				objtipoCliente.setDescripcion(rs.getString(7));
				
				objCliente.setTipo(objtipoCliente);

				data.add(objCliente);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	
	
	public List<Cliente> listaCliente(){
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			
			String sql = "Select c.* , t.nombre from Cliente c inner join tipo_cliente t on c.idCliente = t.idTpoCliente ";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			Cliente objCliente = null;
			tipoCliente objtipoCliente = null;
			while(rs.next()){
				objCliente = new Cliente();
				objCliente.setIdCliente(rs.getInt(1));
				objCliente.setNombres(rs.getString(2));
				objCliente.setApellidos(rs.getString(3));
				objCliente.setDni(rs.getString(4));
				objCliente.setFechaNacimiento(rs.getDate(5));
				
				objtipoCliente = new tipoCliente();
				objtipoCliente.setIdtipo(rs.getInt(6));
				objtipoCliente.setDescripcion(rs.getString(7));
				
				objCliente.setTipo(objtipoCliente);

				data.add(objCliente);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	
}
