package org.example.mockitoexample.entitiea;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-04-04 下午 04:31
*/
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SecondaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SecondaryEntity main = (SecondaryEntity) o;
        return id == main.id;
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
                getClass().hashCode();
    }
}
