package br.com.unipe.aula.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.unipe.aula.model.Torcedor;

@Repository
public class TorcedorDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public TorcedorDAO() {
		
	}
	
	@Transactional(readOnly = false)
	public void salvar(Torcedor torcedor) {
		entityManager.persist(torcedor);
	}
	
	@Transactional(readOnly = true)
	public List<Torcedor> getAll() {
		String jpql = "from Torcedor u";
		TypedQuery<Torcedor> consulta = entityManager.createQuery(jpql, Torcedor.class);
		
		return consulta.getResultList();
	}
	
	public Torcedor getId(Long id) {
		return entityManager.find(Torcedor.class, id);
	}
	
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		Torcedor torcedor = getId(id);
		entityManager.remove(torcedor);
	}
	
	@Transactional(readOnly = false)
	public void editar(Torcedor torcedor) {
		entityManager.merge(torcedor);
	}

}
