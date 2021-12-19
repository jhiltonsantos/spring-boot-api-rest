package br.com.hilton.apirestspring.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TB_STORE")
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;

}
