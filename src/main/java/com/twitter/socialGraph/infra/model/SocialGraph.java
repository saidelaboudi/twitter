package com.twitter.socialGraph.infra.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private User owner ;
    @OneToMany
    private List<User> blocked;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> followed;
    @OneToMany
    private List<User> reported;

    public SocialGraphDomain toDomain() {
        return new SocialGraphDomain(
                this.id,
                this.owner.toDomain(),
                this.blocked == null ? null : this.blocked.stream().map(User::toDomain).collect(Collectors.toList()),
                this.followed == null ? null : this.blocked.stream().map(User::toDomain).collect(Collectors.toList()),
                this.reported == null ? null : this.blocked.stream().map(User::toDomain).collect(Collectors.toList())
        );
    }
}
