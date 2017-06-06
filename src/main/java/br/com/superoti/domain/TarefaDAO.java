package br.com.superoti.domain;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

@Component
public class TarefaDAO extends HibernateDAO<Tarefa> {

	public TarefaDAO() {
		super(Tarefa.class);
	}

	// Consulta Tarefa pelo Id
	public Tarefa getTarefaById(Long id) {
		//O hibernate consulta automaticamente o pelo Id
		return super.get(id);
	}

	//Consulta todos os Tarefas
	public List<Tarefa> getTarefas() {
		Query q = getSession().createQuery("from Tarefa");
		List<Tarefa> Tarefas  = q.list();
		return Tarefas;
	}

	//Insere ou atualiza um Tarefa
	public void salvar(Tarefa c){
		super.save(c);
	}

	//Deleta o Tarefa pelo Id
	public boolean delete(Long id) {
		Tarefa c = get(id);
		delete(c);
		return true;
	}
}
