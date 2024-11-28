package com.gitgudgang.dogeverse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositoryAdapter <D, T, ID> extends CrudRepository    <D, ID> {
}
