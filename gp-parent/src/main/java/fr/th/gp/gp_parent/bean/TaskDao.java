package fr.th.gp.gp_parent.bean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.th.gp.gp_parent.model.Task;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TaskDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Task task) {
		entityManager.persist(task);
	}

	@SuppressWarnings("unchecked")
	public List<Task> list() {
		return entityManager.createQuery("select t from Task t")
				.getResultList();
	}

}
