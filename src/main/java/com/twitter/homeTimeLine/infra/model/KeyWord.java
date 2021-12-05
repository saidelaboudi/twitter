package com.twitter.homeTimeLine.infra.model;

import com.twitter.directMessage.infra.model.REACTION_TYPE;
import com.twitter.homeTimeLine.domain.model.KeyWordDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private REACTION_TYPE reaction;

    public KeyWordDomain toDomain() {
        return new KeyWordDomain();
    }
}
