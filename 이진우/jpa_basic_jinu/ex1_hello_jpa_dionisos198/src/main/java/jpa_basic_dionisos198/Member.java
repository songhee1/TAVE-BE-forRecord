package jpa_basic_dionisos198;

import javax.persistence.*;
import java.util.*;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;


    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> products=new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts=new ArrayList<>();




    public Member(){

    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
