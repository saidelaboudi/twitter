package com.twitter.searchService.infra.model;

import com.twitter.searchService.domain.model.TopicDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.User;
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
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private List<String> keywords;

    @OneToMany
    private List<User> community;

    public TopicDomain toDomain() {
        List<String> keywords = new ArrayList<String>();
        List<UserDomain> community = new ArrayList<UserDomain>();

        return new TopicDomain(
                this.id,
                this.title,
                this.description,
                keywords,
                community
        );
    }

}
