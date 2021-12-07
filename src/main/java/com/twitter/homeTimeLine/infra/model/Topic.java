package com.twitter.homeTimeLine.infra.model;

import com.twitter.homeTimeLine.domain.model.TopicDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public TopicDomain toDomain(){
        return new TopicDomain(this.id,this.description);
    }

}
