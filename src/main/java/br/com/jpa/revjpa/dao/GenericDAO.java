package br.com.jpa.revjpa.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.com.jpa.revjpa.util.JPAUtil;

public abstract class GenericDAO <T extends Serializable>{
	
	private Class<T> aClass;
	
	protected GenericDAO(Class<T> aClass){
		this.aClass = aClass;
	}
	
	protected EntityManager getEntityManager(){
		return JPAUtil.getInstance().geEntityManager();
	}
	
	
	//Criando o metodo para salvar ou persistir dados
	public void save(T entity){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager.persist(manager);
		manager.getTransaction().commit();
		manager.close();
	}

}
