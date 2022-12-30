package com.person.repository;

import com.person.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    private List<Person> list = new ArrayList<Person>();

    public List<Person> getAllPersons() {
        return list;
    }

    public Person findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Person> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public Person save(Person p) {
        Person product = new Person();
        product.setId(p.getId());
        product.setName(p.getName());
        product.setAge(p.getAge());
        list.add(product);
        return product;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Person update(Person person) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (person.getId())) {
                id = person.getId();
                idx = i;
                break;
            }
        }

        Person product1 = new Person();
        product1.setId(id);
        product1.setName(person.getName());
        product1.setAge(person.getAge());
        list.set(idx, person);
        return product1;
    }
}
