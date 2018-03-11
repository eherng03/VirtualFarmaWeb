/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.model;

import com.inso.Utils.DataChecks;
import com.inso.exceptions.AlreadyExistException;
import com.inso.exceptions.InvalidCIFException;
import com.inso.exceptions.InvalidCuentaException;
import com.inso.exceptions.InvalidNameException;
import com.inso.exceptions.InvalidPasswordException;
import com.inso.exceptions.InvalidTelefoneException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eva
 */
@Entity
@Table(name = "farmacias", catalog = "virtualfarma", schema = "")
public class Farmacia implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "farmacia")
    private Collection<Productos> productosCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "CIF", nullable = false, length = 9)
    private String cif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Horario", nullable = false, length = 200)
    private String horario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Direccion", nullable = false, length = 100)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "NumeroCuenta", nullable = false, length = 24)
    private String numeroCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NombreDueno", nullable = false, length = 100)
    private String nombreDueno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "Telefono", nullable = false, length = 9)
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "email", nullable = false, length = 20)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Password", nullable = false, length = 20)
    private String password;
   
    public Farmacia() {
    }

    public Farmacia(String cif) {
        this.cif = cif;
    }

    public Farmacia(String nombre, String cif, String horario, String direccion, 
			String numeroCuenta, String nombreDueno, String telefono, String email, String password, boolean nuevo) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException, SQLException, AlreadyExistException {
		if(checkDatos(nombre, cif, numeroCuenta, nombreDueno, telefono, password)){
			this.nombre = nombre;
			this.cif = cif;
			this.horario = horario;
			this.direccion = direccion;
			this.numeroCuenta = numeroCuenta;
			this.nombreDueno = nombreDueno;
			this.telefono = telefono;
			this.email = email;
			this.password = password;
			
		}
	}
    
     /**
	 * Comprueba la estructura de los datos introducidos en la creacion de la farmacia
	 * @param nombre
	 * @param cif
	 * @param cuenta
	 * @param nombreDueno
	 * @param telefono
	 * @param password
	 * @return
	 * @throws InvalidNameException
	 * @throws InvalidCIFException
	 * @throws InvalidCuentaException
	 * @throws InvalidTelefoneException
	 * @throws InvalidPasswordException
	 */
	private boolean checkDatos(String nombre, String cif, String cuenta,
			String nombreDueno, String telefono, String password) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException {
		if(!DataChecks.getInstance().checkCadenaLetrasNumerosOEspacios(nombre)){
			throw new InvalidNameException();
		}
		if(!DataChecks.getInstance().checkCIF(cif)){
			throw new InvalidCIFException();
		}
		if(!DataChecks.getInstance().checkCuentaBancaria(cuenta)){
			throw new InvalidCuentaException();
		}
		if(!DataChecks.getInstance().checkCadenaLetrasNumerosOEspacios(nombreDueno)){
			throw new InvalidNameException();
		}
		if(!DataChecks.getInstance().checkTelefono(telefono)){
			throw new InvalidTelefoneException();
		}
		if(!DataChecks.getInstance().checkCadenaLetrasNumerosOEspacios(password)){
			throw new InvalidPasswordException();
		}

		return true;
	}

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cif != null ? cif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Farmacia)) {
            return false;
        }
        Farmacia other = (Farmacia) object;
        if ((this.cif == null && other.cif != null) || (this.cif != null && !this.cif.equals(other.cif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inso.EJB.Farmacias[ cif=" + cif + " ]";
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }
    
}
