package com.snap.food.model.dao;



import com.snap.food.exception.AlreadyExistException;
import com.snap.food.exception.NotFoundException;
import com.snap.food.model.domain.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Dao<ID, E extends Entity<ID>> {

    private Map<ID, E> cache;
    private File file;

    protected Dao(File file) throws IOException, ClassNotFoundException {
        this.file = file;

        cache = new HashMap<>();

        if (!file.exists()) {
            file.createNewFile();
            writeToFile();
        }

        loadFromFile();
    }

    public E create(E entity) throws IOException, AlreadyExistException {
        if (cache.containsKey(entity.getId()))
            throw new AlreadyExistException();

        cache.put(entity.getId(), entity);
        writeToFile();

        return entity;
    }

    public E getById(ID id) throws NotFoundException {
        if (!cache.containsKey(id))
            throw new NotFoundException();

        return cache.get(id);
    }

    public Collection<E> getAll() {

        return cache.values();
    }

    public E update(ID id, E entity) throws IOException, NotFoundException {
        if (!cache.containsKey(id))
            throw new NotFoundException();

        cache.put(id, entity);
        writeToFile();

        return entity;
    }

    public void delete(ID id) throws IOException {

        cache.remove(id);
        writeToFile();
    }

    private void loadFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ArrayList<E> data = (ArrayList<E>) objectInputStream.readObject();

        for (E entity : data) {
            cache.put(entity.getId(), entity);
        }

        objectInputStream.close();
        fileInputStream.close();
    }

    private void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(new ArrayList<>(cache.values()));

        objectOutputStream.flush();

        objectOutputStream.close();
        fileOutputStream.close();
    }

}
