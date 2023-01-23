package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    Long id;
    @Column(name = "name_book")
    String nameBook;
    @Column(name = "price")
    BigDecimal price;
    @Column(name = "author")
    String author;

}
