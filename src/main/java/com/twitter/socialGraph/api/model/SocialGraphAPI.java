package com.twitter.socialGraph.api.model;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialGraphAPI {
    private Long id;
    private List<UserAPI> blocked = new ArrayList<UserAPI>();
    private List<UserAPI> followed= new ArrayList<UserAPI>();
    private List<UserAPI> reported= new ArrayList<UserAPI>();

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
