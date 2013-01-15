package com.todo.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.todo.domain.TodoList;

/**
 * Session Bean implementation class TodoService
 */
@Stateless
@LocalBean
@Path("/todolists")
public class TodoService {

	@PersistenceContext
	private EntityManager entityManager;

	@POST
	@Consumes("application/json")
	public TodoList save(@Valid TodoList todoList) {
		entityManager.persist(todoList);
		return todoList;
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TodoList lookupTodoListById(@PathParam("id") String id) {
		TodoList todoList = entityManager.find(TodoList.class, id);
		if (todoList == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return todoList;
	}

}
