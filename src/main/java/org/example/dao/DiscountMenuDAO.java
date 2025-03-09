package org.example.dao;

import org.example.models.DiscountMenu;
import org.example.models.Menu;

import javax.persistence.TypedQuery;
import java.util.List;

public class DiscountMenuDAO extends AbstractDAO<DiscountMenu>{
    public DiscountMenuDAO() {
        super(DiscountMenu.class);
    }
    public List<DiscountMenu> viewAllDiscountMenu() {
        TypedQuery<DiscountMenu> query = em.createQuery(
                "SELECT m FROM DiscountMenu m WHERE TYPE(m) = DiscountMenu", DiscountMenu.class);
        List<DiscountMenu> res = query.getResultList();
        return res;
    }
}
