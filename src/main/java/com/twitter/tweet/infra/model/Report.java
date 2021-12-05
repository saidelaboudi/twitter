package com.twitter.tweet.infra.model;

import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.domain.model.ReportDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public ReportDomain toDomain() {
        return new ReportDomain(
                this.id,
                this.message,
                this.user.toDomain()
        );
    }
}
