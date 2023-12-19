package it.betacom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String sesso = request.getParameter("sesso");
		String luogoNascita = request.getParameter("luogo-nascita");
		String citta = request.getParameter("citta");
		String dataNascita = request.getParameter("data-nascita");
		String codiceFiscale = request.getParameter("codice-fiscale");
		String password = request.getParameter("password");
		String fonte = request.getParameter("fonte");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoginProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataParsata;
		try {
			dataParsata = formato.parse(dataNascita);
			if (em.find(User.class, codiceFiscale) == null) {
				User user = new User(nome, cognome, sesso, luogoNascita, citta, dataParsata, codiceFiscale, password,
						fonte);
				System.out.println(user.toString() + "creato utente");
				em.persist(user);
				em.getTransaction().commit();
				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF-8");

				try (PrintWriter out = response.getWriter()) {
					out.append("<html>" + "<body>" + "<div>" + "<h1>" + " congratulazioni ti sei registrato:" + nome
							+ "</h1>" + "<div>" + "</body>" + "</html>");
				}

			} else {
				System.out.println("utente gia registrato");
				try (PrintWriter out = response.getWriter()) {
					out.append("<html>" + "<body>" + "<div>" + "<h1>" + "Ops! sermbra che tu sia già registrato:" + nome
							+ "</h1>" + "<div>" + "</body>" + "</html>");
				}
			}
			;

		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("si è rotto tutto");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
