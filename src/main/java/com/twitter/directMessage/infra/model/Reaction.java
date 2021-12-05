package com.twitter.directMessage.infra.model;

import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.socialGraph.infra.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public ReactionDomain toDomain() {
        return new ReactionDomain(
                this.id,
                this.user.toDomain()
        );
    }
}
