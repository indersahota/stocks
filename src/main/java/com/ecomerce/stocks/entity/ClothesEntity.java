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
@Table(name = "clothes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClothesEntity {
    @Id
    @Column(name = "clothes_id")
    Integer clotheId;
    @Column(name = "clothes_name")
    String clotheName;
}
