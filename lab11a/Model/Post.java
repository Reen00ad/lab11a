package com.example.lab11a.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "category id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer categoryid;
    @NotEmpty(message = "title should not be null")
    @Column(columnDefinition = "varchar(10) not null ")
    private String title;
    @NotEmpty(message = "content should not be null")
    @Column(columnDefinition = "varchar(50) not null ")
    private String content;
    @NotNull(message = "user id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer userid;
    @Column(columnDefinition = " date ")
    private LocalDate publishDate;
}
