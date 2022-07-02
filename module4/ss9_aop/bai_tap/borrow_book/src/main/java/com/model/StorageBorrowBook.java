package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sach_muon")
public class StorageBorrowBook {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "")
    private List<DetailBook> codeOfBook;
}
