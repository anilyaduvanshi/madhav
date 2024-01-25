package com.learn.tavant.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;


@Entity
@Component
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ProgrammerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private List<Languages> languages;

    @Embedded
    @NotNull
    private Other other;
}


