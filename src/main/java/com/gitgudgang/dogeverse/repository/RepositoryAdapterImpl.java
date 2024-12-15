package com.gitgudgang.dogeverse.repository;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@AllArgsConstructor
public class RepositoryAdapterImpl<D, T, ID> implements RepositoryAdapter<D, T, ID> {

    private final CrudRepository<T, ID> repository;
    private final ModelMapper modelMapper;
    private final Class<D> domainClass;
    private final Class<T> databaseClass;

    public <S extends D> S save(S entity) {
        T mappedEntity = modelMapper.map(entity, databaseClass);
        T savedEntity = repository.save(mappedEntity);
        return modelMapper.map(savedEntity, (Class<S>) entity.getClass());
    }

    public <S extends D> Iterable<S> saveAll(Iterable<S> entities) {
        List<T> mappedEntities = StreamSupport.stream(entities.spliterator(), false)
                .map(entity -> modelMapper.map(entity, databaseClass))
                .collect(Collectors.toList());


        Iterable<T> savedEntities = repository.saveAll(mappedEntities);
        return StreamSupport.stream(savedEntities.spliterator(), false)
                .map(savedEntity -> modelMapper.map(savedEntity, (Class<S>) domainClass))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<D> findById(ID id) {
        return repository.findById(id)
                .map(entity -> modelMapper.map(entity, domainClass));
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public Iterable<D> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(entity -> modelMapper.map(entity, domainClass))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<D> findAllById(Iterable<ID> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .map(entity -> modelMapper.map(entity, domainClass))
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public void delete( D domainObject) {
        T entity = modelMapper.map(domainObject, databaseClass);
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends ID> ids) {
        repository.deleteAllById(ids);
    }

    public void deleteAll(Iterable<? extends D> domainObjects) {
        List<T> entities = StreamSupport.stream(domainObjects.spliterator(), false)
                .map(domainObject -> modelMapper.map(domainObject, databaseClass))
                .collect(Collectors.toList());
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
