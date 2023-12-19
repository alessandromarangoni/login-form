package it.betacom.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {
	
	private String nome;
	private String cognome;
	private String sesso;
	private String luogoDiNascita;
	private String citta;
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;
	@Id
	private String codiceFiscale;
	private String password;
	private String fonte;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public User(String nome, String cognome, String sesso, String luogoDiNascita, String citta,Date dataDiNascita,
			String codiceFiscale, String password, String fonte) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.luogoDiNascita = luogoDiNascita;
		this.citta = citta;
		this.dataDiNascita = dataDiNascita;
		this.codiceFiscale = codiceFiscale;
		this.password = password;
		this.fonte = fonte;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	@Override
	public String toString() {
		return "User [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", luogoDiNascita="
				+ luogoDiNascita + ", citta=" + citta + ", dataDiNascita=" + ", codiceFiscale="
				+ codiceFiscale + ", password=" + password + ", fonte=" + fonte + "]";
		
	}
   
}
