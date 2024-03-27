package com.example.lab11a.Model;

import jakarta.persistence.*;
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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "user id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer userid;
    @NotNull(message = "post id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer postid;
    @NotEmpty(message = "content should not be null")
    @Column(columnDefinition = "varchar(50) not null ")
    private String content;
    @Column(columnDefinition = " date ")
    private LocalDate commentDate;
}
