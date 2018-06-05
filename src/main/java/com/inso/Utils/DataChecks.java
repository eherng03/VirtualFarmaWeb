/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.Utils;

import java.util.Objects;

/**
 * Clase que engloba las operaciones de comprobar correccion y estructura de datos
 * @author Eva y Alba
 *
 */
public class DataChecks {

	private static DataChecks dataChecks;
	
	private DataChecks(){
		
	}
	
	/**
	 * Devuelve la unica instancia de la clase, que es un singleton
	 * @return
	 */
	public static DataChecks getInstance(){
		if(dataChecks == null){
			dataChecks = new DataChecks();
		}
		return dataChecks;
	}
	
	/**
	 * Comprueba que la cadena pasada como parametro este formada unicamente por letras numeros o espacios
	 * @param cadena
	 * @return boolean
	 */
	public boolean checkCadenaLetrasNumerosOEspacios(String cadena){
		for(char caracter : cadena.toCharArray()){
			if(!(esEspacio(caracter) ||esNumero(caracter) || esLetraMayuscula(caracter) || esLetraMinuscula(caracter))){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Comprueba que el dni sea correcto
	 * @param dni
	 * @return true o false
	 */
	public boolean checkDNI(String dni){
		char[] charDNI = dni.toCharArray();
		final String letra= "TRWAGMYFPDXBNJZSQVHLCKE";
		
		if(charDNI.length == 9){
			for(int i = 0; i < 8; i++){
				if(charDNI[i] < 48 || charDNI[i] > 58){
					return false;
				}
			}
			if(!esLetraMayuscula(charDNI[8])){
				return false;
			}else{
				Integer valor= new Integer(dni.substring(0, 8));
				int aux= valor%23;
				Character letraReal = charDNI[8];
				Character letraCalculada = letra.charAt(aux);
                            return Objects.equals(letraCalculada, letraReal);
			}
		}
		return false;
	}
	
	/**
	 * Comprueba la correccion del cif de una farmacia, debe tener 9 caracteres y una letra mayuscula al principio
	 * @param cif
	 * @return true o false
	 */
	public boolean checkCIF(String cif){
		char[] charCIF = cif.toCharArray();
		if(!esLetraMayuscula(charCIF[0])){
			return false;
		}
		if(charCIF.length != 9){
			return false;
		}
		for(int i = 1; i < charCIF.length; i++){
			if(!esNumero(charCIF[i])){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Comprueba que el numero de la seguridad social sea válido, es decir, tenga 12 digitos numéricos
	 * @param numeroSS
	 * @return 
	 */
	public boolean checkNumeroSS(String numeroSS){
		char[] charNumeroSSDNI = numeroSS.toCharArray();
		if(charNumeroSSDNI.length != 12){
			return false;
		}else{
			for(int i = 0; i < charNumeroSSDNI.length; i++){
				if(!esNumero(charNumeroSSDNI[i])){
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Comprueba que la cuenta bancaria introducida sea correcta, este formada por dos letras mayusculas seguidas de 22 numeros
	 * @param cuentaBancaria
	 * @return
	 */
	public boolean checkCuentaBancaria(String cuentaBancaria){
		char[] charCuenta = cuentaBancaria.toCharArray();
		if(!(esLetraMayuscula(charCuenta[0]) && esLetraMayuscula(charCuenta[1]))){
			return false;
		}
		if(charCuenta.length != 24){
			return false;
		}
		for(int i = 2; i < charCuenta.length; i++){
			if(!esNumero(charCuenta[i])){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Comprueba que el numero de telefono pasado como parámetro esté formado unicamente por 9 números
	 * @param telefono
	 * @return
	 */
	public boolean checkTelefono(String telefono) {
		char[] charTelefono = telefono.toCharArray();
		if(telefono.length() != 9){
			return false;
		}
		for(char caracter : charTelefono){
			if(!esNumero(caracter)){
				return false;
			}
		}
		return true;
	}

	/**
	 * Comprueba que el caracter pasado como parametro sea una letra mayuscula o minuscula
	 * @param caracter
	 * @return true o false
	 */
	public boolean esLetra(char caracter){
		return esLetraMayuscula(caracter) || esLetraMinuscula(caracter);
	}
	
	/**
	 * Comprueba que el caracter pasado como parámetro sea una letra mayúscula
	 * @param caracter
	 * @return
	 */
	public boolean esLetraMayuscula(char caracter){
		return caracter > 64 && caracter < 91;
	}
	
	/**
	 * Comprueba que el caracter pasado como parámetro sea una letra mayúscula
	 * @param caracter
	 * @return
	 */
	public boolean esLetraMinuscula(char caracter){
		return caracter > 96 && caracter < 123;
	}
	
	/**
	 * Comprueba que el caracter pasado como parámetro sea un número
	 * @param caracter
	 * @return
	 */
	public boolean esNumero(char caracter){
		return caracter > 47 && caracter < 58;
	}
	
	/**
	 * Comprueba que el caracter pasado como parámetro sea un espacio
	 * @param caracter
	 * @return
	 */
	public boolean esEspacio(char caracter){
		return caracter == 32;
	}

}
