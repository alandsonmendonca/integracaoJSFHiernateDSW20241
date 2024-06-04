package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Moeda;
import util.JPAUtil;

public class MoedaDao {
	public static void salvar(Moeda moeda) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(moeda);
		em.getTransaction().commit();
		em.close();
	}

	public static List<Moeda> listar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select m from Moeda m");
		List<Moeda> resultado = q.getResultList();
		em.close();
		return resultado;
	}
}
