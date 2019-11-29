package com.example.pet_shop.model.order;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class OrderProductKey  implements Serializable {

    @Column(name = "order_id_fk")
    private long orderIdFk;

    @Column(name = "product_id_fk")
    private long productIdFk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductKey that = (OrderProductKey) o;
        return orderIdFk == that.orderIdFk &&
                productIdFk == that.productIdFk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderIdFk, productIdFk);
    }
}
