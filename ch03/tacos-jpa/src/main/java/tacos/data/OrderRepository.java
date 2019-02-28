package tacos.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tacos.Order;

public interface OrderRepository 
         extends JpaRepository<Order, Long> {

}
