package com.twitter.tweet.infra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.tweet.domain.model.ReportDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    @JsonFormat(timezone="UTC")
    Date createdDate ;
    @Column(name = "modified_date")
    @LastModifiedDate
    @JsonFormat(timezone="UTC")
    Date modifiedDate ;

    public Report(Long id, String message, User user) {
        this.id = id;
        this.message = message;
        this.user = user;
    }

    public ReportDomain toDomain() {
        return new ReportDomain(
                this.id,
                this.message,
                this.user.toDomain()
        );
    }
}
