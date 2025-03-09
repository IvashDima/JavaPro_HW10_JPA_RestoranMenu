package org.example.dao;

import org.example.models.Menu;

import javax.persistence.TypedQuery;
import java.util.List;

public class MenuDAO extends AbstractDAO<Menu>{
    public MenuDAO() {
        super(Menu.class);
    }
    public List<Menu> viewMenuByPrice(double from, double to) {
        TypedQuery<Menu> query = em.createQuery(
                "SELECT m FROM Menu m WHERE m.price > : from AND m.price < : to", Menu.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        List<Menu> res = query.getResultList();
        return res;
    }

    public List<Menu> viewMenuToKg() {
        TypedQuery<Menu> query = em.createQuery(
                "SELECT m FROM Menu m WHERE m.weight < : w", Menu.class);
        query.setParameter("w", 1000);
        List<Menu> res = query.getResultList();
        return res;
    }
}
