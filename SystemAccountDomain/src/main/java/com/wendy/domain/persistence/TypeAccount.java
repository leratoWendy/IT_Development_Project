package com.wendy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Account_Types")
public class TypeAccount implements Serializable {
    private Long id;
    private String name;
    private String nmonic;
    private LocalDate createddate;
    private Set<PersonTransactions> personTransactionsSet;

    public TypeAccount() {
    }

    public TypeAccount(Long id, String name, String nmonic, LocalDate createddate) {
        this.id = id;
        this.name = name;
        this.nmonic = nmonic;
        this.createddate = createddate;
    }

    public TypeAccount(Long id, String name, String nmonic, LocalDate createddate, Set<PersonTransactions> personTransactionsSet) {
        this.id = id;
        this.name = name;
        this.nmonic = nmonic;
        this.createddate = createddate;
        this.personTransactionsSet = personTransactionsSet;
    }

    @Id
    @SequenceGenerator(name="SEQ_TypeAccount",sequenceName = "AcountType_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TypeAccount")
    @Column(name = "type_account_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "nmonic")
    public String getNmonic() {
        return nmonic;
    }

    public void setNmonic(String nmonic) {
        this.nmonic = nmonic;
    }

    @Column(name = "created_date")
    public LocalDate getCreateddate() {
        return createddate;
    }

    public void setCreateddate(LocalDate createddate) {
        this.createddate = createddate;
    }

    @OneToMany(targetEntity = PersonTransactions.class, fetch = FetchType.LAZY, mappedBy = "typeAccount", cascade = CascadeType.ALL)
    public Set<PersonTransactions> getPersonTransactionsSet() {
        return personTransactionsSet;
    }

    public void setPersonTransactionsSet(Set<PersonTransactions> personTransactionsSet) {
        this.personTransactionsSet = personTransactionsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeAccount that = (TypeAccount) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(nmonic, that.nmonic) && Objects.equals(createddate, that.createddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nmonic, createddate);
    }

    @Override
    public String toString() {
        return "TypeAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nmonic='" + nmonic + '\'' +
                ", createddate=" + createddate +
                '}';
    }
}
