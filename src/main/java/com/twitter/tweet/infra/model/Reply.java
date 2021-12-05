package com.twitter.tweet.infra.model;


import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.domain.model.ReplyDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public ReplyDomain toDomain() {
        return new ReplyDomain(
                this.id,
                this.message,
                this.user.toDomain()
        );
    }
}
