package baseDatos;

import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class base {
	private static base DB = new base();
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driverDB = "org.postgresql.Driver";
	private String dbName = "ZOO";
	private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
	private String userDB = "postgres";
	private String passDB = "jose22";
	//constructor...
	private base(){
		try {
			Class.forName(driverDB);
			this.conn=DriverManager.getConnection(urlDB,userDB,passDB);
			System.out.println("Conexion lista...");
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
	public static base getInstances() {
		return DB;
	}
	
	//retorna resultados (tabla animales)
	public void Imprime(String query, DefaultTableModel p) {
		try {
			Object data[]= new Object[7];
			this.stmt=this.conn.createStatement();
			this.rs=this.stmt.executeQuery(query);
			while(rs.next()) {
				for(int i=0;i<7;i++) {
					if(i!=2)
						data[i]=rs.getString(i+1);
					else
						data[i]=rs.getInt(i+1);
				}
				p.addRow(data);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				this.stmt.close();
				this.rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//En un arreglo de objetos
	public void Imprime(String query, String [] data) {
		try {
			this.stmt=this.conn.createStatement();
			this.rs=this.stmt.executeQuery(query);
			while(rs.next()) {
				for(int i=0;i<7;i++) 
					data[i]=(i!=2)? rs.getString(i+1):Integer.toString(rs.getInt(i+1));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				this.stmt.close();
				this.rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//moviendome por las tablas vive y moviliza...
	public void ImprimeVM(String query,Object [] obj) {
		try {
			this.stmt=this.conn.createStatement();
			this.rs=this.stmt.executeQuery(query);
			int i=0;
			while(rs.next()) {
				obj[i]=rs.getString("Descripcion");
				i++;
				obj[i]=Integer.toString(rs.getInt(1));
				i++;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				this.stmt.close();
				this.rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public String[] nombres() {
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("Select count(NombreC) from animal");
			String obj[]=new String[rs.getInt(1)];
			int i=0;
			while(rs.next()) {
				obj[i]=rs.getString(1);
				i++;
			}
			return obj;
		}catch (SQLException e) {
			e.printStackTrace();
			String dato[]= {"Error"};
			return dato;
		}
	}
	//ingreso a tablas...
	public void IngresoDB(String query, Object [] obj, int op){
		try {
			this.pstmt=this.conn.prepareStatement(query);
			//ingreso a tabla animales...
			if(op==1) {
				this.pstmt.setString(1, (String)obj[0]);
				this.pstmt.setString(2, (String)obj[1]);
				this.pstmt.setInt(3,(int)obj[2]);
				this.pstmt.setString(4, (String)obj[3]);
				this.pstmt.setInt(5,(int) obj[4]);
				
			}
			//ingreso a tabla movilizar y vive...
			else if(op==2){
				this.pstmt.setString(1,(String) obj[0]);
				this.pstmt.setInt(2,(int) obj[1]);
			}
			//ejecuto...
			this.pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				this.pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void IngresoDB(String query, String elec){
		try {
			this.pstmt=this.conn.prepareStatement(query);
			pstmt.setString(1, elec);
			//ejecuto...
			this.pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				this.pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void IngresoDB(String query, int elec){
		try {
			this.pstmt=this.conn.prepareStatement(query);
			pstmt.setInt(1, elec);
			//ejecuto...
			this.pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				this.pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//cierre de conexion
	public void dbClose() {
		try {
			this.conn.close();
			System.out.println("Conexion cerrada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}