package com.twitter.socialGraph.infra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> blocked;
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> followed;
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> reported;
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    @JsonFormat(timezone="UTC")
    Date createdDate ;
    @Column(name = "modified_date")
    @LastModifiedDate
    @JsonFormat(timezone="UTC")
    Date modifiedDate ;

    public SocialGraph(Long id, List<User> blocked, List<User> followed, List<User> reported) {
        this.id = id;
        this.blocked = blocked;
        this.followed = followed;
        this.reported = reported;
    }

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
                blocked,
                followed,
                reported
        );
    }
}
