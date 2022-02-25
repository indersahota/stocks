package com.ecomerce.stocks.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryEntity {
    @Id
    @Column(name= "category_id")
    private Integer categoryId;

    @Column(name ="category_type_name")
    private String categoryTypeName;
}
