package com.twitter.socialGraph.api.model;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialGraphAPI {
    private Long id;
    private List<UserAPI> blocked = new ArrayList<UserAPI>();
    private List<UserAPI> followed = new ArrayList<UserAPI>();
    private List<UserAPI> reported = new ArrayList<UserAPI>();

    public SocialGraphDomain toDomain() {
        return new SocialGraphDomain(
                this.id,
                this.blocked.stream().map(UserAPI::toDomain).collect(Collectors.toList()),
                this.followed.stream().map(UserAPI::toDomain).collect(Collectors.toList()),
                this.reported.stream().map(UserAPI::toDomain).collect(Collectors.toList())
        );
    }
}
