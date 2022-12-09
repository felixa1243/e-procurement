package com.enigma.models.spec;

import com.enigma.entities.ProductPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Data
@AllArgsConstructor
public class ProductPriceSpec implements Specification<ProductPrice> {
    SearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<ProductPrice> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
