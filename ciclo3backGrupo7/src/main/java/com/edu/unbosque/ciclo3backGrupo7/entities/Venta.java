package com.edu.unbosque.ciclo3backGrupo7.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {
	
	@Id
	private Long codigo_venta;
	private Long cedula_cliente;
	private Long cedula_usuario;
	private Double ivaventa;
	private Double total_venta;
	private Double valor_venta;
	
	public Venta(){
		
	}
	
	public Venta(Long cedula_cliente, Long cedula_usuario, Double ivaventa, Double total_venta,Double valor_venta) {
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}
	
	public Venta(Long codigo_venta, Long cedula_cliente, Long cedula_usuario, Double ivaventa, Double total_venta,Double valor_venta) {
		this.codigo_venta = codigo_venta;
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}
	
	public Long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Long getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public Long getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(Long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public Double getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(Double ivaventa) {
		this.ivaventa = ivaventa;
	}
	public Double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}
	public Double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
}
