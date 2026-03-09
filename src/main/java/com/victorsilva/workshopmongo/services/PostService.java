package com.victorsilva.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorsilva.workshopmongo.domain.Post;
import com.victorsilva.workshopmongo.repositories.PostRepository;
import com.victorsilva.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	
	public Post findById(String id) {
		Post post = repository.findById(id).orElse(null);
		if( post == null ) {
			throw new ObjectNotFoundException("Objeto não encotrado");
		}
		return post;
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}

}
