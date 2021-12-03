package com.twitter.socialGraph.infra.model;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialGraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User owner;
    @OneToMany
    private List<User> blocked;
    @OneToMany
    private List<User> followed;
    @OneToMany
    private List<User> reported;

    public SocialGraphDomain toDomain() {
        List<UserDomain> blocked = new ArrayList<UserDomain>();
        List<UserDomain> followed = new ArrayList<UserDomain>();
        List<UserDomain> reported = new ArrayList<UserDomain>();
        this.blocked.forEach(user->{
            blocked.add(user.toDomain());
        });
        this.followed.forEach(user->{
            followed.add(user.toDomain());
        });
        this.reported.forEach(user->{
            reported.add(user.toDomain());
        });
        return new SocialGraphDomain(
                this.id,
                this.owner.toDomain(),
                blocked,
                followed,
                reported
        );
    }
}
