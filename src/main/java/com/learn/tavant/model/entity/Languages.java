package com.learn.tavant.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long langId;
    private String title;
    private int rating;
}
