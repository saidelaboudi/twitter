package com.twitter.socialGraph.domain.model;

import com.twitter.socialGraph.infra.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private SocialGraphDomain socialGraph;

    public User toInfra() {
        return new User(
            this.id,
            this.username,
            this.firstname,
            this.lastname,
            this.email,
            this.phone,
            this.socialGraph.toInfra()
        );
    }

}
