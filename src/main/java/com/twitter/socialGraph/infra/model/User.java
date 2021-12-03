package com.twitter.socialGraph.infra.model;

import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    @OneToOne
    private SocialGraph socialGraph;

    public UserDomain toDomain() {
        return new UserDomain(
                this.id,
                this.username,
                this.firstname,
                this.lastname,
                this.email,
                this.phone,
                this.socialGraph.toDomain()
        );
    }
}
