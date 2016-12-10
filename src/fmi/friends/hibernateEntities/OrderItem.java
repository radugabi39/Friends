package fmi.friends.hibernateEntities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ORDER_ITEM", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class OrderItem {

}
