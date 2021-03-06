package com.hitema.spring.boot.planning.entities;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long id;
    @Column(name = "nom")
    private String nom ;
    @Column(name = "unites")
    private String unites ;

    @Column(name="date_creation")
    private LocalDateTime creationDate;
    @Column(name="resultat_vote")
    private Integer ResultatVote;
    @ManyToMany(mappedBy = "sessions")
    private List<User> users;


    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", unites='" + unites + '\'' +
                ", creationDate=" + creationDate +
                ", ResultatVote=" + ResultatVote +

                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUnites() {
        return unites;
    }

    public void setUnites(String unites) {
        this.unites = unites;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getResultatVote() {
        return ResultatVote;
    }

    public void setResultatVote(Integer resultatVote) {
        ResultatVote = resultatVote;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

