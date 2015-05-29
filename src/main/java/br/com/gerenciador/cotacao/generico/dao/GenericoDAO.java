package br.com.gerenciador.cotacao.generico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GenericoDAO<T> {

	protected EntityManager entityManager;

	protected Class<T> entidade;

	public GenericoDAO(Class<T> entidade, EntityManager entityManager) {
		super();
		this.entidade = entidade;
		this.entityManager = entityManager;
	}
	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
    }
 
    public void commit() {
    	entityManager.getTransaction().commit();
    }
 
    public void rollback() {
    	entityManager.getTransaction().rollback();
    }
 
    public void closeTransaction() {
    	entityManager.close();
    }
 
    public void commitAndCloseTransaction() {
        commit();
        closeTransaction();
    }
 
    public void flush() {
    	entityManager.flush();
    }
	
	public void inserir(T entidade) throws Exception {
		entityManager.persist(entidade);
	}

	public T atualizar(T entidade) throws Exception {
		return entityManager.merge(entidade);
	}

	public void deletar(T entidade) throws Exception {
		entidade = entityManager.merge(entidade);
		entityManager.remove(entidade);
	}

	public T buscarPorId(Object id) throws Exception {
		return entityManager.find(entidade, id);
	}

	public List<T> buscarTodos() throws Exception {
		TypedQuery<T> query = entityManager.createQuery("FROM " + entidade.getName(), entidade);
		return query.getResultList();
	}

}